package nio_file;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.sun.javafx.image.IntPixelSetter;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


class FileSender extends Thread{

	SocketChannel socket;
	File file;
	public FileSender(SocketChannel socket, File file) {
		super();
		this.socket = socket;
		this.file = file;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			Path pp = Paths.get(file.getPath());
			FileChannel channel = FileChannel.open(pp, StandardOpenOption.READ);
			ByteBuffer buf = ByteBuffer.allocate(1024);
			Charset charset = Charset.defaultCharset();
			buf = charset.encode(file.getName());
			socket.write(buf);
			buf.clear();
			
			buf = ByteBuffer.allocate(1024);
			int cnt = 0;
			while(true) {
//				Thread.sleep(10);
				
				cnt = channel.read(buf);
				System.out.println(cnt);
				if(cnt==-1)  
					break;
				buf.flip();
//				socket.write(charset.encode(charset.decode(buf)));
				socket.write(buf);
				buf.clear();
			}
			
			channel.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
}

public class TransFileServer extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("\\hyungho\\study\\javaHome\\guiHome\\ppp"));
		File file = fc.showOpenDialog(primaryStage);
		
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			while(true) {
				System.out.println("서버대기");	
				
				SocketChannel client = server.accept();
				System.out.println("클라이언트 접속");
				
				new FileSender(client, file).start();				
				
			}
			
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
