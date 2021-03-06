package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.GenericDao;
import jdbchomework.exceptions.DbConnectionException;
import jdbchomework.entity.AbstractEntity;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJdbcDao<T extends AbstractEntity> implements GenericDao<T> {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(AbstractJdbcDao.class);
    private String table;
    private static final String ERROR_MESSAGE = "Cannot connect to DB";

    protected Connection connection;

    public AbstractJdbcDao(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    @Override
    public boolean deleteById(long id) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("DELETE FROM " + table + " WHERE id  = ?;")) {
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new DbConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }

    public void add(T toAdd) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT  INTO " + table + " (name)VALUES (?);")) {
            statement.setString(1, toAdd.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new DbConnectionException(ERROR_MESSAGE, e);
        }
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table)) {
            while (resultSet.next()) {
                T t = createEntity(resultSet);
                result.add(t);
            }
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new DbConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }


    public T getById(long id) {
        T result = null;
        try (
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM " + table + " WHERE id  = ?;")) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = createEntity(rs);
            }
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new DbConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }

    public boolean updateById(long id, T toUpdate) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE " + table + " SET name = ?  WHERE id  = ?;")) {
            String name = toUpdate.getName();
            statement.setString(1, name);
            statement.setLong(2, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error(ERROR_MESSAGE, e);
            throw new DbConnectionException(ERROR_MESSAGE, e);
        }
        return result;
    }

    protected abstract T createEntity(ResultSet resultSet) throws SQLException;
}