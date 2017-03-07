package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;
import org.hibernate.SessionFactory;

public class ProjectsJdbcDao extends AbstractDao<Project> implements ProjectsDao {

    public ProjectsJdbcDao(SessionFactory sessionFactory, String entity, Class<Project> clazz) {
        super(sessionFactory, entity, clazz);
    }
}
