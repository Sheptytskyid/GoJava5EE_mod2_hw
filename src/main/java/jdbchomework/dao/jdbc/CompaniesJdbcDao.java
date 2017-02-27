package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
import jdbchomework.utils.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GetFire on 25.02.2017.
 */
public class CompaniesJdbcDao implements CompaniesDao {


    private Connection connection;

    public CompaniesJdbcDao() {
        this.connection = ConnectionUtil.getConnection();
    }

    @Override
    public void add(Company toAdd) {
        String name = toAdd.getName();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO "
                + "companies(name) VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println(name + "Successfully added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }

    @Override
    public List<Company> getAll() {
        List<Company> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM companies;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = createCompany(resultSet);
                result.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

        return result;
    }

    @Override
    public Company getById(int id) {
        Company company;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "companies WHERE company_id = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                company = createCompany(rs);
            } else {
                System.out.println("Cannot find any company with id: " + id);
                company = new Company("Default");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return company;
    }

    @Override
    public int deleteById(int id) {
        int res;
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM "
                + "companies WHERE company_id = ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Successfully deleted");
            res = 1;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
        return res;
    }

    @Override
    public Company getByName(String name) {
        Company result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "companies WHERE name LIKE ?;")) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createCompany(resultSet);
            } else {
                result = new Company("Default");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateById(int id, Company toUpdate) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE companies SET name = ? WHERE company_id =?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = toUpdate.getName();
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }

    @Override
    public List<Project> getCompaniesProjects(Company company) {
        List<Project> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT projects.name AS project_name, "
                + "projects.cost AS project_cost FROM "
                + "projects INNER JOIN companies USING (company_id)"
                + " WHERE companies.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = "%" + company.getName() + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name1 = resultSet.getString("project_name");
                int cost = resultSet.getInt("project_cost");
                result.add(new Project(name1, cost));
            }
            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
        return result;
    }

    @Override
    public int deleteByName(String name) {
        int res;
        String sql = "DELETE FROM companies WHERE name LIKE ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name1 = "%" + name + "%";
            statement.setString(1, name1);
            statement.executeUpdate();
            connection.commit();
            System.out.println(name + ", Successfully deleted");
            res = 1;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
        return res;
    }

    @Override
    public List<Developer> getAllDevelopers(String companyName) {
        companyName = "%" + companyName + "%";
        List<Developer> developers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT developers.name AS dev_name "
                + "FROM developers INNER JOIN projects USING (project_id) "
                + "INNER JOIN companies USING (company_id) "
                + "WHERE companies.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, companyName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                developers.add(new Developer(resultSet.getString("dev_name")));
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return developers;
    }

    private Company createCompany(ResultSet resultSet) throws SQLException {
        return new Company(resultSet.getString("name"),
                resultSet.getInt("company_id"));

    }
}
