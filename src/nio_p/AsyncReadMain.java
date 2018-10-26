package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class AttachGoGo2{
	Path path;
	AsynchronousFileChannel channel;
	ByteBuffer buf;
	public AttachGoGo2(Path path, AsynchronousFileChannel channel, ByteBuffer buf) {
		super();
		this.path = path;
		this.channel = channel;
		this.buf = buf;
	}
}

public class AsyncReadMain {
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Path path = Paths.get("nnn/aaa_"+i+".txt");
			
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
			ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
			AttachGoGo2 attach = new AttachGoGo2(path, channel, buf);
			
			CompletionHandler<Integer, AttachGoGo2> handler = new CompletionHandler<Integer, AttachGoGo2>() {

				@Override
				public void completed(Integer result, AttachGoGo2 attachment) {
					// TODO Auto-generated method stub
					attachment.buf.flip();
					Charset charset = Charset.defaultCharset();
					String data = charset.decode(attachment.buf).toString();
					
					System.out.println(Thread.currentThread().getName()+"->"+attachment.path.getFileName()+":"+data);
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void failed(Throwable exc, AttachGoGo2 attachment) {
					// TODO Auto-generated method stub
					
				}
			};
			
			channel.read(buf, 0, attach, handler);
		}
	}

}
