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

    public boolean deleteById(int id) {
        return skillService.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        return skillService.updateById(id, name);
    }
}
