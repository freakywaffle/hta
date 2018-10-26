package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.application.Platform;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;




public class TimelineController2 implements Initializable {

	@FXML Arc arc;
	@FXML Circle ball;
	@FXML Button btn1, btn2;
	
	int disX = 50;
	int disY = 230;
	int dur = 10;
	
	ScaleTransition transition;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		BallControl bc = new BallControl();
		bc.setDaemon(true);
		bc.start();
		
		transition = new ScaleTransition();
		transition.setFromX(1);
		transition.setToX(2);
		transition.setFromY(1);
		transition.setToY(0.5);
		transition.setNode(ball);
		transition.setDuration(new Duration(100));
		transition.setAutoReverse(true);
		transition.setCycleCount(2);
		
		
		btn1.setOnAction(ee->{
			
			Timeline tl = new Timeline();
			
			KeyFrame x_0 = new KeyFrame(new Duration(0), new KeyValue(arc.layoutXProperty(), 50));
			KeyFrame x_1 = new KeyFrame(new Duration(1000), new KeyValue(arc.layoutXProperty(), 100));
			KeyFrame y_1 = new KeyFrame(new Duration(1000), new KeyValue(arc.layoutYProperty(), 50));
			KeyFrame y_2 = new KeyFrame(new Duration(2000), new KeyValue(arc.layoutYProperty(), 200));
			
			tl.getKeyFrames().add(x_0);
			tl.getKeyFrames().add(x_1);
			tl.getKeyFrames().add(y_1);
			tl.getKeyFrames().add(y_2);
//			tl.setCycleCount(5);
			tl.setCycleCount(-1);
			tl.setAutoReverse(true);
			tl.play();
		});
		
		btn2.setOnAction(ee->{
			Timeline tl = new Timeline();
//			int cnt=0;
//			while(cnt++<50) {
//				if(disY>50) {
//					System.out.println(disY);
//					tl.getKeyFrames().add(new KeyFrame(new Duration(dur+=10), new KeyValue(ball.layoutYProperty(), disY-=5)));
//				}
//				if(disX<400) {
//					tl.getKeyFrames().add(new KeyFrame(new Duration(dur+=10), new KeyValue(ball.layoutXProperty(), disX+=10)));
//				}
//			}
			
////			KeyFrame x_1 = new KeyFrame(new Duration(1000), new KeyValue(ball.layoutXProperty(), 400));
////			KeyFrame y_1 = new KeyFrame(new Duration(1000), new KeyValue(ball.layoutYProperty(), 50));
//			
////			tl.getKeyFrames().add(x_1);
////			tl.getKeyFrames().add(y_1);
////			tl.setCycleCount(5);
			
			int dis = 400;
			
			KeyFrame x1 = new KeyFrame(new Duration(1000), new KeyValue(ball.layoutYProperty(), 450));
			
			tl.getKeyFrames().add(x1);
			tl.setAutoReverse(true);
			tl.setCycleCount(-1);
			
			tl.play();
			
			
//			if(ball.getLayoutY() > dis) {
				
			
//			}
		});
		
	}
	
	
	class BallControl extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Platform.runLater(()->chk());
					sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	void chk() {
		if((ball.getLayoutY()+ball.getRadius()*2) >= 460) {
			
			transition.play();
		}
	}
	

}
