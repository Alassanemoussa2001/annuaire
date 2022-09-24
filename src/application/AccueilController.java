package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AccueilController {
	

	@FXML
	private Button btnVisiteur;
	
	@FXML
	private Button btnAdmin;
	
	
	
	
	@FXML
	private void handleButtonVisiteurListAction(ActionEvent e) throws IOException
	{
		Stage primaryStage = (Stage) btnVisiteur.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene sceneList = new Scene(layoutAddProduct,500,550);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

		
	}
	@FXML
	private void handleButtonbtnAdminAction(ActionEvent e) throws IOException
	{
		Stage primaryStage = (Stage) btnAdmin.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene sceneList = new Scene(layoutAddProduct,500,550);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);
}

}

	


	
