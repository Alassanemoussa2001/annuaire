package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ModifierController {
	
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
	    private Button bntModifier;

	    @FXML
	    private Button bntAnnuler;

	    @FXML
	    private Button bntDecon;
	    
	    
//	    @FXML
//	    private void handlebntModifier(ActionEvent e) throws IOExcepti{
//	  
//		
//		    	
//		    	
//				
//				
//				
//				Alert alert = new Alert(AlertType.INFORMATION);
//				alert.setTitle("Modifier Stagiaire");
//				alert.setHeaderText(null);
//				alert.setContentText("modification reussi ");
//				alert.showAndWait();
//				
//				
//				nom.clear();
//				prenom.clear();
//				dpt.clear();
//				promo.clear();
//				annee.clear();
//				
//					
//			Stage primaryStage = (Stage) bntModifier.getScene().getWindow();
//			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Visualiser.fxml"));
//			Scene sceneList = new Scene(layoutAddProduct,650,600);
//			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(sceneList);
//
//			
//		}
//		    
//		    @FXML
//			private void handlebntDeconnextion(ActionEvent e) throws IOException
//			{
//				Stage primaryStage = (Stage) bntDecon.getScene().getWindow();
//				BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
//				Scene sceneList = new Scene(layoutAddProduct,650,600);
//				sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//				primaryStage.setScene(sceneList);
//
//				
//			}
//		    
//		    @FXML
//			private void handlebtnAnnuler(ActionEvent e) throws IOException
//			{
//		    Stage primaryStage = (Stage) bntAnnuler.getScene().getWindow();
//			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Visualiser.fxml"));
//			Scene sceneList = new Scene(layoutAddProduct,650,600);
//			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(sceneList);
//
//	}
//}
//
//	
//
//
//
}