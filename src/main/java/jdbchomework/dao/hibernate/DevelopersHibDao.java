package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import jdbchomework.exceptions.DbConnectionException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;


public class DevelopersHibDao extends AbstractHibDao<Developer> implements DevelopersDao {

    private org.slf4j.Logger log = LoggerFactory.getLogger(AbstractHibDao.class);

    public DevelopersHibDao(String entityName, SessionFactory sessionFactory, Class<Developer> clazz) {
        super(entityName, sessionFactory, clazz);
    }

    @Override
    public boolean updateById(long id, Developer toUpdate) {
        boolean res;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Developer developer = (Developer) getById(id);
                developer.setName(toUpdate.getName());
                developer.setSkills(toUpdate.getSkills());
                session.update(developer);
                session.getTransaction().commit();
                res = true;
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                log.error(CANNOT_CONNECT_TO_DB, e);
                throw new DbConnectionException(CANNOT_CONNECT_TO_DB, e);
            }
        }
        return res;
    }
}