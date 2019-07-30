package HMS.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import HMS.Databases.DatabasesInfo;
import HMS.TableView.RoomTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable {

	
	
	

    @FXML
    private Label RoomAvailable;

    @FXML
    private Label RoomBusy;
    
    @FXML
    private Label Empeloyee;

	double x = 0;
	double y = 0;
    @FXML
    private JFXButton CLOSE;
    
    @FXML
    private AnchorPane PANE;

    @FXML
    void ToReservation(ActionEvent event) throws IOException {
    	
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
    	PANE.getChildren().clear();
    	PANE.getChildren().add(pane);
    }
	
    
    @FXML
    void ToAvailableRoom(ActionEvent event) throws IOException {
    	
    	int numberAvailableRoom = 0;
    	int numberBusyRoom = 0;
    	
    	
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("Available Room.fxml"));
    	PANE.getChildren().clear();
    	PANE.getChildren().add(pane);
    	
    	RoomTableView view = new RoomTableView();
		 Connection con;
		try {
			
			 con = DatabasesInfo.getConnection();
			 Statement statement = con.createStatement();
			 ResultSet set = statement.executeQuery("select * from room");
		       
			 while (set.next()) {

				 if (set.getString(8).equalsIgnoreCase("Available")) {
					numberAvailableRoom++;
				}else if (set.getString(8).equalsIgnoreCase("Busy")) {
					numberBusyRoom++;;
				}
				 
			 }
	    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		RoomAvailable.setText(String.valueOf(numberAvailableRoom));
       RoomBusy.setText(String.valueOf(numberBusyRoom));
    }
    
    @FXML
    void ToCustomesInfo(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("Customers Info.fxml"));
    	PANE.getChildren().clear();
    	PANE.getChildren().add(pane);
    }
    
    @FXML
    void ToEmploee(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("Employee.fxml"));
    	PANE.getChildren().clear();
    	PANE.getChildren().add(pane);
    }
    
    @FXML
    void Logoff(ActionEvent event) throws IOException {
    	Node node = (Node) event.getSource();
    	Stage pStage = (Stage) node.getScene().getWindow();
		pStage.close();
		
		Stage stage = new Stage();
		Parent parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		stage.initStyle(StageStyle.UNDECORATED);

		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		int numberAvailableRoom = 0;
		int numberBusyRoom = 0;
		int EmployeeNumber = 0;
		RoomTableView view = new RoomTableView();
		 Connection con;
		try {
			
			 con = DatabasesInfo.getConnection();
			 Statement statement = con.createStatement();
			 ResultSet set = statement.executeQuery("select * from room");
		       
			 while (set.next()) {

				 if (set.getString(8).equalsIgnoreCase("Available")) {
					numberAvailableRoom++;
				}else if (set.getString(8).equalsIgnoreCase("Busy")) {
					numberBusyRoom++;;
				}
				 
			 }
	    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		RoomAvailable.setText(String.valueOf(numberAvailableRoom));
        RoomBusy.setText(String.valueOf(numberBusyRoom));
        
        
        try {
			 EmployeeNumber = DatabasesInfo.getEmpeloyeeNumber();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        Empeloyee.setText(String.valueOf(EmployeeNumber));
        
		try {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
    	PANE.getChildren().clear();
    	PANE.getChildren().add(pane);
		}catch (Exception e) {
			// TODO: handle exception
		}
		CLOSE.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
			System.exit(0);
		});
		
		
		
		
		
		
	}

    @FXML
    void dragged(MouseEvent event) {
 
	    	Node node = (Node) event.getSource();
	    	Stage stage = (Stage) node.getScene().getWindow();
	    	
	    	stage.setX(event.getScreenX()-x);
	    	stage.setY(event.getScreenY()-y);

	    }

	    @FXML
	void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
	    }
	
	
}
