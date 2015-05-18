package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage mortgageStage;
	private AnchorPane mortgageAnchor;
	@Override
	public void start(Stage mortgageStage){
		this.mortgageStage = mortgageStage;
		this.mortgageStage.setTitle("Mortgage Calculator");
		showmortgageAnchor();
	}
	
	private void showmortgageAnchor(){
		try{
			FXMLLoader mortgageLoader = new FXMLLoader();
			mortgageLoader.setLocation(Main.class.getResource("mortfxml.fxml"));
			mortgageAnchor = (AnchorPane) mortgageLoader.load();
			Scene scene = new Scene(mortgageAnchor);
			mortgageStage.setScene(scene);
			mortController mortgageControl = mortgageLoader.getController();
			mortgageControl.setMain(this);
			mortgageStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
	}
	public static void main(String[] args){
		launch(args);
	}
	}
