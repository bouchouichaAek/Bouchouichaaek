package HMS.Model;

public class Room {

	int RoomID;
	String RoomNumber;
	String RoomType;
	int RoomCapacity;
	int FloorNumber;
	String RomePhone;
	int RoomPrice;
	String RoomStatus;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int roomID, String roomNumber, String roomType, int roomCapacity, int floorNumber, String romePhone,
			int roomPrice, String roomStatus) {
		this.RoomID = roomID;
		this.RoomNumber = roomNumber;
		this.RoomType = roomType;
		this.RoomCapacity = roomCapacity;
		this.FloorNumber = floorNumber;
		this.RomePhone = romePhone;
		this.RoomPrice = roomPrice;
		this.RoomStatus = roomStatus;
	}

	public int getRoomID() {
		return RoomID;
	}

	public String getRoomNumber() {
		return RoomNumber;
	}

	public String getRoomType() {
		return RoomType;
	}

	public int getRoomCapacity() {
		return RoomCapacity;
	}

	public int getFloorNumber() {
		return FloorNumber;
	}

	public String getRomePhone() {
		return RomePhone;
	}

	public int getRoomPrice() {
		return RoomPrice;
	}

	public String getRoomStatus() {
		return RoomStatus;
	}

	public void setRoomID(int roomID) {
		this.RoomID = roomID;
	}

	public void setRoomNumber(String roomNumber) {
		this.RoomNumber = roomNumber;
	}

	public void setRoomType(String roomType) {
		this.RoomType = roomType;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.RoomCapacity = roomCapacity;
	}

	public void setFloorNumber(int floorNumber) {
		this.FloorNumber = floorNumber;
	}

	public void setRomePhone(String romePhone) {
		this.RomePhone = romePhone;
	}

	public void setRoomPrice(int roomPrice) {
		this.RoomPrice = roomPrice;
	}

	public void setRoomStatus(String roomStatus) {
		this.RoomStatus = roomStatus;
	}
	
	
	
	
	
}
