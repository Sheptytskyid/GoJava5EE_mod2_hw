package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Developer;
import jdbchomework.exceptions.DbConnectionException;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesJdbcDao extends AbstractJdbcDao<Company> implements CompaniesDao {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(CompaniesJdbcDao.class);
    private DevelopersJdbcDao developersJdbcDao;

    public CompaniesJdbcDao(Connection connection, String table, DevelopersJdbcDao developersJdbcDao) {
        super(connection, table);
        this.developersJdbcDao = developersJdbcDao;
    }

    protected Company createEntity(ResultSet resultSet) throws SQLException {
        return new Company(resultSet.getString("name"),
            resultSet.getInt("id"));
    }

    @Override
    public List<Developer> getCompanyDevelopers(long id) {
        List<Developer> developers = new ArrayList<>();
        String sql = "SELECT * FROM developers"
            + " INNER JOIN projects ON projects.id = developers.project_id"
            + " INNER JOIN companies ON companies.id = projects.company_id"
            + " WHERE companies.id = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Developer developer = new Developer(result.getInt("id"), result.getString("name"), result.getInt("salary"));
                developer.setSkills(developersJdbcDao.getDeveloperSkills(id));
                developers.add(developer);
            }
        } catch (SQLException e) {
            log.error("Cannot connect to DB", e);
            throw new DbConnectionException("Cannot connect to DB", e);
        }
        return developers;
    }
}