package data.districtData;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.railRoadData.RailWay;

public class Administrative extends District{
	private int currentNbWorkers;
	private int nbUserMax;
	private int currentNbUsers;
	private int nbMaxWorkers;
	private HashMap<District, RailWay> railways;
	private boolean station;
	
	public Administrative(int price, int revenues, int usingTime, int satisfaction,
			Coordinates coordinates, boolean inConstruction, int constructionTime, int constructionTimeLeft,
			int turnCount, int currentNbWorkers, int nbUserMax, int currentNbUsers, int nbMaxWorkers,
			HashMap<District, RailWay> railways, boolean station) {
		
		super(Constants.ADMINISTRATIVE, Constants.ADMINISTRATIVE_NAME, price, revenues, usingTime, satisfaction, coordinates, inConstruction, constructionTime,
				constructionTimeLeft, turnCount);
		this.currentNbWorkers = currentNbWorkers;
		this.nbUserMax = nbUserMax;
		this.currentNbUsers = currentNbUsers;
		this.nbMaxWorkers = nbMaxWorkers;
		this.railways = railways;
		this.station = station;
	}
	
	public Administrative(Coordinates coordinates) {
		this(Constants.ADMINISTRATIVE_PRICE, Constants.ADMINISTRATIVE_REVENUES, Constants.ADMINISTRATIVE_USING_TIME, 
				Constants.ADMINISTRATIVE_SATISFACTION, coordinates, true, Constants.ADMINISTRATIVE_CONSTRUCTION_TIME,
				Constants.ADMINISTRATIVE_CONSTRUCTION_TIME_LEFT,  Constants.ADMINISTRATIVE_TURN_COUNT, 
				Constants.STARTING_NUMBER_OF_USERS, Constants.MAX_NUMBER_OF_USERS,
				Constants.STARTING_NUMBER_OF_USERS, Constants.MAX_NUMBER_OF_COMMERCIAL_WORKERS,
				new HashMap<District, RailWay>(), false);
	}
	
	public int getCurrentNbWorkers() {
		return currentNbWorkers;
	}
	public void setCurrentNbWorkers(int currentNbWorkers) {
		this.currentNbWorkers = currentNbWorkers;
	}
	public int getNbUserMax() {
		return nbUserMax;
	}
	public void setNbUserMax(int nbUserMax) {
		this.nbUserMax = nbUserMax;
	}
	public int getCurrentNbUsers() {
		return currentNbUsers;
	}
	public void setCurrentNbUsers(int currentNbUsers) {
		this.currentNbUsers = currentNbUsers;
	}
	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}
	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}

	public HashMap<District, RailWay> getRailways() {
		return railways;
	}

	public void setRailways(HashMap<District, RailWay> railways) {
		this.railways = railways;
	}

	public boolean isStation() {
		return station;
	}

	public void setStation(boolean station) {
		this.station = station;
	}
	
	
}