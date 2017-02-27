package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.SkillsDao;
import jdbchomework.entity.Skill;
import jdbchomework.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillsJdbcDao implements SkillsDao {

    private Connection connection;

    public SkillsJdbcDao() {
        this.connection = ConnectionUtil.getConnection();
    }

    @Override
    public Skill getByName(String name) {
        Skill result = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM skills WHERE name"
                + " LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createSkill(resultSet);
                connection.commit();
            } else {
                result = new Skill("Default");
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(Skill skill) {
        String name = skill.getName();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO skills(name) VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }

    @Override
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
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM skills;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Skill skill = createSkill(resultSet);
                result.add(skill);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

        return result;
    }

    @Override
    public Skill getById(int id) {
        Skill skill;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM skills WHERE skill_id=?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                skill = createSkill(rs);
                connection.commit();
            } else {
                System.out.println("Cannot find any company with id: " + id);
                skill = new Skill("Default");
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return skill;
    }

    @Override
    public int deleteById(int id) {
        int res;
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM skills WHERE skill_id = ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Successfully deleted");
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
    }

    @Override
    public void updateById(int id, Skill skill) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE skills SET name = ? WHERE "
                + "id = ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = skill.getName();
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to DB", e);
            }
        }
    }
    private Skill createSkill(ResultSet resultSet) throws SQLException {
        return new Skill(resultSet.getString("skill_name"),
                resultSet.getInt("skill_id"));

    }
}