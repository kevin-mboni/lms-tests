package lms.main.lmstest.config;
import java.sql.*;
import java.util.LinkedList;

import lms.main.lmstest.Models.Authors;
public class AuthorsModel {

    public static void createTable() {
        String createAuthorsTable = "CREATE TABLE IF NOT EXISTS Authors ("
                + "id SERIAL PRIMARY KEY,"
                + "First_Name VARCHAR(255) NOT NULL,"
                + "Last_Name VARCHAR(255) NOT NULL,"
                + "Email VARCHAR(255) NOT NULL"
                + ");";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createAuthorsTable);
            System.out.println("Authors table created");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(Authors author) {
        String insertAuthor = "INSERT INTO Authors(First_Name, Last_Name, Email) VALUES(?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertAuthor)) {
            pstmt.setString(1, author.getFirst_name());
            pstmt.setString(2, author.getLast_name());
            pstmt.setString(3, author.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Authors> getAuthors() {
        LinkedList<Authors> authors = new LinkedList<>();
        String selectAuthors = "SELECT * FROM Authors";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectAuthors)) {
            while (rs.next()) {
                Authors author = new Authors(
                        rs.getInt("id"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Email")
                );
                authors.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public void updateAuthor(Authors author) {
        String updateAuthorSql = "UPDATE Authors set First_Name=?,Last_Name=?,email=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateAuthorSql)) {
            pstmt.setString(1, author.getFirst_name());
            pstmt.setString(2, author.getLast_name());
            pstmt.setString(3, author.getEmail());
            pstmt.setInt(4, author.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteAuthor(int authorId) {
        String deleteAuthorSql = "DELETE FROM Authors WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteAuthorSql)) {
            pstmt.setInt(1, authorId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//public static  void main(String[] args) {
//        createTable();
//}

}




