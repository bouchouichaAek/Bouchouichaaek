package HMS.TableView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class RoomTableView {

	IntegerProperty RoomID;
	StringProperty RoomNumber;
	StringProperty RoomType;
	IntegerProperty RoomCapacity;
	IntegerProperty FloorNumber;
	StringProperty RomePhone;
	IntegerProperty RoomPrice;
	StringProperty RoomStatus;
	//Button StatusRoom;
	public RoomTableView() {
		// TODO Auto-generated constructor stub
	}

	public RoomTableView(int roomID, String roomNumber, String roomType, int roomCapacity, int floorNumber, String romePhone,
			int roomPrice,String roomStatus) {
		this.RoomID = new SimpleIntegerProperty(roomID);
		this.RoomNumber = new SimpleStringProperty(roomNumber);
		this.RoomType = new SimpleStringProperty(roomType);
		this.RoomCapacity = new SimpleIntegerProperty(roomCapacity);
		this.FloorNumber = new SimpleIntegerProperty(floorNumber);
		this.RomePhone = new SimpleStringProperty(romePhone);
		this.RoomPrice = new SimpleIntegerProperty(roomPrice);
		this.RoomStatus = new SimpleStringProperty(roomStatus);
		//this.StatusRoom=StatusRoom;
		
		/*if (getRoomStatus().equalsIgnoreCase("Available")) {
			StatusRoom.setText("Available");
		}else {
			StatusRoom.setText("Busy");
		}*/
		
	}
	
	



	public int getRoomID() {
		return RoomID.get();
	}
	public String getRoomNumber() {
		return RoomNumber.get();
	}

	public String getRoomType() {
		return RoomType.get();
	}

	public int getRoomCapacity() {
		return RoomCapacity.get();
	}

	public int getFloorNumber() {
		return FloorNumber.get();
	}

	public String getRomePhone() {
		return RomePhone.get();
	}

	public int getRoomPrice() {
		return RoomPrice.get();
	}

	public String getRoomStatus() {
		return RoomStatus.get();
	}
	/**************************************************************************/

	public void setRoomID(int roomID) {
		RoomID.setValue(roomID);
	}

	
	public void setRoomNumber(String roomNumber) {
		RoomNumber.setValue(roomNumber);;
	}

	public void setRoomType(String roomType) {
		RoomType.setValue(roomType);;
	}

	public void setRoomCapacity(Integer roomCapacity) {
		RoomCapacity.setValue(roomCapacity);;
	}

	public void setFloorNumber(Integer floorNumber) {
		FloorNumber.setValue(floorNumber);;
	}

	public void setRomePhone(String romePhone) {
		RomePhone.setValue(romePhone);;
	}

	public void setRoomPrice(Integer roomPrice) {
		RoomPrice.setValue(roomPrice);;
	}

	public void setRoomStatus(String roomStatus) {
		RoomStatus.setValue(roomStatus);;
	}

	public void setRoomID(IntegerProperty roomID) {
		RoomID = roomID;
	}

	public void setRoomNumber(StringProperty roomNumber) {
		RoomNumber = roomNumber;
	}

	public void setRoomType(StringProperty roomType) {
		RoomType = roomType;
	}

	public void setRoomCapacity(IntegerProperty roomCapacity) {
		RoomCapacity = roomCapacity;
	}

	public void setFloorNumber(IntegerProperty floorNumber) {
		FloorNumber = floorNumber;
	}

	public void setRomePhone(StringProperty romePhone) {
		RomePhone = romePhone;
	}

	public void setRoomPrice(IntegerProperty roomPrice) {
		RoomPrice = roomPrice;
	}

	public void setRoomStatus(StringProperty roomStatus) {
		RoomStatus = roomStatus;
	}


	
	
	
	
}
