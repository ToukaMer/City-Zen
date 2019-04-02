package data.districtData;

import data.Coordinates;

public class District {
	 private int type;
	 private String typeName;
	 private int price;
	 private int revenues;
	 private int usingTime;
	 private int satisfaction;
	 private Coordinates coordinates;
	 private boolean inConstruction;
	 private int constructionTime;
	 private int constructionTimeLeft;
	 private int turnCount;
	 
	 public District(int type, String typeName, int price, int revenues, int usingTime, int satisfaction,
			 Coordinates coordinates, boolean inConstruction, int constructionTime,
			 int constructionTimeLeft, int turnCount){
		this.type = type;
		this.typeName = typeName;
		this.revenues = revenues;
		this.usingTime = usingTime;
		this.satisfaction = satisfaction;
		this.coordinates = coordinates;
		this.inConstruction = inConstruction;
		this.constructionTime = constructionTime;
		this.constructionTimeLeft = constructionTimeLeft;
		this.turnCount = turnCount;
	 }
	 
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRevenues() {
		return revenues;
	}
	public void setRevenues(int revenues) {
		this.revenues = revenues;
	}
	public int getUsingTime() {
		return usingTime;
	}
	public void setUsingTime(int usingTime) {
		this.usingTime = usingTime;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}


	public boolean isInConstruction() {
		return inConstruction;
	}


	public void setInConstruction(boolean inConstruction) {
		this.inConstruction = inConstruction;
	}


	public int getConstructionTime() {
		return constructionTime;
	}


	public void setConstructionTime(int constructionTime) {
		this.constructionTime = constructionTime;
	}


	public int getConstructionTimeLeft() {
		return constructionTimeLeft;
	}


	public void setConstructionTimeLeft(int constructionTimeLeft) {
		this.constructionTimeLeft = constructionTimeLeft;
	}


	public int getTurnCount() {
		return turnCount;
	}


	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	 
}
