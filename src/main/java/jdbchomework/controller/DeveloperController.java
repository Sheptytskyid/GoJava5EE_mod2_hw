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
}
