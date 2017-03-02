package jdbchomework.controller;

import jdbchomework.entity.Skill;
import jdbchomework.service.SkillService;

import java.util.List;

public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    public void addSkill(String name) {
        skillService.add(name);
    }

    public Skill getSkillById(int id) {
        return skillService.getById(id);
    }

    public boolean deleteSkillById(int id) {
        return skillService.deleteById(id);
    }

    public boolean updateSkillById(int id, String name) {
        return skillService.updateById(id, name);
    }
}
