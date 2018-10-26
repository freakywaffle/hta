package pageExchange;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	
	@FXML Label label;
	
	@FXML TextField msg;
	////subLayout ��������
	@FXML AnchorPane subLayout;

	MainController main;
	
	public void subClose() {
		
			
		///���� layout
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	
		          //���� Parent �� AnchorPane(layout)�� ������
		
		main.label.setText(msg.getText());
		///���� layout ���� subLayout ����
		root.getChildren().remove(subLayout);
		
	
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		main = (MainController)resources.getObject("main");
		
		
		label.setText("From Main :"+main.msg.getText());
		
	}

}
