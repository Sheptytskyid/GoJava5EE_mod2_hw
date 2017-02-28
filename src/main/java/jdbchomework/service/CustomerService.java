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
}
