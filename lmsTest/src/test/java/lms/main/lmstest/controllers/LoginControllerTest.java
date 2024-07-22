package lms.main.lmstest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class LoginControllerTest {

    private LoginController controller;

    @Start
    private void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        // Any setup before each test can go here
    }

    @Test
    public void testLibrarianLogin(FxRobot robot) {
        // Simulate entering username and password
        robot.clickOn("#usernameField").write("librarian");
        robot.clickOn("#passwordField").write("password");

        // Simulate clicking the login button
        robot.clickOn("#loginButton");

        // Verify the dashboard is loaded
        assertTrue(controller.isLibrarianDashboardLoaded(), "Librarian dashboard should be loaded");
    }

    @Test
    public void testPatronLogin(FxRobot robot) {
        // Simulate entering username and password
        robot.clickOn("#usernameField").write("patron");
        robot.clickOn("#passwordField").write("password");

        // Simulate clicking the login button
        robot.clickOn("#loginButton");

        // Verify the dashboard is loaded
        assertTrue(controller.isPatronDashboardLoaded(), "Patron dashboard should be loaded");
    }

    @Test
    public void testInvalidLogin(FxRobot robot) {
        // Simulate entering invalid username and password
        robot.clickOn("#usernameField").write("invalidUser");
        robot.clickOn("#passwordField").write("wrongPassword");

        // Simulate clicking the login button
        robot.clickOn("#loginButton");

        // Verify the error message is displayed
        verifyThat("#errorMessage", LabeledMatchers.hasText("Invalid credentials. Please try again."));
    }
}
