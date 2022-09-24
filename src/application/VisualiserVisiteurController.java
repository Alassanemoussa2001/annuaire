package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VisualiserVisiteurController implements Initializable{

    @FXML
    private Button bntRechSimpl;

    @FXML
    private TableView<Stagiaire> tab;
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
    private Button btnAjouter;

    @FXML
    private Button btnimprimer;

    @FXML
    private Button bntDeconnextion;

    @FXML
    private Button bntRecheAva;


    @FXML
    ObservableList<Stagiaire> stagiaire= FXCollections.observableArrayList(
			new Stagiaire("LACROIX","Pascale", "91","BOBI","2008"),
					
    		new Stagiaire("CHAVENEAU", "Kim Anh", "92", "ATOD 22", "2014"),
    		new Stagiaire("GARIJO", "Rosie", "75", "AI 79", "2011"));
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 	nom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		dpt.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("dpt"));
		promo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		annee.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
//		ObservableList<Stagiaire>stagiaire.getVisualiser();
		tab.setItems(stagiaire);
		
	}
    @FXML
  		private void handleButton(ActionEvent e) throws IOException
  		{
    	
    	
	    
	  
	    

  			Stage primaryStage = (Stage) btnAjouter.getScene().getWindow();
  			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("AjouterStagiaire.fxml"));
  			Scene sceneList = new Scene(layoutAddProduct,650,600);
  			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  			primaryStage.setScene(sceneList);

  			
  		}
  	    
    @FXML
		private void handlebntRecheAva(ActionEvent e) throws IOException
		{
			Stage primaryStage = (Stage) bntRecheAva.getScene().getWindow();
			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("RechercheAvancee.fxml"));
			Scene sceneList = new Scene(layoutAddProduct,650,600);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneList);

			
		}
    
    @FXML
  		private void handlebntDeconnextion(ActionEvent e) throws IOException
  		{
  			Stage primaryStage = (Stage) bntDeconnextion.getScene().getWindow();
  			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
  			Scene sceneList = new Scene(layoutAddProduct,650,600);
  			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  			primaryStage.setScene(sceneList);

  			
  		}

    
    
	

}
