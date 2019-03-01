package data.railRoadData;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;

public class RailWay extends RailRoad
{	
	private ArrayList<Coordinates> coord;
	private int [] orientation = {0, 0, 0, 0};
	
	public RailWay(ArrayList<Coordinates> coord2, int [] orientation) 
	{
		super();
		this.setOrientation(orientation);
		this.setCoord(coord2);
		this.setTypeName("Rail");
		this.setType(Constants.RAILWAY);
	}


	public ArrayList<Coordinates> getCoord() {
		return coord;
	}

	public void setCoord(ArrayList<Coordinates> coord2) {
		this.coord = coord2;
	}

	public int[] getOrientation() {
		return orientation;
	}

	public void setOrientation(int[] orientation) {
		this.orientation = orientation;
	}
}
