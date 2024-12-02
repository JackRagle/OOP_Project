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

public class BlackJack {
	
	@FXML private AnchorPane BJMenu;
	@FXML private AnchorPane BJRulesSheet;
	@FXML private AnchorPane BJGameResult;
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
	@FXML private ImageView CardOne;
	@FXML private ImageView CardTwo;
	@FXML private ImageView CardThree;
	@FXML private ImageView CardFour;
	@FXML private ImageView CardFive;
	@FXML private ImageView CardSix;
	@FXML private ImageView CardSeven;
	@FXML private ImageView CardEight;
	@FXML private ImageView CardNine;
	@FXML private Label GameResultOne;
	@FXML private Label GameResultTwo;
	
	Deck deck = new Deck();
	
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
	@FXML protected void StandBtn(ActionEvent event) throws IOException, URISyntaxException {
		
		StandBtn.setDisable(true);
		HitBtn.setDisable(true);
		Card cardFour = deck.draw();
		String cardFourName = cardFour.getName();
		Image cardFourImg = new Image(getClass().getResource(cardFourName).toURI().toString());
		CardFour.setImage(cardFourImg);
		CardFour.setLayoutX(CardPHFour.getLayoutX());
		CardFour.setLayoutY(CardPHFour.getLayoutY());
		
		if(DealerScore.getText().matches("11 / 1")) {
			
			if(cardFour.value == 0) {
				DealerScore.setText("12 / 2");
			}else {
				
				int dealerScoreHigh = 11 + cardFour.value;
				int dealerScoreLow = 1 + cardFour.value;
				DealerScore.setText(dealerScoreHigh + " / " + dealerScoreLow);
				
			}
			
		}else {
			
			if(cardFour.value == 0) {
				
				int dealerScoreHigh = Integer.parseInt(DealerScore.getText()) + 11;
				int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
				DealerScore.setText(dealerScoreHigh + " / " + dealerScoreLow);
					
			}else {
				
				int dealerScore = Integer.parseInt(DealerScore.getText()) + cardFour.value;
				DealerScore.setText("" + dealerScore);
				
			}
			
		}
		
		if(PlayerScore.getText().length() > 2) {
			String[] scoreArray = PlayerScore.getText().split(" ");
			PlayerScore.setText(scoreArray[0]);
		}
		
		String dealerScore = DealerScore.getText();
		String[] dealerScoreArray = dealerScore.split(" / ");
		int dealerScoreNum = Integer.parseInt(dealerScoreArray[0]);
		if(dealerScoreNum > Integer.parseInt(PlayerScore.getText())) {
			
			DealerScore.setText("" + dealerScoreNum);
			GameResultTwo.setText("Lose!");
			BJGameResult.setLayoutY(205);
			
		}else {
			
			if(dealerScoreNum < 17) {
				
				Card cardSeven = deck.draw();
				String cardSevenName = cardSeven.getName();
				Image cardSevenImg = new Image(getClass().getResource(cardSevenName).toURI().toString());
				CardSeven.setImage(cardSevenImg);
				CardSeven.setLayoutX(CardPHFour.getLayoutX() + 100);
				CardSeven.setLayoutY(CardPHFour.getLayoutY());
				
				if(DealerScore.getText().length() > 2) {
					
					dealerScore = DealerScore.getText();
					dealerScoreArray = dealerScore.split(" / ");
					if(cardSeven.value == 0) {
						
						int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + 11;
						if(dealerScoreHigh > 21) {
							
							int dealerScoreLow = Integer.parseInt(dealerScoreArray[1] + 11);
							DealerScore.setText("" + dealerScoreLow);
						}else {
							
							DealerScore.setText("" + dealerScoreHigh);
							
						}
						
					}else {
						
						int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + cardSeven.value;
						int dealerScoreLow = Integer.parseInt(dealerScoreArray[1]) + cardSeven.value;
						if(dealerScoreHigh > 21) {
							
							DealerScore.setText("" + dealerScoreLow);
							
						}else {
							
							DealerScore.setText("" + dealerScoreHigh);
							
						}
						
					}
					
				}else {
					
					if(cardSeven.value == 0) {
						
						int dealerScoreHigh = Integer.parseInt(DealerScore.getText()) + 11;
						if(dealerScoreHigh > 21) {
							
							int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
							DealerScore.setText("" + dealerScoreLow);
							
						}else {
							
							int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
							DealerScore.setText(dealerScoreHigh + " / " + dealerScoreLow);
							
						}
						
					}
					
					int dealerScoreTwo = Integer.parseInt(DealerScore.getText()) + cardSeven.value;
					DealerScore.setText("" + dealerScoreTwo);
					
				}
				
				if(Integer.parseInt(DealerScore.getText()) > 21) {
					
					GameResultTwo.setText("Win!");
					BJGameResult.setLayoutY(205);
					
				}else {
					
					if(Integer.parseInt(DealerScore.getText()) > Integer.parseInt(PlayerScore.getText())) {
						
						GameResultTwo.setText("Lose!");
						BJGameResult.setLayoutY(205);
						
					}else {
						
						if(Integer.parseInt(DealerScore.getText()) < 17) {
							
							Card cardEight = deck.draw();
							String cardEightName = cardEight.getName();
							Image cardEightImg = new Image(getClass().getResource(cardEightName).toURI().toString());
							CardEight.setImage(cardEightImg);
							CardEight.setLayoutX(CardPHFour.getLayoutX() + 200);
							CardEight.setLayoutY(CardPHFour.getLayoutY());
							if(DealerScore.getText().length() > 2) {
								
								dealerScore = DealerScore.getText();
								dealerScoreArray = dealerScore.split(" / ");
								if(cardEight.value == 0) {
									
									int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + 11;
									if(dealerScoreHigh > 21) {
										
										int dealerScoreLow = Integer.parseInt(dealerScoreArray[1] + 11);
										DealerScore.setText("" + dealerScoreLow);
									}else {
										
										DealerScore.setText("" + dealerScoreHigh);
										
									}
									
								}else {
									
									int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + cardEight.value;
									int dealerScoreLow = Integer.parseInt(dealerScoreArray[1]) + cardEight.value;
									if(dealerScoreHigh > 21) {
										
										DealerScore.setText("" + dealerScoreLow);
										
									}else {
										
										DealerScore.setText("" + dealerScoreHigh);
										
									}
									
								}
								
							}else {
								
								if(cardEight.value == 0) {
									
									int dealerScoreHigh = Integer.parseInt(DealerScore.getText()) + 11;
									if(dealerScoreHigh > 21) {
										
										int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
										DealerScore.setText("" + dealerScoreLow);
										
									}else {
										
										int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
										DealerScore.setText(dealerScoreHigh + " / " + dealerScoreLow);
										
									}
									
								}
								
								int dealerScoreTwo = Integer.parseInt(DealerScore.getText()) + cardEight.value;
								DealerScore.setText("" + dealerScoreTwo);
								
							}
							
							if(Integer.parseInt(DealerScore.getText()) > 21) {
								
								GameResultTwo.setText("Win!");
								BJGameResult.setLayoutY(205);
								
							}else {
								
								if(Integer.parseInt(DealerScore.getText()) > Integer.parseInt(PlayerScore.getText())) {
									
									GameResultTwo.setText("Lose!");
									BJGameResult.setLayoutY(205);
									
								}else {
									
									if(dealerScoreNum < 17) {
										
										Card cardNine = deck.draw();
										String cardNineName = cardNine.getName();
										Image cardNineImg = new Image(getClass().getResource(cardNineName).toURI().toString());
										CardNine.setImage(cardNineImg);
										CardNine.setLayoutX(CardPHFour.getLayoutX() + 300);
										CardNine.setLayoutY(CardPHFour.getLayoutY());
										
										if(DealerScore.getText().length() > 2) {
											
											dealerScore = DealerScore.getText();
											dealerScoreArray = dealerScore.split(" / ");
											if(cardNine.value == 0) {
												
												int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + 11;
												if(dealerScoreHigh > 21) {
													
													int dealerScoreLow = Integer.parseInt(dealerScoreArray[1] + 11);
													DealerScore.setText("" + dealerScoreLow);
												}else {
													
													DealerScore.setText("" + dealerScoreHigh);
													
												}
												
											}else {
												
												int dealerScoreHigh = Integer.parseInt(dealerScoreArray[0]) + cardNine.value;
												int dealerScoreLow = Integer.parseInt(dealerScoreArray[1]) + cardNine.value;
												if(dealerScoreHigh > 21) {
													
													DealerScore.setText("" + dealerScoreLow);
													
												}else {
													
													DealerScore.setText("" + dealerScoreHigh);
													
												}
												
											}
											
										}else {
											
											if(cardNine.value == 0) {
												
												int dealerScoreHigh = Integer.parseInt(DealerScore.getText()) + 11;
												if(dealerScoreHigh > 21) {
													
													int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
													DealerScore.setText("" + dealerScoreLow);
													
												}else {
													
													int dealerScoreLow = Integer.parseInt(DealerScore.getText()) + 1;
													DealerScore.setText(dealerScoreHigh + " / " + dealerScoreLow);
													
												}
												
											}
											
											int dealerScoreTwo = Integer.parseInt(DealerScore.getText()) + cardNine.value;
											DealerScore.setText("" + dealerScoreTwo);
											
										}
										
										if(Integer.parseInt(DealerScore.getText()) > 21) {
											
											GameResultTwo.setText("Win!");
											BJGameResult.setLayoutY(205);
											
										}else {
											
											if(Integer.parseInt(DealerScore.getText()) > Integer.parseInt(PlayerScore.getText())) {
												
												GameResultTwo.setText("Lose!");
												BJGameResult.setLayoutY(205);
												
											}
										
										}
								
							}else {
							
							GameResultTwo.setText("Win!");
							BJGameResult.setLayoutY(205);
							
						}
						
					}
					
					
				}
				
			}else {
				
				GameResultTwo.setText("Win!");
				BJGameResult.setLayoutY(205);
			}
				
					}
			
					}
		
				}else {
					
					GameResultTwo.setText("Win!");
					BJGameResult.setLayoutY(205);
			}
		}
	}
	@FXML protected void DealBtn(ActionEvent event) throws IOException, URISyntaxException {
		
		DealBtn.setDisable(true);
		deck.shuffle();
		Card cardOne = deck.draw();
		String cardOneName = cardOne.getName();
		Image cardOneImg = new Image(getClass().getResource(cardOneName).toURI().toString());
		CardOne.setImage(cardOneImg);
		CardOne.setLayoutX(CardPHOne.getLayoutX());
		CardOne.setLayoutY(CardPHOne.getLayoutY());
		Card cardTwo = deck.draw();
		String cardTwoName = cardTwo.getName();
		Image cardTwoImg = new Image(getClass().getResource(cardTwoName).toURI().toString());
		CardTwo.setImage(cardTwoImg);
		CardTwo.setLayoutX(CardPHTwo.getLayoutX());
		CardTwo.setLayoutY(CardPHTwo.getLayoutY());
		Card cardThree = deck.draw();
		String cardThreeName = cardThree.getName();
		Image cardThreeImg = new Image(getClass().getResource(cardThreeName).toURI().toString());
		CardThree.setImage(cardThreeImg);
		CardThree.setLayoutX(CardPHThree.getLayoutX());
		CardThree.setLayoutY(CardPHThree.getLayoutY());
		
		if(cardOne.value == 0 && cardTwo.value == 0) {
			
			PlayerScore.setText("12 / 2");
			
		}else if(cardOne.value == 0) {
			
			int playerScoreOne = 11 + cardTwo.value;
			if(playerScoreOne <= 21) {
				
				int playerScoreTwo = 1 + cardTwo.value;
				PlayerScore.setText(playerScoreOne + " / " + playerScoreTwo);
				
			}else {
				
				int playerScoreTwo = 1 + cardTwo.value;
				PlayerScore.setText("" + playerScoreTwo);
				
			}
			
		}else if(cardTwo.value == 0) {
			
			int playerScoreOne = 11 + cardOne.value;
			if(playerScoreOne <= 21) {
				
				int playerScoreTwo = 1 + cardOne.value;
				PlayerScore.setText(playerScoreOne + " / " + playerScoreTwo);
				
			}else {
				
				int playerScoreTwo = 1 + cardOne.value;
				PlayerScore.setText("" + playerScoreTwo);
				
			}
		}else {
			
			int playerScore = cardOne.value + cardTwo.value;
			PlayerScore.setText("" + playerScore);
			
		}
		
		if(cardThree.value == 0) {
			DealerScore.setText("11 / 1");
		}else {
			DealerScore.setText("" + cardThree.value);
		}
		
	}
	@FXML protected void HitBtn(ActionEvent event) throws IOException, URISyntaxException {
		
		if(CardFive.getLayoutX() != (CardOne.getLayoutX() - 100)) {
			
			Card cardFive = deck.draw();
			String cardFiveName = cardFive.getName();
			Image cardFiveImg = new Image(getClass().getResource(cardFiveName).toURI().toString());
			CardFive.setImage(cardFiveImg);
			CardFive.setLayoutX(CardOne.getLayoutX() - 100);
			CardFive.setLayoutY(CardPHOne.getLayoutY());
			
			if(PlayerScore.getText().length() > 2) {
				
				String playerScore = PlayerScore.getText();
				String[] playerScoreArray = playerScore.split(" / ");
				if(cardFive.value == 0) {
					
					int playerScoreNumHigh = Integer.parseInt(playerScoreArray[0]) + 11;
					int playerScoreNumLow = Integer.parseInt(playerScoreArray[1]) + 1;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}else {
					
					int playerScoreNumHigh = Integer.parseInt(playerScoreArray[0]) + cardFive.value;
					int playerScoreNumLow = Integer.parseInt(playerScoreArray[1]) + cardFive.value;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}
				
			}else {
				
				if(cardFive.value == 0) {
					
					int playerScoreNumHigh = Integer.parseInt(PlayerScore.getText()) + 11;
					int playerScoreNumLow = Integer.parseInt(PlayerScore.getText()) + 1;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}else {
					
					int playerScoreNum = Integer.parseInt(PlayerScore.getText()) + cardFive.value;
					PlayerScore.setText("" + playerScoreNum);
					
				}
				
			}
			if(PlayerScore.getText().length() <= 2) {
				
				if(Integer.parseInt(PlayerScore.getText()) > 21) {
					
					GameResultTwo.setText("Lose!");
					BJGameResult.setLayoutY(205);
					
				}
				
			}
			
		}else if(CardSix.getLayoutX() != (CardOne.getLayoutX() - 200)) {
			
			Card cardSix = deck.draw();
			String cardSixName = cardSix.getName();
			Image cardSixImg = new Image(getClass().getResource(cardSixName).toURI().toString());
			CardSix.setImage(cardSixImg);
			CardSix.setLayoutX(CardOne.getLayoutX() - 200);
			CardSix.setLayoutY(CardPHOne.getLayoutY());
			
			if(PlayerScore.getText().length() > 2) {
				
				String playerScore = PlayerScore.getText();
				String[] playerScoreArray = playerScore.split(" / ");
				if(cardSix.value == 0) {
					
					int playerScoreNumHigh = Integer.parseInt(playerScoreArray[0]) + 11;
					int playerScoreNumLow = Integer.parseInt(playerScoreArray[1]) + 1;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}else {
					
					int playerScoreNumHigh = Integer.parseInt(playerScoreArray[0]) + cardSix.value;
					int playerScoreNumLow = Integer.parseInt(playerScoreArray[1]) + cardSix.value;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}
				
			}else {
				
				if(cardSix.value == 0) {
					
					int playerScoreNumHigh = Integer.parseInt(PlayerScore.getText()) + 11;
					int playerScoreNumLow = Integer.parseInt(PlayerScore.getText()) + 1;
					if(playerScoreNumHigh > 21) {
						
						PlayerScore.setText("" + playerScoreNumLow);
						
					}else {
						
						PlayerScore.setText(playerScoreNumHigh + " / " + playerScoreNumLow);
						
					}
					
				}else {
					
					int playerScoreNum = Integer.parseInt(PlayerScore.getText()) + cardSix.value;
					PlayerScore.setText("" + playerScoreNum);
					
				}
				
			}
			if(PlayerScore.getText().length() <= 2) {
				
				if(Integer.parseInt(PlayerScore.getText()) > 21) {
					
					GameResultTwo.setText("Lose!");
					BJGameResult.setLayoutY(205);
					
				}
				
			}
			
		}
	
	}
	@FXML protected void PlayAgain(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("BlackJack.fxml"));
		Scene BlackJack = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		BlackJack.getStylesheets().add(css);
		Stage window =  (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(BlackJack);
		window.setTitle("BlackJack");
		window.show();
		
	}
	@FXML protected void BJRulesCloseBtn(ActionEvent event) throws IOException {
		
		BJRulesSheet.setLayoutX(800);
		
	}

}
