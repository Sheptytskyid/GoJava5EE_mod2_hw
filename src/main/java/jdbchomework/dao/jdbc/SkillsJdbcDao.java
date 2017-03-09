package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.SkillsDao;
import jdbchomework.entity.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillsJdbcDao extends AbstractDao<Skill> implements SkillsDao {

    public SkillsJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    @Override
    protected Skill createEntity(ResultSet resultSet) throws SQLException {
        return new Skill(resultSet.getInt("id"), resultSet.getString("name"));
    }
}