package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import org.hibernate.SessionFactory;


public class DevelopersHibDao extends AbstractHibDao<Developer> implements DevelopersDao {
    public DevelopersHibDao(String entityName, SessionFactory sessionFactory, Class<Developer> clazz) {
        super(entityName, sessionFactory, clazz);
    }
}