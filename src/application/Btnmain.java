package application;



import javax.swing.event.ChangeEvent;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Btnmain extends Application { // Ŭ���� �����Ҷ� ���������� application util ����

	/*�̺�Ʈ�� �Ǳ����ؼ��� �������� �ʿ�
	 * �������� �̺�Ʈ�� �ɰų�
	 * �������� ���� - > ������
	 * �׼��� �ָ� ����ϰ� �ִ� �����ʰ� �̺�Ʈ�� �Ѵ�
	 * ��ư �̺�Ʈ �ҽ� 
	 * � �������� ->������(���) // setonAction�� ������
	 * changed�� �ڵ鷯 		
*/			
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		VBox vBox = new VBox();//VBOX�� ���̾ƿ�
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER); // ���Ϳ� ��ư ����
		
		
		
		
		Button button = new Button("������");////fx��ư ��� // �̸� ���� ��ȣ�ȿ�
		
		
		Alert alert = new Alert(AlertType.CONFIRMATION);//inform �� ���� CONFIRMATION- �� �� /�ƴϿ�
		alert.setTitle("�˸�â");
		alert.setContentText("java Fx�̴�");//����
		alert.setHeaderText("�޽���"); 
		//alert.show();
		
	
		
		
		
		
		
		
		button.setOnAction(a-> {
			System.out.println("�������ϴ�.");
			alert.show();//�������� �������� 
			});
		
		/*
		button.setOnAction(new EventHandler<ActionEvent>() {//setOn~~�� �� �̺�Ʈ�� �θ�
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("�������ϴ�.");//�������� "�������ϴ�." �ܼ�â�� �Էµ�
			}
		}
		
				
		);*/
		
		
		
		vBox.getChildren().add(button);//���̾ƿ��� ����־����
		Label lb = new Label("���̴�");
		Font font = new Font(50); //��Ʈ ����, ������
		lb.setFont(font);
		
		
		Slider slider = new Slider();
		vBox.getChildren().add(lb); //��ư�ؿ� ����
		vBox.getChildren().add(slider); //�׹ؿ� �ٱ׾���
		
		slider.valueProperty().addListener( //setonAction�� ����
			
		
				(ObservableValue<? extends Number> observable,
						Number oldValue, 
						Number newValue)->{
							
						
							lb.setText(newValue+"");//���ڸ� ������ �� �ֿܼ����� ���� â���� �����ش�
							lb.setFont(new Font(newValue.doubleValue())); //���� ����� ��ȭ
							
							
							
							
							//System.out.println(newValue);
						
				}); 
		
		/*slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue); //�󺧿� ���߻��ܼ� �����̸� ���� �ٲ�
			}
			
			
		});*///���� ���� �۾�
		Scene scene = new Scene(vBox);//root�� ���̾ƿ�
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
		
		
	}

}
