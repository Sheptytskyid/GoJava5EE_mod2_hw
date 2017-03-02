package jdbchomework.service;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;

import java.util.List;

public class CompanyService {

    private CompaniesDao companiesJdbcDao;

    public CompanyService(CompaniesDao companiesJdbcDao) {
        this.companiesJdbcDao = companiesJdbcDao;
    }

    public List<Company> getAll() {
        return companiesJdbcDao.getAll();
    }

    public void add(String name) {
        Company company = new Company(name);
        companiesJdbcDao.add(company);
    }

    public Company getById(int id) {
        return companiesJdbcDao.getById(id);
    }

    public boolean deleteById(int id) {
        return companiesJdbcDao.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        Company company = new Company(name);
        return companiesJdbcDao.updateById(id, company);
    }
}
