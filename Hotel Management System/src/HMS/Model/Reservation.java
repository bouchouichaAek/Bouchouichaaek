package HMS.Model;

import java.sql.Date;

public class Reservation {

	int ReservationId;
	int RomeID;
	int CustomerID;
	String CustomerType;
	int Duration;
	String StartDate;
	String EndDate;
	int NumberOfPeople;
	int Price;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationId, int romeID, int customerID, String customerType, int duration, String startDate,
			String endDate, int numberOfPeople, int price) {
		this.ReservationId = reservationId;
		this.RomeID = romeID;
		this.CustomerID = customerID;
		this.CustomerType = customerType;
		this.Duration = duration;
		this.StartDate = startDate;
		this.EndDate = endDate;
		this.NumberOfPeople = numberOfPeople;
		this.Price = price;
	}

	public int getReservationId() {
		return ReservationId;
	}

	public int getRomeID() {
		return RomeID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public String getCustomerType() {
		return CustomerType;
	}

	public int getDuration() {
		return Duration;
	}

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public int getNumberOfPeople() {
		return NumberOfPeople;
	}

	public int getPrice() {
		return Price;
	}

	public void setReservationId(int reservationId) {
		this.ReservationId = reservationId;
	}

	public void setRomeID(int romeID) {
		this.RomeID = romeID;
	}

	public void setCustomerID(int customerID) {
		this.CustomerID = customerID;
	}

	public void setCustomerType(String customerType) {
		this.CustomerType = customerType;
	}

	public void setDuration(int duration) {
		this.Duration = duration;
	}

	public void setStartDate(String startDate) {
		this.StartDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.NumberOfPeople = numberOfPeople;
	}

	public void setPrice(int price) {
		this.Price = price;
	}
	
	
	
	
	
	
}
