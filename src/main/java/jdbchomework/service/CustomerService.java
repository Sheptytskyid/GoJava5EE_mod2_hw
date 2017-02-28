package jdbchomework.service;

import jdbchomework.dao.jdbc.CustomersJdbcDao;
import jdbchomework.entity.Customer;

import java.util.List;

public class CustomerService {

    private CustomersJdbcDao customersJdbcDao;

    public CustomerService(CustomersJdbcDao customersJdbcDao) {
        this.customersJdbcDao = customersJdbcDao;
    }

    public List<Customer> getAll() {
        return customersJdbcDao.getAll();
    }

    public void add(String name) {
        Customer customer = new Customer(name);
        customersJdbcDao.add(customer);
    }

    public Customer getById(int id) {
        return customersJdbcDao.getById(id);
    }

    public boolean deleteById(int id) {
        return customersJdbcDao.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        Customer customer = new Customer(name);
        return customersJdbcDao.updateById(id, customer);
    }
}
