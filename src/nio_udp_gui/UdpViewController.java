package nio_udp_gui;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class UdpViewController implements Initializable {
	@FXML TextField ip_tf;
	@FXML TextField msg_tf;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		msg_tf.setOnAction(ee->{
			try {
				DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
				//IPV4 사용-StandardProtocolFamily.INET
				
				System.out.println("data 전송시작");
				
				Charset charset = Charset.defaultCharset();
				ByteBuffer buf = charset.encode(msg_tf.getText());
				
				int cnt = channel.send(buf,new InetSocketAddress(ip_tf.getText(),7777));
				
				System.out.println("data 전송완료:"+cnt);
				
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}
