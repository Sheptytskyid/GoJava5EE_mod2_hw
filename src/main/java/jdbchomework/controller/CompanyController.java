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
}
