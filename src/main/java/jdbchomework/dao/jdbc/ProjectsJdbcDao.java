package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsJdbcDao extends AbstractDao<Project> implements ProjectsDao {

    public ProjectsJdbcDao(Connection connection) {
        super(connection);
    }

    @Override
    public void add(Project toAdd) {
        String name = toAdd.getName();
        int cost = toAdd.getCost();
        try (PreparedStatement statement = connection
            .prepareStatement("INSERT INTO projects (name, cost) VALUES (?,?)")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            statement.setString(1, name);
            statement.setInt(2, cost);
            statement.executeUpdate();
            connection.commit();
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
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM projects;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Project project = createProject(resultSet);
                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return projects;
    }

    @Override
    public Project getById(int id) {
        Project project = null;
        try (PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM projects WHERE project_id = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                project = createProject(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return project;
    }

    @Override
    public void updateById(int id, Project toUpdate) {
        try (PreparedStatement statement = connection
            .prepareStatement("UPDATE projects SET name = ?, cost =? WHERE project_id =?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement.setString(1, toUpdate.getName());
            statement.setInt(2, toUpdate.getCost());
            statement.setInt(3, id);
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

    private Project createProject(ResultSet resultSet) throws SQLException {
        return new Project(resultSet.getInt("project_id"), resultSet.getString("name"),
            resultSet.getInt("cost"));
    }

    /*@Override
    public Project getByName(String projectName) {
        Project result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "projects WHERE name LIKE ?;")) {
            projectName = "%" + projectName + "%";
            statement.setString(1, projectName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createProject(resultSet);
            } else {
                result = new Project("Default", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }*/

    /*@Override
    public int deleteByName(String projectName) {
        int res;
        String sql = "DELETE FROM projects WHERE name LIKE ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            projectName = "%" + projectName + "%";
            statement.setString(1, projectName);
            statement.executeUpdate();
            connection.commit();
            System.out.println(projectName + ", Successfully deleted");
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

    /*@Override
    public List<Project> getAllProjects(String companyName) {
        List<Project> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT projects.name, "
                + "projects.cost FROM "
                + "projects INNER JOIN companies USING (company_id)"
                + " WHERE companies.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = "%" + companyName + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = createProject(resultSet);
                result.add(project);
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
    public List<Developer> getDevelopers(String projectName) {
        projectName = "%" + projectName + "%";
        List<Developer> result = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT developers.name AS dev_name "
                             + "FROM developers INNER JOIN projects USING (project_id) "
                             + "WHERE projects.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, projectName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Developer dev = new Developer(resultSet.getString("dev_name"));
                result.add(dev);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }*/
}
