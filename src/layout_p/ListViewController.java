package layout_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ListViewController implements Initializable{
	
	@FXML Label label;
	@FXML Button btn;
	@FXML ListView<String> list;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		list.setItems(FXCollections.observableArrayList());
		list.getItems().add("냉면");
		list.getItems().add("칭따오");
		list.getItems().add("마파두부");
		
		//Single 처리
//		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
//		list.setOnMouseClicked(mm->{
//			Object obj = list.getSelectionModel().getSelectedItem();
//			label.setText(obj.toString());
//		});
//		
//		list.getSelectionModel().selectedItemProperty().addListener((a,b,c)->{label.setText(c);});
		
		//Multiple 처리
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list.setOnMouseClicked(mm->{
			ObservableList<String> items = list.getSelectionModel().getSelectedItems();
			
			
			for (String string : items) {
				System.out.println(string);
			}
		});
		
	}

}
