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
			BorderPane root = new BorderPane();
			//initial menu
			
			HBox titleBox = new HBox(100);
			Label title = new Label("Welcome to Heart Health Imaging and Recording System");
			titleBox.setAlignment(Pos.CENTER);
			titleBox.getChildren().addAll(title);
			root.setTop(titleBox);
	
			
			VBox buttons = new VBox(30);
			buttons.setAlignment(Pos.CENTER);
			
			Button patientIntakeButton = new Button("Patient Intake");
			Button ctScanTechButton = new Button("CT Scan Tech View");
			Button patientViewButton = new Button("Patient View");

			double buttonWidth = 50;
			double buttonLength = 200;
			patientIntakeButton.setPrefSize(buttonLength, buttonWidth);
			ctScanTechButton.setPrefSize(buttonLength, buttonWidth);
			patientViewButton.setPrefSize(buttonLength, buttonWidth);
			String buttonColor = "-fx-background-color: #ADD8E6";
			patientIntakeButton.setStyle(buttonColor);
			ctScanTechButton.setStyle(buttonColor);
			patientViewButton.setStyle(buttonColor);
			
			
			buttons.getChildren().addAll(patientIntakeButton,ctScanTechButton,patientViewButton);
			root.setCenter(buttons);
			
			
			Scene scene = new Scene(root,400,400);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//button clicking event
			patientIntakeButton.setOnAction(event -> {
				patientIntakeScene sceneIntake = new patientIntakeScene();
				primaryStage.setScene(sceneIntake.get_scene());
				primaryStage.show();
				
				}
			);
;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
