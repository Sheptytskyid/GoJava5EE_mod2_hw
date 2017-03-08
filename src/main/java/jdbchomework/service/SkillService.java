package jdbchomework.service;

import jdbchomework.dao.model.SkillsDao;
import jdbchomework.entity.Skill;

import java.util.List;

public class SkillService {

    private SkillsDao skillsDao;

    public SkillService(SkillsDao skillsDao) {
        this.skillsDao = skillsDao;
    }

    public List<Skill> getAllSkills() {
        return skillsDao.getAll();
    }

    public void addSkill(String name) {
        Skill skill = new Skill(name);
        skillsDao.add(skill);
    }

    public Skill getSkillById(int id) {
        return skillsDao.getById(id);
    }

    public boolean deleteSkillById(int id) {
        return skillsDao.deleteById(id);
    }

    public boolean updateSkillById(int id, String name) {
        Skill skill = new Skill(name);
        return skillsDao.updateById(id, skill);
    }
}
