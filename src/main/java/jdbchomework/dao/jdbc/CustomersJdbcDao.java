package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersJdbcDao extends AbstractJdbcDao<Customer> implements CustomersDao {

    public CustomersJdbcDao(Connection connection, String table) {
        super(connection, table);
    }

    @Override
    protected Customer createEntity(ResultSet resultSet) throws SQLException {
        return new Customer(resultSet.getInt("id"),
                resultSet.getString("name"));
    }
}