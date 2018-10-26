package nio_p;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pageExchange.MainController;


public class ExamController implements Initializable {

	@FXML AnchorPane ancMain;
	
	@FXML TextField no_tf;
	@FXML TextField name_tf;
	@FXML Button start;
	
	String name;
	String no;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
	}
	
	public void startKor() {
		
		no = no_tf.getText();
		name = name_tf.getText();
		
		
		AnchorPane root=  (AnchorPane)start.getScene().getRoot();	
		
		Parent kor;
		try {
			kor = FXMLLoader.load(
					getClass().getResource("Kor.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, String>map = new HashMap<>();
							map.put("no", no);
							map.put("name", name);
							
							return map.get(key);
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});

			root.getChildren().add(kor);
			root.getChildren().remove(ancMain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
