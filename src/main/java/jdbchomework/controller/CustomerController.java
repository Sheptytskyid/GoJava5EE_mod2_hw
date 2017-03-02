package jdbchomework.controller;

import jdbchomework.entity.Customer;
import jdbchomework.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    public void addCustomer(String name) {
        customerService.add(name);
    }

    public Customer getCustomerById(int id) {
        return customerService.getById(id);
    }

    public boolean deleteCustomerById(int id) {
        return customerService.deleteById(id);
    }

    public boolean updateCustomerById(int id, String name) {
        return customerService.updateById(id, name);
    }
}

