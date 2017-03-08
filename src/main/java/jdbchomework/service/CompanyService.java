package jdbchomework.service;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;

import java.util.List;

public class CompanyService {

    private CompaniesDao companiesDao;

    public CompanyService(CompaniesDao companiesDao) {
        this.companiesDao = companiesDao;
    }

    public List<Company> getAllCompanies() {
        return companiesDao.getAll();
    }

    public void addCompany(String name) {
        Company company = new Company(name);
        companiesDao.add(company);
    }

    public Company getCompanyById(int id) {
        return companiesDao.getById(id);
    }

    public boolean deleteCompanyById(int id) {
        return companiesDao.deleteById(id);
    }

    public boolean updateCompanyById(int id, String name) {
        Company company = new Company(name);
        return companiesDao.updateById(id, company);
    }
}
