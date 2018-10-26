package net_p;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientController implements Initializable {

	@FXML Button connect_bt;
	@FXML TextField ip_tf;
	@FXML TextField port_tf;
	
	@FXML BorderPane conbp;
	
	String message;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		connect_bt.setOnAction(ee->{
			try {
				Alert al = new Alert(AlertType.WARNING);
				String ip = ip_tf.getText();
				String port = port_tf.getText();
				if(port.equals("")) {
					al.setContentText("port를 입력하세요");
					al.show();
					port_tf.requestFocus();
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
				
				
				Socket socket = new Socket(ip, Integer.parseInt(port));
				
				InputStream is = socket.getInputStream();
				
				DataInputStream dis = new DataInputStream(is);
				
				message = dis.readUTF();
				
				dis.close();
				is.close();
				
				
				go();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
	void go() throws Exception {
		
		Parent view = FXMLLoader.load(getClass().getResource("clientview.fxml"),
				new ResourceBundle() {

					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						return message;
					}

					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}});
		
		Scene scene = new Scene(view);
		Stage stage = (Stage)connect_bt.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
