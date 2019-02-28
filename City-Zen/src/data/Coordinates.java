package data;

public class Coordinates {
	private int row; //X
	private int column; //y
	
	public Coordinates() {
		this(0,0);
	}
	public Coordinates(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public static Coordinates [] testArray() {
		
		Coordinates coord0 = new Coordinates(1,1);
		Coordinates coord1 = new Coordinates(1,2);
		Coordinates coord2 = new Coordinates(1,3);
		Coordinates coord3 = new Coordinates(1,4);
		Coordinates coord4 = new Coordinates(1,5);
		
		Coordinates [] coord = {coord0,coord1,coord2,coord3,coord4};
		
		return coord;
		
	}
	
	
	
	
}
