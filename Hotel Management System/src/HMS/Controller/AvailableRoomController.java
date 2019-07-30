package HMS.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import HMS.Databases.DatabasesInfo;
import HMS.TableView.RoomTableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AvailableRoomController implements Initializable  {

	
	    @FXML
	    private TableView<RoomTableView> TableView = new TableView<RoomTableView>();

	    @FXML
	    private TableColumn<RoomTableView, String> ColumnRoomType;

	    @FXML
	    private TableColumn<RoomTableView, String> ColumnsRoomNumber;

	    @FXML
	    private TableColumn<RoomTableView, Integer> ColumnsNumberofpeople;

	    @FXML
	    private TableColumn<RoomTableView, Integer> ColumnsFloorNumber;

	    @FXML
	    private TableColumn<RoomTableView, String> ColumnsPhoneNumber;

	    @FXML
	    private TableColumn<RoomTableView, Integer> ColumnsRoomPrice;

	    @FXML
	    private TableColumn<String, String> ColumnsRoomStatus;
	    
	    
	    ObservableList<RoomTableView> rooms ;
	    

	    @FXML
	    private JFXTextField RoomNumber;
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
      
		try {
			
		       Connection con = DatabasesInfo.getConnection();
				System.out.println("Connected !");
			    rooms = DatabasesInfo.getRoomInfo();
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ColumnsRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
		ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
		ColumnsNumberofpeople.setCellValueFactory(new PropertyValueFactory<>("RoomCapacity"));
		ColumnsFloorNumber.setCellValueFactory(new PropertyValueFactory<>("FloorNumber"));
		ColumnsPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("RomePhone"));
		ColumnsRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
		ColumnsRoomStatus.setCellValueFactory(new PropertyValueFactory<>("RoomStatus"));

		
		TableView.setItems(rooms);
		
	
	}
	
	
	@FXML
    private JFXCheckBox Busy;

    @FXML
    private JFXCheckBox Available;

    @FXML
    void SearchCheckBox(ActionEvent event) throws SQLException {
    	
    	if (Busy.isSelected()) {
    	
 		Connection con = DatabasesInfo.getConnection();
 		System.out.println("Connected !");
 		rooms = DatabasesInfo.getBusyRoom();
 		 	
	}else if(Available.isSelected()) {
		
		Connection con = DatabasesInfo.getConnection();
 		System.out.println("Connected !");
 		rooms = DatabasesInfo.getAvailableRoom();
	}else {
		Connection con = DatabasesInfo.getConnection();
 		System.out.println("Connected !");
 		rooms = DatabasesInfo.getRoomInfo();
	}

    	
    	
    	
    	
    	
    	ColumnsRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
		ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
		ColumnsNumberofpeople.setCellValueFactory(new PropertyValueFactory<>("RoomCapacity"));
		ColumnsFloorNumber.setCellValueFactory(new PropertyValueFactory<>("FloorNumber"));
		ColumnsPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("RomePhone"));
		ColumnsRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
		ColumnsRoomStatus.setCellValueFactory(new PropertyValueFactory<>("RoomStatus"));

		TableView.setItems(rooms);
    }
	   
    @FXML
    void SearchRoom(ActionEvent event) throws SQLException {
       
    	String NumberRoom =	RoomNumber.getText();

    	if (NumberRoom.equals("")) {
    		Connection con = DatabasesInfo.getConnection();
     		System.out.println("Connected !");
     		rooms = DatabasesInfo.getRoomInfo();
		}else {
			Connection con = DatabasesInfo.getConnection();
     		System.out.println("Connected !");
     		rooms = DatabasesInfo.getRoom(NumberRoom);
		}
    	
    	
    	
    	ColumnsRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
		ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
		ColumnsNumberofpeople.setCellValueFactory(new PropertyValueFactory<>("RoomCapacity"));
		ColumnsFloorNumber.setCellValueFactory(new PropertyValueFactory<>("FloorNumber"));
		ColumnsPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("RomePhone"));
		ColumnsRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
		ColumnsRoomStatus.setCellValueFactory(new PropertyValueFactory<>("RoomStatus"));

		TableView.setItems(rooms);
		RoomNumber.setText("");
    }
	
    @FXML
    void MakeAvailable(ActionEvent event) throws SQLException {
    	
    	String NumberRoom =	RoomNumber.getText();

    	Connection con = DatabasesInfo.getConnection();
		System.out.println("Connected !");

        DatabasesInfo.MakeAvailableRoom(NumberRoom); 
        
        rooms = DatabasesInfo.getRoom(NumberRoom);
        
    	ColumnsRoomNumber.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
		ColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
		ColumnsNumberofpeople.setCellValueFactory(new PropertyValueFactory<>("RoomCapacity"));
		ColumnsFloorNumber.setCellValueFactory(new PropertyValueFactory<>("FloorNumber"));
		ColumnsPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("RomePhone"));
		ColumnsRoomPrice.setCellValueFactory(new PropertyValueFactory<>("RoomPrice"));
		ColumnsRoomStatus.setCellValueFactory(new PropertyValueFactory<>("RoomStatus"));

		TableView.setItems(rooms);
	    
    }
	

}
