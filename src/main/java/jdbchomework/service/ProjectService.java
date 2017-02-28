package jdbchomework.service;

import jdbchomework.dao.jdbc.ProjectsJdbcDao;
import jdbchomework.entity.Project;

import java.util.List;

public class ProjectService {

    private ProjectsJdbcDao projectsJdbcDao;

    public ProjectService(ProjectsJdbcDao projectsJdbcDao) {
        this.projectsJdbcDao = projectsJdbcDao;
    }

    public List<Project> getAll() {
        return projectsJdbcDao.getAll();
    }

}
