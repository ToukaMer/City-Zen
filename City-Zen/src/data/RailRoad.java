package data;

public abstract class RailRoad {
	private int type;
	private String typeName;
	private int timeFoot;
	private int timeTrain;
	private int price;
	
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
	public int getTimeFoot() {
		return timeFoot;
	}
	public void setTimeFoot(int timeFoot) {
		this.timeFoot = timeFoot;
	}
	public int getTimeTrain() {
		return timeTrain;
	}
	public void setTimeTrain(int timeTrain) {
		this.timeTrain = timeTrain;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
