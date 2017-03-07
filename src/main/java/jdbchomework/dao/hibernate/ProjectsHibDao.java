package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;
import org.hibernate.SessionFactory;


public class ProjectsHibDao extends HibAbstractDao<Project> implements ProjectsDao {
    public ProjectsHibDao(String entityName, SessionFactory sessionFactory, Class<Project> aClass) {
        super(entityName, sessionFactory, aClass);
    }
}