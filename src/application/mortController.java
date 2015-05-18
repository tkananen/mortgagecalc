package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class mortController extends Main{

	
	@FXML
	private TextField grossIncomeBox;
	
	@FXML
	private TextField monthlyDebtBox;
	
	@FXML
	private TextField interestRateBox;
	
	@FXML
	private ComboBox<String> term;
	
	
	@FXML
	private TextField downPaymentBox;
	
	@FXML
	private TextField housingPaymentBox;
	
	@FXML
	private TextField hpObligationsBox;
	
	@FXML 
	private TextField maxPaymentBox;
	
	@FXML
	private TextField mortgageAmountBox;
	
	

	
	@FXML
	private ChoiceBox myBox = new ChoiceBox(FXCollections.observableArrayList("0", "5", "10", "15"));
	
	

	
	
	private Main main;
	
	
	

	@FXML
	private void intialize(){
		
	
	term.getItems().addAll(
			"5",
			"10",
			"15");
	term.setValue("0");
	
	
	term.getButtonCell().setText("5");
	
	myBox.getItems().addAll("5", "10");
	
	}
	
	
	
	@FXML
	public void handlegrossIncome(){
	

		
		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText().toString());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);		
		
		
		if (monthlyDebtBox.getText().equals(null)){
			hpObligationsBox.setText(""); 
			maxPaymentBox.setText("" + newHousing);
		}
		int temptotalPayment = Integer.parseInt(monthlyDebtBox.getText().toString());
		double totalPay =  ((temphousingPayment /12) * (.36)) - temptotalPayment;

		
		hpObligationsBox.setText(""+totalPay);
		
		if(newHousing > totalPay){
			maxPaymentBox.setText(""+totalPay);
			
		}
		else{
			maxPaymentBox.setText(""+newHousing);
		}
		
			
		}
	
	@FXML
	public void handlemonthyDebtBox(){			
	
		
		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);		

		if (monthlyDebtBox.getText().equals(null)){
			hpObligationsBox.setText(""); 
			maxPaymentBox.setText("" + newHousing);
		}
		
		
		
		int temptotalPayment = Integer.parseInt(monthlyDebtBox.getText());
		double totalPay =  ((temphousingPayment /12) * (.36)) - temptotalPayment;

		
		hpObligationsBox.setText(""+totalPay);
		
		if(newHousing > totalPay){
			maxPaymentBox.setText(""+totalPay);
			
		}
		else{
			maxPaymentBox.setText(""+newHousing);
		}
				
		
	}
	
	@FXML
	public void handleinterestRateBox(){

		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);
		
		
		
		
		int temptotalPayment = Integer.parseInt(monthlyDebtBox.getText());
		double totalPay =  ((temphousingPayment /12) * (.36)) - temptotalPayment;

		
		hpObligationsBox.setText(""+totalPay);
		
		if(newHousing > totalPay){
			maxPaymentBox.setText(""+totalPay);
			
		}
		else{
			maxPaymentBox.setText(""+newHousing);
		}
		
		
	}
	
	@FXML
	public void handlemortgageTermBox(){

		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);
		

		
		int temptotalPayment1 = Integer.parseInt(monthlyDebtBox.getText());
		double totalPay1 =  ((temphousingPayment /12) * (.36)) - temptotalPayment1;
		
		
		hpObligationsBox.setText(""+totalPay1);
		
		
		double intRateTemp = Integer.parseInt(interestRateBox.getSelectedText());
		double intRate = intRateTemp / 100;
		double mortTerm = Integer.parseInt(term.getValue());
		
		
		if(newHousing > totalPay1){
			maxPaymentBox.setText(""+totalPay1);
			double mortgageFinanced = (totalPay1*((1/intRate)-(1/(intRate*Math.pow(1+intRate, mortTerm)))));
			mortgageAmountBox.setText("" + mortgageFinanced);
			
		}
		else{
			maxPaymentBox.setText(""+newHousing);
			double mortgageFinanced = (newHousing*((1/intRate)-(1/(intRate*Math.pow(1+intRate, mortTerm)))));
			mortgageAmountBox.setText(""+mortgageFinanced);
		}
		

		
	}
	
	@FXML 
	public void handledownPaymentBox(){
	
	}
	


	public void setMain( Main main){
		this.main = main;
	}
}
