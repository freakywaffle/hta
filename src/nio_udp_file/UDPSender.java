package nio_udp_file;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UDPSender extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			FileChooser fch = new FileChooser();
			fch.setInitialDirectory(new File("\\hyungho\\study\\javaHome\\guiHome\\ppp"));
			File file = fch.showOpenDialog(primaryStage);
			Path pp = Paths.get(file.getPath());
			
			FileChannel fc = FileChannel.open(pp, StandardOpenOption.READ);
			
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			Charset charset = Charset.defaultCharset();
			buf = charset.encode(file.getName());
			channel.send(buf,new InetSocketAddress("192.168.10.16",7777));
			buf.clear();
			
			buf = ByteBuffer.allocate(1024);
//	
//			double aa = Files.size(pp)/1024.0;
//			
//			int size = (int)Math.ceil(aa);
//			buf.putInt(size);
//			buf.flip();
//			channel.send(buf, new InetSocketAddress("192.168.10.16",7777));
//			buf.clear();
			
			
			int cnt = 0;
			while(true) {
				
				cnt = fc.read(buf);
				System.out.println(cnt);
				if(cnt==-1)  
					break;
				buf.flip();

				channel.send(buf,new InetSocketAddress("192.168.10.16",7777));
				buf.clear();
			}
			
			buf = ByteBuffer.allocate(0);
			
			channel.send(buf,new InetSocketAddress("192.168.10.16",7777));
			
			
			fc.close();
			channel.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		launch(args);
	}

	

}
