package page2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class SubController2 implements Initializable{
	Stage primaryStage;
	
	
	@FXML Button btn2;
	@FXML Button print_bt2;
	@FXML ListView<String> list2;
	
	ObservableList<String> items;
	ObservableList<String> items_buf;
	
	ArrayList<String> items_arr = new ArrayList<>();

	public ObservableList<String> getItems_buf() {
		return items_buf;
	}



	public void setItems_buf(ObservableList<String> items_buf) {
		this.items_buf = items_buf;
		this.items_arr.addAll(items_buf);
	}



	public Stage getPrimaryStage() {
		return primaryStage;
	}



	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	
	public void submit() {
		try {
			
			Stage ppp = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sub.fxml"));
			System.out.println("su2-su"+items_buf);
			System.out.println("su2-su"+items);
			
			Parent root = loader.load();
			SubController controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.setItems_buf(items);
			Scene scene = new Scene(root);
			ppp.setScene(scene);
			
			ppp.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		list2.setItems(FXCollections.observableArrayList());
		list2.getItems().add("Â¥Àå¸é");
		list2.getItems().add("Â«»Í");
		list2.getItems().add("ººÀ½¹ä");
		System.out.println("su2-in"+items_buf);
		

		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list2.setOnMouseClicked(mm->{
			items = list2.getSelectionModel().getSelectedItems();
			
		});
		
		btn2.setOnAction(ee->{
			submit();
			list2.getItems().removeAll(items);
		});
		
		print_bt2.setOnAction(ee->{
			System.out.println(items_buf);
			System.out.println(items_arr);
			if(items_arr!=null) {
				for (String str : items_arr) {
					list2.getItems().add(str);
				}
			}
		});
		
	}
	
}
