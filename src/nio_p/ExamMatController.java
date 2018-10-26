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

class MatQA{
	
	ArrayList<String> qq = new ArrayList<>();
	ArrayList<String> aa = new ArrayList<>();

	public MatQA() {
		super();
		qq.add("1+1");
		qq.add("2*3");
		qq.add("6/2");
		qq.add("3+2");
		qq.add("2.5*2");
		qq.add("3-1");
		qq.add("5*2");
		qq.add("10/2");
		
		aa.add("2");
		aa.add("6");
		aa.add("3");
		aa.add("5");
		aa.add("5");
		aa.add("2");
		aa.add("10");
		aa.add("5");
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

public class ExamMatController implements Initializable {

	@FXML Button testEnd;
	@FXML AnchorPane ancMat;
	
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
	
	MatQA mqa;
	
	String name;
	String no;
	
	double engJum;
	double korJum;
	double matJum;
	
	int tt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		no = resources.getObject("no").toString();
		name = resources.getObject("name").toString();
		korJum = Double.parseDouble(resources.getObject("korJum").toString());
		engJum = Double.parseDouble(resources.getObject("engJum").toString());
		
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
		
		mqa = new MatQA();
		for (int i = 0; i < qlist.size(); i++) {
			qlist.get(i).setText(mqa.qq.get(i));
		}
		
		Timer tm = new Timer();
		tm.start();
		
	}

	
	public void endTest() {
		
		
		matJum = mqa.chkJum(alist);
		
		AnchorPane root=  (AnchorPane)testEnd.getScene().getRoot();	
		
		Parent finish;
		try {
			finish = FXMLLoader.load(
					getClass().getResource("Finish.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, Object>map = new HashMap<>();
							map.put("no", no);
							map.put("name", name);
							map.put("korJum", korJum);
							map.put("engJum", engJum);
							map.put("matJum", matJum);
							
							return map.get(key); 
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});

			root.getChildren().add(finish);
			root.getChildren().remove(ancMat);
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
							
							inf.setHeaderText("시간초과 성적표 화면으로넘어갑니다");
							
							Optional<ButtonType> intOpt = inf.showAndWait();
							
							if(intOpt.get() == ButtonType.OK) {
								endTest();
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
