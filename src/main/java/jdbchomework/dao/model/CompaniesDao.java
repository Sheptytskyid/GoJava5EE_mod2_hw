package jdbchomework.dao.model;

import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;

import java.util.List;

public interface CompaniesDao extends GenericDao<Company> {

    List<Developer> getCompanyDevelopers(long id);
}
