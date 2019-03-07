package algo;

public class Amount {
	
	private String value;
	private boolean used;
	private int index;
	private int group;
	
	public Amount(String value, int index, int group) {
		this.value = value;
		this.index = index;
		this.group = group;
	}
	
	public int getIndex() {
		return index;
	}
	public int getGroup() {
		return group;
	}
	public boolean isUsed() {
		return used;
	}
	
	public String getValue() {
		return value;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
}
