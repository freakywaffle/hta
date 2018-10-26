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

public class SubController implements Initializable{
	Stage primaryStage;
	
	
	@FXML Button btn1;
	@FXML Button print_bt1;
	@FXML ListView<String> list1;
	
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sub2.fxml"));
			System.out.println("su-su"+items_buf);
			System.out.println("su-su"+items);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SubController2 controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.setItems_buf(items);
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
		
		
		
		list1.setItems(FXCollections.observableArrayList());
		list1.getItems().add("³Ã¸é");
		list1.getItems().add("Äªµû¿À");
		list1.getItems().add("¸¶ÆÄµÎºÎ");

		System.out.println("su-in"+items_buf);
		

		list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list1.setOnMouseClicked(mm->{
			items = list1.getSelectionModel().getSelectedItems();
			
		});
		
		btn1.setOnAction(ee->{
			submit();
			list1.getItems().removeAll(items);
		});
		
		print_bt1.setOnAction(ee->{
			System.out.println(items_buf);
			System.out.println(items_arr);
			if(items_arr!=null) {
				for (String str : items_arr) {
					list1.getItems().add(str);
				}
			}
		});
		
	}
	
}
