package data;

public class Coordinates {
	private int row; //X
	private int columns; //y
	
	public Coordinates(int row, int columns) {
		super();
		this.row = row;
		this.columns = columns;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
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
