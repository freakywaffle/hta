package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController2 implements Initializable {

	@FXML Arc rotatearc, scalearc, fillarc, strokearc, fadearc;
	@FXML Button rotate, scale, fill, stroke, fade;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		rotate.setOnAction(ee->{
			RotateTransition transition = new RotateTransition();
			transition.setFromAngle(0);
			transition.setToAngle(359);
			transition.setNode(rotatearc);
			transition.setDuration(new Duration(1000));
//			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		scale.setOnAction(ee->{
			ScaleTransition transition = new ScaleTransition();
			transition.setFromX(1);
			transition.setToX(2);
			transition.setFromY(2);
			transition.setToY(0.5);
			transition.setNode(scalearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		fill.setOnAction(ee->{
			FillTransition transition = new FillTransition();
			transition.setFromValue(Color.RED);
			transition.setToValue(Color.BLUE);
			transition.setShape(fillarc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		stroke.setOnAction(ee->{
			StrokeTransition transition = new StrokeTransition();
			transition.setFromValue(Color.RED);
			transition.setToValue(Color.BLUE);
			transition.setShape(strokearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		fade.setOnAction(ee->{
			FadeTransition transition = new FadeTransition();
			transition.setFromValue(1);
			transition.setToValue(0.3);
			transition.setNode(fadearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		
		
	}
	

}
