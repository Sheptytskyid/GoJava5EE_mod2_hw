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

    public void add(String name, int cost) {
        Project project = new Project(name, cost);
        projectsJdbcDao.add(project);
    }

    public Project getById(int id) {
        return projectsJdbcDao.getById(id);
    }

    public void deleteById(int id) {
        projectsJdbcDao.deleteById(id);
    }

    public void updateById(int id, Project project) {
        projectsJdbcDao.updateById(id, project);

    }

}
