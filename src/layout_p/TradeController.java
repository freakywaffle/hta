package layout_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class TradeController implements Initializable{

	@FXML ListView<String> list_l;
	@FXML ListView<String> list_r;
	@FXML Button right_bt;
	@FXML Button left_bt;
	
	ObservableList<String> items_r;
	ObservableList<String> items_l;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		list_l.setItems(FXCollections.observableArrayList());
		list_l.getItems().add("³Ã¸é");
		list_l.getItems().add("Äªµû¿À");
		list_l.getItems().add("¸¶ÆÄµÎºÎ");

		list_r.setItems(FXCollections.observableArrayList());
		list_r.getItems().add("Â¥Àå¸é");
		list_r.getItems().add("Â«»Í");
		list_r.getItems().add("ººÀ½¹ä");
		
		list_r.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list_r.setOnMouseClicked(mm->{
			items_r = list_r.getSelectionModel().getSelectedItems();

		});
		list_l.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list_l.setOnMouseClicked(mm->{
			items_l = list_l.getSelectionModel().getSelectedItems();

		});
		
		right_bt.setOnAction(ee->{
			for (String str : items_l) {
				System.out.println(str);
				list_r.getItems().add(str);
			}
			list_l.getItems().removeAll(items_l);
		});
		left_bt.setOnAction(ee->{
			for (String str : items_r) {
				System.out.println(str);
				list_l.getItems().add(str);
			}
			list_r.getItems().removeAll(items_r);
		});
		
	}

}
