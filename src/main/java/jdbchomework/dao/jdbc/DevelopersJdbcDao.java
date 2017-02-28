package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DevelopersJdbcDao extends AbstractDao<Developer> implements DevelopersDao {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(AbstractDao.class);

    public DevelopersJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    @Override
    public boolean updateById(int id, Developer toUpdate) {
        boolean result = false;
        try (PreparedStatement statement = connection
            .prepareStatement("UPDATE developers SET name = ?, salary = ? WHERE developer_id =?;")) {
            statement.setString(1, toUpdate.getName());
            statement.setInt(2, toUpdate.getSalary());
            statement.setInt(3, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    @Override
    protected Developer createEntity(ResultSet resultSet) throws SQLException {
        return new Developer(resultSet.getLong("developer_id"), resultSet.getString("name"),
                resultSet.getInt("salary"));
    }
}
