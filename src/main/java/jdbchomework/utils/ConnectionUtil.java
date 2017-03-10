package jdbchomework.utils;

import jdbchomework.dao.model.ProblemDbConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection connection;

    private ConnectionUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static Connection getConnection() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            String url = property.getProperty("db.url");
            String user = property.getProperty("db.user");
            String password = property.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            throw new ProblemDbConnection("Cannot find file ", e);
        } catch (SQLException e) {
            throw new ProblemDbConnection("Cannot get connection to db", e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ProblemDbConnection("Cannot close connection", e);
        }
    }
}