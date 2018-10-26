package page2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;

public class TabController implements Initializable{

	@FXML Tab tab1;
	@FXML Tab tab2;
	
	@FXML Button bt1;
	@FXML Button bt2;
	
	
	@FXML ListView<String> list1;
	@FXML ListView<String> list2;

	ObservableList<String> items1;
	ObservableList<String> items2;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		list1.setItems(FXCollections.observableArrayList());
		list1.getItems().add("³Ã¸é");
		list1.getItems().add("Äªµû¿À");
		list1.getItems().add("¸¶ÆÄµÎºÎ");

		list2.setItems(FXCollections.observableArrayList());
		list2.getItems().add("Â¥Àå¸é");
		list2.getItems().add("Â«»Í");
		list2.getItems().add("ººÀ½¹ä");
	
		list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list1.setOnMouseClicked(mm->{
			items1 = list1.getSelectionModel().getSelectedItems();
			
		});

		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list2.setOnMouseClicked(mm->{
			items2 = list2.getSelectionModel().getSelectedItems();

		});
		
		bt1.setOnAction(ee->{
			for (String str : items1) {
				list2.getItems().add(str);
			}
			list1.getItems().removeAll(items1);
		});
		bt2.setOnAction(ee->{
			for (String str : items2) {
				list1.getItems().add(str);
			}
			list2.getItems().removeAll(items2);
		});
		
		
	}
}


