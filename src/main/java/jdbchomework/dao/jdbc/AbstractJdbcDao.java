package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.GenericDao;
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
    private String column;

    protected Connection connection;

    public AbstractJdbcDao(Connection connection, String table, String column) {
        this.connection = connection;
        this.table = table;
        this.column = column;
    }

    @Override
    public boolean deleteById(long id) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("DELETE FROM " + table + " WHERE " + column + " = ?;")) {
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public void add(T toAdd) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT  INTO " + table + " (name)VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, toAdd.getName());
            connection.commit();
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                log.error("Cannot connect to DB", e);
                throw new RuntimeException("Cannot connect to DB", e);
            }
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
            log.error("Cannot connect to DB", e);
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }


    public T getById(long id) {
        T result = null;
        try (
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?;")) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = createEntity(rs);
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    public boolean updateById( long id, T toUpdate) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE " + table + " SET name = ? WHERE " + column + " =?;")) {
            String name = toUpdate.getName();
            statement.setString(1, name);
            statement.setLong(2, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    protected abstract T createEntity(ResultSet resultSet) throws SQLException;
}