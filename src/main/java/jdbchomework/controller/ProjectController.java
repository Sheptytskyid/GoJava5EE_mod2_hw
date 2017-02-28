package jdbchomework.controller;

import jdbchomework.Main;
import jdbchomework.entity.Project;
import jdbchomework.service.ProjectService;

import java.io.IOException;
import java.util.List;

public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<Project> getAll() {
        return projectService.getAll();
    }

    public void add() {
        try {
            System.out.println("Please enter project name: ");
            String name = Main.getReader().readLine();
            System.out.println("Please enter project cost: ");
            String cs = Main.getReader().readLine();
            int cost = Integer.valueOf(cs);
            projectService.add(name, cost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Project getById() {
        Project project = null;
        try {
            System.out.println("Please enter project ID: ");
            int id = Integer.valueOf(Main.getReader().readLine());
            project = projectService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return project;
    }

    public void deleteById() {
        try {
            System.out.println("Please enter project ID: ");
            int id = Integer.valueOf(Main.getReader().readLine());
            projectService.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateById() {
        try {
            System.out.println("Please enter project ID: ");
            int id = Integer.valueOf(Main.getReader().readLine());
            System.out.println("Please enter project name: ");
            String name = Main.getReader().readLine();
            System.out.println("Please enter project cost: ");
            int cost = Integer.valueOf(Main.getReader().readLine());
            Project project = new Project(name, cost);
            projectService.updateById(id, project);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
