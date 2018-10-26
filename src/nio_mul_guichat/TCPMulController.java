package nio_mul_guichat;

import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TCPMulController implements Initializable {

	@FXML Button connect_bt;
	@FXML TextField ip_tf;
	@FXML TextField name_tf;
	
	@FXML BorderPane conbp;
	
	String message;
	
	SocketChannel socket = null;
	String name;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		connect_bt.setOnAction(ee->{
			try {
				Alert al = new Alert(AlertType.WARNING);
				String ip = ip_tf.getText();
				name = name_tf.getText();
				if(name.equals("")) {
					al.setContentText("닉네임을 입력하세요");
					al.show();
					name_tf.requestFocus();
					return;
				}
				
				if(ip.equals("")) {
					al.setContentText("ip를 입력하세요");
					al.show();
					ip_tf.requestFocus();
					return;
				}
				
				if(!Pattern.matches("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})", ip)){
					al.setContentText("ip의 형식을 확인하세요");
					al.show();
					ip_tf.requestFocus();					
					return;
				}
				
				
				
				socket = SocketChannel.open();
				socket.configureBlocking(true);
				
				socket.connect(new InetSocketAddress(ip, 7777));
				System.out.println("서버 연결 성공");
				
				go();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
	void go() throws Exception {
		
		Parent root = FXMLLoader.load(
				getClass().getResource("clientview.fxml"),
				new ResourceBundle() {
					
					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						HashMap<String, Object> map = new HashMap<>();
						map.put("socket", socket);
						map.put("name", name);
						return map.get(key);
					}
					
					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}
				});
		Scene scene = new Scene(root);
		Stage stage = (Stage)conbp.getScene().getWindow();
		stage.setScene(scene);

		stage.show();
	}

}
