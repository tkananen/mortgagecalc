package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage mortStage;
	private AnchorPane mortAnchor;
	@Override
	public void start(Stage mortStage ){
		this.mortStage = mortStage;
		this.mortStage.setTitle("Calendar App");
		showmortAnchor();
		
	}
	
	private void showmortAnchor(){
		try{
			FXMLLoader mortLoader = new FXMLLoader();
			mortLoader.setLocation(Main.class.getResource("mortfxml.fxml"));
			mortAnchor = (AnchorPane) mortLoader.load();
			Scene scene = new Scene(mortAnchor);
			mortStage.setScene(scene);
			mortController mortControl = mortLoader.getController();
			mortControl.setMain(this);
			mortStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
					
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}