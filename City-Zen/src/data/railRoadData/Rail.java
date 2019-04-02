package data.railRoadData;

import data.Constants;
import data.Coordinates;

public class Rail extends RailSquare {

	private int[] direction;
	
	public Rail(Coordinates coordinates, int[] direction) {
		super(Constants.RAIL, Constants.RAIL_NAME, coordinates);
		this.direction = direction;
	}

	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}
	
	

}
