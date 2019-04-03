package data.districtData;

import java.util.ArrayList;

import data.Coordinates;

public class TripPath {
	
	private ArrayList<Coordinates> squares;
	private int tripTime;
	
	public TripPath(ArrayList<Coordinates> squares, int tripTime) {
		super();
		this.squares = squares;
		this.tripTime = tripTime;
	}

	public TripPath() {
		this(new ArrayList<Coordinates>(), 0);
	}

	public ArrayList<Coordinates> getSquares() {
		return squares;
	}

	public void setSquares(ArrayList<Coordinates> squares) {
		this.squares = squares;
	}

	public int getTripTime() {
		return tripTime;
	}

	public void setTripTime(int tripTime) {
		this.tripTime = tripTime;
	}
	
}
