package HMS.TableView;

import java.sql.SQLException;

import HMS.DatabasesInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmpeloyeTableView  {
	
	IntegerProperty EmpeloyeID;
	IntegerProperty sectionID;
	StringProperty SectionName;
    StringProperty Fullname;
    StringProperty Addrres;
    StringProperty PhoneNumber;
    IntegerProperty Salary;

    public EmpeloyeTableView() {
		// TODO Auto-generated constructor stub
	}

	
	public EmpeloyeTableView(int empeloyeID, int sectionID, String fullname, String addrres, String phoneNumber, int salary) throws SQLException {
	
		this.EmpeloyeID = new SimpleIntegerProperty(empeloyeID);
		this.sectionID=new SimpleIntegerProperty(sectionID);
		this.Fullname = new SimpleStringProperty(fullname);
		this.Addrres = new SimpleStringProperty(addrres);
		this.PhoneNumber = new SimpleStringProperty(phoneNumber);
		this.Salary = new SimpleIntegerProperty(salary);
		this.SectionName =  DatabasesInfo.getSectionName(sectionID);
	}

	

	public String getSectionName() {
		return SectionName.get();
	}


	public void setSectionName(String sectionName) {
		SectionName.setValue(sectionName);;
	}


	public int getEmpeloyeID() {
		return EmpeloyeID.get();
	}


	public int getSectionID() {
		return sectionID.get();
	}


	public String getFullname() {
		return Fullname.get();
	}


	public String getAddrres() {
		return Addrres.get();
	}


	public String getPhoneNumber() {
		return PhoneNumber.get();
	}


	public int getSalary() {
		return Salary.get();
	}
/**************************************************************************/

	public void setEmpeloyeID(int empeloyeID) {
		EmpeloyeID.setValue(empeloyeID);
	}


	public void setSectionID(int sectionId) {
		sectionID.setValue(sectionId);
	}


	public void setFullname(String fullname) {
		Fullname.setValue(fullname);
	}


	public void setAddrres(String addrres) {
		Addrres.setValue(addrres);
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber.setValue(phoneNumber);
	}


	public void setSalary(int salary) {
		Salary.setValue(salary);
	}

	
	
    
    
}
