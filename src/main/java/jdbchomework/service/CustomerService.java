package jdbchomework.service;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;

import java.util.List;

public class CustomerService {

    private CustomersDao customersDao;

    public CustomerService(CustomersDao customersDao) {
        this.customersDao = customersDao;
    }

    public List<Customer> getAllCustomers() {
        return customersDao.getAll();
    }

    public void addCustomer(String name) {
        Customer customer = new Customer(name);
        customersDao.add(customer);
    }

    public Customer getCustomerById(int id) {
        return customersDao.getById(id);
    }

    public boolean deleteCustomerById(int id) {
        return customersDao.deleteById(id);
    }

    public boolean updateCustomerById(int id, String name) {
        Customer customer = new Customer(name);
        return customersDao.updateById(id, customer);
    }
}
