package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class ThreadAniController implements Initializable {
	
	@FXML Pane pp, user;
	@FXML Arc pArc;
	@FXML AnchorPane totalP;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		//�̺�Ʈ ��� --> Ű�Է� �̺�Ʈ(KEY_PRESSED, KEY_RELEASED)
		//focusTraversable="true" -- node�� focus�� �������� �ʰ� �����Ű�°� keyEvent�� ��ü�� ���� �ʵ��� ����4
		
		totalP.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {	
			
			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
			
				if(key.getCode()==KeyCode.UP) {
					double yy = user.getLayoutY()-5;
					if(yy<0) {
						yy = 0;
					}
					user.setLayoutY(yy);
				}
				if(key.getCode()==KeyCode.DOWN) {
					double yy = user.getLayoutY()+5;
					if(totalP.getPrefHeight()<yy+user.getPrefHeight())
						yy = totalP.getPrefHeight() - user.getPrefHeight();
					user.setLayoutY(yy);
				}
				if(key.getCode()==KeyCode.LEFT) {
					double xx = user.getLayoutX()-5;

					if(xx<0) {
						xx = 0;
					}
					user.setLayoutX(xx);
				}
				if(key.getCode()==KeyCode.RIGHT) {
					double xx = user.getLayoutX()+5;
					if(totalP.getPrefWidth()<xx+user.getPrefWidth())
						xx=totalP.getPrefWidth()-user.getPrefWidth();
					user.setLayoutX(xx);
				}
			}
						
		});
	}
	

	class Timer extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(true) {
				
				try {
					Platform.runLater(()->init());
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	int disX = 5;
	int disY = 5;
	void init() {
		double xx = pp.getLayoutX()+disX;
		double yy = pp.getLayoutY()+disY;
		if(totalP.getPrefWidth()<xx+pp.getPrefWidth() || xx<0) {
			disX*=-1;
		}
		if(totalP.getPrefHeight()<yy+pp.getPrefHeight() || yy<0) {
			disY*=-1;
		}
		
		
		pp.setLayoutX(xx);
		pp.setLayoutY(yy);
		oc();
		
	}
	boolean chk = true;
	boolean chk2 = true;
	int chg = 5;
	
	void oc() {
		if(disX<0) {
			if(chk) {
				pArc.setRotate(180);
				chk = false;
			}
		}else {
			if(!chk) {
				pArc.setRotate(0);
				chk = true;				
			}
		}
		if(disY<0) {
			if(chk2) {
				pArc.setRotate(270);
				chk2 = false;
			}
		}else {
			if(!chk2) {
				pArc.setRotate(90);
				chk2 = true;
			}
		}
		
		double sa = pArc.getStartAngle();
		double l = pArc.getLength();
		
		if(sa-chg < 0 || sa-chg > 45) {
			chg *=-1; 
			if(sa-chg >= 45) {
				sa = 45;
			}else if(sa-chg <0){
				
				
				
				sa = 0;
				
			}
		}
		
		pArc.setStartAngle(sa-chg);
		pArc.setLength(l+chg*2);
	}
}
