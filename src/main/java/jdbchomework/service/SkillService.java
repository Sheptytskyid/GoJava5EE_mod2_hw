package jdbchomework.service;

import jdbchomework.dao.jdbc.SkillsJdbcDao;
import jdbchomework.entity.Skill;

import java.util.List;

public class SkillService {

    private SkillsJdbcDao skillsJdbcDao;

    public SkillService(SkillsJdbcDao skillsJdbcDao) {
        this.skillsJdbcDao = skillsJdbcDao;
    }

    public List<Skill> getAll() {
        return skillsJdbcDao.getAll();
    }

    public void add(String name) {
        Skill skill = new Skill(name);
        skillsJdbcDao.add(skill);
    }

    public Skill getById(int id) {
        return skillsJdbcDao.getById(id);
    }

    public void deleteById(int id) {
        skillsJdbcDao.deleteById(id);
    }

    public void updateById(int id, String name) {
        Skill skill = new Skill(name);
        skillsJdbcDao.updateById(id, skill);

    }
}
