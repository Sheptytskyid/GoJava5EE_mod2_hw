package jdbchomework.utils;

import jdbchomework.exceptions.DbConnectionException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new DbConnectionException("Cannot create Session Factory", e);
        }
    }

    private HibernateUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        try {
            sessionFactory.close();
        } catch (HibernateException e) {
            log.error("Cannot close sessionFactory", e);
            throw new DbConnectionException("Cannot close sessionFactory", e);
        }
    }
}