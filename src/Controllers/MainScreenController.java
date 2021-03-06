package Controllers;

import DAO.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main screen controller has access to customer, reports, and appointments
 */

public class MainScreenController implements Initializable {

    @FXML
    private Button customerAppointmentReport;

    @FXML
    private Button contactSchedulesReport;

    @FXML
    private Button customerSchedulesBtn;

    @FXML
    private Button customerBtn;

    @FXML
    private Button aptBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button logoutButton;

    @FXML
    private Button exitButton;

    /**
     * Exits application from Main Screen
     *
     * @param event
     */
    @FXML
    void exitApp(ActionEvent event) {

        Button sourceButton = (Button) event.getSource();
        exitButton.setText(sourceButton.getText());
        DBConnection.closeConnection();
        System.exit(0);
    }

    /**
     * Access to the appointment table
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void sceneAptMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/Appointment.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Access to the customer table
     *
     * @param event
     * @throws IOException
     */

    @FXML
    void sceneCustMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/Customer.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Gets the Customer Schedules report
     * Select a customer
     *
     * @param event
     * @throws IOException
     */


    @FXML
    void sceneCustomerSchedulesReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/CustomerScheduleReport.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Gets the Contact Schedules report
     * Select a contact
     *
     * @param event
     * @throws IOException
     */

    @FXML
    void sceneContactSchedulesReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/ContactsReport.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Gets the Customer Appointment Schedules report
     * Gives the total by month and by type
     *
     * @param event
     * @throws IOException
     */


    @FXML
    void sceneCustomerAppointmentReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/CustomerAppointmentReport.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Logs user out of application
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void sceneLogout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Object scene = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    /**
     * Login handler for Main Screen
     *
     * @param event
     */
    public void sceneLogin(ActionEvent event) {

    }

    /**
     * Loads combo box and resource bundle
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

