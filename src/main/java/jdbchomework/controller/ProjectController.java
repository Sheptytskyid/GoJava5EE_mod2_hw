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
}
