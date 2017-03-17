package jdbchomework.controller;

import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
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

    public List<Developer> getAllCompanyDevelopers(int id) {
        return companyService.getCompanyDevelopers(id);
    }

    public void addCompany(String name, List<Project> projects, List<Developer> developers) {
        companyService.addCompany(name, projects, developers);
    }

    public Company getCompanyById(int id) {
        return companyService.getCompanyById(id);
    }

    public boolean deleteCompanyById(int id) {
        return companyService.deleteCompanyById(id);
    }

    public boolean updateCompanyById(int id, String name, List<Project> projects, List<Developer> developers) {
        return companyService.updateCompanyById(id, name, projects, developers);
    }
}
