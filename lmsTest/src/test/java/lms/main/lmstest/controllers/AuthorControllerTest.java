package lms.main.lmstest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lms.main.lmstest.Models.Authors;
import lms.main.lmstest.config.AuthorsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import java.sql.SQLException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
public class AuthorControllerTest {

    @Mock
    private AuthorsModel authorsModel;

    @InjectMocks
    private AuthorController authorController;

    @Start
    private void start(Stage stage) throws Exception {
        // Load the FXML file and set up the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/author.fxml"));
        loader.setController(authorController);
        VBox root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitialization() {
        // Verify that the TableView and columns are set up correctly
        assertNotNull(authorController.authorTable);
        assertNotNull(authorController.authorIdColumn);
        assertNotNull(authorController.firstNameColumn);
        assertNotNull(authorController.lastNameColumn);
        assertNotNull(authorController.emailColumn);
    }

    @Test
    void testLoadAuthors() throws SQLException {
        // Set up test data
        LinkedList<Authors> authorsList = new LinkedList<>();
        authorsList.add(new Authors(1, "John", "Doe", "john.doe@example.com"));
        when(authorsModel.getAuthors()).thenReturn(authorsList);

        authorController.initialize(); // Trigger the initialization

        WaitForAsyncUtils.waitForFxEvents(); // Wait for UI updates

        // Verify that the TableView has the correct data
        assertEquals(1, authorController.authorTable.getItems().size());
        Authors author = authorController.authorTable.getItems().get(0);
        assertEquals("John", author.getFirst_name());
        assertEquals("Doe", author.getLast_name());
        assertEquals("john.doe@example.com", author.getEmail());
    }

    @Test
    void testHandleAddAuthor() throws SQLException {
        // Simulate user input
        authorController.firstNameField.setText("Jane");
        authorController.lastNameField.setText("Smith");
        authorController.emailField.setText("jane.smith@example.com");

        // Trigger add author
        authorController.handleAddAuthor();

        // Verify interactions with the model
        verify(authorsModel).addAuthor(any(Authors.class));
        verify(authorsModel).getAuthors();
    }

    @Test
    void testHandleUpdateAuthor() throws SQLException {
        // Prepare a mock author and set it as selected
        Authors existingAuthor = new Authors(1, "John", "Doe", "john.doe@example.com");
        when(authorController.authorTable.getSelectionModel().getSelectedItem()).thenReturn(existingAuthor);

        // Simulate user input
        authorController.firstNameField.setText("Johnathan");
        authorController.lastNameField.setText("Dough");
        authorController.emailField.setText("john.dough@example.com");

        // Trigger update author
        authorController.handleUpdateAuthor();

        // Verify interactions with the model
        verify(authorsModel).updateAuthor(existingAuthor);
        verify(authorsModel).getAuthors();
    }

    @Test
    void testHandleDeleteAuthor() throws SQLException {
        // Prepare a mock author and set it as selected
        Authors existingAuthor = new Authors(1, "John", "Doe", "john.doe@example.com");
        when(authorController.authorTable.getSelectionModel().getSelectedItem()).thenReturn(existingAuthor);

        // Trigger delete author
        authorController.handleDeleteAuthor();

        // Verify interactions with the model
        verify(authorsModel).deleteAuthor(1);
        verify(authorsModel).getAuthors();
    }

    @Test
    void testShowAlert() {
        // Simulate showing an alert
        authorController.showAlert("Test alert");

        // Check that the alert has been shown (manual verification in UI)
        // This test may require manual inspection of the UI
    }
}
