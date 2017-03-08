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
        return customerService.getAllCustomers();
    }

    public void addCustomer(String name) {
        customerService.addCustomer(name);
    }

    public Customer getCustomerById(int id) {
        return customerService.getCustomerById(id);
    }

    public boolean deleteCustomerById(int id) {
        return customerService.deleteCustomerById(id);
    }

    public boolean updateCustomerById(int id, String name) {
        return customerService.updateCustomerById(id, name);
    }
}

