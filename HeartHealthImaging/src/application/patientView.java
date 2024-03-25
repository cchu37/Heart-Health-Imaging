//Chu, Chen

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
import java.io.BufferedReader;
import java.io.FileReader;

public class patientView {
	private Scene scene;
	
	public patientView() {
		BorderPane root = new BorderPane();
		
		//title
		HBox titleBox = new HBox(100);
		Label title = new Label("Hello, ");
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().addAll(title);
		root.setTop(titleBox);
		
		//input form
		GridPane form = new GridPane();
		form.setAlignment(Pos.CENTER);
		form.setVgap(10);
		form.setHgap(10);
		
		//input entries
		form.add(new Label("Pateint ID: "), 0, 0);
		TextField patientId = new TextField();
		form.add(patientId, 1, 0);
		
		form.add(new Label("The total Agatston CAC score: "), 0, 1);
		TextField totalCAC = new TextField();
		form.add(totalCAC, 1, 1);
		
		form.add(new Label("Vessel level Agatston CAC score: "), 0, 2);
		
		form.add(new Label("LM: "), 0, 3);
		TextField LM = new TextField();
		form.add(LM, 1, 3);
		
		form.add(new Label("LAD: "), 0, 4);
		TextField LAD = new TextField();
		form.add(LAD, 1, 4);
		
		form.add(new Label("LCX: "), 0, 5);
		TextField LCX = new TextField();
		form.add(LCX, 1, 5);
		
		form.add(new Label("RCA: "), 0, 6);
		TextField RCA = new TextField();
		form.add(RCA, 1, 6);
		
		form.add(new Label("PDA: "), 0, 7);
		TextField PDA = new TextField();
		form.add(PDA, 1, 7);
		
		//save button
		Button saveButton = new Button("Check");
		double buttonWidth = 50;
		double buttonLength = 200;
		saveButton.setPrefSize(buttonLength, buttonWidth);
		String buttonColor = "-fx-background-color: #ADD8E6";
		saveButton.setStyle(buttonColor);
		form.add(saveButton, 4, 7);
		
		root.setCenter(form);
		
		//check event
		saveButton.setOnAction(event -> {
			String id = patientId.getText();
			try (BufferedReader patientInfo = new BufferedReader(new FileReader(id + "_PatientInfo.txt"))) {
				String row = patientInfo.readLine();
				String[] info = row.split(", ");
				String name = info[0];
				//title
				title.setText("Hello, " + name + ".");
				
				
			} catch (IOException e) {
				Alert alertMessage = new Alert(Alert.AlertType.ERROR);
				alertMessage.setContentText("The patient ID does not exists.");
				alertMessage.showAndWait();
			}
			
			try (BufferedReader ctResult = new BufferedReader(new FileReader(id + "CTResults.txt"))){
				String row = ctResult.readLine();
				String[] results = row.split(", ");
				totalCAC.setText(results[0]);
                LM.setText(results[1]);
                LAD.setText(results[2]);
                LCX.setText(results[3]);
                RCA.setText(results[4]);
                PDA.setText(results[5]);
				
			} catch (IOException e) {
				Alert alertMessage = new Alert(Alert.AlertType.ERROR);
				alertMessage.setContentText("The result does not exist.");
				alertMessage.showAndWait();
			}

		});
		
		scene = new Scene(root, 600, 400);
		
	}
	
	public Scene get_scene() {
		return scene;
	}
	
}