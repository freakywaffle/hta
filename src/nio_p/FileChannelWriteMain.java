package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileChannel channel = FileChannel.open(Paths.get("ppp/ccc.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		
		//버퍼 생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("바보바보바보바보바보바보바보바보");

		//파일에 쓰기
		int cnt = channel.write(buf);
		System.out.println(cnt);
		
		//파일에 쓰기
		buf = charset.encode("뚜루");
		cnt = channel.write(buf);
		System.out.println(cnt);

		//한번 사용한 버프는 재사용 불가능
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		//close 필수
		channel.close();
	}

}
