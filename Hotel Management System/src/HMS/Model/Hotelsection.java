package HMS.Model;

public class Hotelsection {

	 int sectionID;
	 String SectionName;

	public Hotelsection() {
		// TODO Auto-generated constructor stub
	}

	public Hotelsection(int sectionID, String sectionName) {
		this.sectionID = sectionID;
		this.SectionName = sectionName;
	}

	public int getSectionID() {
		return sectionID;
	}

	public String getSectionName() {
		return SectionName;
	}

	
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public void setSectionName(String sectionName) {
		this.SectionName = sectionName;
	}

	
	
	
	
	
	
}
