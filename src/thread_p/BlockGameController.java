package thread_p;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


class Block{
	double x;
	double y;
	double width;
	double height;
	
	Rectangle rec;
	
	public Block(double x, double y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
		makeRec();
	}
	
	void makeRec() {
		rec = new Rectangle(x,y,width,height);
	}
}

class SetBlockCla {
	
	ArrayList<Block> recs = new ArrayList<>();

	public SetBlockCla() {

		recs.add(new Block(0, 30, 60, 30));
		recs.add(new Block(70, 30, 60, 30));
		recs.add(new Block(140, 30, 60, 30));
		recs.add(new Block(210, 30, 60, 30));
//		recs.add(new Rectangle(280, 30, 60, 30));
	}

	public ArrayList<Block> getRecs() {
		return recs;
	}

	public void setRecs(ArrayList<Block> recs) {
		this.recs = recs;
	}
	
	boolean crash(Pane ballP, int disY, Rectangle rec) {
		boolean chk = false;
		double yy = ballP.getLayoutY()+disY;
		
		if(rec.getLayoutY()+rec.getHeight()>yy && rec.getLayoutX() < ballP.getLayoutX() && rec.getLayoutX()+rec.getWidth()>ballP.getLayoutX()) {
			chk = true;
		}
//		if(rec.getLayoutY()+rec.getHeight()>yy) {
////			System.out.println("Á¶°Ç1 µé¾î¿È");
//			chk = true;			
//		}
//		if(rec.getLayoutX() < ballP.getLayoutX()) {
////			System.out.println("Á¶°Ç2 µé¾î¿È");
//			chk = true;			
//		}
//		if(rec.getLayoutX()+rec.getWidth()>ballP.getLayoutX()) {
////			System.out.println("Á¶°Ç3 µé¾î¿È");
//			chk = true;			
//		}
		
		return chk;
	}
	
//	int chk(Pane ballP, int disY) {
//		for (Rectangle rec : recs) {
//			System.out.println(rec.getLayoutX());
//			System.out.println(rec.getLayoutY());
//			if(crash(ballP, disY, rec)) {
//				System.out.println("µé¾î¿È");
//				disY *=-1;
//				break;
//			}
//		}
//		
//		return disY;
//	}
	
	
	int chk(Pane ballP, int disY, ArrayList<Rectangle> recs) {
		for (Rectangle rec : recs) {
			if(crash(ballP, disY, rec)) {
				
				
				rec.setLayoutX(0);
				rec.setLayoutY(0);
				rec.setWidth(0);
				rec.setHeight(0);
				rec.setVisible(false);
				disY *=-1;
				break;
			}
		}		
		return disY;
	}
	
//	int chk(Pane ballP, int disY, ArrayList<Block> recs) {
//		for (Block rec : recs) {
//			if(crash(ballP, disY, rec.rec)) {				
//				
//				rec.rec.setLayoutX(0);
//				rec.rec.setLayoutY(0);
//				rec.rec.setWidth(0);
//				rec.rec.setHeight(0);
//				rec.rec.setVisible(false);
//				disY *=-1;
//				break;
//			}
//		}		
//		return disY;
//	}

}



public class BlockGameController implements Initializable {

	@FXML Pane ballP;
	@FXML Rectangle bar;
	@FXML AnchorPane ancP;
	@FXML Rectangle r1;
	@FXML Rectangle r2;
	@FXML Rectangle r3;
	@FXML Rectangle r4;
	@FXML Rectangle r5;
	@FXML Rectangle r6;
	
	
	BlockGame bg;
	
	SetBlockCla sbc;
	ArrayList<Rectangle> recs;
//	ArrayList<Block> recs;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		sbc = new SetBlockCla();
//		ArrayList<Rectangle> recs = sbc.getRecs();
//		for (Rectangle rec : recs) {
//			System.out.println(rec);
//			ancP.getChildren().add(rec);
//		}
		
		recs = new ArrayList<>();
		
		recs.add(r1);
		recs.add(r2);
		recs.add(r3);
		recs.add(r4);
		recs.add(r5);
		recs.add(r6);
				
		
		
		
		
		ancP.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {	
			
			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				if(key.getCode()==KeyCode.LEFT) {
					double xx = bar.getLayoutX()-10;

					if(xx<0) {
						xx = 0;
					}
					bar.setLayoutX(xx);
				}
				if(key.getCode()==KeyCode.RIGHT) {
					double xx = bar.getLayoutX()+10;
					if(ancP.getPrefWidth()<xx+bar.getWidth())
						xx=ancP.getPrefWidth()-bar.getWidth();
					bar.setLayoutX(xx);
				}
				if(key.getCode()==KeyCode.SPACE) {
					bg = new BlockGame();
					bg.setDaemon(true);
					bg.start();
				}
			}
						
		});
	}

	
	class BlockGame extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {			
			
				try {
					Platform.runLater(()->moveBall());
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
	
	void moveBall() {
		double xx = ballP.getLayoutX()+disX;
		double yy = ballP.getLayoutY()+disY;
		
		if(ancP.getPrefWidth()<xx+ballP.getPrefWidth() || xx<0) {
			disX *= -1;
		}
		if(yy < 0 || 
				(bar.getLayoutY()<yy+ballP.getPrefHeight() && 
				bar.getLayoutX() < ballP.getLayoutX() && 
				bar.getLayoutX()+bar.getWidth()>ballP.getLayoutX())) {
			disY *= -1;
		}
		
		disY = sbc.chk(ballP, disY, recs);
		
		
		ballP.setLayoutX(xx);
		ballP.setLayoutY(yy);
		
		endChk();
	}
	
	
	void endChk() {
		boolean end = true;
		for (Rectangle rec : recs) {
			if(rec.isVisible()) {
				end = false;
			}
		}
		if(end) {
			bg.stop();
		}
	}
}
