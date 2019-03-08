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
	@Override
	public String toString() {
		return "Coordinates [row=" + row + ", column=" + column + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
	
	
}
