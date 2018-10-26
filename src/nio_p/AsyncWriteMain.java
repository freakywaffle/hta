package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AttachGoGo{
	Path path;
	AsynchronousFileChannel channel;
	public AttachGoGo(Path path, AsynchronousFileChannel channel) {
		super();
		this.path = path;
		this.channel = channel;
	}
	
	
}

public class AsyncWriteMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println(executorService);
		
		for (int i = 0; i < 10; i++) {
			
			Path path = Paths.get("nnn/aaa_"+i+".txt");
			
			Charset chSet = Charset.defaultCharset();
			
			ByteBuffer buf = chSet.encode("Ω√∞£≈Ω«Ë¥Î ¡ˆ¥œ");
			
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(
					path, 
					EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
					executorService);
			
			AttachGoGo gogo = new AttachGoGo(path, channel);
			CompletionHandler<Integer, AttachGoGo> completionHandler = new CompletionHandler<Integer, AttachGoGo>() {

				@Override
				public void completed(Integer result, AttachGoGo attachment) {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"->"+attachment.path.getFileName()+":"+result+" byte");
					
					try {
						attachment.channel.close();///¥Ÿ ΩË¿∏∏È ¥›±‚
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void failed(Throwable exc, AttachGoGo attachment) {
					// TODO Auto-generated method stub
					
				}
			};
			
			
			channel.write(buf, 0, gogo, completionHandler);
			
			//channel.close();
		}
		
	}

}
