package lms.main.lmstest.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorsTest {

    private Authors author;

    @BeforeEach
    public void setUp() {
        author = new Authors(1, "John", "Doe", "john.doe@example.com");
    }

    @Test
    public void testGetId() {
        assertEquals(1, author.getId());
    }

    @Test
    public void testSetId() {
        author.setId(2);
        assertEquals(2, author.getId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", author.getFirst_name());
    }

    @Test
    public void testSetFirstName() {
        author.setFirst_name("Jane");
        assertEquals("Jane", author.getFirst_name());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", author.getLast_name());
    }

    @Test
    public void testSetLastName() {
        author.setLast_name("Smith");
        assertEquals("Smith", author.getLast_name());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", author.getEmail());
    }

    @Test
    public void testSetEmail() {
        author.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", author.getEmail());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe", author.toString());
    }

    @Test
    public void testAuthorConstructor() {
        Authors newAuthor = new Authors(2, "Jane", "Smith", "jane.smith@example.com");
        assertNotNull(newAuthor);
        assertEquals(2, newAuthor.getId());
        assertEquals("Jane", newAuthor.getFirst_name());
        assertEquals("Smith", newAuthor.getLast_name());
        assertEquals("jane.smith@example.com", newAuthor.getEmail());
    }
}
