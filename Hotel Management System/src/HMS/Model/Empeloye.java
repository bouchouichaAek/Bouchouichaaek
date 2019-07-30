package HMS.Model;

public class Empeloye  {
	
	int empeloyeID;
	int sectionID; //FK
    String fullname;
    String addrres;
    String phoneNumber;
    int salary;
    
    public Empeloye() {
		// TODO Auto-generated constructor stub
	}

	
	public Empeloye(int empeloyeID, int sectionID, String fullname, String addrres, String phoneNumber, int salary) {
		this.empeloyeID = empeloyeID;
		this.sectionID = sectionID;
		this.fullname = fullname;
		this.addrres = addrres;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}

	public int getEmpeloyeID() {
		return empeloyeID;
	}

	public int getSectionID() {
		return sectionID;
	}

	public String getFullname() {
		return fullname;
	}

	public String getAddrres() {
		return addrres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmpeloyeID(int empeloyeID) {
		this.empeloyeID = empeloyeID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAddrres(String addrres) {
		this.addrres = addrres;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    
    
    
    
}
