package HMS.Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import HMS.Customer;
import HMS.Empeloye;
import HMS.EmpeloyeTableView;
import HMS.Reservation;
import HMS.ReservationTableView;
import HMS.RoomTableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabasesInfo {
	
	
	private static  String URL ="jdbc:mysql://localhost/hotelmanagementsystem";
	private static  String USER ="root";
	private static  String PASSWORD ="123456";
	
	static Connection con;
	
	public static Connection getConnection() throws SQLException {
		con =  DriverManager.getConnection(URL, USER, PASSWORD);
		return con;

	}

	
	public static ObservableList<RoomTableView> getRoomInfo() throws SQLException {
 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<RoomTableView> rooms = FXCollections.observableArrayList();
	    rooms = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from room");
	       
	       
	       while (set.next()) {
	    	   rooms.add(new RoomTableView(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getString(6), set.getInt(7),set.getString(8) ));
		    }
    
		return rooms;
		
	}
	
	public static ObservableList<RoomTableView> getBusyRoom() throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<RoomTableView> rooms = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from room where RoomStatus = 'Busy'");
	       
	       
	       while (set.next()) {
	    	   rooms.add(new RoomTableView(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getString(6), set.getInt(7),set.getString(8)));
		    }
    
		return rooms;
		
	}

	
	public static ObservableList<RoomTableView> getAvailableRoom() throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<RoomTableView> rooms = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from room  where RoomStatus = 'Available';");
	       
	       
	       while (set.next()) {
	    	   rooms.add(new RoomTableView(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getString(6), set.getInt(7),set.getString(8)));
		    }
    
		return rooms;
		
	}

	public static ObservableList<RoomTableView> getRoom(String RoomNumber) throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<RoomTableView> rooms = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from room  where RomeNumber ="+RoomNumber);
	       
	       
	       while (set.next()) {
	    	   rooms.add(new RoomTableView(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getString(6), set.getInt(7),set.getString(8)));
		    }
    
		return rooms;
		
	}
	
	public static void MakeAvailableRoom(String RoomNumber) throws SQLException {
		int i = 0;
		Connection con = DatabasesInfo.getConnection();
		PreparedStatement pr = con.prepareStatement("update room set RoomStatus ='Available' where RomeId = ?");
        int id = getRoomID(RoomNumber);
		pr.setInt(1, id);
        i =  pr.executeUpdate();
     //  return i; 
	}
	
	public static int getRoomID(String RoomNumber) throws SQLException {
		Connection   con = DatabasesInfo.getConnection();
    Statement statement = con.createStatement();
	ResultSet set = statement.executeQuery("select * from room");
    HashMap<String, Integer> hashMap =new HashMap<String, Integer>();
    
	 while (set.next()) {
           hashMap.put(set.getString(2), set.getInt(1));
	 }
	 
       int Id = hashMap.get(RoomNumber);
       
	   return Id;
	       
	}
	
	public static int getCustomerID(String Fisrname) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from customer");
	    HashMap<String, Integer> hashMap =new HashMap<String, Integer>();
	    
		 while (set.next()) {
	           hashMap.put(set.getString(2), set.getInt(1));
		 }
		 
	       //int Id ;
	       
		   return  hashMap.get(Fisrname);
		       
		}
	

	
	//,Reservation reservation , String RoomNumber
	public static boolean Reserver(Customer customer,Reservation reservation , String RoomNumber) throws SQLException {
		int i = 0;
		int j = 0;
		int k = 0;
		 Connection  con = DatabasesInfo.getConnection();
		 PreparedStatement pr = con.prepareStatement("INSERT INTO customer(firtname,lastname,Email,phoneNumber,addres)VALUES(?,?,?,?,?)");
		 pr.setString(1, customer.getFirtname());
		 pr.setString(2, customer.getLastname());
		 pr.setString(3, customer.getEmail());
		 pr.setString(4, customer.getPhoneNumber());
		 pr.setString(5, customer.getAddres());
		 i = pr.executeUpdate();

	     int customerID = getCustomerID(customer.getFirtname());
	    int RoomID = getRoomID(RoomNumber);
		 PreparedStatement pr2 = con.prepareStatement("INSERT INTO reservation(RomeID,CustomerID,CustomerType,Duration,StartDate,EndDate,NumberOfPeople,Price)VALUES(?,?,?,?,?,?,?,?)");
		 pr2.setInt(1, RoomID);
		 pr2.setInt(2, customerID);
		 pr2.setString(3, reservation.getCustomerType());
		 pr2.setInt(4, reservation.getDuration());
		 pr2.setString(5, reservation.getStartDate());
		 pr2.setString(6, reservation.getEndDate());
		 pr2.setInt(7, reservation.getNumberOfPeople());
		 pr2.setInt(8, reservation.getPrice());
		 j = pr2.executeUpdate();
		 PreparedStatement pr3 = con.prepareStatement("UPDATE room SET RoomStatus = ? WHERE RomeId = ?");
		 pr3.setString(1, "Busy");	
		 pr3.setInt(2, RoomID);	
		 k = pr3.executeUpdate();
		 
		 if (i>0 && j>0 && k>0) 
			return true;
		 else 
			return false;
		
	
		
	}
	
	public static ObservableList<EmpeloyeTableView> getEmpeloye() throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<EmpeloyeTableView> empList = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select* from  empeloye");
	       
	       
	       while (set.next()) {
	    	   empList.add(new EmpeloyeTableView(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4), set.getString(5), set.getInt(6)));
		    }
    
		return empList;
		
	}
	
	public static int DeleteEmployee(int EmployeeID) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	     PreparedStatement statement = con.prepareStatement("DELETE FROM empeloye WHERE empeloyeID = ?");
	     statement.setInt(1, EmployeeID);
	     int i = statement.executeUpdate();
         return i;
		
	}
	
	public static StringProperty getSectionName(int SectionId) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from hotelsection");
	    HashMap<Integer,String > hashMap =new HashMap<Integer,String >();
	    
		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getString(2));
		 }
		 
         Object obj = hashMap.get(SectionId);
         return (StringProperty) (obj = new SimpleStringProperty((String) obj));
		       
		}
	
	
	
	
	public static int  getSectionID(String SectionName) throws SQLException {
		
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from hotelsection");
		
		HashMap<String,Integer > hashMap =new HashMap<String,Integer >();
	    
		 while (set.next()) {
	           hashMap.put( set.getString(2),set.getInt(1));
		 }
		 
		 
		 return hashMap.get(SectionName);
		 
	}
	
	
	
	public static int  SaveEmployee(Empeloye Emp) throws SQLException {
		 Connection  con = DatabasesInfo.getConnection();
		 PreparedStatement pr = con.prepareStatement("INSERT INTO empeloye(sectionID,fullname,addrres,phoneNumber,salary)VALUES(?,?,?,?,?)");
		 pr.setInt(1, Emp.getSectionID());
		 pr.setString(2, Emp.getFullname());
		 pr.setString(3, Emp.getAddrres());
		 pr.setString(4, Emp.getPhoneNumber());
		 pr.setInt(5, Emp.getSalary());
		 
		 int i = pr.executeUpdate();
		 return i ;
	}
	
	public static StringProperty getName(int customerid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from customer");
	    HashMap<Integer,String > hashMap =new HashMap<Integer,String >();
	    HashMap<Integer,String > hashMap1 =new HashMap<Integer,String >();

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getString(2));
	           hashMap1.put( set.getInt(1),set.getString(3));

		 }
		 
		 String obj = (String) hashMap.get(customerid);
		 String obj1 = (String) hashMap1.get(customerid);
        
         Object object = obj+" "+obj1;
           return     (StringProperty) (object = new SimpleStringProperty((String) object));  
		}
	
	public static StringProperty getAddress(int customerid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from customer");
	    HashMap<Integer,Object > hashMap =new HashMap<Integer,Object >();
	

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getObject(6));
		 }
		 
         Object obj = hashMap.get(customerid);
         
        
             return   (StringProperty) (obj = new SimpleStringProperty((String) obj));
		}
	
	public static StringProperty getEmail(int customerid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from customer");
	    HashMap<Integer,Object > hashMap =new HashMap<Integer,Object >();
	

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getObject(4));
		 }
		 
         Object obj = hashMap.get(customerid);
         
        
             return   (StringProperty) (obj = new SimpleStringProperty((String) obj));
		}
	
	public static StringProperty getPhoneNumber(int customerid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from customer");
	    HashMap<Integer,Object > hashMap =new HashMap<Integer,Object >();
	

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getObject(5));
		 }
		 
         Object obj = hashMap.get(customerid);
         
        
             return   (StringProperty) (obj = new SimpleStringProperty((String) obj));
		}
	
	public static StringProperty getRoomNumber(int Roomid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from room");
	    HashMap<Integer,Object > hashMap =new HashMap<Integer,Object >();
	

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getObject(2));
		 }
		 
         Object obj = hashMap.get(Roomid);
         
        
             return   (StringProperty) (obj = new SimpleStringProperty((String) obj));
		}
	
	public static StringProperty getRoomType(int Roomid) throws SQLException {
		Connection con = DatabasesInfo.getConnection();
	    Statement statement = con.createStatement();
		ResultSet set = statement.executeQuery("select * from room");
	    HashMap<Integer,Object > hashMap =new HashMap<Integer,Object >();
	

		 while (set.next()) {
	           hashMap.put( set.getInt(1),set.getObject(3));
		 }
		 
         Object obj = hashMap.get(Roomid);
         
        
             return   (StringProperty) (obj = new SimpleStringProperty((String) obj));
		}
	
	public static ObservableList<ReservationTableView> getCustomersInfo() throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<ReservationTableView> Customers = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from reservation");
	       
	       
	       while (set.next()) {
	    	   Customers.add(new ReservationTableView(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9)));
		    }
    
		return Customers;
		
	}
	
	
	/***************************************************************************************************/
	
	
	public static ObservableList<ReservationTableView> getCustomersInfo(int RoomId) throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<ReservationTableView> Customers = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from reservation where RomeID ="+RoomId);
	       
	       
	       while (set.next()) {
	    	   Customers.add(new ReservationTableView(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9)));
		    }
    
		return Customers;
		
	}
	
	public static ObservableList<ReservationTableView> getCustomersInfo(String startdate,String EndDate) throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<ReservationTableView> Customers = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from reservation where StartDate between '"+startdate+"' and '"+EndDate+"'");
	       
	       
	       while (set.next()) {
	    	   Customers.add(new ReservationTableView(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9)));
		    }
    
		return Customers;
		
	}

	
	public static int getEmpeloyeeNumber() throws SQLException {
		 
		Connection con = DatabasesInfo.getConnection();
		ObservableList<EmpeloyeTableView> Customers = FXCollections.observableArrayList();
	     Statement statement = con.createStatement();
		 ResultSet set = statement.executeQuery("select * from empeloye");
	       
	      
	       while (set.next()) {
	    	   Customers.add(new EmpeloyeTableView(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4), set.getString(5), set.getInt(6)));
		    }
    
		return Customers.size();
		
	}

	
	
	
	
}
