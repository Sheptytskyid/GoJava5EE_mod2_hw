package jdbchomework.controller;

import jdbchomework.entity.Customer;
import jdbchomework.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAll() {
        return customerService.getAll();
    }

    public void add(String name) {
        customerService.add(name);
    }

    public Customer getById(int id) {
        return customerService.getById(id);
    }

    public boolean deleteById(int id) {
        return customerService.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        return customerService.updateById(id, name);
    }
}

