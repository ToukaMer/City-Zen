package data.railRoadData;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;

public class RailWay extends RailRoad
{	
	private ArrayList<Coordinates> coord;
	
	public RailWay(ArrayList<Coordinates> coord) 
	{
		super();
		this.setCoord(coord);
		this.setTypeName("Rail");
		this.setType(Constants.RAILWAY);
	}


	public ArrayList<Coordinates> getCoord() {
		return coord;
	}

	public void setCoord(ArrayList<Coordinates> coord) {
		this.coord = coord;
	}
	
}
