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
}
