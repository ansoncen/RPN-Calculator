package main;

public class InputItem {
	private String value;
	private int index;
	
	public InputItem(String value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
