package data.railRoadData;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;

public class RailWay extends RailRoad
{	
	private ArrayList<Coordinates> coord;
	private int [] orientation = {0, 0, 0, 0}; //{north,south,east,west};
	
	public RailWay(ArrayList<Coordinates> coord, int [] orientation) 
	{
		super();
		this.setOrientation(orientation);
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

	public int[] getOrientation() {
		return orientation;
	}

	public void setOrientation(int[] orientation) {
		this.orientation = orientation;
	}
}
