package net_p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientViewController implements Initializable {

	@FXML Button back_bt;
	@FXML Label msg_lb;
	
	@FXML BorderPane viewbp;
	
	String msg;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		msg = resources.getObject("").toString();
		msg_lb.setText(msg);
		back_bt.setOnAction(ee->back());
	}
	
	void back() {
		
		Parent view;
		try {
			view = FXMLLoader.load(getClass().getResource("client.fxml"));
			Scene scene = new Scene(view);
			Stage stage = (Stage)back_bt.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

}
