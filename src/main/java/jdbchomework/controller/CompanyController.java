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
        return companyService.getAllCompanies();
    }

    public void addCompany(String name) {
        companyService.addCompany(name);
    }

    public Company getCompanyById(int id) {
        return companyService.getCompanyById(id);
    }

    public boolean deleteCompanyById(int id) {
        return companyService.deleteCompanyById(id);
    }

    public boolean updateCompanyById(int id, String name) {
        return companyService.updateCompanyById(id, name);
    }
}
