package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.Dao;
import jdbchomework.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
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

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM " + table;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                T t = createT(resultSet);
                result.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }


    public T getById(int id) {
        T result = null;
        try (
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = createT(rs);
            } else {
                System.out.println("Cannot find any company with id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    protected abstract T createT(ResultSet resultSet) throws SQLException;
}
