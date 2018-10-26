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
		
		//������� ������ ũ�⸦ �𸣹Ƿ� ����� buffer ũ�� Ȯ��
		ByteBuffer buf = ByteBuffer.allocate(100);
		Charset charset = Charset.defaultCharset();
		int cnt = 0;
		
		
		String data = "";
		while(true) {
			cnt = channel.read(buf);
			
			if(cnt==-1) // -1�� ���ϵǸ� channel���� ������ data�� �������̶�� �� 
				break;
			buf.flip();//buf�� ��ġ�� ó������ �̵�
			data+= charset.decode(buf);
			buf.clear();//�ѹ� ����� ������ �����ֱ�
		}
//		while(channel.read(buf)!=-1) {}
		
		channel.close();
		System.out.println(data);
	}

}
