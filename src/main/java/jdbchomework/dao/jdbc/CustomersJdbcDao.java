package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersJdbcDao extends AbstractDao<Customer> implements CustomersDao {

    public CustomersJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    @Override
    public void add(Customer toAdd) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT  INTO customers(name)VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, toAdd.getName());
            connection.commit();
            System.out.println(toAdd.getName() + " successfully added to DB");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }


    @Override
    public void updateById(int id, Customer toUpdate) {
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE customers SET name = ? WHERE customer_id =?;")) {
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
    protected Customer createT(ResultSet resultSet) throws SQLException {
        return new Customer(resultSet.getInt("customer_id"),
                resultSet.getString("name"));
    }

    /*@Override
    public List<Project> getCustomersProject(Customer customer) {
        List<Project> projects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT projects.name AS project_name, "
                + "projects.cost AS project_cost FROM "
                + "projects INNER JOIN customers USING (customer_id) "
                + "WHERE customers.name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            String name = "%" + customer.getName() + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String aName = resultSet.getString("project_name");
                int cost = resultSet.getInt("project_cost");
                projects.add(new Project(aName, cost));
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
        return projects;
    }*/

    /*@Override
    public Customer getByName(String name) {
        Customer customer;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers "
                + "WHERE name LIKE ?")) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = createT(resultSet);
            } else {
                customer = new Customer("Default");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return customer;
    }*/

    /*@Override
    public int deleteByName(String name) {
        int res;
        String sql = "DELETE FROM customers WHERE name LIKE ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
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
    }*/
}
