package jdbchomework.service;

import jdbchomework.dao.jdbc.CompaniesJdbcDao;
import jdbchomework.entity.Company;

import java.util.List;

public class CompanyService {

    private CompaniesJdbcDao companiesJdbcDao;

    public CompanyService(CompaniesJdbcDao companiesJdbcDao) {
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

    public void deleteById(int id) {
        companiesJdbcDao.deleteById(id);
    }

    public void updateById(int id, String name) {
        Company company = new Company(name);
        companiesJdbcDao.updateById(id, company);

    }

}
