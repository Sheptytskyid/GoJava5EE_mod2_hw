package jdbchomework.dao.jdbc;

import jdbchomework.entity.Skill;

public interface SkillsDao extends Dao<Skill> {

    Skill getByName(String name);

    int deleteByName(String name);
}
