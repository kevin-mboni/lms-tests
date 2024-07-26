package lms.main.lmstest.session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SessionTest {

    @BeforeEach
    public void setUp() {
        // Reset the static field before each test
        Session.setPatronId(0);
    }

    @Test
    public void testPatronIdIsInitiallyZero() {
        assertEquals(0, Session.getPatronId());
    }

    @Test
    public void testSetAndGetPatronId() {
        Session.setPatronId(12345);
        assertEquals(12345, Session.getPatronId());
    }
}
