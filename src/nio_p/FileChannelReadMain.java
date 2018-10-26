package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileChannel channel = FileChannel.open(Paths.get("ppp/ccc.txt"), StandardOpenOption.READ);
		
		//가지고올 데이터 크기를 모르므로 충분한 buffer 크기 확보
		ByteBuffer buf = ByteBuffer.allocate(100);
		Charset charset = Charset.defaultCharset();
		int cnt = 0;
		
		
		String data = "";
		while(true) {
			cnt = channel.read(buf);
			
			if(cnt==-1) // -1이 리턴되면 channel에서 가져올 data가 마지막이라는 것 
				break;
			buf.flip();//buf의 위치를 처음으로 이동
			data+= charset.decode(buf);
			buf.clear();//한번 사용한 버프는 지워주기
		}
//		while(channel.read(buf)!=-1) {}
		
		channel.close();
		System.out.println(data);
	}

}
