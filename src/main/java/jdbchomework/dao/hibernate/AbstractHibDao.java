package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.GenericDao;
import jdbchomework.dao.model.ProblemDbConnection;
import jdbchomework.entity.AbstractEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
            log.error(CANNOT_CONNECT_TO_DB, e);
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }

    }

    @Override
    public List<T> getAll() {
        List<T> result;
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = session.createQuery("from " + entityName).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }

    @Override
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
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }
        return result;
    }

    @Override
    public boolean deleteById(long id) {
        Session session = getSession();
        Transaction transaction = null;
        boolean res = false;
        try {
            transaction = session.beginTransaction();
            T t = getById(id);
            session.delete(t);
            transaction.commit();
            res = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }
        return res;
    }

    @Override
    public boolean updateById(long id, T toUpdate) {
        Session session = getSession();
        Transaction transaction = null;
        boolean res;
        try {
            transaction = session.beginTransaction();
            T t = (T) getById(id);
            t.setName(toUpdate.getName());
            session.update(t);
            transaction.commit();
            res = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(CANNOT_CONNECT_TO_DB, e);
            throw new ProblemDbConnection(CANNOT_CONNECT_TO_DB, e);
        }
        return res;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}