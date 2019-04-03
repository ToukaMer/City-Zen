package data.railRoadData;

import data.Coordinates;

public abstract class RailSquare {
	private int type;
	private String typeName;
	private Coordinates coordinates;
	
	public RailSquare(int type, String typeName, Coordinates coordinates) {
		super();
		this.type = type;
		this.typeName = typeName;
		this.coordinates = coordinates;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
