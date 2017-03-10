package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.GenericDao;
import jdbchomework.entity.AbstractEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJdbcDao<T extends AbstractEntity> implements GenericDao<T> {

    public static final String CANNOT_CONNECT_TO_DB = "Cannot connect to DB";
    private org.slf4j.Logger log = LoggerFactory.getLogger(AbstractJdbcDao.class);
    private SessionFactory sessionFactory;
    private String entity;
    private Class<T> clazz;

    public AbstractJdbcDao(SessionFactory sessionFactory, String entity, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.entity = entity;
        this.clazz = clazz;
    }

    public void add(T toAdd) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(toAdd);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = session.createQuery("FROM " + entity).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }


    public T getById(long id) {
        T result = null;
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = session.get(clazz, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }

    public boolean updateById(long id, T toUpdate) {
        boolean result = false;
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            toUpdate.setId(id);
            session.update(toUpdate);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }

    @Override
    public boolean deleteById(long id) {
        boolean result = false;
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T entity = session.get(clazz, id);
            session.delete(entity);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}