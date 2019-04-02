package data.districtData;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.railRoadData.RailWay;

public class Commercial extends District{
	private int nbMaxWorkers=0;
	private int currentNbWorkers=0;
	private HashMap<District, RailWay> railways;
	private boolean station;
	
	public Commercial(int price, int revenues, int usingTime, int satisfaction,
			Coordinates coordinates, boolean inConstruction, int constructionTime, int constructionTimeLeft,
			int turnCount, int nbMaxWorkers, int currentNbWorkers,
			HashMap<District, RailWay> railways, boolean station) {
		super(Constants.COMMERCIAL, Constants.COMMERCIAL_NAME, price, revenues, usingTime, satisfaction, coordinates, inConstruction, constructionTime,
				constructionTimeLeft, turnCount);
		this.nbMaxWorkers = nbMaxWorkers;
		this.currentNbWorkers = currentNbWorkers;
		this.railways = railways;
		this.station = station;
	}
	public Commercial(Coordinates coordinates) {
		this(Constants.COMMERCIAL_PRICE, Constants.COMMERCIAL_REVENUES, Constants.COMMERCIAL_USING_TIME, 
				Constants.COMMERCIAL_SATISFACTION, coordinates, true, Constants.COMMERCIAL_CONSTRUCTION_TIME,
				Constants.COMMERCIAL_CONSTRUCTION_TIME_LEFT,  Constants.COMMERCIAL_TURN_COUNT, 
				Constants.MAX_NUMBER_OF_COMMERCIAL_WORKERS, 0,
				new HashMap<District, RailWay>(), false);
	}
	
	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}
	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}
	public int getCurrentNbWorkers() {
		return currentNbWorkers;
	}
	public void setCurrentNbWorkers(int currentNbWorkers) {
		this.currentNbWorkers = currentNbWorkers;
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
