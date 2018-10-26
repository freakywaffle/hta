package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GraphicFxmlMain extends Application implements Initializable{

	@FXML Rectangle rec;
	@FXML Line line;
	@FXML Button btn;
	@FXML Button packman_bt;
	@FXML Arc arc;
	int chg = 15;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// TODO Auto-generated method stub
		Parent root = 
				FXMLLoader.load(getClass().getResource("graphicFxml.fxml"));
		
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
		btn.setOnAction(ee->{
			rec.setRotate(chg+=10);
			
		});
		
		
		
		
		packman_bt.setOnAction(ee->{
			
			double sa = arc.getStartAngle();
			double l = arc.getLength();
			
			if(sa-chg < 0 || sa-chg > 45) {
				chg *=-1; 
				if(sa-chg >= 45) {
					sa = 45;
				}else if(sa-chg <0){
					sa = 0;
					
				}
			}
			arc.setStartAngle(sa-chg);
			arc.setLength(l+chg*2);
				
			
			
		});
		
	}

}
