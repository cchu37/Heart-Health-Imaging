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

public class technicianView {
	private Scene scene;
	
	public technicianView() {
		BorderPane root = new BorderPane();
		
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
		Button saveButton = new Button("Save");
		double buttonWidth = 50;
		double buttonLength = 200;
		saveButton.setPrefSize(buttonLength, buttonWidth);
		String buttonColor = "-fx-background-color: #ADD8E6";
		saveButton.setStyle(buttonColor);
		form.add(saveButton, 4, 7);
		
		root.setCenter(form);
		
		//save event
		saveButton.setOnAction(event -> {
			String patientIdInput = patientId.getText();
			String totalCACInput = totalCAC.getText();
			String LMTInput = LM.getText();
			String LADInput = LAD.getText();
			String LCXInput = LCX.getText();
			String RCAInputt = RCA.getText();
			String PDAInput = PDA.getText();
			
			//check if any field is empty
			if (patientIdInput.isEmpty() || totalCACInput.isEmpty() || LMTInput.isEmpty() || 
				LADInput.isEmpty() || LCXInput.isEmpty() || RCAInputt.isEmpty() || PDAInput.isEmpty()) {
				Alert alertMessage = new Alert(Alert.AlertType.ERROR);
				alertMessage.setContentText("Fill in all the fields.");
				alertMessage.showAndWait();
			}
			else {
				save(patientIdInput, totalCACInput, LMTInput, LADInput, LCXInput, RCAInputt, PDAInput);
			}
			
		});
		
		scene = new Scene(root, 600, 400);
		
	}
	
	public Scene get_scene() {
		return scene;
	}
	
	public void save(String patientIdInput, String totalCACInput, String LMTInput, String LADInput, String LCXInput, String RCAInputt, String PDAInput) {
		try {
			BufferedWriter intakeFile = new BufferedWriter(new FileWriter(patientIdInput + "CTResults.txt"));
			intakeFile.write(totalCACInput+ ", " + LMTInput + ", " + LADInput + ", " + LCXInput + ", " + RCAInputt + ", " + PDAInput);
			intakeFile.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}