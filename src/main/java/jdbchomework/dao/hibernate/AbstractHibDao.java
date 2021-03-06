package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.GenericDao;
import jdbchomework.entity.AbstractEntity;
import jdbchomework.exceptions.DbConnectionException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import java.util.List;


public class AbstractHibDao<T extends AbstractEntity> implements GenericDao<T> {

    public static final String CANNOT_CONNECT_TO_DB = "Cannot connect to DB";
    private org.slf4j.Logger log = LoggerFactory.getLogger(AbstractHibDao.class);
    protected SessionFactory sessionFactory;
    private String entityName;
    private Class<T> clazz;

    public AbstractHibDao(String entityName, SessionFactory sessionFactory, Class<T> clazz) {
        this.entityName = entityName;
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;

    }

    @Override
    public void add(T toAdd) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(toAdd);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                log.error(CANNOT_CONNECT_TO_DB, e);
                throw new DbConnectionException(CANNOT_CONNECT_TO_DB, e);
            }
        }
    }

    @Override
    public List<T> getAll() {
        List<T> result;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                result = session.createQuery("from " + entityName).list();
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                log.error(CANNOT_CONNECT_TO_DB, e);
                throw new DbConnectionException(CANNOT_CONNECT_TO_DB, e);
            }
        }
        return result;
    }

    @Override
    public T getById(long id) {
        T result = null;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                result = session.get(clazz, id);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                log.error(CANNOT_CONNECT_TO_DB, e);
                throw new DbConnectionException(CANNOT_CONNECT_TO_DB, e);
            }
        }
        return result;
    }

    @Override
    public boolean deleteById(long id) {
        boolean res = false;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                T t = getById(id);
                session.delete(t);
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

    @Override
    public boolean updateById(long id, T toUpdate) {
        boolean res;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                T t = (T) getById(id);
                t.setName(toUpdate.getName());
                session.update(t);
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