package algo;
public class Box {
	
	private Amount amount;
	private boolean mine;
	private  int numberBox;
	
	public Box(Amount amount,int numberBox) {
		this.amount = amount;
		this.numberBox=numberBox;
	}
	
	public Amount getAmount() {
		return amount;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	
	
	public int getNumberBox() {
		return numberBox;
	}
}
