package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import org.hibernate.SessionFactory;

public class CompaniesJdbcDao extends AbstractDao<Company> implements CompaniesDao {

    public CompaniesJdbcDao(SessionFactory sessionFactory, String entity, Class<Company> clazz) {
        super(sessionFactory, entity, clazz);
    }
}
