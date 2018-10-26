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
		
		
		//���� ����
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("�ٺ��ٺ��ٺ��ٺ��ٺ��ٺ��ٺ��ٺ�");

		//���Ͽ� ����
		int cnt = channel.write(buf);
		System.out.println(cnt);
		
		//���Ͽ� ����
		buf = charset.encode("�ѷ�");
		cnt = channel.write(buf);
		System.out.println(cnt);

		//�ѹ� ����� ������ ���� �Ұ���
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		//close �ʼ�
		channel.close();
	}

}
