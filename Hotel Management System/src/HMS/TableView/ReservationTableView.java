package HMS.TableView;

import java.sql.SQLException;

import HMS.DatabasesInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReservationTableView {

	IntegerProperty ReservationId;
	StringProperty Name;
	StringProperty Address;
	StringProperty Email;
	StringProperty phonNumber;
	StringProperty RomeNumber;
	StringProperty RomeType;
	IntegerProperty RomeID;
	IntegerProperty CustomerID;
	StringProperty StartDate;
	StringProperty EndDate;
	IntegerProperty NumberOfPeople;
	IntegerProperty Price;
	
	public ReservationTableView() {
		// TODO Auto-generated constructor stub
	}

	public ReservationTableView(int reservationId, int romeID, int customerID, String startDate,String endDate, int numberOfPeople, int price) throws SQLException {
		this.ReservationId= new SimpleIntegerProperty(reservationId);
		this.RomeID = new SimpleIntegerProperty(romeID);;
		this.CustomerID = new SimpleIntegerProperty(customerID);
		this.StartDate = new SimpleStringProperty(startDate);
		this.EndDate = new SimpleStringProperty(endDate);
		this.NumberOfPeople =new SimpleIntegerProperty(numberOfPeople);
		this.Price = new SimpleIntegerProperty(price);
		
		Name = DatabasesInfo.getName(customerID);
		Address = DatabasesInfo.getAddress(customerID);
		Email = DatabasesInfo.getEmail(customerID);
		phonNumber = DatabasesInfo.getPhoneNumber(customerID);
        RomeNumber = DatabasesInfo.getRoomNumber(romeID);
        RomeType = DatabasesInfo.getRoomType(romeID);
	}

	public int getReservationId() {
		return ReservationId.get();
	}

	public String getName() {
		return Name.get();
	}

	public String getAddress() {
		return Address.get();
	}

	public String getEmail() {
		return Email.get();
	}

	public String getPhonNumber() {
		return phonNumber.get();
	}

	public String getRomeNumber() {
		return RomeNumber.get();
	}

	public String getRomeType() {
		return RomeType.get();
	}

	public int getRomeID() {
		return RomeID.get();
	}

	public int getCustomerID() {
		return CustomerID.get();
	}

	public String getStartDate() {
		return StartDate.get();
	}

	public String getEndDate() {
		return EndDate.get();
	}

	public int getNumberOfPeople() {
		return NumberOfPeople.get();
	}

	public int getPrice() {
		return Price.get();
	}

	public void setReservationId(int reservationId) {
		ReservationId.setValue(reservationId);
	}

	public void setName(String name) {
		Name.setValue(name);
	}

	public void setAddress(String address) {
		Address.setValue(address);
	}

	public void setEmail(String email) {
		Email.setValue(email);
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber.setValue(phonNumber);
	}

	public void setRomeNumber(String romeNumber) {
		RomeNumber.setValue(romeNumber);
	}

	public void setRomeType(String romeType) {
		RomeType.setValue(romeType);
	}

	public void setRomeID(int romeID) {
		RomeID.setValue(romeID);
	}

	public void setCustomerID(int customerID) {
		CustomerID.setValue(customerID);
	}

	public void setStartDate(String startDate) {
		StartDate.setValue(startDate);
	}

	public void setEndDate(String endDate) {
		EndDate.setValue(endDate);
	}

	public void setNumberOfPeople(int numberOfPeople) {
		NumberOfPeople.setValue(numberOfPeople);
	}

	public void setPrice(int price) {
		Price.setValue(price);
	}


	
	
	
	
	
}
