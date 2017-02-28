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
    protected Skill createT(ResultSet resultSet) throws SQLException {
        return new Skill(resultSet.getInt("skill_id"), resultSet.getString("name"));
    }

        /*@Override
    public Skill getByName(String name) {
        Skill result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM skills WHERE name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createT(resultSet);
                connection.commit();
            } else {
                result = new Skill("Default");
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }*/

        /*@Override
    public int deleteByName(String name) {
        int res;
        String sql = "DELETE FROM skills WHERE name LIKE ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            String name1 = "%" + name + "%";
            statement.setString(1, name1);
            statement.executeUpdate();
            connection.commit();
            System.out.println(name + ", Successfully deleted");
            res = 1;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
        return res;
    }*/
}