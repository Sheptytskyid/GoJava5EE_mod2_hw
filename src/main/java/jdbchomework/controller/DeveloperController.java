package jdbchomework.controller;

import jdbchomework.entity.Developer;
import jdbchomework.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<Developer> getAllDevelopers() {
        return developerService.getAll();
    }

    public void addDeveloper(String name) {
        developerService.add(name);
    }

    public Developer getDeveloperById(int id) {
        return developerService.getById(id);
    }

    public boolean deleteDeveloperById(int id) {
        return developerService.deleteById(id);
    }

    public boolean updateDeveloperById(int id, String name) {
        return developerService.updateById(id, name);
    }
}
