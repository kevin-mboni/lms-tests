package lms.main.lmstest.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibrariansTest {

    @Test
    public void testGettersAndSetters() {
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String username = "johndoe";
        String password = "password123";

        // Create a new Librarians instance
        Librarians librarian = new Librarians(id, firstName, lastName, email, username, password);

        // Test getters
        assertEquals(id, librarian.getId());
        assertEquals(firstName, librarian.getFirstName());
        assertEquals(lastName, librarian.getLastName());
        assertEquals(email, librarian.getEmail());
        assertEquals(username, librarian.getUsername());
        assertEquals(password, librarian.getPassword());

        // Test setters
        int newId = 2;
        String newFirstName = "Jane";
        String newLastName = "Smith";
        String newEmail = "jane.smith@example.com";
        String newUsername = "janesmith";
        String newPassword = "newpassword456";

        librarian.setId(newId);
        librarian.setFirstName(newFirstName);
        librarian.setLastName(newLastName);
        librarian.setEmail(newEmail);
        librarian.setUsername(newUsername);
        librarian.setPassword(newPassword);

        assertEquals(newId, librarian.getId());
        assertEquals(newFirstName, librarian.getFirstName());
        assertEquals(newLastName, librarian.getLastName());
        assertEquals(newEmail, librarian.getEmail());
        assertEquals(newUsername, librarian.getUsername());
        assertEquals(newPassword, librarian.getPassword());
    }
}
