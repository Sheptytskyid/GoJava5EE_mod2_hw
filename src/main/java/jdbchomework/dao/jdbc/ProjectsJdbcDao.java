package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.MyOwnExceprion;
import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectsJdbcDao extends AbstractJdbcDao<Project> implements ProjectsDao {
    private static final String ERROR_MESSAGE = "Cannot connect to DB";

    private static org.slf4j.Logger log = LoggerFactory.getLogger(ProjectsJdbcDao.class);

    public ProjectsJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    @Override
    public void add(Project toAdd) {
        String name = toAdd.getName();
        int cost = toAdd.getCost();
        try (PreparedStatement statement = connection
                .prepareStatement("INSERT INTO projects (name, cost) VALUES (?,?)")) {
            statement.setString(1, name);
            statement.setInt(2, cost);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new MyOwnExceprion(ERROR_MESSAGE, e);
        }
    }

    @Override
    public boolean updateById(long id, Project toUpdate) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE projects SET name = ?, cost =? WHERE project_id =?;")) {
            statement.setString(1, toUpdate.getName());
            statement.setInt(2, toUpdate.getCost());
            statement.setLong(3, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new MyOwnExceprion(ERROR_MESSAGE, e);
        }
        return result;
    }

    @Override
    protected Project createEntity(ResultSet resultSet) throws SQLException {
        return new Project(resultSet.getInt("id"), resultSet.getString("name"),
                resultSet.getInt("cost"));
    }
}