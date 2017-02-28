package jdbchomework.controller;

import jdbchomework.Main;
import jdbchomework.entity.Company;
import jdbchomework.service.CompanyService;

import java.io.IOException;
import java.util.List;

public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Company> getAll() {
        return companyService.getAll();
    }

    public void add() {
        System.out.println("Please enter company name: ");
        try {
            String name = Main.getReader().readLine();
            companyService.add(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Company getById() {
        Company company = null;
        System.out.println("Please enter company ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            company = companyService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void deleteById() {
        System.out.println("Please enter company ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            companyService.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateById() {
        try {
            System.out.println("Please enter company ID: ");
            int id = Integer.valueOf(Main.getReader().readLine());
            System.out.println("Please enter company name: ");
            String name = Main.getReader().readLine();
            companyService.updateById(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
