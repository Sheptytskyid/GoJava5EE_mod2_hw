package jdbchomework.dao.model;

import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;

import java.util.List;

public interface CompaniesDao {

    public void addCompany(Company company);

    public List<Company> getAllCompanies();

    public Company getByName(String name);

    public List<Project> getCompaniesProjects(Company company);

    public int deleteByName(String name);

    public void updateById(int id, Company company);

    public Company getById(int id);

    public List<Developer> getAllDevelopers(String companyName);
}
