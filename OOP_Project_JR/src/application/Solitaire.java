package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Solitaire {

	@FXML private AnchorPane SolitaireMenu;
	@FXML private AnchorPane SRulesSheet;
	@FXML private Button SMMBtn;
	@FXML private Button SRulesBtn;
	@FXML private Label SRulesTitle;
	
	@FXML protected void SMMBtn(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene mainMenu = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		mainMenu.getStylesheets().add(css);
		Stage window =  (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(mainMenu);
		window.setTitle("Main Menu");
		window.show();
		
	}
	@FXML protected void SRulesBtn(ActionEvent event) throws IOException {
		
		SRulesSheet.setLayoutX(0);
		
	}
	@FXML protected void SRulesCloseBtn(ActionEvent event) {
		
		SRulesSheet.setLayoutX(800);
		
	}
	
}
