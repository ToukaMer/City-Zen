package data.railRoadData;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;

public class RailWay{
	public ArrayList<Coordinates> rails;
	public int tripTime;
	public int nbUser;
	public int nbUserMax;
	
	public RailWay(ArrayList<Coordinates> rails, int tripTime, int nbUser) {
		super();
		this.rails = rails;
		this.tripTime = tripTime;
		this.nbUser = nbUser;
		this.nbUserMax = Constants.NB_USER_MAX_RAILWAY;
	}
	
	public RailWay(ArrayList<Coordinates> rails, int tripTime) {
		this(new ArrayList<Coordinates>(), tripTime, 0);
	}

	public ArrayList<Coordinates> getRails() {
		return rails;
	}

	public void setRails(ArrayList<Coordinates> rails) {
		this.rails = rails;
	}

	public int getTripTime() {
		return tripTime;
	}

	public void setTripTime(int tripTime) {
		this.tripTime = tripTime;
	}

	public int getNbUser() {
		return nbUser;
	}

	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}

	public int getNbUserMax() {
		return nbUserMax;
	}

	public void setNbUserMax(int nbUserMax) {
		this.nbUserMax = nbUserMax;
	}
	
	
	
}
