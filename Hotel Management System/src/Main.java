

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
        
		Parent parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		primaryStage.initStyle(StageStyle.UNDECORATED);


		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[]args) throws SQLException {
		
	
		launch(args);
	}
}
