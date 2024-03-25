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


//UI for patient intake form
public class patientIntakeScene {
	private Scene scene;
	
	public patientIntakeScene() {
		BorderPane root = new BorderPane();
		
		//title
		HBox titleBox = new HBox(100);
		Label title = new Label("Patient Intake Form");
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().addAll(title);
		root.setTop(titleBox);
		
		//input fields
		GridPane form = new GridPane();
		form.setAlignment(Pos.CENTER);
		form.setVgap(10);
		form.setHgap(10);
		
		form.add(new Label("First Name: "), 0, 0);
		TextField firstNameInput = new TextField();
		form.add(firstNameInput, 1, 0);
		
		form.add(new Label("Last Name: "), 0, 1);
		TextField lastNameInput = new TextField();
		form.add(lastNameInput, 1, 1);
		
		form.add(new Label("Email: "), 0, 2);
		TextField email = new TextField();
		form.add(email, 1, 2);
		
		form.add(new Label("Phone Number: "), 0, 3);
		TextField phoneNumber = new TextField();
		form.add(phoneNumber, 1, 3);
		
		form.add(new Label("Health History: "), 0, 4);
		TextField healthHistory = new TextField();
		form.add(healthHistory, 1, 4);
		
		form.add(new Label("Insurance ID: "), 0, 5);
		TextField insuranceId = new TextField();
		form.add(insuranceId, 1, 5);
		
		//save button
		Button saveButton = new Button("Save");
		double buttonWidth = 50;
		double buttonLength = 100;
		saveButton.setPrefSize(buttonLength, buttonWidth);
		String buttonColor = "-fx-background-color: #ADD8E6";
		saveButton.setStyle(buttonColor);
		form.add(saveButton, 4, 6);
		saveButton.setOnAction(event -> {
			int id = id_generator();
			String firstName = firstNameInput.getText();
			String lastName = lastNameInput.getText();
		    String emailText = email.getText();
		    String phoneNumberText = phoneNumber.getText();
		    String healthHistoryText = healthHistory.getText();
		    String insuranceIdText = insuranceId.getText();
			save_intake(id, firstName, lastName, emailText, phoneNumberText, healthHistoryText, insuranceIdText);
		});
		
		root.setCenter(form);
		this.scene = new Scene(root, 400, 400);
		
		
	}
	
	public Scene get_scene() {
		return scene;
	}
	
	public int id_generator() {
		Random random = new Random();
		int id;
		Path path;
		do {
			id = 10000 + random.nextInt(90000);
			String filePath = "./" + id + "_PatientInfo.txt";
			path = Paths.get(filePath);
		} while (Files.exists(path));
		
		return id;
	}
	public void save_intake(int id, String firstName, String lastName, String email, String phoneNumber, String healthHistory, String insuranceId) {
		try (BufferedWriter intakeFile = new BufferedWriter(new FileWriter(id + "_PatientInfo.txt"))) {

			intakeFile.write(firstName + ", " + lastName + ", " + email + ", " + phoneNumber + ", " + healthHistory + ", " + insuranceId);
			intakeFile.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}