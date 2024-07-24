package lms.main.lmstest.controllers;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lms.main.lmstest.config.LibrarianModel;
import lms.main.lmstest.config.PatronsModel;
import lms.main.lmstest.session.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
public class LoginControllerTest {

    @Mock
    private LibrarianModel librarianModel;

    @Mock
    private PatronsModel patronsModel;

    @InjectMocks
    private LoginController loginController;

    private TextField usernameField;
    private PasswordField passwordField;
    private VBox root;

    @Start
    public void start(Stage stage) {
        usernameField = new TextField();
        passwordField = new PasswordField();
        root = new VBox(usernameField, passwordField);
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        loginController = new LoginController(); // Ensure LoginController instance is created
        loginController.usernameField = usernameField;
        loginController.passwordField = passwordField;
    }

    @Test
    public void testHandleLogin_LibrarianAuthenticationSuccess() {
        try {
            when(librarianModel.authenticateLibrarian(anyString(), anyString())).thenReturn(true);

            usernameField.setText("librarian");
            passwordField.setText("password");

            loginController.handleLogin();

            verify(librarianModel).authenticateLibrarian("librarian", "password");
            verify(patronsModel, never()).authenticatePatron(anyString(), anyString());
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testHandleLogin_PatronAuthenticationSuccess() {
        try {
            when(librarianModel.authenticateLibrarian(anyString(), anyString())).thenReturn(false);
            when(patronsModel.authenticatePatron(anyString(), anyString())).thenReturn(true);
            when(patronsModel.getPatronId(anyString())).thenReturn(1);

            usernameField.setText("patron");
            passwordField.setText("password");

            loginController.handleLogin();

            verify(librarianModel).authenticateLibrarian("patron", "password");
            verify(patronsModel).authenticatePatron("patron", "password");
            verify(patronsModel).getPatronId("patron");
            Session.setPatronId(1);  // Ensure this line reflects the correct method to set the patron ID in your session management.
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testHandleLogin_AuthenticationFailure() {
        try {
            when(librarianModel.authenticateLibrarian(anyString(), anyString())).thenReturn(false);
            when(patronsModel.authenticatePatron(anyString(), anyString())).thenReturn(false);

            usernameField.setText("user");
            passwordField.setText("wrongpassword");

            loginController.handleLogin();

            verify(librarianModel).authenticateLibrarian("user", "wrongpassword");
            verify(patronsModel).authenticatePatron("user", "wrongpassword");
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRegister() {
        try {
            loginController.handleRegister();

            // Add verification to ensure the registration screen is displayed.
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
