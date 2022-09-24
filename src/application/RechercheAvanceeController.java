package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RechercheAvanceeController {
	
    @FXML
    private TextField nomrecher;

    @FXML
    private TextField prenomRech;

    @FXML
    private TextField dptRech;

    @FXML
    private TextField promoRech;

    @FXML
    private TextField anneeRech;

    @FXML
    private CheckBox cNom;

    @FXML
    private CheckBox CPrenom;

    @FXML
    private CheckBox Cdpt;

    @FXML
    private CheckBox cpromo;

    @FXML
    private CheckBox cAnnee;

    @FXML
    private Button btnValider;

    @FXML
    private Button bntannuler;
    @FXML
    private Button bntDeconnextion;


    @FXML
    private void handlebntannuler(ActionEvent e) throws IOException
    {
 	Stage primaryStage = (Stage) bntannuler.getScene().getWindow();
	BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("VisualiserGlobale.fxml"));
	Scene sceneList = new Scene(layoutAddProduct,900,700);
	sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(sceneList);

}
    
    @FXML
    private void handlebtnValider(ActionEvent e) throws IOException{
 
	Stage primaryStage = (Stage)btnValider.getScene().getWindow();
	BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("VisualiserGlobale.fxml"));
	Scene sceneList = new Scene(layoutAddProduct,900,700);
	sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(sceneList);

}
    
    @FXML
  		private void handlebntDeconnextion(ActionEvent e) throws IOException
  		{
  			Stage primaryStage = (Stage) bntDeconnextion.getScene().getWindow();
  			BorderPane layoutAddProduct = (BorderPane)FXMLLoader.load(getClass().getResource("Accueil.fxml"));
  			Scene sceneList = new Scene(layoutAddProduct,550,580);
  			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  			primaryStage.setScene(sceneList);

  			
  		}
}
