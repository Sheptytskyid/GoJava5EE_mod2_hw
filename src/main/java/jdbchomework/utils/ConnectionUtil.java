package jdbchomework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by GetFire on 26.02.2017.
 */
public class ConnectionUtil {

    static {
        loadDriver("com.mysql.jdbc.Driver");
    }

    private static Connection connection;


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
            throw new RuntimeException("Cannot find file ", e);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get connection to db", e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot close connection", e);
        }
    }

    public static void loadDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot download driver", e);
        }
    }
}
