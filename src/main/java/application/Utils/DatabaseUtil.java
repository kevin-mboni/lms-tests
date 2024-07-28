package application.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/lms";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";

    // Private constructor to prevent instantiation
    private DatabaseUtil() {}

    // Static method to get a database connection
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC driver not found", e);
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Method to close a connection
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}
