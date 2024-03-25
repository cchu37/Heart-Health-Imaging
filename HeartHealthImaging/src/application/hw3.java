//Chu, Chen

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.text.DecimalFormat;

public class hw3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			homePage mainMenu = new homePage(primaryStage);
			Scene scene = mainMenu.get_scene();
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
