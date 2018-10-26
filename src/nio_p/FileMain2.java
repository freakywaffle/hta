package nio_p;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Path pp = Paths.get("ppp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		DecimalFormat df = new DecimalFormat("#,###");
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		for (Path path : ds) {
			FileTime ft= Files.getLastModifiedTime(path);
			Date d = new Date(ft.toMillis());

			System.out.print(sdf.format(d)+"\t");
//			System.out.print(Files.getLastModifiedTime(path)+"\t");
			if(Files.isDirectory(path)) {
				System.out.print("<DIR>\t");
			}else {
				System.out.print("\t");
			}
			System.out.print(df.format(Files.size(path))+"\t");
			System.out.println(path.getFileName());
			
		}
		
		
	}

}
