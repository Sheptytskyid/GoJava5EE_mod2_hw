package jdbchomework.controller;

import jdbchomework.entity.Project;
import jdbchomework.service.ProjectService;

import java.util.List;

public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    public void addProject(String name, int cost) {
        projectService.add(name, cost);
    }

    public Project getProjectById(int id) {
        return projectService.getById(id);
    }

    public boolean deleteProjectById(int id) {
        return projectService.deleteById(id);
    }

    public boolean updateProjectById(int id, String name, int cost) {
        Project project = new Project(name, cost);
        return projectService.updateById(id, project);
    }
}
