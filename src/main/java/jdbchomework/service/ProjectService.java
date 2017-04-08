package jdbchomework.service;

import jdbchomework.dao.model.ProjectsDao;
import jdbchomework.entity.Project;

import java.util.List;

public class ProjectService {

    private ProjectsDao projectsDao;

    public ProjectService(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    public List<Project> getAllProjects() {
        return projectsDao.getAll();
    }

    public void addProject(String name, int cost) {
        Project project = new Project(name, cost);
        projectsDao.add(project);
    }

    public Project getProjectById(int id) {
        return projectsDao.getById(id);
    }

    public boolean deleteProjectById(int id) {
        return projectsDao.deleteById(id);
    }

    public boolean updateProjectById(int id, Project project) {
        return projectsDao.updateById(id, project);
    }
}
