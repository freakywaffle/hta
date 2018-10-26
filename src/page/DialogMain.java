package page;

import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DialogMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("알림창");
		info.setHeaderText("알림창 제목");
		info.setContentText("알림창 내용");
		info.show();
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("에러창");
		error.setHeaderText("에러창 제목");
		error.setContentText("에러창 내용");
		error.show();

		Alert warning = new Alert(AlertType.WARNING);
		warning.setTitle("워닝창");
		warning.setHeaderText("워닝창 제목");
		warning.setContentText("워닝창 내용");
		warning.show();

		Alert custom = new Alert(AlertType.WARNING);
		custom.setTitle("커스텀창");
		custom.setHeaderText("커스텀창 제목");
		custom.setContentText("커스텀창 내용");
		Label label = new Label("구체적 경고 내용");
		TextArea textArea = new TextArea("경고 경고 내용내용 블라블라");
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxHeight(Double.MAX_VALUE);
		textArea.setMaxWidth(Double.MAX_VALUE);
		
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane gridPane = new GridPane();
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.add(label,0,0);
		gridPane.add(textArea,0,1);
		
		custom.getDialogPane().setExpandableContent(gridPane);
		
		custom.show();
		
		

		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("컨펌창");
		confirm.setHeaderText("컨펌창 제목");
		confirm.setContentText("컨펌창 내용");
		
		Optional<ButtonType> result = confirm.showAndWait();
		System.out.println(result.get());
		if(result.get()==ButtonType.OK) {
			System.out.println("확인 클릭");
		}else {
			System.out.println("취소클릭");
		}
		
		
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("입력창");
		textD.setHeaderText("입력창 제목");
		textD.setContentText("입력 : ");
		Optional<String> res = textD.showAndWait();
		res.ifPresent(str -> System.out.println("입력창내용: "+str));
		
		//파일선택
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("img", "*.jpg","*.png","*.gif"));
		
		
										//현재 프로젝트의 드라이브가 root임
		fc.setInitialDirectory(new File("\\hyungho\\study\\javaHome\\guiHome\\ppp"));
		File res2 = fc.showOpenDialog(primaryStage);
		if(res2 != null) {
			System.out.println(res2.getName());
		}
		
		//폴더선택
		DirectoryChooser dc = new DirectoryChooser();
		dc.setInitialDirectory(new File("\\hyungho\\study\\javaHome\\guiHome\\ppp"));
		File res3 = dc.showDialog(primaryStage);
		if(res3 != null) {
			System.out.println(res3.getPath());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
