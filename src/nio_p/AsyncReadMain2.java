package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class AsyncReadMain2 {
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Path path = Paths.get("ppp");
		DirectoryStream<Path> ds = Files.newDirectoryStream(path);
		for (Path pp : ds) {
//			System.out.println(pp);
//			System.out.println(pp.getFileName().toString().endsWith("txt"));
//			System.out.println();
//			Thread.sleep(10);
			if(pp.getFileName().toString().endsWith(".txt")) {
				AsynchronousFileChannel channel = AsynchronousFileChannel.open(pp, StandardOpenOption.READ);
				ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
				AttachGoGo2 attach = new AttachGoGo2(pp, channel, buf);
				
				CompletionHandler<Integer, AttachGoGo2> handler = new CompletionHandler<Integer, AttachGoGo2>() {
	
					@Override
					public void completed(Integer result, AttachGoGo2 attachment) {
						// TODO Auto-generated method stub
						attachment.buf.flip();
						Charset charset = Charset.defaultCharset();
						String data = charset.decode(attachment.buf).toString();
						
						System.out.println("³»¿ë: "+Thread.currentThread().getName()+"->"+attachment.path.getFileName()+":"+data);
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

}
