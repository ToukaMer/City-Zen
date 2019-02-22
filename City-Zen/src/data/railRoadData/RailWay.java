package data.railRoadData;

import data.Coordinates;

public class RailWay extends RailRoad
{	
	private Coordinates [] coord;
	
	public RailWay(Coordinates [] coord) 
	{
		super();
		this.coord=coord;
		this.setType(1);
	}

	public Coordinates[] getCoord() {
		return coord;
	}

	public void setCoord(Coordinates[] coord) {
		this.coord = coord;
	}

}
