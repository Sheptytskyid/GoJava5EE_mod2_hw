package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.TestDao;
import jdbchomework.entity.Test;
import org.hibernate.SessionFactory;


public class TestHibDao extends HibAbstractDao<Test> implements TestDao {
    public TestHibDao(String entityName, SessionFactory sessionFactory, Class<Test> aClass) {
        super(entityName, sessionFactory, aClass);
    }
}
