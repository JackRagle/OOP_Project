package application;

import java.util.Random;

public class Deck {

	public Card[] deck;
	public int indx;
	
	public Deck() {
		deck = new Card[52];
		indx = 0;
		deck[0] = new Card(0, "AC.png"); deck[1] = new Card(0, "AD.png");
		deck[2] = new Card(0, "AH.png"); deck[3] = new Card(0, "AS.png");
		deck[4] = new Card(2, "2C.png"); deck[5] = new Card(2, "2D.png");
		deck[6] = new Card(2, "2H.png"); deck[7] = new Card(2, "2S.png");
		deck[8] = new Card(3, "3C.png"); deck[9] = new Card(3, "3D.png");
		deck[10] = new Card(3, "3H.png"); deck[11] = new Card(3, "3S.png");
		deck[12] = new Card(4, "4C.png"); deck[13] = new Card(4, "4D.png");
		deck[14] = new Card(4, "4H.png"); deck[15] = new Card(4, "4S.png");
		deck[16] = new Card(5, "5C.png"); deck[17] = new Card(5, "5D.png");
		deck[18] = new Card(5, "5H.png"); deck[19] = new Card(5, "5S.png");
		deck[20] = new Card(6, "6C.png"); deck[21] = new Card(6, "6D.png");
		deck[22] = new Card(6, "6H.png"); deck[23] = new Card(6, "6S.png");
		deck[24] = new Card(7, "7C.png"); deck[25] = new Card(7, "7D.png");
		deck[26] = new Card(7, "7H.png"); deck[27] = new Card(7, "7S.png");
		deck[28] = new Card(8, "8C.png"); deck[29] = new Card(8, "8D.png");
		deck[30] = new Card(8, "8H.png"); deck[31] = new Card(8, "8S.png");
		deck[32] = new Card(9, "9C.png"); deck[33] = new Card(9, "9D.png");
		deck[34] = new Card(9, "9H.png"); deck[35] = new Card(9, "9S.png");
		deck[36] = new Card(10, "10C.png"); deck[37] = new Card(10, "10D.png");
		deck[38] = new Card(10, "10H.png"); deck[39] = new Card(10, "10S.png");
		deck[40] = new Card(10, "JC.png"); deck[41] = new Card(10, "JD.png");
		deck[42] = new Card(10, "JH.png"); deck[43] = new Card(10, "JS.png");
		deck[44] = new Card(10, "QC.png"); deck[45] = new Card(10, "QD.png");
		deck[46] = new Card(10, "QH.png"); deck[47] = new Card(10, "QS.png");
		deck[48] = new Card(10, "KC.png"); deck[49] = new Card(10, "KD.png");
		deck[50] = new Card(10, "KH.png"); deck[51] = new Card(10, "KS.png");
		
	}
	
	public void shuffle() {
		
		Random random = new Random();
		indx = 0;
		for(int i = deck.length - 1; i >0; i--) {
			
			int j = random.nextInt(i + 1);
			Card temp = this.deck[i];
			this.deck[i] = this.deck[j];
			this.deck[j] = temp;
			
		}
		
		/*for(int b = 0; b < 52; b++) {
			System.out.println(deck[b].name);
		}*/
		
	}
	
	public Card draw() {
		return this.deck[indx++];
	}
	
}
