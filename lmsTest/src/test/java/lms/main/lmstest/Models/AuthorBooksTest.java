package lms.main.lmstest.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AuthorBooksTest {

    @Test
    public void testConstructor() {
        int bookId = 1;
        int authorId = 2;
        AuthorBooks authorBooks = new AuthorBooks(bookId, authorId);

        assertEquals(bookId, authorBooks.getBookId());
        assertEquals(authorId, authorBooks.getAuthorId());
    }

    @Test
    public void testGetBookId() {
        int bookId = 1;
        int authorId = 2;
        AuthorBooks authorBooks = new AuthorBooks(bookId, authorId);

        assertEquals(bookId, authorBooks.getBookId());
    }

    @Test
    public void testSetBookId() {
        int bookId = 1;
        int authorId = 2;
        AuthorBooks authorBooks = new AuthorBooks(bookId, authorId);

        int newBookId = 3;
        authorBooks.setBookId(newBookId);

        assertEquals(newBookId, authorBooks.getBookId());
    }

    @Test
    public void testGetAuthorId() {
        int bookId = 1;
        int authorId = 2;
        AuthorBooks authorBooks = new AuthorBooks(bookId, authorId);

        assertEquals(authorId, authorBooks.getAuthorId());
    }

    @Test
    public void testSetAuthorId() {
        int bookId = 1;
        int authorId = 2;
        AuthorBooks authorBooks = new AuthorBooks(bookId, authorId);

        int newAuthorId = 3;
        authorBooks.setAuthorId(newAuthorId);

        assertEquals(newAuthorId, authorBooks.getAuthorId());
    }
}
