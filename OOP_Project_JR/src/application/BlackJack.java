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

public class BlackJack {
	
	@FXML private AnchorPane BJMenu;
	@FXML private AnchorPane BJRulesSheet;
	@FXML private Button BJMMBtn;
	@FXML private Button BJRulesBtn;
	@FXML private Button StandBtn;
	@FXML private Button DealBtn;
	@FXML private Button HitBtn;
	@FXML private Label CardPHOne;
	@FXML private Label CardPHTwo;
	@FXML private Label CardPHThree;
	@FXML private Label CardPHFour;
	@FXML private Label DealerScore;
	@FXML private Label PlayerScore;
	@FXML private Label BJRulesTitle;
	
	@FXML protected void BJMMBtn(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene mainMenu = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		mainMenu.getStylesheets().add(css);
		Stage window =  (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(mainMenu);
		window.setTitle("Main Menu");
		window.show();
		
	}
	@FXML protected void BJRulesBtn(ActionEvent event) throws IOException {
		
		BJRulesSheet.setLayoutX(0);
		
	}
	@FXML protected void StandBtn(ActionEvent event) throws IOException {
		
	}
	@FXML protected void DealBtn(ActionEvent event) throws IOException {
		
	}
	@FXML protected void HitBtn(ActionEvent event) throws IOException {
	
	}
	@FXML protected void BJRulesCloseBtn(ActionEvent event) throws IOException {
		
		BJRulesSheet.setLayoutX(800);
		
	}

}
