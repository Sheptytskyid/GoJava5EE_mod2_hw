package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import org.hibernate.SessionFactory;


public class DevelopersHibDao extends HibAbstractDao<Developer> implements DevelopersDao {
    public DevelopersHibDao(String entityName, SessionFactory sessionFactory, Class<Developer> aClass) {
        super(entityName, sessionFactory, aClass);
    }
}
