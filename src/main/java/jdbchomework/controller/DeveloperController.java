package jdbchomework.controller;

import jdbchomework.entity.Developer;
import jdbchomework.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }

    public void add(String name) {
        developerService.add(name);
    }

    public Developer getById(int id) {
        return developerService.getById(id);
    }

    public void deleteById(int id) {
        developerService.deleteById(id);
    }

    public void updateById(int id, String name) {
        developerService.updateById(id, name);
    }
}
