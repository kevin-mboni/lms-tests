package lms.main.lmstest.Models;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionsTest {

    @Test
    public void testConstructor() {
        Timestamp transactionDate = new Timestamp(System.currentTimeMillis());
        Date dueDate = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000); // 1 week later

        Transactions transaction = new Transactions(1, 101, 1001, "Effective Java", "John", "Doe", transactionDate, dueDate, false);

        assertEquals(1, transaction.getId());
        assertEquals(101, transaction.getBook_id());
        assertEquals(1001, transaction.getPatron_id());
        assertEquals("Effective Java", transaction.getBook_title());
        assertEquals("John", transaction.getPatron_firstName());
        assertEquals("Doe", transaction.getPatron_lastName());
        assertEquals(transactionDate, transaction.getTransaction_date());
        assertEquals(dueDate, transaction.getDue_date());
        assertFalse(transaction.isReturned());
    }

    @Test
    public void testSettersAndGetters() {
        Transactions transaction = new Transactions(1, 101, 1001, "Effective Java", "John", "Doe",
                new Timestamp(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000), false);

        transaction.setId(2);
        assertEquals(2, transaction.getId());

        transaction.setBook_id(102);
        assertEquals(102, transaction.getBook_id());

        transaction.setPatron_id(1002);
        assertEquals(1002, transaction.getPatron_id());

        transaction.setBook_title("Clean Code");
        assertEquals("Clean Code", transaction.getBook_title());

        transaction.setPatron_firstName("Jane");
        assertEquals("Jane", transaction.getPatron_firstName());

        transaction.setPatron_lastName("Smith");
        assertEquals("Smith", transaction.getPatron_lastName());

        Timestamp newTransactionDate = new Timestamp(System.currentTimeMillis() - 1000);
        transaction.setTransaction_date(newTransactionDate);
        assertEquals(newTransactionDate, transaction.getTransaction_date());

        Date newDueDate = new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000); // 2 weeks later
        transaction.setDue_date(newDueDate);
        assertEquals(newDueDate, transaction.getDue_date());

        transaction.setReturned(true);
        assertTrue(transaction.isReturned());
    }
}
