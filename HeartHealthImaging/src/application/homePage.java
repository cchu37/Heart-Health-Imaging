package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class homePage {
	private Scene scene;
	
	public homePage(Stage primaryStage) {
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
		
		//button clicking events
		//switch to patient intake form
		patientIntakeButton.setOnAction(event -> {
			patientIntakeScene sceneIntake = new patientIntakeScene();
			primaryStage.setScene(sceneIntake.get_scene());
			primaryStage.show();
			
			}
		);
		
		//switch to technician view
		ctScanTechButton.setOnAction(event -> {
			technicianView techView = new technicianView();
			primaryStage.setScene(techView.get_scene());
			primaryStage.show();
			}
		);
		
		
		scene = new Scene(root,400,400);
		
		
	}
	
	public Scene get_scene() {
		return scene;
	}
}