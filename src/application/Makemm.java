package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Makemm extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//fxml 을 사용하는 이유는 보기 편해서 한눈에 잘들어온다 뷰 화면구성을 일케 하겠다
		Parent parent = FXMLLoader.load(getClass().getResource("MakeMem.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}

}
