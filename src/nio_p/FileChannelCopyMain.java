package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelCopyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileChannel channel = FileChannel.open(Paths.get("ppp/neogul.jpg"), StandardOpenOption.READ);
			FileChannel channel2 = FileChannel.open(Paths.get("Test/neogul.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			ByteBuffer buf = ByteBuffer.allocateDirect(1000000000);
			int cnt = 0;
			
			while(true) {
				cnt = channel.read(buf);
				
				if(cnt==-1)  
					break;
				
				buf.flip();
				channel2.write(buf);
				buf.clear();
			}
			
			channel.close();
			channel2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
