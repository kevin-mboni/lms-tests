package lms.main.lmstest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = System.getenv("url");
    private static final String user = System.getenv("username");
    private static final String password = System.getenv("password");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
