package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySQLDriverManager {

    private static final String url;
    private static final String username;
    private static final String password;

    private Connection connection;

    static {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/app.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = property.getProperty("url");
        username = property.getProperty("username");
        password = property.getProperty("password");
    }

    public MySQLDriverManager() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    }

    public Connection getConnection() throws RuntimeException, SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}



