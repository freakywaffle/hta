package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class DrawingMain extends Application implements Initializable{

	@FXML Canvas canvas;
	GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("canvas2.fxml")); 
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gc = canvas.getGraphicsContext2D();
		
		Image img = new Image("file:ppp/1.jpg");
		gc.drawImage(img, 50, 50);
		
		gc.strokeArc(40, 300, 70, 70, 10, 240, ArcType.OPEN);
		gc.strokeArc(180, 300, 70, 70, -60, 225, ArcType.OPEN);
		gc.strokeOval(50, 320, 200, 200);
		gc.setFill(Color.BLUE);
		gc.fillOval(75, 345, 150, 150);
		gc.setFill(Color.BLACK);
		gc.fillOval(140, 410, 20, 20);
		gc.setFill(Color.BLACK);
		gc.fillRect(147, 380, 5, 30);
		gc.fillRect(159, 418, 50, 5);
		
	}

}
