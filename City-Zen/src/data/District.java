package data;

public abstract class District {
	 private int type;
	 private String typeName;
	 private int price;
	 private int revenues;
	 private int usingTime;
	 private int satisfaction;
	
	 
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
	 
}
