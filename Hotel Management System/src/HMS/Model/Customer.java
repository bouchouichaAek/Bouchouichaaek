package HMS.Model;

public class Customer {
	
	int customerID;
	String firtname;
	String lastname;
	String Email;
	String phoneNumber;
	String addres;


	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerID, String firtname, String lastname, String email, String phoneNumber, String addres) {
		this.customerID = customerID;
		this.firtname = firtname;
		this.lastname = lastname;
		this.Email = email;
		this.phoneNumber = phoneNumber;
		this.addres = addres;
	}


	public int getCustomerID() {
		return customerID;
	}


	public String getFirtname() {
		return firtname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getEmail() {
		return Email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getAddres() {
		return addres;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public void setFirtname(String firtname) {
		this.firtname = firtname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	
	
	
	
}
