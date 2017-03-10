package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CompaniesDao;
import jdbchomework.entity.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompaniesJdbcDao extends AbstractJdbcDao<Company> implements CompaniesDao {

    public CompaniesJdbcDao(Connection connection, String table, String column) {
        super(connection, table, column);
    }

    protected Company createEntity(ResultSet resultSet) throws SQLException {
        return new Company(resultSet.getString("name"),
                resultSet.getInt("id"));
    }
}