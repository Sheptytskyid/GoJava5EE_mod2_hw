package jdbchomework.controller;

import jdbchomework.entity.Company;
import jdbchomework.service.CompanyService;

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

    public boolean deleteById(int id) {
        return companyService.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        return companyService.updateById(id, name);
    }
}
