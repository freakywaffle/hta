package nio_udp_gui;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UdpViewController2 implements Initializable {
	@FXML TextArea msg_ta;
	@FXML Button rec_bt;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		rec_bt.setText("수신대기");
		rec_bt.setOnAction(ee->{
			try {
				DatagramChannel channel = 
						DatagramChannel.open(StandardProtocolFamily.INET);
				
				channel.bind(new InetSocketAddress(7777));
				
				
				ByteBuffer buf = ByteBuffer.allocate(100);
				SocketAddress addr = channel.receive(buf);
				
				buf.flip();
				Charset charset = Charset.defaultCharset();
				String data = charset.decode(buf).toString();
				System.out.println(data);
				msg_ta.appendText(data);						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		
	}

}
