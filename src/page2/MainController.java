package page2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;


public class MainController{

	Stage primaryStage;
	
	@FXML Button btn;
	@FXML Button btn1;
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}



	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



	public void go1() {
		try {
			
			
			Stage ppp = new Stage();	//货肺款 stage 积己
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sub.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			SubController controller = loader.getController();
			System.out.println("pri1"+primaryStage);
			controller.setPrimaryStage(primaryStage);

//			Stage stage = (Stage)btn.getScene().getWindow();
//			ppp.show(stage);
			ppp.setScene(scene);
			ppp.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
