package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import org.hibernate.SessionFactory;

public class DevelopersJdbcDao extends AbstractDao<Developer> implements DevelopersDao {

    public DevelopersJdbcDao(SessionFactory sessionFactory, String entity, Class<Developer> clazz) {
        super(sessionFactory, entity, clazz);
    }
}
