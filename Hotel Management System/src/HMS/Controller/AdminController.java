package HMS.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class AdminController implements Initializable {

	double x = 0;
	double y = 0;

    @FXML
    private JFXButton CLOSE;
    
    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		CLOSE.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
			System.exit(0);
		});
		

	}
	
	    @FXML
    void dragged(MouseEvent event) {
 
	    	Node node = (Node) event.getSource();
	    	Stage stage = (Stage) node.getScene().getWindow();
	    	
	    	stage.setX(event.getScreenX()-x);
	    	stage.setY(event.getScreenY()-y);

	    }

	    @FXML
	void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
	    }
	
	    @FXML
	void EnterIN(ActionEvent event) throws IOException {

	    	String username = Username.getText();
	    	String password = Password.getText();

	    	if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
				Stage stage = new Stage();
				Parent parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
				
				Scene scene = new Scene(parent);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setScene(scene);
				stage.show();
				
				Node node = (Node) event.getSource();
		    	Stage pStage = (Stage) node.getScene().getWindow();
				pStage.close();
			}

	    	
	    	
	    }
	
}
