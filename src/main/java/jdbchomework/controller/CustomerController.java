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

    public void add() {
        System.out.println("Please enter company name: ");
        try {
            String name = Main.getReader().readLine();
            customerService.add(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getById() {
        Customer customer = null;
        System.out.println("Please enter company ID: ");
        try {
            String ID = Main.getReader().readLine();
            int id = Integer.valueOf(ID);
            customer = customerService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteById() {
        System.out.println("Please enter company ID: ");
        try {
            String ID = Main.getReader().readLine();
            int id = Integer.valueOf(ID);
            customerService.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateById() {
        try {
            System.out.println("Please enter company ID: ");
            String name = Main.getReader().readLine();
            int id = Integer.valueOf(name);
            System.out.println("Please enter company name: ");
            name = Main.getReader().readLine();
            customerService.updateById(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

