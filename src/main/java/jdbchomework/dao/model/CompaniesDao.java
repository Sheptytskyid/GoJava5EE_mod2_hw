package jdbchomework.dao.model;

import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;

import java.util.List;

public interface CompaniesDao extends Dao<Company> {

    Company getByName(String name);

    List<Project> getCompaniesProjects(Company company);

    int deleteByName(String name);

    List<Developer> getAllDevelopers(String companyName);
}
