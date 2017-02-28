package jdbchomework.controller;

import jdbchomework.Main;
import jdbchomework.entity.Customer;
import jdbchomework.service.CustomerService;

import java.io.IOException;
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

    public void deleteById(int id) {
        customerService.deleteById(id);
    }

    public void updateById(int id, String name) {
        customerService.updateById(id, name);
    }
}

