package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.dao.model.ProblemDbConnection;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;


public class CompaniesHibDao extends AbstractHibDao<Company> implements CompaniesDao {
    private org.slf4j.Logger log = LoggerFactory.getLogger(CompaniesHibDao.class);

    public CompaniesHibDao(String entityName, SessionFactory sessionFactory, Class<Company> clazz) {
        super(entityName, sessionFactory, clazz);
    }

    public List<Developer> getCompanyDevelopers(long id) {
        List result = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from developers"
                    + " inner join projects on projects.id = developers.project_id"
                    + " inner join companies on companies.id = projects.company_id"
                    + " where companies.id = :id";
            NativeQuery query = session.createNativeQuery(sql);
            query.addEntity(Developer.class);
            query.setParameter("id", id);
            result.addAll(query.list());
        } catch (HibernateException e) {
            log.error(CANNOT_CONNECT_TO_DB, e);
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }
}