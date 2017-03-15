package jdbchomework.controller;

import jdbchomework.entity.Developer;
import jdbchomework.entity.Skill;
import jdbchomework.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    public void addDeveloper(String name) {
        developerService.addDeveloper(name);
    }

    public Developer getDeveloperById(int id) {
        return developerService.getDeveloperById(id);
    }

    public boolean deleteDeveloperById(int id) {
        return developerService.deleteDeveloperById(id);
    }

    public boolean updateDeveloperById(int id, String name, List<Skill> skills) {
        return developerService.updateDeveloperById(id, name, skills);
    }
}
