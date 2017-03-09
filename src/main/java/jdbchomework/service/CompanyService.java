package jdbchomework.service;

import jdbchomework.dao.hibernate.CompaniesHibDao;
import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;

import java.util.List;

public class CompanyService {

    private CompaniesDao companiesDao;
    private CompaniesHibDao companiesHibDao;

    public CompanyService(CompaniesDao companiesDao) {
        this.companiesDao = companiesDao;
    }

    public CompanyService(CompaniesHibDao companiesDao) {
        this.companiesHibDao = companiesDao;
    }

    /**
     * Using by Hibernate
     */
    public List<Company> getAllCompanies() {
        return companiesHibDao.getAll();
    }

    /**
     * Using by Hibernate
     */
    public void addCompany(String name) {
        Company company = new Company(name);
        companiesHibDao.add(company);
    }

    public Company getCompanyById(int id) {
        return companiesHibDao.getById(id);
    }

    public boolean deleteCompanyById(int id) {
        return companiesHibDao.deleteById(id);
    }

    public boolean updateCompanyById(int id, String name) {
        Company company = new Company(name);
        return companiesHibDao.updateById(id, company);
    }

    public List<Developer> getCompanyDevelopers(int id) {
        return companiesHibDao.getCompanyDevelopers(id);
    }
}
