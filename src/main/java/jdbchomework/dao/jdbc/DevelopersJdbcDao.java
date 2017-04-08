package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Skill;
import jdbchomework.exceptions.DbConnectionException;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopersJdbcDao extends AbstractJdbcDao<Developer> implements DevelopersDao {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(DevelopersJdbcDao.class);

    public DevelopersJdbcDao(Connection connection, String table) {
        super(connection, table);
    }

    @Override
    public boolean updateById(long id, Developer toUpdate) {
        boolean result = false;
        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE developers SET name = ?, salary = ? WHERE developer_id =?;")) {
            statement.setString(1, toUpdate.getName());
            statement.setInt(2, toUpdate.getSalary());
            statement.setLong(3, id);
            if (statement.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new DbConnectionException("Cannot connect to DB", e);
        }
        return result;
    }

    public List<Skill> getDeveloperSkills(long developerId) {
        List<Skill> skills = new ArrayList<>();
        String sql = "select skills.id, skills.name "
            + "from developers_skills inner join skills on developers_skills.skill_id=skills.id "
            + "where developers_skills.developer_id= ? ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, developerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Skill skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"));
                skills.add(skill);
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new DbConnectionException("Cannot connect to DB", e);
        }
        return skills;
    }

    @Override
    protected Developer createEntity(ResultSet resultSet) throws SQLException {
        return new Developer(resultSet.getLong("id"), resultSet.getString("name"),
                resultSet.getInt("salary"));
    }
}