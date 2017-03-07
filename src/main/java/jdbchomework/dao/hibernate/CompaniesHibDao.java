package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import org.hibernate.SessionFactory;

import java.util.List;


public class CompaniesHibDao extends HibAbstractDao<Company> implements CompaniesDao {

    public CompaniesHibDao(String entityName, SessionFactory sessionFactory, Class<Company> aClass) {
        super(entityName, sessionFactory, aClass);
    }

    public List<Developer> getDeveloper(long id) {
        Company company = getById(id);
        return company.getDevelopers();
    }
}
