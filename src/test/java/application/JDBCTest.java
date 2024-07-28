package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JDBCTest {

    @Test
    public void testConnection() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/lms";
        String username = "postgres";
        String password = "12345";
        Connection connection = null;

        try {
            // Explicitly load the JDBC driver class
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Assert that connection is not null
            assertNotNull(connection, "Connection should not be null");
            System.out.println("Connected to the database!");

        } catch (ClassNotFoundException e) {
            fail("JDBC Driver not found! " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            fail("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close connection in finally block
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
