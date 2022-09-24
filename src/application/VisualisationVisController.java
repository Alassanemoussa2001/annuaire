package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VisualisationVisController implements Initializable {

	@FXML
	private TableView<Stagiaire> tbt;

	@FXML
	private TableColumn<Stagiaire, String> nom_col;

	@FXML
	private TableColumn<Stagiaire, String> prenom_col;

	@FXML
	private TableColumn<Stagiaire, String> dpt_col;

	@FXML
	private TableColumn<Stagiaire, String> promo_col;

	@FXML
	private TableColumn<Stagiaire, String> annee_col;

	@FXML
	private TextField nomText;

	@FXML
	private TextField prenomText;

	@FXML
	private TextField dptText;
	@FXML
	private TextField barreText;

	@FXML
	private TextField promoText;

	@FXML
	private TextField anneeText;

	@FXML
	private Button bntAjout;

	@FXML
	private Button bntImprimer;
	@FXML
	private Button btnRecherSimple;

	@FXML
	private Button btnRecherAvan;

	@FXML
	private Button btnDeconnexion;

	@FXML
	void AjoutStagaire(MouseEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// TODO: handle exception
		try {
		nom_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		prenom_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		dpt_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("dpt"));
		promo_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		annee_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
		tbt.setItems(Main.annuaire);

		Main.annuaire.clear();
			Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void handlebtnAjout(ActionEvent event) {
		try {
			Stagiaire st = new Stagiaire(nomText.getText(), prenomText.getText(), dptText.getText(),
					promoText.getText(), anneeText.getText());
			
			Noeud.ajouterStagiaire(st, new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
			
			Main.annuaire.clear();
			
			Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
			
			/// début partie alert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ajout de stagiaire");
			alert.setHeaderText(null);
			alert.setContentText("Félicitation, stagiaire ajouté avec succès !");
			alert.showAndWait();
			/// fin partie alert
			nomText.clear();
			prenomText.clear();
			dptText.clear();
			promoText.clear();
			anneeText.clear();

		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		}

	}

	@FXML
	private void handlRechercheSimple(ActionEvent e) throws IOException {
//		tbt.getItems().clear();
//		tbt.getItems().add(barreText.getText(),stagiaire);

	}

	@FXML
	private void handleButtonListAction(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) bntAjout.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("VisualisationVis.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 900, 700);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}

	@FXML
	private void handleRechercheAva(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) btnRecherAvan.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("RechercheAvancee.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 580, 550);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}

//	@FXML
//	private void handlebtnDeconnexion(ActionEvent e) throws IOException {
//		Stage primaryStage = (Stage) btnDeconnexion.getScene().getWindow();
//		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("Accueil.fxml"));
//		Scene sceneList = new Scene(layoutAddProduct, 580,550);
//		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(sceneList);
//
//	}

	@FXML
	private void handlebtnDeconnexion(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) btnDeconnexion.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 580, 550);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}
}
