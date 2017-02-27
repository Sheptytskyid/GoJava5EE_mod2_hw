package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
import jdbchomework.entity.Skill;
import jdbchomework.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DevelopersJdbcDao implements DevelopersDao {

    private Connection connection;

    public DevelopersJdbcDao() {
        this.connection = ConnectionUtil.getConnection();
    }

    @Override
    public void add(Developer toAdd) {
        String name = toAdd.getName();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO developers(name) VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.executeUpdate();
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
    public List<Developer> getAll() {
        List<Developer> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM developers;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Developer developer = createDeveloper(resultSet);
                result.add(developer);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

        return result;
    }

    @Override
    public Developer getById(int id) {
        Developer developer = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM developers WHERE developer_id=?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                developer = createDeveloper(rs);
                connection.commit();
            } else {
                System.out.println("Cannot find any developer with id: " + id);
                developer = new Developer("Default");
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
        return developer;
    }

    @Override
    public int deleteById(int id) {
        int res;
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM "
                + "developers WHERE developer_id = ?;")) {
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
    public void updateById(int id, Developer toUpdate) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE developers SET name = ? WHERE "
                + "developer_id =?;")) {
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
    public Developer getByName(String name) {
        Developer result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM developers "
                + "WHERE name LIKE ?;")) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createDeveloper(resultSet);
            } else {
                result = new Developer("Default");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Developer> getBySalary(int salary) {
        List<Developer> developers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM developer WHERE salary =?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            statement.setInt(1, salary);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Developer dev = createDeveloper(resultSet);
                developers.add(dev);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public List<Project> getDeveloperProject(Developer developer) {
        List<Project> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT projects.name AS project_name, "
                + "projects.cost AS project_cost FROM "
                + "projects JOIN developers USING (project_id) WHERE developers.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            String name = "%" + developer.getName() + "%";
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
        String sql = "DELETE FROM developers WHERE name LIKE ?;";
        try (
                PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
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
    public List<Skill> getDeveloperSkills(Developer developer) {
        List<Skill> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT skills.name AS skill_name"
                + "FROM developers INNER JOIN developers_skills USING (developer_id) "
                + "INNER JOIN  skills USING (skill_id) WHERE developers.name LIKE ?;")) {
            connection.setAutoCommit(false);
            String name = "%" + developer.getName() + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Skill skill = new Skill(resultSet.getString("skill_name"));
                result.add(skill);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    private Developer createDeveloper(ResultSet resultSet) throws SQLException {
        return new Developer(resultSet.getString("developer_name"),
                resultSet.getInt("developer_id"));
    }
}
