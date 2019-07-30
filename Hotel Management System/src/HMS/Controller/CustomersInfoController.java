package HMS.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import HMS.Databases.DatabasesInfo;
import HMS.TableView.ReservationTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomersInfoController implements Initializable {

	  @FXML
	    private TableView<ReservationTableView> TableView;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumName;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnEmail;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnAdderss;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnNumber;

	    @FXML
	    private TableColumn<ReservationTableView, Integer> ColumnNOP;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnRoomType;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnRoomNumber;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnStartDate;

	    @FXML
	    private TableColumn<ReservationTableView, String> ColumnEndDate;

	    @FXML
	    private TableColumn<ReservationTableView, Integer> ColumnPrice;

	    
	    @FXML
	    private JFXTextField RoomNumber;
	    
	    @FXML
	    private JFXDatePicker StartDate;

	    @FXML
	    private JFXDatePicker EndDate;


	    @FXML
	    void GetRoomNumber(ActionEvent event) throws SQLException {

	    	int RoomID = DatabasesInfo.getRoomID(RoomNumber.getText());
	    	ObservableList<ReservationTableView> customers = FXCollections.observableArrayList();

		    try {
				Connection con = DatabasesInfo.getConnection();
				System.out.println("Connected !");
				customers = DatabasesInfo.getCustomersInfo(RoomID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    ColumName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		    ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		    ColumnAdderss.setCellValueFactory(new PropertyValueFactory<>("Address"));
		    ColumnNumber.setCellValueFactory(new PropertyValueFactory<>("phonNumber"));
		    ColumnRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RomeNumber"));
		    ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RomeType"));
		    ColumnNOP.setCellValueFactory(new PropertyValueFactory<>("NumberOfPeople"));
		    ColumnStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
		    ColumnEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
		    ColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));


		    TableView.setItems(customers);
		    
		    RoomNumber.setText("");
		
	    }
	    
	    @FXML
	    void SerachByDate(ActionEvent event) {

	    	String start = StartDate.getValue().toString();
	    	String end = EndDate.getValue().toString();
	    	
	    	ObservableList<ReservationTableView> customersbyDate = FXCollections.observableArrayList();


	        try {

	    		Connection con = DatabasesInfo.getConnection();
	    	    System.out.println("Connected !");
	    	    customersbyDate = DatabasesInfo.getCustomersInfo(start, end);
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	        ColumName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		    ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		    ColumnAdderss.setCellValueFactory(new PropertyValueFactory<>("Address"));
		    ColumnNumber.setCellValueFactory(new PropertyValueFactory<>("phonNumber"));
		    ColumnRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RomeNumber"));
		    ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RomeType"));
		    ColumnNOP.setCellValueFactory(new PropertyValueFactory<>("NumberOfPeople"));
		    ColumnStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
		    ColumnEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
		    ColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));


		    TableView.setItems(customersbyDate);    
	        
	    }
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  
		ObservableList<ReservationTableView> customers = FXCollections.observableArrayList();

		    try {
				Connection con = DatabasesInfo.getConnection();
				System.out.println("Connected !");
				customers = DatabasesInfo.getCustomersInfo();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    ColumName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		    ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		    ColumnAdderss.setCellValueFactory(new PropertyValueFactory<>("Address"));
		    ColumnNumber.setCellValueFactory(new PropertyValueFactory<>("phonNumber"));
		    ColumnRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RomeNumber"));
		    ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RomeType"));
		    ColumnNOP.setCellValueFactory(new PropertyValueFactory<>("NumberOfPeople"));
		    ColumnStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
		    ColumnEndDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
		    ColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));


		    TableView.setItems(customers);
		
	}
	
	

	
}
