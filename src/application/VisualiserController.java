package application;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class VisualiserController implements Initializable {
	
	
    

    @FXML
    private TableColumn<Stagiaire, String> nom;

    @FXML
    private TableColumn<Stagiaire, String> prenom;

    @FXML
    private TableColumn<Stagiaire, String> dpt;

    @FXML
    private TableColumn<Stagiaire, String> promo;

    @FXML
    private TableColumn<Stagiaire, String> annee;

    

	    @FXML
	    private TextField BarreRecherche;

	    @FXML
	    private Button btnREcherche;

	    @FXML
	    private Button bntAjouter;

	    @FXML
	    private Button btnModifier;

	    @FXML
	    private Button btnSupprimer;

	    @FXML
	    private Button btnImprimer;
	    
	    
	    @FXML
	    private Button bntDeconnextion;
	    
	    @FXML
	    private TableView<Stagiaire> tbl;

			    	
			
	    ObservableList<Stagiaire> stagiaire= FXCollections.observableArrayList(
				new Stagiaire("Alassane", "M'BOW", "92", "a14", "2008"),
	    		new Stagiaire("Ala5", "5BOW", "92", "a15", "2009"),
	    		new Stagiaire("aaa", "OW", "93", "b32", "2010"));
	    
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
	    	nom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
			prenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
			dpt.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("dpt"));
			promo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
			annee.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
			tbl.setItems(stagiaire);
		}
	    

	    @FXML
		private void handleButton(ActionEvent e) throws IOException
		
		{
	    	

				
			
			Stage primaryStage = (Stage) bntAjouter.getScene().getWindow();
			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("AjouterStagiaire.fxml"));
			Scene sceneList = new Scene(layoutAddProduct,600,570);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneList);

			
		}
	  

		@FXML
		private void handlebbntDeconnextion(ActionEvent e) throws IOException
		{
			Stage primaryStage = (Stage) bntDeconnextion.getScene().getWindow();
			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
			Scene sceneList = new Scene(layoutAddProduct,600,570);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneList);

			
	
		
		}

	     
//		@FXML
//		private void handlebntbtnModifier(ActionEvent e) throws IOException
//		{
//			 nom.setCelleValueFactory(new PropertyValueFactory<Stagiaire.String> ("Nom"));
//			 
//		   
//		   
//		       
//					Stage primaryStage = (Stage) btnSupprimer.getScene().getWindow();
//					BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
//					Scene sceneList = new Scene(layoutAddProduct,600,570);
//					sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//					primaryStage.setScene(sceneList);
		}
				
			

		
