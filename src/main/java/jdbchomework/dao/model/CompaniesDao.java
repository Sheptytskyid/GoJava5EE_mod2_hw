package jdbchomework.dao.model;

import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;

import java.util.List;

public interface CompaniesDao extends Dao<Company> {

    public Company getByName(String name);

    public List<Project> getCompaniesProjects(Company company);

    public int deleteByName(String name);

    public List<Developer> getAllDevelopers(String companyName);
}
