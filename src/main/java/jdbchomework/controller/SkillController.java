package jdbchomework.controller;

import jdbchomework.entity.Skill;
import jdbchomework.service.SkillService;

import java.util.List;

public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }

    public void add(String name) {
        skillService.add(name);
    }

    public Skill getById(int id) {
        return skillService.getById(id);
    }

    public void deleteById(int id) {
        skillService.deleteById(id);
    }

    public void updateById(int id, String name) {
        skillService.updateById(id, name);
    }
}
