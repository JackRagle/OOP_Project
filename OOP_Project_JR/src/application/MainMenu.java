package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenu {
	
	@FXML private AnchorPane MainMenu;
	@FXML private Button BJMenuBtn;
	
	@FXML protected void blackjackStartBtn(ActionEvent event) throws IOException {
    	
		Parent root = FXMLLoader.load(getClass().getResource("BlackJack.fxml"));
		Scene BlackJack = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		BlackJack.getStylesheets().add(css);
		Stage window =  (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(BlackJack);
		window.setTitle("BlackJack");
		window.show();
		
    }
	
	@FXML protected void solitareStartBtn(ActionEvent event) {
    	
    }
	
}
