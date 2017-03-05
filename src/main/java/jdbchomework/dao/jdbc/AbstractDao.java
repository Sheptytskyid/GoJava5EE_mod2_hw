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

public abstract class AbstractDao<T extends AbstractEntity> implements GenericDao<T> {

    public static final String CANNOT_CONNECT_TO_DB = "Cannot connect to DB";
    protected static org.slf4j.Logger log = LoggerFactory.getLogger(AbstractDao.class);
    protected static SessionFactory sessionFactory;
    private String entity;
    private Class<T> clazz;

    public AbstractDao(SessionFactory sessionFactory, String entity, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.entity = entity;
        this.clazz = clazz;
    }

    public void add(T toAdd) {
        Session session = sessionFactory.openSession();
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
        } finally {
            session.close();
        }
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        Session session = sessionFactory.openSession();
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
        } finally {
            session.close();
        }
        return result;
    }


    public T getById(int id) {
        T result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = session.get(clazz, id);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("Cannot connect to DB", e);
        } finally {
            session.close();
        }
        return result;
    }

    public boolean updateById(int id, T toUpdate) {
        boolean result = false;
        Session session = sessionFactory.openSession();
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
            log.error("Cannot connect to DB", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        Session session = sessionFactory.openSession();
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
            log.error("Cannot connect to DB", e);
        } finally {
            session.close();
        }
        return result;
    }
}
