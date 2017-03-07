package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;


public class CompaniesHibDao extends AbstractHibDao<Company> implements CompaniesDao {

    public CompaniesHibDao(String entityName, SessionFactory sessionFactory, Class<Company> aClass) {
        super(entityName, sessionFactory, aClass);
    }

//    public List<Developer> getDeveloper(long id) {
//        Company company = getById(id);
//        return company.getDevelopers();
//    }

    public List<Developer> getCompanyDevelopers(long id) {
        List result = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String sql = "select * from developers"
                    + " inner join projects on projects.id = developers.project_id"
                    + " inner join companies on companies.id = projects.company_id"
                    + " where companies.id = :id";
            NativeQuery query = session.createNativeQuery(sql);
            query.addEntity(Developer.class);
            query.setParameter("id", id);
            result.addAll(query.list());
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot save to DB", e);
        }
        return result;
    }
}
