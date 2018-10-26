package nio_mul_guichat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TCPMulServer {
	
	
	ArrayList<SocketChannel> list = new ArrayList<>();
	
	
	class TCPMulServerReciever extends Thread{
		SocketChannel socket;
		String name;

		public TCPMulServerReciever(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				InetSocketAddress addr = (InetSocketAddress)socket.getRemoteAddress();
				name = "["+addr.getAddress().getHostAddress()+"]";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			sendToAll(name+" 입장");
			
			list.add(socket);
			sendToAll("접속자수: "+list.size());
			System.out.println(name+"연결: "+list.size());
			Charset charset = Charset.defaultCharset();
				try {
					while(socket!=null) {
						ByteBuffer buf = ByteBuffer.allocate(100);
						socket.read(buf);
						buf.flip();
						String data = charset.decode(buf).toString();
						sendToAll(data);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					list.remove(socket);
					sendToAll(name+" 퇴장");	
					sendToAll("접속자수: "+list.size());
				}
		}		
	}
	
	void sendToAll(String msg) {
		
		for (SocketChannel channel : list) {
			Charset charset = Charset.defaultCharset(); 
			ByteBuffer buf = charset.encode(msg);
			try {
				channel.write(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public TCPMulServer() {
		// TODO Auto-generated constructor stub
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			while(true) {
				SocketChannel client = server.accept();
				
				new TCPMulServerReciever(client).start();
				
				System.out.println(client.getRemoteAddress()+"연결: "+list.size());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPMulServer();
	}

}
