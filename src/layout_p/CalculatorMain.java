package layout_p;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

class Cal extends Application implements Initializable{

	@FXML Button n0;	@FXML Button n1;	@FXML Button n2;	@FXML Button n3;
	@FXML Button n4;	@FXML Button n5;	@FXML Button n6;	@FXML Button n7;
	@FXML Button n8;	@FXML Button n9;
	
	@FXML Button plus;	@FXML Button minus;	@FXML Button multi;	@FXML Button per;	@FXML Button back;
	@FXML Button div;	@FXML Button res;	@FXML Button dot;	@FXML Button cancel;

	@FXML Label text1;	@FXML Label input1;	
	
	ArrayList<Button> nbt_list;
	ArrayList<Button> kbt_list;
	
	ArrayList<String> kiho_list;
	
	boolean hasCal;
	boolean hasDot;
	boolean startCal; 
	String kiho = "";
	String kihoBuf = "";
	double nn= 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		startCal = false;
		nbt_list = new ArrayList<>();
		kbt_list = new ArrayList<>();
		kiho_list = new ArrayList<>();
		nbt_list.add(n0);	nbt_list.add(n1);	nbt_list.add(n2);	nbt_list.add(n3);
		nbt_list.add(n4);	nbt_list.add(n5);	nbt_list.add(n6);	nbt_list.add(n7);
		nbt_list.add(n8);	nbt_list.add(n9);
		
		kbt_list.add(plus);	kbt_list.add(minus);	kbt_list.add(multi);	kbt_list.add(div);
		
		for (Button bt : nbt_list) {
			bt.setOnAction(ee->{
				
				if(hasCal) {
					input1.setText(bt.getText());
				}else {
					input1.setText(input1.getText()+bt.getText());
					
				}
				if(!kiho.equals("")) {
					kiho_list.add(kiho);					
					kiho = "";
				}
				hasCal = false;
			});
		}
		
		for (Button bt : kbt_list) {
			bt.setOnAction(ee->{
				if(hasCal) {
					text1.setText(text1.getText().substring(0, text1.getText().length()-1)+bt.getText());
				}else {
					
					text1.setText(text1.getText()+input1.getText()+bt.getText());
					if(startCal) {
						System.out.println(kiho);
						nn = cal_meth(nn+"", input1.getText(), kihoBuf);

						input1.setText(doubleChk(nn+""));
						

					}else {
						nn = Double.parseDouble(input1.getText());
					}
				}
				
				hasCal = true;
				startCal = true;
				kiho = bt.getText();
				kihoBuf = bt.getText();
			});
		}
		
		dot.setOnAction(ee->{
			if(hasDot) {
				input1.setText(input1.getText().substring(0, input1.getText().length()-1)+dot.getText());
				
			}else {
				input1.setText(input1.getText()+dot.getText());
			}
			
			hasDot = true;
		});		

		cancel.setOnAction(ee->{
			text1.setText("");
			input1.setText("");
			kiho_list.clear();
			hasCal = false;
			startCal = false;
			kiho = "";
			kihoBuf = "";
			nn = 0;
		});
		
		
		res.setOnAction(ee->{
			
			String str = text1.getText() + input1.getText();
			
			if(!kiho.equals("")) {
				str = text1.getText().substring(0, text1.getText().length()-1);
				
			}

			String [] vals = str.split("[[+][-][/][*]]");
						
			double result = 0;
			for (int i = 1; i < vals.length; i++) {
				if(i != 1) {
					result = cal_meth(result+"",vals[i],kiho_list.get(i-1));
				}else {
					
					result = cal_meth(vals[i-1],vals[i],kiho_list.get(i-1));
				}
			}
		
			input1.setText(doubleChk(result+""));
			
			text1.setText("");
			
			kiho_list.clear();
			hasCal = false;
			startCal = false;
			kiho = "";
			kihoBuf = "";
			nn = 0;
			
		});
		
		back.setOnAction(ee->{
			input1.setText(input1.getText().substring(0, input1.getText().length()-1));
		});
	}
	
	double cal_meth(String num1, String num2, String kiho) {
		
		double dn1 = Double.parseDouble(num1);
		double dn2 = Double.parseDouble(num2);

		double res = 0;
		switch(kiho) {
			case "+":
				res = dn1 + dn2;
				break;
			case "-":
				res = dn1 - dn2;
				break;
			case "*":
				res = dn1 * dn2;
				break;
			case "/":
				res = dn1 / dn2;
				break;
		}
		return res;
	}
	
	String doubleChk(String str) {
		String [] resArr = (str+"").split("[.]");
//		if(resArr[1].length()>=8) {
//			System.out.println(resArr[1]);
//			resArr[1] = resArr[1].substring(0, 8);
//			System.out.println(resArr[1]);
//		}
		if(Long.parseLong(resArr[1])==0) {
			str = resArr[0];
			
		}
		
		return str;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent pp  = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		Scene ss = new Scene(pp);
		
		primaryStage.setScene(ss);
		primaryStage.show();
			
	}	
}


public class CalculatorMain extends Cal{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
		
	}

}
