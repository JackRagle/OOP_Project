package application;

import java.util.Random;

public class Deck {

	public Card[] deck;
	public int indx;
	
	public Deck() {
		deck = new Card[52];
		indx = 0;
		deck[48] = new Card(0, 1, "AC.png"); deck[49] = new Card(0, 14, "AD.png");
		deck[50] = new Card(0, 27, "AH.png"); deck[51] = new Card(0, 40, "AS.png");
		deck[4] = new Card(2, 2, "2C.png"); deck[5] = new Card(2, 15, "2D.png");
		deck[6] = new Card(2, 28, "2H.png"); deck[7] = new Card(2, 41, "2S.png");
		deck[8] = new Card(3, 3, "3C.png"); deck[9] = new Card(3, 16, "3D.png");
		deck[10] = new Card(3, 29, "3H.png"); deck[11] = new Card(3, 42, "3S.png");
		deck[12] = new Card(4, 4, "4C.png"); deck[13] = new Card(4, 17, "4D.png");
		deck[14] = new Card(4, 30, "4H.png"); deck[15] = new Card(4, 43, "4S.png");
		deck[16] = new Card(5, 5, "5C.png"); deck[17] = new Card(5, 18, "5D.png");
		deck[18] = new Card(5, 31, "5H.png"); deck[19] = new Card(5, 44, "5S.png");
		deck[20] = new Card(6, 6, "6C.png"); deck[21] = new Card(6, 19, "6D.png");
		deck[22] = new Card(6, 32, "6H.png"); deck[23] = new Card(6, 45, "6S.png");
		deck[24] = new Card(7, 7, "7C.png"); deck[25] = new Card(7, 20, "7D.png");
		deck[26] = new Card(7, 33, "7H.png"); deck[27] = new Card(7, 46, "7S.png");
		deck[28] = new Card(8, 8, "8C.png"); deck[29] = new Card(8, 21, "8D.png");
		deck[30] = new Card(8, 34, "8H.png"); deck[31] = new Card(8, 47, "8S.png");
		deck[32] = new Card(9, 9, "9C.png"); deck[33] = new Card(9, 22, "9D.png");
		deck[34] = new Card(9, 35, "9H.png"); deck[35] = new Card(9, 48, "9S.png");
		deck[36] = new Card(10, 10, "10C.png"); deck[37] = new Card(10, 23, "10D.png");
		deck[38] = new Card(10, 36, "10H.png"); deck[39] = new Card(10, 49, "10S.png");
		deck[40] = new Card(10, 11, "JC.png"); deck[41] = new Card(10, 24, "JD.png");
		deck[42] = new Card(10, 37, "JH.png"); deck[43] = new Card(10, 50, "JS.png");
		deck[44] = new Card(10, 12, "QC.png"); deck[45] = new Card(10, 25, "QD.png");
		deck[46] = new Card(10, 38, "QH.png"); deck[47] = new Card(10, 51, "QS.png");
		deck[0] = new Card(10, 13, "KC.png"); deck[1] = new Card(10, 26, "KD.png");
		deck[2] = new Card(10, 39, "KH.png"); deck[3] = new Card(10, 52, "KS.png");
		
	}
	public Deck(String name) {
		deck = new Card[48];
		indx = 0;
		deck[0] = new Card(1, 1, "AC.png"); deck[1] = new Card(1, 14, "AD.png");
		deck[2] = new Card(1, 27, "AH.png"); deck[3] = new Card(1, 40, "AS.png");
		deck[4] = new Card(1, 2, "2C.png"); deck[5] = new Card(1, 15, "2D.png");
		deck[6] = new Card(1, 28, "2H.png"); deck[7] = new Card(1, 41, "2S.png");
		deck[8] = new Card(1, 3, "3C.png"); deck[9] = new Card(1, 16, "3D.png");
		deck[10] = new Card(1, 29, "3H.png"); deck[11] = new Card(1, 42, "3S.png");
		deck[12] = new Card(1, 4, "4C.png"); deck[13] = new Card(1, 17, "4D.png");
		deck[14] = new Card(1, 30, "4H.png"); deck[15] = new Card(1, 43, "4S.png");
		deck[16] = new Card(1, 5, "5C.png"); deck[17] = new Card(1, 18, "5D.png");
		deck[18] = new Card(1, 31, "5H.png"); deck[19] = new Card(1, 44, "5S.png");
		deck[20] = new Card(1, 6, "6C.png"); deck[21] = new Card(1, 19, "6D.png");
		deck[22] = new Card(1, 32, "6H.png"); deck[23] = new Card(1, 45, "6S.png");
		deck[24] = new Card(1, 7, "7C.png"); deck[25] = new Card(1, 20, "7D.png");
		deck[26] = new Card(1, 33, "7H.png"); deck[27] = new Card(1, 46, "7S.png");
		deck[28] = new Card(1, 8, "8C.png"); deck[29] = new Card(1, 21, "8D.png");
		deck[30] = new Card(1, 34, "8H.png"); deck[31] = new Card(1, 47, "8S.png");
		deck[32] = new Card(1, 9, "9C.png"); deck[33] = new Card(1, 22, "9D.png");
		deck[34] = new Card(1, 35, "9H.png"); deck[35] = new Card(1, 48, "9S.png");
		deck[36] = new Card(1, 10, "10C.png"); deck[37] = new Card(1, 23, "10D.png");
		deck[38] = new Card(1, 36, "10H.png"); deck[39] = new Card(1, 49, "10S.png");
		deck[40] = new Card(1, 11, "JC.png"); deck[41] = new Card(1, 24, "JD.png");
		deck[42] = new Card(1, 37, "JH.png"); deck[43] = new Card(1, 50, "JS.png");
		deck[44] = new Card(1, 12, "QC.png"); deck[45] = new Card(1, 25, "QD.png");
		deck[46] = new Card(1, 38, "QH.png"); deck[47] = new Card(1, 51, "QS.png");
		
	}
	
	public void shuffle() {
		
		Random random = new Random();
		this.indx = 0;
		for(int i = this.deck.length - 1; i >0; i--) {
			
			int j = random.nextInt(i + 1);
			Card temp = this.deck[i];
			this.deck[i] = this.deck[j];
			this.deck[j] = temp;
			
		}
		
		/*for(int b = 0; b < 52; b++) {
			System.out.println(deck[b].name);
		}*/
		
	}
	
	public Card draw(String solitaire) {
		
		if(this.indx > 49) {
			
			indx = 0;
			
		}
		
		boolean deckEmpty = false;
		
		for(int i = 0; i < 46; i++) {
			
			if(this.indx > 47) {
				
				indx = 0;
				
			}
			
			if(deck[indx].value == 1) {
				
				break;
				
			}else {
				
				indx++;
				
			}
			
		}
		if(this.deck[indx].value == 1) {
			
			return this.deck[indx];
			
		}else {
			
			Card emptyCard = new Card(1, 100, "Empty.png");
			return emptyCard;
			
		}
	}
	
	public Card draw() {
		
		return this.deck[indx++];
		
	}
	
	public Card draw(int num) {
		
		return this.deck[indx];
		
	}
	
	public int getIndex() {
		
		return this.indx;
		
	}
	
	public void incrementIndex() {
		
		this.indx++;
		
	}
	
	public void setValue(int indx) {
		
		if(this.deck[indx].value == 1) {
			
			this.deck[indx].value = 0;
			
		}
		
	}
	
}
