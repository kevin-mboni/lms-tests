package lms.main.lmstest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class LibrarianSectionControllerTest {

    private LibrarianSectionController controller;

    @Start
    private void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibrarianSection.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        // Initialize the controller to ensure the views are loaded
        controller.initialize();
    }

    @Test
    public void testBookViewLoaded(FxRobot robot) {
        AnchorPane bookViewContainer = robot.lookup("#bookViewContainer").queryAs(AnchorPane.class);
        assertFalse(bookViewContainer.getChildren().isEmpty(), "Book view should be loaded");
    }

    @Test
    public void testAuthorViewLoaded(FxRobot robot) {
        AnchorPane authorViewContainer = robot.lookup("#authorViewContainer").queryAs(AnchorPane.class);
        assertFalse(authorViewContainer.getChildren().isEmpty(), "Author view should be loaded");
    }

    @Test
    public void testTransactionViewLoaded(FxRobot robot) {
        AnchorPane transactionViewContainer = robot.lookup("#transactionViewContainer").queryAs(AnchorPane.class);
        assertFalse(transactionViewContainer.getChildren().isEmpty(), "Transaction view should be loaded");
    }

    @Test
    public void testPatronViewLoaded(FxRobot robot) {
        AnchorPane patronViewContainer = robot.lookup("#patronViewContainer").queryAs(AnchorPane.class);
        assertFalse(patronViewContainer.getChildren().isEmpty(), "Patron view should be loaded");
    }
}
