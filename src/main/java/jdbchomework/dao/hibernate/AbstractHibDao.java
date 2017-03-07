package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.GenericDao;
import jdbchomework.entity.AbstractEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class AbstractHibDao<T extends AbstractEntity> implements GenericDao<T> {
    protected SessionFactory sessionFactory;
    private String entityName;
    private Class<T> aClass;

    public AbstractHibDao(String entityName, SessionFactory sessionFactory, Class<T> aClass) {
        this.entityName = entityName;
        this.sessionFactory = sessionFactory;
        this.aClass = aClass;

    }


    @Override
    public void add(T toAdd) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(toAdd);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot save to DB", e);
        }


    }

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<T>();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("from " + entityName).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    @Override
    public T getById(long id) {
        T result = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            result = session.get(aClass, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }


    @Override
    public boolean deleteById(int id) {
        Transaction transaction = null;
        boolean res = false;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T t = getById(id);
            session.delete(t);
            transaction.commit();
            res = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return res;
    }

    @Override
    public boolean updateById(int id, T toUpdate) {
        Transaction transaction = null;
        boolean res = false;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T t = (T) getById(id);
            t.setName(toUpdate.getName());
            session.update(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return res;
    }
}
