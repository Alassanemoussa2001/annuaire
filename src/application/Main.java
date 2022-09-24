package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	static ObservableList<Stagiaire> annuaire = FXCollections.observableArrayList();


	@Override
	public void start(Stage primaryStage) {
		String nom;
		String prenom;
		String dpt;
		String promo;
		String annee;

		try {

			FileReader fr = new FileReader(	"C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES.DON");
			BufferedReader br = new BufferedReader(fr);
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw");
			while (br.ready()) {
				nom = br.readLine();
				prenom = br.readLine();
				dpt = br.readLine();
				promo = br.readLine();
				annee = br.readLine();
				br.readLine();
				Stagiaire stagiaire = new Stagiaire(nom, prenom, dpt, promo, annee);
				Noeud.ajouterStagiaire(stagiaire, raf);
			}

			br.close();
			fr.close();
			raf.seek(0);
//			System.out.println(Noeud.afficherStagiairesConsole(raf));

			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Accueil.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Visualiser.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AjouterStagiaire.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("RechercheAvancee.fxml"));

//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VisualiserVisiteur.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VisualiserGlobale.fxml"));
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VisualisationVis.fxml"));
			Scene scene = new Scene(root, 580, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}