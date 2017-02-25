package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;
import jdbchomework.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersJdbcDao implements CustomersDao {
    private Connection connection;

    public CustomersJdbcDao(Connection connection) {
        this.connection = connection;
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
    public Customer getByName(String aName) {
        Customer customer = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE name LIKE ?")) {
            aName = "%" + aName + "%";
            statement.setString(1, aName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = createCustomer(resultSet);
            } else {
                customer = new Customer("Default");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer customer = createCustomer(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return customers;
    }

    @Override
    public int deleteByName(String aName) {
        int res;
        String sql = "DELETE FROM customers WHERE name LIKE ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name1 = "%" + aName + "%";
            statement.setString(1, name1);
            statement.executeUpdate();
            connection.commit();
            System.out.println(aName + ", Successfully deleted");
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
    public Customer getByID(int id) {
        Customer customer;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE customer_id = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                customer = createCustomer(rs);
                connection.commit();
            } else {
                System.out.println("Cannot find any company with id: " + id);
                customer = new Customer("Default");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return customer;
    }

    @Override
    public int deleteByID(int id) {
        int res;
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE customer_id = ?;")) {
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
    public void updateByID(int id, Customer toUpdate) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE customers SET name = ? WHERE customer_id =?;")) {
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
    public List<Project> getCustomersProject(Customer customer) {
        List<Project> projects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT projects.name AS project_name, projects.cost AS project_cost FROM "
                + "projects INNER JOIN customers USING (customer_id) WHERE customers.name LIKE ?;")) {
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
    }

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(resultSet.getInt("customer_id"),
                resultSet.getString("name"));

    }
}
