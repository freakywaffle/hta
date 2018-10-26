package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class MulticastSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel channel = DatagramChannel.open();
			channel.bind(null);
			NetworkInterface inter = NetworkInterface.getByName("eth1");
			
			channel.setOption(StandardSocketOptions.IP_MULTICAST_IF, inter);
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("우리 그룹이에요");
			
			InetSocketAddress group = new InetSocketAddress("230.0.0.1", 7777);
			
			channel.send(buf, group);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
