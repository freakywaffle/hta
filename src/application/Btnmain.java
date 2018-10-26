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

public class Btnmain extends Application { // 클래스 생성할때 브라우저에서 application util 선택

	/*이벤트가 되기위해서는 세가지가 필요
	 * 누구한테 이벤트를 걸거냐
	 * 제스쳐의 종류 - > 리스너
	 * 액션을 주면 대기하고 있는 리스너가 이벤트를 한다
	 * 버튼 이벤트 소스 
	 * 어떤 동작일지 ->리스너(대기) // setonAction도 리스너
	 * changed가 핸들러 		
*/			
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		VBox vBox = new VBox();//VBOX는 레이아웃
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER); // 센터에 버튼 설정
		
		
		
		
		Button button = new Button("눌러바");////fx버튼 사용 // 이름 설정 괄호안에
		
		
		Alert alert = new Alert(AlertType.CONFIRMATION);//inform 은 정보 CONFIRMATION- 는 예 /아니오
		alert.setTitle("알림창");
		alert.setContentText("java Fx이다");//내용
		alert.setHeaderText("메시지"); 
		//alert.show();
		
	
		
		
		
		
		
		
		button.setOnAction(a-> {
			System.out.println("눌렀습니다.");
			alert.show();//눌렀을때 나오도록 
			});
		
		/*
		button.setOnAction(new EventHandler<ActionEvent>() {//setOn~~을 다 이벤트라 부름
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("눌렀습니다.");//눌렀을때 "눌렀습니다." 콘솔창에 입력됨
			}
		}
		
				
		);*/
		
		
		
		vBox.getChildren().add(button);//레이아웃에 집어넣어야함
		Label lb = new Label("라벨이당");
		Font font = new Font(50); //폰트 종류, 사이즈
		lb.setFont(font);
		
		
		Slider slider = new Slider();
		vBox.getChildren().add(lb); //버튼밑에 생김
		vBox.getChildren().add(slider); //그밑에 줄그어짐
		
		slider.valueProperty().addListener( //setonAction과 같다
			
		
				(ObservableValue<? extends Number> observable,
						Number oldValue, 
						Number newValue)->{
							
						
							lb.setText(newValue+"");//글자를 빼낸다 즉 콘솔에서의 값을 창에서 보여준다
							lb.setFont(new Font(newValue.doubleValue())); //값의 사이즈를 변화
							
							
							
							
							//System.out.println(newValue);
						
				}); 
		
		/*slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue); //라벨에 단추생겨서 움직이면 값이 바뀜
			}
			
			
		});*///값에 의한 작업
		Scene scene = new Scene(vBox);//root은 레이아웃
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
		
		
	}

}
