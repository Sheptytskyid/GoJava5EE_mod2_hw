package jdbchomework.controller;

import jdbchomework.entity.Company;
import jdbchomework.service.CompanyService;

import java.util.List;

public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Company> getAllCompanies() {
        return companyService.getAll();
    }

    public void addCompany(String name) {
        companyService.add(name);
    }

    public Company getCompanyById(int id) {
        return companyService.getById(id);
    }

    public boolean deleteCompanyById(int id) {
        return companyService.deleteById(id);
    }

    public boolean updateCompanyById(int id, String name) {
        return companyService.updateById(id, name);
    }
}
