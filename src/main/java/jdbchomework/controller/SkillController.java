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
}
