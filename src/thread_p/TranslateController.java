package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {

	@FXML Arc arc;
	@FXML Button pause;
	@FXML Button start;
	@FXML Button stop;
	@FXML Button all;
	
	TranslateTransition transition;
	boolean chk = true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		transition = new TranslateTransition();
		
		transition.setFromX(500);
		transition.setFromY(100);
		transition.setToX(100);
		transition.setToY(400);
		transition.setDuration(new Duration(3000));
		transition.setAutoReverse(true);
		transition.setNode(arc);
		transition.setCycleCount(5);
		transition.play();
		
		pause.setOnAction(ee->{transition.pause(); System.out.println(transition.getStatus());});
		start.setOnAction(ee->{transition.play(); System.out.println(transition.getStatus());});
		stop.setOnAction(ee->{transition.stop(); System.out.println(transition.getStatus());});
		all.setOnAction(ee->{
			if(transition.getStatus()==Status.RUNNING){
				transition.stop();
				all.setText("시작");
			}else
//			if(transition.getStatus()==Status.PAUSED){
//				transition.play();
//				all.setText("일시정지");
//			}else
			if(transition.getStatus()==Status.STOPPED){
				transition.play();
				all.setText("정지");
			}
			
		});
		
		
	}
	

}
