package dataclasses;

public class CellData {
	
	int xPos;
	int yPos;
	int value;
	
	public CellData(int xPos, int yPos, int value) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.value = value;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getValue() {
		return value;
	}
	
	public void setData(int value) {
		this.value = value;
	}

	
}
