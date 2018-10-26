package thread_p;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskController implements Initializable {

	@FXML Button suspend;
	@FXML Button resume;
	@FXML Label label;
	
	NumberGo numberGo;

	boolean spnd = true;
	
	int start=0;
	boolean chk = true;
	boolean chk2 = true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		numberGo = new NumberGo();
		numberGo.start();
		
		suspend.setOnAction(ee->{
			
			if(chk2) {
				numberGo.stop();
				
			}else {
				numberGo = new NumberGo();
				numberGo.start();
			}
			chk2 = !chk2;
		});
		resume.setOnAction(ee->{
			if(chk) {
				numberGo.suspend();
			}else {
				numberGo.resume();
			}
			
			chk = !chk;
		});
	}

	
	class NumberGo extends Thread{

		int i = 0;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		
			
			while(true) {
					
//				if(chk) {
					i++;
					Platform.runLater(()->label.setText(i+""));
//				}
				
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
}
