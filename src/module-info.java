module AnnuaireInterface {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires kernel;
	requires layout;
	requires csv;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base ;
}
