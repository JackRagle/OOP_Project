package application;

public class Card {

	public int value;
	public String name;
	
	public Card(int value, String name) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
}
