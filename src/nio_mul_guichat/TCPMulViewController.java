package nio_mul_guichat;

import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TCPMulViewController implements Initializable {

	class GuiSender extends Thread{

		SocketChannel socket;
		String name;
		
		public GuiSender(SocketChannel socket, String name) {
			super();
			this.socket = socket;
			try {
//				name = "["+InetAddress.getLocalHost().getHostAddress()+"]";
				this.name = "["+name+"]";
				///현재 보내는 컴퓨터의 ip로 이름 설정
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Charset charset = Charset.defaultCharset();
			
			tf.setOnAction(ee->{
				ByteBuffer buf = charset.encode(name+tf.getText());
				try {
					socket.write(buf);
					tf.setText("");
					tf.requestFocus();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
				
	}

	class GuiReciever extends Thread{
		SocketChannel socket;

		public GuiReciever(SocketChannel socket) {
			super();
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Charset charset = Charset.defaultCharset();
			while(true) {
				try {
					ByteBuffer buf = ByteBuffer.allocate(100);
					socket.read(buf);
					buf.flip();
					String data = charset.decode(buf).toString()+"\n";
					ta.appendText(data);
					tf.requestFocus();
				} catch (Exception e) {
					// TODO: handle exception
//					break;
				}
				
			}
		}
		
	}
	
	
	
	@FXML Button back_bt;
	@FXML TextArea ta;
	@FXML TextField tf;
	
	String name;
	SocketChannel socket;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		socket = (SocketChannel)resources.getObject("socket");
		name = resources.getObject("name").toString();
		new GuiSender(socket, name).start();
		new GuiReciever(socket).start();
		 tf.requestFocus();
		
		back_bt.setOnAction(ee->back());
	}
	
	void back() {
		
		socket = null;
		
		Parent view;
		try {
			view = FXMLLoader.load(getClass().getResource("client.fxml"));
			Scene scene = new Scene(view);
			Stage stage = (Stage)back_bt.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

}
