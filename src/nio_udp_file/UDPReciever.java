package nio_udp_file;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			channel.bind(new InetSocketAddress(7777));
			
			System.out.println("수신대기");
			
			int cap = 1024;
			ByteBuffer buf = ByteBuffer.allocate(cap);
			
			Charset charset = Charset.defaultCharset();
			channel.receive(buf);
			buf.flip();
			String str = charset.decode(buf).toString();
			buf.clear();
			
			String dir = "Test";
			String file = str;
			
			Path pp = Paths.get(dir+"/"+file);
			
//			channel.receive(buf);
//			buf.flip();
//			int size = buf.getInt();
//			buf.clear();
//			System.out.println(size);
			
			buf = ByteBuffer.allocate(cap);
			FileChannel fc = FileChannel.open(pp, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//			for (int i = 0; i < size; i++) {
//				SocketAddress addr = channel.receive(buf);
//				System.out.println("addr: "+addr);
//				buf.flip();
//				fc.write(buf);
//				buf.clear();
//				System.out.println(i);
//			}
			
			
			while(true) {
				SocketAddress addr = channel.receive(buf);
				if(buf.position() <= 0) {
					break;
				}
				buf.flip();
				fc.write(buf);
				buf.clear();
				
			}
			
			fc.close();
			channel.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
