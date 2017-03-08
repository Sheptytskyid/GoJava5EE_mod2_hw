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
        return skillService.getAllSkills();
    }

    public void addSkill(String name) {
        skillService.addSkill(name);
    }

    public Skill getSkillById(int id) {
        return skillService.getSkillById(id);
    }

    public boolean deleteSkillById(int id) {
        return skillService.deleteSkillById(id);
    }

    public boolean updateSkillById(int id, String name) {
        return skillService.updateSkillById(id, name);
    }
}
