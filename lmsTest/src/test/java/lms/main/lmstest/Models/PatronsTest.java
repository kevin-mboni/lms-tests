package lms.main.lmstest.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatronsTest {

    @Test
    public void testDefaultConstructor() {
        Patrons patron = new Patrons();
        assertNull(patron.getFirstName());
        assertNull(patron.getLastName());
        assertNull(patron.getEmail());
        assertNull(patron.getAddress());
        assertNull(patron.getPhone());
        assertNull(patron.getUsername());
        assertNull(patron.getPassword());
    }

    @Test
    public void testConstructorWithAllFields() {
        Patrons patron = new Patrons(1, "John", "Doe", "john.doe@example.com", "123 Main St", "555-1234", "johndoe", "password123");
        assertEquals(1, patron.getId());
        assertEquals("John", patron.getFirstName());
        assertEquals("Doe", patron.getLastName());
        assertEquals("john.doe@example.com", patron.getEmail());
        assertEquals("123 Main St", patron.getAddress());
        assertEquals("555-1234", patron.getPhone());
        assertEquals("johndoe", patron.getUsername());
        assertEquals("password123", patron.getPassword());
    }

    @Test
    public void testConstructorWithoutId() {
        Patrons patron = new Patrons("Jane", "Doe", "jane.doe@example.com", "456 Elm St", "555-5678", "janedoe", "password456");
        assertEquals("Jane", patron.getFirstName());
        assertEquals("Doe", patron.getLastName());
        assertEquals("jane.doe@example.com", patron.getEmail());
        assertEquals("456 Elm St", patron.getAddress());
        assertEquals("555-5678", patron.getPhone());
        assertEquals("janedoe", patron.getUsername());
        assertEquals("password456", patron.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        Patrons patron = new Patrons();

        patron.setId(2);
        assertEquals(2, patron.getId());

        patron.setFirstName("Alice");
        assertEquals("Alice", patron.getFirstName());

        patron.setLastName("Smith");
        assertEquals("Smith", patron.getLastName());

        patron.setEmail("alice.smith@example.com");
        assertEquals("alice.smith@example.com", patron.getEmail());

        patron.setAddress("789 Pine St");
        assertEquals("789 Pine St", patron.getAddress());

        patron.setPhone("555-7890");
        assertEquals("555-7890", patron.getPhone());

        patron.setUsername("alicesmith");
        assertEquals("alicesmith", patron.getUsername());

        patron.setPassword("password789");
        assertEquals("password789", patron.getPassword());
    }
}
