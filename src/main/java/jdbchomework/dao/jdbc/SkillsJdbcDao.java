package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.SkillsDao;
import jdbchomework.entity.Skill;
import org.hibernate.SessionFactory;

public class SkillsJdbcDao extends AbstractDao<Skill> implements SkillsDao {

    public SkillsJdbcDao(SessionFactory sessionFactory, String entity, Class<Skill> clazz) {
        super(sessionFactory, entity, clazz);
    }
}