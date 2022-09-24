package application;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class VisualiserGlobaleController implements Initializable {
	
	

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
	private TextField promoText;

	@FXML
	private TextField anneeText;

	@FXML
	private Button bntAjout;

	@FXML
	private Button bntModifier;

	@FXML
	private Button bntSupprimer;

	@FXML
	private Button bntImprimer;
	@FXML
	private Button btnRecherSimple;

	@FXML
	private Button btnRecherAvan;

	@FXML
	private Button btnDeconnexion;

	@FXML
	private TextField barredeREcherche;

	@FXML
	void AjoutStagaire(MouseEvent event) {

	}

	void btnRecherSimple(MouseEvent event) {

	}

	@FXML
	private void handlebtnimprimer(ActionEvent e) throws IOException, DocumentException {
		

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Impression");
		alert.setHeaderText(null);
		alert.setContentText("Reussi avec succès!");
		alert.showAndWait();
		
		Noeud.genererPdf(Main.annuaire);

	}
		

//
	@FXML
	private void handlebtnRecherSimple(ActionEvent e) throws IOException {

//		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
//		 FilteredList<Stagiaire> filteredData = new FilteredList<>(annuaire, p -> true);
//		// 2. Set the filter Predicate whenever the filter changes.
//
//		 barredeREcherche.textProperty().addListener(( observable, oldValue,newValue) -> {
//			 filteredData.setPredicate( stagiaire-> {
//				  if (newValue == null || newValue.isEmpty()) {
//				 return true;
//				  }
//			 			String lowerCaseFilter	= newValue.toLowerCase();
//			 	
//			 		if (stagiaire.getNom().toLowerCase().contains(newValue)) {
//			 			return true;
//			 		} else if (stagiaire.getPrenom().toLowerCase().contains(newValue)) {
//			 			return true;
//			 		}
//			 		return false;
//			 
//		});
//	});
//		 tbt.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		 tbt.getColumns().addAll(Arrays.asList(nom_col, prenom_col));
//		 SortedList<Stagiaire> sortedData = new SortedList<>(filteredData);
//		  sortedData.comparatorProperty().bind(tbt.comparatorProperty());
//		  tbt.setItems(sortedData);
//		 
	}

	@FXML
	void supprimerStagiaire(MouseEvent event) {
		int selectedID = tbt.getSelectionModel().getSelectedIndex();

		tbt.getItems().remove(selectedID);

		Alert dialogC = new Alert(AlertType.CONFIRMATION);
		dialogC.setTitle("Suppression ?");
		dialogC.setHeaderText(null);
		dialogC.setContentText("Voulez - vous supprimer ");
		Optional<ButtonType> answer = dialogC.showAndWait();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	try {

		nom_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		prenom_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		dpt_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("dpt"));
		promo_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		annee_col.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
		tbt.setItems(Main.annuaire);
		tbt.getItems();
		

		Main.annuaire.clear();
			Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
		} catch (FileNotFoundException e) {
			
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
	private void handleButtonListAction(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) bntAjout.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("VisualiserGlobale.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 900, 700);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}

	@FXML
	private void handlebtnDeconnexion(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) btnDeconnexion.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 580, 550);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}

	@FXML
	private void handleRechercheAva(ActionEvent e) throws IOException {
		Stage primaryStage = (Stage) btnRecherAvan.getScene().getWindow();
		BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("RechercheAvancee.fxml"));
		Scene sceneList = new Scene(layoutAddProduct, 520, 580);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);

	}

	@FXML
	private void handlebntModifier() throws IOException {
		
		
		
		nom_col.setCellFactory(TextFieldTableCell.forTableColumn());
		nom_col.setOnEditCommit(
				e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue()));
		prenom_col.setCellFactory(TextFieldTableCell.forTableColumn());
		prenom_col.setOnEditCommit(
				e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue()));
		dpt_col.setCellFactory(TextFieldTableCell.forTableColumn());
		dpt_col.setOnEditCommit(
				e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setDpt(e.getNewValue()));
		promo_col.setCellFactory(TextFieldTableCell.forTableColumn());
		promo_col.setOnEditCommit(
				e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setPromo(e.getNewValue()));
		annee_col.setCellFactory(TextFieldTableCell.forTableColumn());
		annee_col.setOnEditCommit(
				e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setAnnee(e.getNewValue()));
		Main.annuaire.clear();
				
		tbt.setEditable(true);
	
//		Noeud.modifierStagiaire(stagiaire, new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
		Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));


	
	}


	}
//	
//	
//////		METHODE POUR IMPRIMER LA LISTE SOUS FORMAT PDF//
   
//
//	
//
//	Stage primaryStage = (Stage) bntImprimer.getScene().getWindow();
//	BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("VisualiserGlobale.fxml"));
//	Scene sceneList = new Scene(layoutAddProduct, 520, 580);
//	sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//	primaryStage.setScene(sceneList);
//
//}


