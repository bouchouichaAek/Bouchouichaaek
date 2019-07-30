package HMS.TableView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HotelsectionTableView {

	IntegerProperty sectionID;
	StringProperty SectionName;

	public HotelsectionTableView() {
		// TODO Auto-generated constructor stub
	}

	public HotelsectionTableView(int sectionID, String sectionName) {
		this.sectionID = new SimpleIntegerProperty(sectionID);
		this.SectionName = new SimpleStringProperty(sectionName);
	}

	public int getSectionID() {
		return sectionID.get();
	}

	public String getSectionName() {
		return SectionName.get();
	}

	
	public void setSectionID(int sectionID) {
		this.sectionID.setValue(sectionID);
	}

	public void setSectionName(String sectionName) {
		this.SectionName.setValue(sectionName);
	}

	
	
	
	
	
	
}
