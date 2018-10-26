package page;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	@FXML Label label;
	
	@FXML TextField msg;

	////subLayout 가져오기
	@FXML AnchorPane subLayout;
	
	MainController main;

	
	public void subClose() {
		
			
		///기존 layout
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	
		          //기존 Parent 인 AnchorPane(layout)을 가져옴
		
		main.label.setText("From sub:"+msg.getText());
		///기존 layout 에서 subLayout 제거
		root.getChildren().remove(subLayout);
		
	
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		System.out.println(resources.getObject("hi"));
		
		main = (MainController)resources.getObject("main");
		
		label.setText("From Main :"+main.msg.getText());
		
		//data = resources.getObject("data").toString();
		
		//System.out.println(data);
		
		//label.setText("From Main :"+data);
		
	}

}
