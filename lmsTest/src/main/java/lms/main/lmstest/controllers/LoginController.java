package lms.main.lmstest.controllers;

import lms.main.lmstest.config.LibrarianModel;
import lms.main.lmstest.config.PatronsModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lms.main.lmstest.session.Session;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    private Label errorMessage;

    // Method to handle login action
    @FXML
     void handleLogin() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Authenticate librarian
        LibrarianModel librarianModel = new LibrarianModel();
        if (librarianModel.authenticateLibrarian(username, password)) {

            openDashboard("/lms/main/lmstest/LibrarianSection.fxml");
        }
        // Authenticate patron
        else {
            PatronsModel patronsModel = new PatronsModel();
            if (patronsModel.authenticatePatron(username, password)) {
                // Set patron ID into session
                int patronId = patronsModel.getPatronId(username); // Adjust as per your implementation
                Session.setPatronId(patronId); // Example method to set patron ID in session
                openDashboard("/lms/main/lmstest/Patrons.fxml");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid credentials. Please try again.");
            }
        }
    }

    // Method to open dashboard
     void openDashboard(String dashboardFXML) {
        try {
            System.out.println("Loading FXML: " + dashboardFXML);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(dashboardFXML));
            Parent root = loader.load();
            System.out.println("FXML Loaded Successfully");

            // Set up the stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the login window (optional)
            VBox loginVBox = (VBox) usernameField.getScene().getRoot();
            loginVBox.getScene().getWindow().hide();  // Hide login window

        } catch (IOException e) {
            System.err.println("Failed to load FXML: " + dashboardFXML);
            e.printStackTrace();

        }
    }
     void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
     void handleRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lms/main/lmstest/PatronsView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isLibrarianDashboardLoaded() {
        return false;
    }

    public boolean isPatronDashboardLoaded() {
        return false;
    }
}
