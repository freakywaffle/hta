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
		info.setTitle("�˸�â");
		info.setHeaderText("�˸�â ����");
		info.setContentText("�˸�â ����");
		info.show();
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("����â");
		error.setHeaderText("����â ����");
		error.setContentText("����â ����");
		error.show();

		Alert warning = new Alert(AlertType.WARNING);
		warning.setTitle("����â");
		warning.setHeaderText("����â ����");
		warning.setContentText("����â ����");
		warning.show();

		Alert custom = new Alert(AlertType.WARNING);
		custom.setTitle("Ŀ����â");
		custom.setHeaderText("Ŀ����â ����");
		custom.setContentText("Ŀ����â ����");
		Label label = new Label("��ü�� ��� ����");
		TextArea textArea = new TextArea("��� ��� ���볻�� �����");
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
		confirm.setTitle("����â");
		confirm.setHeaderText("����â ����");
		confirm.setContentText("����â ����");
		
		Optional<ButtonType> result = confirm.showAndWait();
		System.out.println(result.get());
		if(result.get()==ButtonType.OK) {
			System.out.println("Ȯ�� Ŭ��");
		}else {
			System.out.println("���Ŭ��");
		}
		
		
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("�Է�â");
		textD.setHeaderText("�Է�â ����");
		textD.setContentText("�Է� : ");
		Optional<String> res = textD.showAndWait();
		res.ifPresent(str -> System.out.println("�Է�â����: "+str));
		
		//���ϼ���
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("img", "*.jpg","*.png","*.gif"));
		
		
										//���� ������Ʈ�� ����̺갡 root��
		fc.setInitialDirectory(new File("\\hyungho\\study\\javaHome\\guiHome\\ppp"));
		File res2 = fc.showOpenDialog(primaryStage);
		if(res2 != null) {
			System.out.println(res2.getName());
		}
		
		//��������
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
