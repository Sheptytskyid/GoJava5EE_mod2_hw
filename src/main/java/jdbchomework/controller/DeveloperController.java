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

    public boolean deleteById(int id) {
        return developerService.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        return developerService.updateById(id, name);
    }
}
