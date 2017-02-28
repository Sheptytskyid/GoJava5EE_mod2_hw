package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompaniesJdbcDao extends AbstractDao<Company> implements CompaniesDao {

    public CompaniesJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    @Override
    public void add(Company toAdd) {
        String name = toAdd.getName();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO companies(name) VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot add to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }


    @Override
    public void updateById(int id, Company toUpdate) {
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE companies SET name = ? WHERE company_id =?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = toUpdate.getName();
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
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
    }

    protected Company createT(ResultSet resultSet) throws SQLException {
        return new Company(resultSet.getString("name"),
                resultSet.getInt("company_id"));
    }

/*    @Override
    public Company getByName(String name) {
        Company result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "companies WHERE name LIKE ?;")) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createT(resultSet);
            } else {
                result = new Company("Default");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }*/

/*    @Override
    public List<Project> getCompaniesProjects(Company company) {
        ProjectsDao projectsDao = new ProjectsJdbcDao();
        return projectsDao.getAllProjects(company.getName());
    }*/

/*    @Override
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
    }*/

/*    @Override
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
    }*/
}
