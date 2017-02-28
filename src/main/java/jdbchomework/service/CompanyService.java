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
}
