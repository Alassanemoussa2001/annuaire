package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AjouterStagiaireController {
	
	   @FXML
	    private TextField nom;

	    @FXML
	    private TextField prenom;

	    @FXML
	    private TextField dpt;

	    @FXML
	    private TextField promo;

	    @FXML
	    private TextField annee;

	    @FXML
	    private Button btnAjout;

	    @FXML
	    private Button btnAnnuler;
	    
	    @FXML
	    private Button bntDeconnextion;


//
//	    @FXML
////
//	private void handlebtnAjout(ActionEvent e) throws IOException
//	{
//	    	Stagiaire stagiaire = new Stagiaire(nom.getText(),prenom.getText(),dpt.getText(),
//	    			promo.getText(),annee.getText());
//	    	
//			Main.stagiaire.add(stagiaire);
//			
//			
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Ajout Stagiaire");
//			alert.setHeaderText(null);
//			alert.setContentText("Ajout reussi avec succès");
//			alert.showAndWait();
//			
//			
//			nom.clear();
//			prenom.clear();
//			dpt.clear();
//			promo.clear();
//			annee.clear();
//			
//				
//		Stage primaryStage = (Stage) btnAjout.getScene().getWindow();
//		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Visualiser.fxml"));
//		Scene sceneList = new Scene(layoutAddProduct,650,600);
//		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(sceneList);
//
//		
//	}
//	    
//	    @FXML
//		private void handlebntDeconnextion(ActionEvent e) throws IOException
//		{
//			Stage primaryStage = (Stage) bntDeconnextion.getScene().getWindow();
//			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
//			Scene sceneList = new Scene(layoutAddProduct,650,600);
//			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(sceneList);
//
//			
//		}
//	    @FXML
//		private void handlebtnAnnuler(ActionEvent e) throws IOException
//		{
//	    Stage primaryStage = (Stage) btnAnnuler.getScene().getWindow();
//		BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Visualiser.fxml"));
//		Scene sceneList = new Scene(layoutAddProduct,650,600);
//		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(sceneList);
//
//		
//	}
//	  
}

	


