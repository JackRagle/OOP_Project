package application;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Solitaire {

	@FXML private AnchorPane SolitaireMenu;
	@FXML private AnchorPane SRulesSheet;
	@FXML private AnchorPane SGameResult;
	@FXML private Button SMMBtn;
	@FXML private Button SRulesBtn;
	@FXML private Button StartBtn;
	@FXML private Button DiscardBtn;
	@FXML private Button PlaySpotOneBtn;
	@FXML private Button PlaySpotTwoBtn;
	@FXML private Button PlaySpotThreeBtn;
	@FXML private Button PlaySpotFourBtn;
	@FXML private Button HandSpotOneBtn;
	@FXML private Button HandSpotTwoBtn;
	@FXML private Button HandSpotThreeBtn;
	@FXML private Button HandSpotFourBtn;
	@FXML private Button SelectedSpotBtn;
	@FXML private Label SRulesTitle;
	@FXML private Label GameResultOne;
	@FXML private Label GameResultTwo;
	@FXML private ImageView PlaySpotOne;
	@FXML private ImageView PlaySpotTwo;
	@FXML private ImageView PlaySpotThree;
	@FXML private ImageView PlaySpotFour;
	@FXML private ImageView HandSpotOne;
	@FXML private ImageView HandSpotTwo;
	@FXML private ImageView HandSpotThree;
	@FXML private ImageView HandSpotFour;
	@FXML private ImageView SelectedSpot;
	
	Deck starterDeck = new Deck();
	Deck deck = new Deck("");
	int score = 0;
	int selectedSpotPosition;
	int selectedSpotIndex;
	int handSpotOnePosition;
	int handSpotOneIndex;
	int handSpotTwoPosition;
	int handSpotTwoIndex;
	int handSpotThreePosition;
	int handSpotThreeIndex;
	int handSpotFourPosition;
	int handSpotFourIndex;
	int playSpotOnePosition;
	int playSpotOneIndex;
	int playSpotTwoPosition;
	int playSpotTwoIndex;
	int playSpotThreePosition;
	int playSpotThreeIndex;
	int playSpotFourPosition;
	int playSpotFourIndex;
	
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
	@FXML protected void StartBtn(ActionEvent event) throws IOException, URISyntaxException {
		
		StartBtn.setLayoutX(800);
		DiscardBtn.setLayoutX(650);
		SelectedSpotBtn.setLayoutX(325);
		
		Card cardOne = starterDeck.draw(0);
		playSpotOneIndex = deck.getIndex();
		starterDeck.incrementIndex();
		String cardOneName = cardOne.getName();
		Image cardOneImg = new Image(getClass().getResource(cardOneName).toURI().toString());
		PlaySpotOne.setImage(cardOneImg);
		playSpotOnePosition = cardOne.getPlacement();
		
		Card cardTwo = starterDeck.draw(0);
		playSpotTwoIndex = deck.getIndex();
		starterDeck.incrementIndex();
		String cardTwoName = cardTwo.getName();
		Image cardTwoImg = new Image(getClass().getResource(cardTwoName).toURI().toString());
		PlaySpotTwo.setImage(cardTwoImg);
		playSpotTwoPosition = cardTwo.getPlacement();
		
		Card cardThree = starterDeck.draw(0);
		playSpotThreeIndex = deck.getIndex();
		starterDeck.incrementIndex();
		String cardThreeName = cardThree.getName();
		Image cardThreeImg = new Image(getClass().getResource(cardThreeName).toURI().toString());
		PlaySpotThree.setImage(cardThreeImg);
		playSpotThreePosition = cardThree.getPlacement();
		
		Card cardFour = starterDeck.draw(0);
		playSpotFourIndex = deck.getIndex();
		starterDeck.incrementIndex();
		String cardFourName = cardFour.getName();
		Image cardFourImg = new Image(getClass().getResource(cardFourName).toURI().toString());
		PlaySpotFour.setImage(cardFourImg);
		playSpotFourPosition = cardFour.getPlacement();
		
		deck.shuffle();
		
		Card cardFive = deck.draw("");
		handSpotOneIndex = deck.getIndex();
		deck.incrementIndex();
		String cardFiveName = cardFive.getName();
		Image cardFiveImg = new Image(getClass().getResource(cardFiveName).toURI().toString());
		HandSpotOne.setImage(cardFiveImg);
		handSpotOnePosition = cardFive.getPlacement();
		
		Card cardSix = deck.draw("");
		handSpotTwoIndex = deck.getIndex();
		deck.incrementIndex();
		String cardSixName = cardSix.getName();
		Image cardSixImg = new Image(getClass().getResource(cardSixName).toURI().toString());
		HandSpotTwo.setImage(cardSixImg);
		handSpotTwoPosition = cardSix.getPlacement();
		
		Card cardSeven = deck.draw("");
		handSpotThreeIndex = deck.getIndex();
		deck.incrementIndex();
		String cardSevenName = cardSeven.getName();
		Image cardSevenImg = new Image(getClass().getResource(cardSevenName).toURI().toString());
		HandSpotThree.setImage(cardSevenImg);
		handSpotThreePosition = cardSeven.getPlacement();
		
		Card cardEight = deck.draw("");
		handSpotFourIndex = deck.getIndex();
		deck.incrementIndex();
		String cardEightName = cardEight.getName();
		Image cardEightImg = new Image(getClass().getResource(cardEightName).toURI().toString());
		HandSpotFour.setImage(cardEightImg);
		handSpotFourPosition = cardEight.getPlacement();
		
	}
	
	@FXML protected void DiscardBtn(ActionEvent event) throws IOException, URISyntaxException {
		
		if(HandSpotOne.getImage() == null) {
			
			SelectedSpot.setImage(null);
			
		}else if(HandSpotTwo.getImage() == null) {
			
			SelectedSpot.setImage(null);
			
		}else if(HandSpotThree.getImage() == null) {
			
			SelectedSpot.setImage(null);
			
		}else if(HandSpotFour.getImage() == null) {
			
			SelectedSpot.setImage(null);
			
		}
		
		if(deck.getIndex() > 47) {
			
			deck.shuffle();
			
		}
		Card cardFive = deck.draw("");
		handSpotOneIndex = deck.getIndex();
		deck.incrementIndex();
		String cardFiveName = cardFive.getName();
		Image cardFiveImg = new Image(getClass().getResource(cardFiveName).toURI().toString());
		HandSpotOne.setImage(cardFiveImg);
		handSpotOnePosition = cardFive.getPlacement();
		
		if(deck.getIndex() > 47) {
			
			deck.shuffle();
			
		}
		Card cardSix = deck.draw("");
		handSpotTwoIndex = deck.getIndex();
		deck.incrementIndex();
		String cardSixName = cardSix.getName();
		Image cardSixImg = new Image(getClass().getResource(cardSixName).toURI().toString());
		HandSpotTwo.setImage(cardSixImg);
		handSpotTwoPosition = cardSix.getPlacement();
		
		if(deck.getIndex() > 47) {
			
			deck.shuffle();
			
		}
		if(cardSix.placement == cardFive.placement) {
			
			HandSpotTwo.setImage(null);
			
		}
		Card cardSeven = deck.draw("");
		handSpotThreeIndex = deck.getIndex();
		deck.incrementIndex();
		String cardSevenName = cardSeven.getName();
		Image cardSevenImg = new Image(getClass().getResource(cardSevenName).toURI().toString());
		HandSpotThree.setImage(cardSevenImg);
		handSpotThreePosition = cardSeven.getPlacement();
		
		if(deck.getIndex() > 47) {
			
			deck.shuffle();
			
		}
		if(cardSeven.placement == cardFive.placement) {
			
			HandSpotThree.setImage(null);
			
		}
		if(cardSeven.placement == cardSix.placement) {
			
			HandSpotThree.setImage(null);
			
		}
		Card cardEight = deck.draw("");
		handSpotFourIndex = deck.getIndex();
		deck.incrementIndex();
		String cardEightName = cardEight.getName();
		Image cardEightImg = new Image(getClass().getResource(cardEightName).toURI().toString());
		HandSpotFour.setImage(cardEightImg);
		handSpotFourPosition = cardEight.getPlacement();
		if(cardEight.placement == cardFive.placement) {
			
			HandSpotFour.setImage(null);
			
		}
		if(cardEight.placement == cardSix.placement) {
	
			HandSpotFour.setImage(null);
	
		}
		if(cardEight.placement == cardSeven.placement) {
	
			HandSpotFour.setImage(null);
			
		}	
		score++;
		
	}
	
	@FXML protected void PlaySpotOneBtn(ActionEvent event) throws IOException {
		
		if(SelectedSpot.getImage() != null) {
			
			if(selectedSpotPosition == (playSpotOnePosition - 1)) {
				
				PlaySpotOne.setImage(SelectedSpot.getImage());
				playSpotOnePosition--;
				deck.setValue(selectedSpotIndex);
				SelectedSpot.setImage(null);
				selectedSpotPosition = 0;
				selectedSpotIndex = 0;
				
			}
			
		}
		
		if(playSpotOnePosition == 1 && playSpotTwoPosition == 14 && playSpotThreePosition == 27 && playSpotFourPosition == 40) {
			
			GameResultTwo.setText("Win!");
			SGameResult.setLayoutY(300);
			
		}
		
	}
	
	@FXML protected void PlaySpotTwoBtn(ActionEvent event) throws IOException {
		
		if(SelectedSpot.getImage() != null) {
			
			if(selectedSpotPosition == (playSpotTwoPosition - 1)) {
				
				PlaySpotTwo.setImage(SelectedSpot.getImage());
				playSpotTwoPosition--;
				deck.setValue(selectedSpotIndex);
				SelectedSpot.setImage(null);
				selectedSpotPosition = 0;
				selectedSpotIndex = 0;
				
			}
			
		}
		
		if(playSpotOnePosition == 1 && playSpotTwoPosition == 14 && playSpotThreePosition == 27 && playSpotFourPosition == 40) {
			
			GameResultTwo.setText("Win!");
			SGameResult.setLayoutY(300);
			
		}
		
	}

	@FXML protected void PlaySpotThreeBtn(ActionEvent event) throws IOException {
	
		if(SelectedSpot.getImage() != null) {
			
			if(selectedSpotPosition == (playSpotThreePosition - 1)) {
				
				PlaySpotThree.setImage(SelectedSpot.getImage());
				playSpotThreePosition--;
				deck.setValue(selectedSpotIndex);
				SelectedSpot.setImage(null);
				selectedSpotPosition = 0;
				selectedSpotIndex = 0;
				
			}
			
		}
		
		if(playSpotOnePosition == 1 && playSpotTwoPosition == 14 && playSpotThreePosition == 27 && playSpotFourPosition == 40) {
			
			GameResultTwo.setText("Win!");
			SGameResult.setLayoutY(300);
			
		}
	
	}

	@FXML protected void PlaySpotFourBtn(ActionEvent event) throws IOException {
	
		if(SelectedSpot.getImage() != null) {
			
			if(selectedSpotPosition == (playSpotFourPosition - 1)) {
				
				PlaySpotFour.setImage(SelectedSpot.getImage());
				playSpotFourPosition--;
				deck.setValue(selectedSpotIndex);
				SelectedSpot.setImage(null);
				selectedSpotPosition = 0;
				selectedSpotIndex = 0;
				
			}
			
		}
		
		if(playSpotOnePosition == 1 && playSpotTwoPosition == 14 && playSpotThreePosition == 27 && playSpotFourPosition == 40) {
			
			GameResultTwo.setText("Win!");
			SGameResult.setLayoutY(300);
			
		}
	
	}
	
	@FXML protected void HandSpotOneBtn(ActionEvent event) throws IOException {
		
		if(SelectedSpot.getImage() == null) {
			
			SelectedSpot.setImage(HandSpotOne.getImage());
			selectedSpotPosition = handSpotOnePosition;
			selectedSpotIndex = handSpotOneIndex;
			HandSpotOne.setImage(null);
			
		}else {
			
			if(HandSpotTwo.getImage() == null) {
				
				HandSpotTwo.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotOne.getImage());
				selectedSpotPosition = handSpotOnePosition;
				selectedSpotIndex = handSpotOneIndex;
				HandSpotOne.setImage(null);
				
			}else if(HandSpotThree.getImage() == null) {
				
				HandSpotThree.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotOne.getImage());
				selectedSpotPosition = handSpotOnePosition;
				selectedSpotIndex = handSpotOneIndex;
				HandSpotOne.setImage(null);
				
			}else if(HandSpotFour.getImage() == null) {
				
				HandSpotFour.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotOne.getImage());
				selectedSpotPosition = handSpotOnePosition;
				selectedSpotIndex = handSpotOneIndex;
				HandSpotOne.setImage(null);
				
			}
			
		}
		
	}
	
	@FXML protected void HandSpotTwoBtn(ActionEvent event) throws IOException {
		
		if(SelectedSpot.getImage() == null) {
			
			SelectedSpot.setImage(HandSpotTwo.getImage());
			selectedSpotPosition = handSpotTwoPosition;
			selectedSpotIndex = handSpotTwoIndex;
			HandSpotTwo.setImage(null);
			
		}else {
			
			if(HandSpotOne.getImage() == null) {
				
				HandSpotOne.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotTwo.getImage());
				selectedSpotPosition = handSpotTwoPosition;
				selectedSpotIndex = handSpotTwoIndex;
				HandSpotTwo.setImage(null);
				
			}else if(HandSpotThree.getImage() == null) {
				
				HandSpotThree.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotTwo.getImage());
				selectedSpotPosition = handSpotTwoPosition;
				selectedSpotIndex = handSpotTwoIndex;
				HandSpotTwo.setImage(null);
				
			}else if(HandSpotFour.getImage() == null) {
				
				HandSpotFour.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotTwo.getImage());
				selectedSpotPosition = handSpotTwoPosition;
				selectedSpotIndex = handSpotTwoIndex;
				HandSpotTwo.setImage(null);
				
			}
			
		}
		
	}

	@FXML protected void HandSpotThreeBtn(ActionEvent event) throws IOException {
	
		if(SelectedSpot.getImage() == null) {
			
			SelectedSpot.setImage(HandSpotThree.getImage());
			selectedSpotPosition = handSpotThreePosition;
			selectedSpotIndex = handSpotThreeIndex;
			HandSpotThree.setImage(null);
			
		}else {
			
			if(HandSpotTwo.getImage() == null) {
				
				HandSpotTwo.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotThree.getImage());
				selectedSpotPosition = handSpotThreePosition;
				selectedSpotIndex = handSpotThreeIndex;
				HandSpotThree.setImage(null);
				
			}else if(HandSpotOne.getImage() == null) {
				
				HandSpotOne.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotThree.getImage());
				selectedSpotPosition = handSpotThreePosition;
				selectedSpotIndex = handSpotThreeIndex;
				HandSpotThree.setImage(null);
				
			}else if(HandSpotFour.getImage() == null) {
				
				HandSpotFour.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotThree.getImage());
				selectedSpotPosition = handSpotThreePosition;
				selectedSpotIndex = handSpotThreeIndex;
				HandSpotThree.setImage(null);
				
			}
			
		}
	
	}

	@FXML protected void HandSpotFourBtn(ActionEvent event) throws IOException {
	
		if(SelectedSpot.getImage() == null) {
			
			SelectedSpot.setImage(HandSpotFour.getImage());
			selectedSpotPosition = handSpotFourPosition;
			selectedSpotIndex = handSpotFourIndex;
			HandSpotFour.setImage(null);
			
		}else {
			
			if(HandSpotTwo.getImage() == null) {
				
				HandSpotTwo.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotFour.getImage());
				selectedSpotPosition = handSpotFourPosition;
				selectedSpotIndex = handSpotFourIndex;
				HandSpotFour.setImage(null);
				
			}else if(HandSpotThree.getImage() == null) {
				
				HandSpotThree.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotFour.getImage());
				selectedSpotPosition = handSpotFourPosition;
				selectedSpotIndex = handSpotFourIndex;
				HandSpotFour.setImage(null);
				
			}else if(HandSpotOne.getImage() == null) {
				
				HandSpotOne.setImage(SelectedSpot.getImage());
				SelectedSpot.setImage(HandSpotFour.getImage());
				selectedSpotPosition = handSpotFourPosition;
				selectedSpotIndex = handSpotFourIndex;
				HandSpotFour.setImage(null);
				
			}
			
		}
	
	}
	
	@FXML protected void SelectedSpotBtn(ActionEvent event) throws IOException {
		
		if(HandSpotOne.getImage() == null) {
			
			HandSpotOne.setImage(SelectedSpot.getImage());
			SelectedSpot.setImage(null);
			selectedSpotPosition = 0;
			selectedSpotIndex = 0;
			
		}else if(HandSpotTwo.getImage() == null) {
			
			HandSpotTwo.setImage(SelectedSpot.getImage());
			SelectedSpot.setImage(null);
			selectedSpotPosition = 0;
			selectedSpotIndex = 0;
			
		}else if(HandSpotThree.getImage() == null) {
			
			HandSpotThree.setImage(SelectedSpot.getImage());
			SelectedSpot.setImage(null);
			selectedSpotPosition = 0;
			selectedSpotIndex = 0;
			
		}else if(HandSpotFour.getImage() == null) {
			
			HandSpotFour.setImage(SelectedSpot.getImage());
			SelectedSpot.setImage(null);
			selectedSpotPosition = 0;
			selectedSpotIndex = 0;
			
		}
		
	}
	
	@FXML protected void SRulesBtn(ActionEvent event) throws IOException {
		
		SRulesSheet.setLayoutX(0);
		
	}
	
	@FXML protected void SRulesCloseBtn(ActionEvent event) {
		
		SRulesSheet.setLayoutX(800);
		
	}
	
	@FXML protected void PlayAgain(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Solitaire.fxml"));
		Scene Solitaire = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		Solitaire.getStylesheets().add(css);
		Stage window =  (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(Solitaire);
		window.setTitle("Solitaire");
		window.show();
		
	}
	
}
