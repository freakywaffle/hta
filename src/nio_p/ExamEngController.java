package nio_p;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import nio_p.ExamKorController.Timer;

class EngQA{
	
	ArrayList<String> qq = new ArrayList<>();
	ArrayList<String> aa = new ArrayList<>();

	public EngQA() {
		super();
		qq.add("호랑이 영어로");
		qq.add("고양이 영어로");
		qq.add("쥐 영어로");
		qq.add("토끼 영어로");
		qq.add("개 영어로");
		qq.add("사자 영어로");
		qq.add("소 영어로");
		qq.add("돼지 영어로");
		
		aa.add("tiger");
		aa.add("cat");
		aa.add("mouse");
		aa.add("rabbit");
		aa.add("dog");
		aa.add("lion");
		aa.add("cow");
		aa.add("pig");
	}
	
	double chkJum(ArrayList<TextField> alist) {
		
		double jum = 0;
		
		for (int i = 0; i < aa.size(); i++) {
			if(aa.get(i).equals(alist.get(i).getText())) {
				jum+=12.5;
			}
		}
		
		return jum;
	}
}

public class ExamEngController implements Initializable {
	
	@FXML Button matStart;
	@FXML AnchorPane ancEng;
	
	@FXML TextField aa1;
	@FXML TextField aa2;
	@FXML TextField aa3;
	@FXML TextField aa4;
	@FXML TextField aa5;
	@FXML TextField aa6;
	@FXML TextField aa7;
	@FXML TextField aa8;
	@FXML Label qq1;
	@FXML Label qq2;
	@FXML Label qq3;
	@FXML Label qq4;
	@FXML Label qq5;
	@FXML Label qq6;
	@FXML Label qq7;
	@FXML Label qq8;
	
	@FXML Label timer;
	
	ArrayList<Label> qlist = new ArrayList<>();
	ArrayList<TextField> alist = new ArrayList<>();
	
	EngQA eqa;
	
	String name;
	String no;
	
	double engJum;
	double korJum;
	
	int tt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		no = resources.getObject("no").toString();
		name = resources.getObject("name").toString();
		korJum = Double.parseDouble(resources.getObject("korJum").toString());
		
		
		qlist.add(qq1);
		qlist.add(qq2);
		qlist.add(qq3);
		qlist.add(qq4);
		qlist.add(qq5);
		qlist.add(qq6);
		qlist.add(qq7);		
		qlist.add(qq8);
		
		alist.add(aa1);
		alist.add(aa2);
		alist.add(aa3);
		alist.add(aa4);
		alist.add(aa5);
		alist.add(aa6);
		alist.add(aa7);
		alist.add(aa8);
		
		eqa = new EngQA();
		for (int i = 0; i < qlist.size(); i++) {
			qlist.get(i).setText(eqa.qq.get(i));
		}
		
		Timer tm = new Timer();
		tm.start();
		
	}
	
	public void startMat() {
		
		engJum = eqa.chkJum(alist);
		
		
		AnchorPane root=  (AnchorPane)matStart.getScene().getRoot();	
		
		Parent mat;
		try {
			mat = FXMLLoader.load(
					getClass().getResource("Mat.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, Object>map = new HashMap<>();
							map.put("no", no);
							map.put("name", name);
							map.put("korJum", korJum);
							map.put("engJum", engJum);
							
							return map.get(key);
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});

			root.getChildren().add(mat);
			root.getChildren().remove(ancEng);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class Timer extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for (int i = 0; i < 10; i++)  {
					
					sleep(1000);
					Platform.runLater(()->{
						tt++;
						timer.setText(tt+"");
						if(tt >= 10) {
							Alert inf = new Alert(AlertType.INFORMATION);
							
							inf.setHeaderText("시간초과 다음과목으로넘어갑니다");
							
							Optional<ButtonType> intOpt = inf.showAndWait();
							
							if(intOpt.get() == ButtonType.OK) {
								startMat();
							}
						}
					});
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
