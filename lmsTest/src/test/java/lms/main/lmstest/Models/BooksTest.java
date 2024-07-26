package lms.main.lmstest.Models;

import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

public class BooksTest {

    @Test
    public void testGetId() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        assertEquals(1, book.getId());
    }

    @Test
    public void testSetId() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        book.setId(2);
        assertEquals(2, book.getId());
    }

    @Test
    public void testGetTitle() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        assertEquals("Test Title", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testGetPublishedDate() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        assertEquals(Date.valueOf("2023-01-01"), book.getPublished_date());
    }

    @Test
    public void testSetPublishedDate() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        Date newDate = Date.valueOf("2024-01-01");
        book.setPublished_date(newDate);
        assertEquals(newDate, book.getPublished_date());
    }

    @Test
    public void testGetIsbn() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        assertEquals("1234567890", book.getIsbn());
    }

    @Test
    public void testSetIsbn() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        book.setIsbn("0987654321");
        assertEquals("0987654321", book.getIsbn());
    }

    @Test
    public void testGetAvailability() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        assertTrue(book.getAvailability());
    }

    @Test
    public void testSetAvailability() {
        Books book = new Books(1, "Test Title", Date.valueOf("2023-01-01"), "1234567890", true);
        book.setAvailability(false);
        assertFalse(book.getAvailability());
    }
}
