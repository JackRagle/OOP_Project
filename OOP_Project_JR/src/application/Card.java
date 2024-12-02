package application;

public class Card {

	public int value;
	public int placement;
	public String name;
	
	public Card(int value, int placement, String name) {
		this.name = name;
		this.value = value;
		this.placement = placement;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getPlacement() {
		return this.placement;
	}
	
	public void setValue() {
		
		this.value = 0;
		
	}
}
