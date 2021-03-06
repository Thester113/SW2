package Controllers;



import DAO.CustomerDB;
import DAO.DBConnection;
import DAO.ReportDB;
import Model.Appointments;
import Model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Shows the total appointments by type and month
 */
public class CustomerScheduleReportController implements Initializable {

  @FXML
  private ComboBox<Customers> customerCB;

  @FXML
  private TableView<Appointments> customerAppointmentTbl;

  @FXML
  private TableColumn<Appointments, Integer> appointmentID;

  @FXML
  private TableColumn<Appointments, String> aptTitle;

  @FXML
  private TableColumn<Appointments, String> aptType;

  @FXML
  private TableColumn<Appointments, String> aptDescription;

  @FXML
  private TableColumn<Appointments, LocalDateTime> aptStart;

  @FXML
  private TableColumn<Appointments, LocalDateTime> aptEnd;

  @FXML
  private TableColumn<Appointments, Integer> aptCustID;

  @FXML
  private Button exitBtn;

  @FXML
  private Button mainBtn;

  /**
   * Opens main screen and loads changes
   *
   * @param event
   * @throws IOException
   */
  @FXML
  void backToMain(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/Views/MainScreen.fxml"));
    loader.load();

    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    Parent scene = loader.getRoot();
    stage.setScene(new Scene(scene));
    stage.show();
  }

  /**
   * @param event
   *  For each Lambda that finds and displays customer schedules. This solves a long load time when using a foreach with iterator
   */
  @FXML
  void displayCustomerSchedule(ActionEvent event) {
    try {

      Customers customerSchedule = customerCB.getSelectionModel().getSelectedItem();
      ReportDB.sendCustomerSelection(customerSchedule);

      customerAppointmentTbl.setItems(ReportDB.getCustomerSchedule());
      for (Appointments appointments : ReportDB.customerSchedule) {
        System.out.println(appointments.getStart());
      }
      appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
      aptTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
      aptType.setCellValueFactory(new PropertyValueFactory<>("type"));
      aptDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
      aptStart.setCellValueFactory(new PropertyValueFactory<>("start"));
      aptEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
      aptCustID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void exitApp(ActionEvent event) {
    Button sourceButton = (Button) event.getSource();
    exitBtn.setText(sourceButton.getText());
    DBConnection.closeConnection();
    System.exit(0);
  }

  ObservableList<Customers> customerList = FXCollections.observableArrayList();

  /**
   * Loads all customers using a for each lambda.
   * Lambda expression reduces code needed to get customers from DB
   *
   * @param url
   * @param resourceBundle
   */
  @FXML
  public void initialize(URL url, ResourceBundle resourceBundle) {
    try {
      customerCB.setItems(CustomerDB.getAllCustomers());
      for (Customers customer : CustomerDB.allCustomers) {
        System.out.println(customer.getCustomerID());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
