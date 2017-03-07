package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.SkillsDao;
import jdbchomework.entity.Skill;
import org.hibernate.SessionFactory;

public class SkillsHibDao extends AbstractHibDao<Skill> implements SkillsDao {
    public SkillsHibDao(String entityName, SessionFactory sessionFactory, Class<Skill> aClass) {
        super(entityName, sessionFactory, aClass);
    }
}
