package data.railRoadData;

import data.Constants;
import data.Coordinates;

public class RailWay extends RailRoad
{	
	private Coordinates [] coord;
	private int [] orientation = {0, 0, 0, 0};
	
	public RailWay(Coordinates [] coord, int [] orientation) 
	{
		super();
		this.setOrientation(orientation);
		this.setCoord(coord);
		this.setTypeName("Rail");
		this.setType(Constants.RAILWAY);
	}

	public Coordinates[] getCoord() {
		return coord;
	}

	public void setCoord(Coordinates[] coord) {
		this.coord = coord;
	}

	public int[] getOrientation() {
		return orientation;
	}

	public void setOrientation(int[] orientation) {
		this.orientation = orientation;
	}
}
