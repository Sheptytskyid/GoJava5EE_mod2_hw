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
        return projectService.getAllProjects();
    }

    public void addProject(String name, int cost) {
        projectService.addProject(name, cost);
    }

    public Project getProjectById(int id) {
        return projectService.getProjectById(id);
    }

    public boolean deleteProjectById(int id) {
        return projectService.deleteProjectById(id);
    }

    public boolean updateProjectById(int id, String name, int cost) {
        return projectService.updateProjectById(id, name, cost);
    }
}
