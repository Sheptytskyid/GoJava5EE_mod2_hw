package jdbchomework.controller;

import jdbchomework.entity.Project;
import jdbchomework.service.ProjectService;

import java.util.List;

public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<Project> getAll() {
        return projectService.getAll();
    }

    public void add(String name, int cost) {
        projectService.add(name, cost);
    }

    public Project getById(int id) {
        return projectService.getById(id);
    }

    public void deleteById(int id) {
        projectService.deleteById(id);
    }

    public void updateById(int id, String name, int cost) {
        Project project = new Project(name, cost);
        projectService.updateById(id, project);
    }

}
