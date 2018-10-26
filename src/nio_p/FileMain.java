package nio_p;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Path pp = Paths.get("ppp");
		
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.newDirectoryStream(pp));
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		for (Path path : ds) {
			System.out.println(path);
		}
		
		pp = Paths.get("ppp/testImage.jpg");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));
		System.out.println(Files.getOwner(pp));
		System.out.println(Files.isHidden(pp));
		System.out.println(Files.isReadable(pp));
		System.out.println(Files.isWritable(pp));
		System.out.println("파일명: "+pp.getFileName());
		System.out.println("현재디렉토리명: "+pp.getParent().getFileName());
		System.out.println("디렉토리 경로수: "+pp.getNameCount());
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i));
		}
	}

}
