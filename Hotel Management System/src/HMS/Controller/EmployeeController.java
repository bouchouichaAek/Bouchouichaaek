package HMS.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import HMS.Databases.DatabasesInfo;
import HMS.Model.Empeloye;
import HMS.TableView.EmpeloyeTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeController implements Initializable {
	

    @FXML
    private TableView<EmpeloyeTableView> TableView = new TableView<EmpeloyeTableView>();;

    @FXML
    private TableColumn<EmpeloyeTableView, String> ColumnFullName;

    @FXML
    private TableColumn<EmpeloyeTableView, String> ColumnAddress;

    @FXML
    private TableColumn<EmpeloyeTableView, String> Columnsection;

    @FXML
    private TableColumn<EmpeloyeTableView, String> ColumnphoneNumber;

    @FXML
    private TableColumn<EmpeloyeTableView, Integer> ColumnSalary;
    
    @FXML
    private JFXTextField FullName;

    @FXML
    private JFXTextField Address;

    @FXML
    private JFXTextField section;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXTextField Salary;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		  ObservableList<EmpeloyeTableView> Employee = FXCollections.observableArrayList();

		try {
		       Connection con = DatabasesInfo.getConnection();
				System.out.println("Connected !");
				Employee = DatabasesInfo.getEmpeloye();
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ColumnFullName.setCellValueFactory(new PropertyValueFactory<>("Fullname"));
		ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("Addrres"));
		ColumnphoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		ColumnSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
		Columnsection.setCellValueFactory(new PropertyValueFactory<>("SectionName"));

		TableView.setItems(Employee);
		
	}
	
    @FXML
    void InsertEmploye(ActionEvent event) throws SQLException {

    	Empeloye empeloye = new Empeloye();
    	
    	empeloye.setFullname(FullName.getText());
    	empeloye.setSectionID(DatabasesInfo.getSectionID(section.getText()));
    	empeloye.setAddrres(Address.getText());
    	empeloye.setPhoneNumber(phoneNumber.getText());
    	empeloye.setSalary(Integer.parseInt(Salary.getText()));
    	
    	int i = DatabasesInfo.SaveEmployee(empeloye);
   
    	System.out.println(i);
    	FullName.setText("");
    	section.setText("");
    	Address.setText("");
    	phoneNumber.setText("");
    	Salary.setText("");
    	
    }
    
    @FXML
    void DeleteEmployee(ActionEvent event) throws SQLException {

    	int id = TableView.getSelectionModel().getSelectedItem().getEmpeloyeID();
    	
    	int i = DatabasesInfo.DeleteEmployee(id);
    	
    	System.out.println(i);
    	
    	
		  ObservableList<EmpeloyeTableView> Employee = FXCollections.observableArrayList();

		try {
		       Connection con = DatabasesInfo.getConnection();
				System.out.println("Connected !");
				Employee = DatabasesInfo.getEmpeloye();
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ColumnFullName.setCellValueFactory(new PropertyValueFactory<>("Fullname"));
		ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("Addrres"));
		ColumnphoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		ColumnSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
		Columnsection.setCellValueFactory(new PropertyValueFactory<>("SectionName"));

		TableView.setItems(Employee);
    	
    }
	
	
	
	

}
