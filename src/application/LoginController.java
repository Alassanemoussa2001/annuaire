package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

	String vlogin = "admin";
	String vmdp = "1234";

	String vloginv = "visiteur";
	String vmdpv = "56789";

	@FXML // fx:id="pwd"
	private PasswordField pwd; // Value injected by FXMLLoader

	@FXML // fx:id="btnConnexion"
	private Button btnCon; // Value injected by FXMLLoader

	@FXML // fx:id="login"
	private TextField login; // Value injected by FXMLLoader

	@FXML
	private void handleConnexion(ActionEvent e) throws IOException {

		// System.out.println(login.getText() +" "+pwd.getText());
		if (login.getText().equals(vlogin) && pwd.getText().equals(vmdp))

		{
			/// début partie alert

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Connexion réussi");
			alert.setHeaderText(null);
			alert.setContentText("Félicitation, connexion avec succès");

			alert.showAndWait();

			/// fin partie alert

			Stage primaryStage = (Stage) btnCon.getScene().getWindow();
			BorderPane layoutAddProduct = (BorderPane) FXMLLoader
					.load(getClass().getResource("VisualiserGlobale.fxml"));
			Scene sceneList = new Scene(layoutAddProduct, 900, 700);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneList);

		} else if (login.getText().equals(vloginv) && pwd.getText().equals(vmdpv)) {
			Stage primaryStage = (Stage) btnCon.getScene().getWindow();
			BorderPane layoutAddProduct = (BorderPane) FXMLLoader.load(getClass().getResource("VisualisationVis.fxml"));
			Scene sceneList = new Scene(layoutAddProduct, 900, 700);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneList);

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Connexion échoué");
			alert.setHeaderText(null);
			alert.setContentText("Verifiez votre login ou mot de passe");

			alert.showAndWait();

		}
	}
}
