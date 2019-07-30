package HMS.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import HMS.Databases.DatabasesInfo;
import HMS.Model.Customer;
import HMS.Model.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ReservationController implements Initializable {

	  @FXML
	    private JFXTextField CustLastName;

	    @FXML
	    private JFXTextField CustPhoneNumber;

	    @FXML
	    private JFXTextField CustAddress;

	    @FXML
	    private JFXTextField CustEmail;

	    @FXML
	    private JFXTextField CustDuration;

	    @FXML
	    private JFXTextField CustNOP;

	    @FXML
	    private JFXTextField CustType;

	    @FXML
	    private JFXTextField CustFRoomNumber;

	    @FXML
	    private JFXTextField CustPrice;

	    @FXML
	    private JFXDatePicker CustStartDate;

	    @FXML
	    private JFXDatePicker CustEndDate;

	    @FXML
	    private JFXTextField CustFirstName;

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	    @FXML
	    void BookingRoom(ActionEvent event) throws SQLException {
	    	
	    	String Firstname = CustFirstName.getText();
	    	String Lastname = CustLastName.getText();
	    	String Phone = CustPhoneNumber.getText();
	    	String Address = CustAddress.getText();
	    	String Email = CustEmail.getText();
	    	String roomNumber = CustFRoomNumber.getText();
	    	int NOP = Integer.parseInt(CustNOP.getText());
	    	String CustomerType =  CustType.getText();
	        int Duration = Integer.parseInt(CustDuration.getText());

	    	String StartDate = CustStartDate.getValue().toString();
	    	String EndDAte = CustEndDate.getValue().toString();
	    	
	        int Price = Integer.parseInt(CustPrice.getText());

	        Customer customer = new Customer();
	        
	        customer.setFirtname(Firstname);
	        customer.setLastname(Lastname);
	        customer.setPhoneNumber(Phone);
	        customer.setAddres(Address);
	        customer.setEmail(Email);
	        Reservation reservation = new Reservation();
	        
	        reservation.setCustomerType(CustomerType);
	        reservation.setDuration(Duration);
	        reservation.setEndDate(EndDAte);
	        reservation.setStartDate(StartDate);
	        reservation.setNumberOfPeople(NOP);
	        reservation.setPrice(Price);
	        
	        boolean notB  = DatabasesInfo.Reserver(customer, reservation, roomNumber);
	        System.out.println(notB);

	      }
	
	

}
