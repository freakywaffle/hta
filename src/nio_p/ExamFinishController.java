package nio_p;

import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class ExamFinishController implements Initializable {
	
	
	@FXML Label nol;
	@FXML Label namel;
	@FXML Label korl;
	@FXML Label engl;
	@FXML Label matl;
	@FXML Label suml;
	@FXML Label avgl;
	
	
	String name;
	String no;
	double avg;
	double sum;
	double kor;
	double mat;
	double eng;
	
	String str;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		no = resources.getObject("no").toString();
		name = resources.getObject("name").toString();
		kor = Double.parseDouble(resources.getObject("korJum").toString());
		eng = Double.parseDouble(resources.getObject("engJum").toString());
		mat = Double.parseDouble(resources.getObject("matJum").toString());
		
		sum = kor+eng+mat;
		avg = sum/3;
		
		
		nol.setText(no);
		namel.setText(name);
		korl.setText(kor+"");
		engl.setText(eng+"");
		matl.setText(mat+"");
		suml.setText(sum+"");
		avgl.setText(avg+"");
		
		
		str = "번호:"+no +",이름:"+name +",국어:"+kor+",영어:"+eng+",수학:"+mat+",합계:"+sum+",평균:"+avg;
	}

	public void writeResult() throws IOException {
		FileChannel channel = FileChannel.open(Paths.get("Test/result.txt"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode(str);

		channel.write(buf);
		
		
		channel.close();
	}
}
