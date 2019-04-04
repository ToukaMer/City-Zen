package data.districtData;

import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.railRoadData.RailWay;


public class Residencial extends District{
	private int nbHab=0;
	private int administrationWorkers=0;
	private int commercialWorkers=0;
	private int nbResidentMax=0;
	private HashMap<District, RailWay> railways;
	private boolean station;

	public Residencial(int price, int revenues, int usingTime, int satisfaction,
			Coordinates coordinates, boolean inConstruction, int constructionTime, int constructionTimeLeft,
			int turnCount, int nbHab, int administrationWorkers, int commercialWorkers, int nbResidentMax,
			HashMap<District, RailWay> railways, boolean station) 
	{
		super(Constants.RESIDENCIAL, Constants.RESIDENCIAL_NAME, price, revenues, usingTime, satisfaction, coordinates, inConstruction, constructionTime,
				constructionTimeLeft, turnCount);
		this.nbHab = nbHab;
		this.administrationWorkers = administrationWorkers;
		this.commercialWorkers = commercialWorkers;
		this.nbResidentMax = nbResidentMax;
		this.railways = railways;
		this.station = station;
	}

	public Residencial(Coordinates coordinates) {
		this(Constants.RESIDENCIAL_PRICE, Constants.RESIDENCIAL_REVENUES, Constants.RESIDENCIAL_USING_TIME, 
				Constants.RESIDENCIAL_SATISFACTION, coordinates, true, Constants.RESIDENCIAL_CONSTRUCTION_TIME,
				Constants.RESIDENCIAL_CONSTRUCTION_TIME_LEFT,  Constants.RESIDENCIAL_TURN_COUNT, 0, 0, 0, 
				Constants.MAX_NUMBER_OF_RESIDENTS,
				new HashMap<District, RailWay>(), false);
	}

	public int getNbHab() {
		return nbHab;
	}

	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}

	public int getAdministrationWorkers() {
		return administrationWorkers;
	}

	public void setAdministrationWorkers(int administrationWorkers) {
		this.administrationWorkers = administrationWorkers;
	}

	public int getCommercialWorkers() {
		return commercialWorkers;
	}

	public void setCommercialWorkers(int commercialWorkers) {
		this.commercialWorkers = commercialWorkers;
	}

	public int getNbResidentMax() {
		return nbResidentMax;
	}

	public void setNbResidentMax(int nbResidentMax) {
		this.nbResidentMax = nbResidentMax;
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
