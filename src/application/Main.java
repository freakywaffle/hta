package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;





public class Main extends Application {
	
	
	
	public Main() {
		super();
		// TODO Auto-generated constructor stub
		
		System.out.println("생성자");
	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init다"); //데이터를 받을때 쓴다.
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("죽는닷"); // 죽으면서 다음걸 연다  국어 >> 영어 여는것 처럼
		//Sub.launch(new String[] {});//스태틱이라 걍 sub치려고했는데 안되고 문자열을 집어넣어도 안되고
		
		Sub.main(new String[] {} );
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("start다");
			//primaryStage -> scene -> root 순으로 속해있음 
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);//크기
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//getResource를 핢으로써 css파일을 불러옴 (한쌍임)
			primaryStage.setScene(scene); //sc
			primaryStage.setTitle("와 제목이당");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("main이다");
		launch(args);//실행 버튼임 없으면 콘솔에서 계속 돎 (빨간불들어옮)
	}
}
