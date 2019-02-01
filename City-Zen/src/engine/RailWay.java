package engine;

public class RailWay extends RailRoad{
	private Coordinates tab[] [];
	private int maxLenght;
	
	public RailWay(Coordinates[][] tab, int maxLenght) {
		super();
		this.tab = tab;
		this.maxLenght = maxLenght;
	}

	public Coordinates[][] getTab() {
		return tab;
	}

	public void setTab(Coordinates[][] tab) {
		this.tab = tab;
	}

	public int getMaxLenght() {
		return maxLenght;
	}

	public void setMaxLenght(int maxLenght) {
		this.maxLenght = maxLenght;
	}
	
	
	
}
