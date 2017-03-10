package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;
import org.hibernate.SessionFactory;


public class ProjectsHibDao extends AbstractHibDao<Project> implements ProjectsDao {
    public ProjectsHibDao(String entityName, SessionFactory sessionFactory, Class<Project> clazz) {
        super(entityName, sessionFactory, clazz);
    }
}