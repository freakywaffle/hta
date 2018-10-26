package nio_file;

import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;

import com.sun.javafx.image.PixelSetter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FileConnectController implements Initializable {
	@FXML Button con_bt;
	@FXML TextField ip_tf;
	
	SocketChannel socket;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		con_bt.setOnAction(ee->{
			try {
				String ip = ip_tf.getText();
				
				socket = SocketChannel.open();
				socket.configureBlocking(true);
				
				socket.connect(new InetSocketAddress(ip, 7777));
				System.out.println("서버 연결 성공");
				
				
				int cap = 1024;
				ByteBuffer buf = ByteBuffer.allocate(cap);
				
				Charset charset = Charset.defaultCharset();
				socket.read(buf);
				buf.flip();
				String str = charset.decode(buf).toString();
				System.out.println(str);
				buf.clear();
				
				String dir = "Test";
				String file = str;
				
				Path pp = Paths.get(dir+"/"+file);
//				Path pp = Paths.get("Test/test.jpg");
				FileChannel channel = FileChannel.open(pp, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				int cnt = 0;
				
				while(true) {
					cnt = socket.read(buf);
					buf.flip();
					channel.write(buf);
					buf.clear();
					System.out.println(cnt);
					if(cnt < cap) {
						break;
					}
				}		
				socket.close();
				channel.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
