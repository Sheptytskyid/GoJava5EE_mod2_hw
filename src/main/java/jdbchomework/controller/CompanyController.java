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

    public void add(String name) {
        companyService.add(name);
    }

    public Company getById(int id) {
        return companyService.getById(id);
    }

    public void deleteById(int id) {
        companyService.deleteById(id);
    }

    public void updateById(int id, String name) {
        companyService.updateById(id, name);
    }
}
