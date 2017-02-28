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
}
