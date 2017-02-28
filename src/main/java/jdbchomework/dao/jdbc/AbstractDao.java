package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.Dao;
import jdbchomework.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {
    private String table;
    private String column;

    protected Connection connection;

    public AbstractDao(Connection connection, String table, String column) {
        this.connection = connection;
        this.table = table;
        this.column = column;
    }

    @Override
    public int deleteById(int id) {
        int res;
        try (PreparedStatement statement = connection
                .prepareStatement("DELETE FROM " + table + " WHERE " + column + " = ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
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
    }

    public abstract void add(T toAdd);

    public abstract List<T> getAll();

    public abstract T getById(int id);
}
