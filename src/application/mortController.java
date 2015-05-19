package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.math.*;

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
	

	private Main main;


	@FXML
	private void initialize(){
		
	
	term.getItems().addAll(
			"5",
			"10",
			"15");
	
	downPaymentBox.setText("0");
	
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

		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText().toString());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);
		
		
		
		
		int temptotalPayment = Integer.parseInt(monthlyDebtBox.getText().toString());
		double totalPay =  (((temphousingPayment /12) * (.36)) - temptotalPayment);

		
		hpObligationsBox.setText(""+totalPay);
		
		if(newHousing > totalPay){
			maxPaymentBox.clear();
			maxPaymentBox.setText(""+totalPay);
			
		}
		if(totalPay > newHousing){
			maxPaymentBox.clear();
			maxPaymentBox.setText(""+newHousing);
		}
		
		
	}
	
	@FXML
	public void handlemortgageTermBox(){

		int temphousingPayment = Integer.parseInt(grossIncomeBox.getText());
		double newHousing = (temphousingPayment /12) * (.18);
		
		housingPaymentBox.setText(""+newHousing);
		

		
		int temptotalPayment = Integer.parseInt(monthlyDebtBox.getText());
		double totalPay =  ((temphousingPayment /12) * (.36)) - temptotalPayment;
		
		
		hpObligationsBox.setText(""+totalPay);
		
		
		
		
		int intRateTemp = Integer.parseInt(interestRateBox.getText());
		double intRate = 1.0 * (intRateTemp/100);
		double intRatePlusOne = 1 +intRate;
		int mortTermTemp = Integer.parseInt(term.getValue());
		double mortTerm = 1.0 * mortTermTemp;	
		
		if(newHousing > totalPay){
			maxPaymentBox.clear();
			maxPaymentBox.setText(""+totalPay);
			
		}
		else{
			maxPaymentBox.clear();
			maxPaymentBox.setText(""+newHousing);
		}
		
		
		if(newHousing > totalPay){
			
		
			
			double PV = totalPay * ((1-(1/Math.pow(intRatePlusOne, mortTerm)))/intRate);
			mortgageAmountBox.setText("" + PV);

			
		}
		if(totalPay > newHousing){
			
			
			double PV = newHousing * ((1-(1/Math.pow(intRatePlusOne, mortTerm)))/intRate);
			mortgageAmountBox.setText("" + PV); 
		}
		

		
	}
	
	@FXML 
	public void handledownPaymentBox(){
	
	}
	


	public void setMain( Main main){
		this.main = main;
	}
}
