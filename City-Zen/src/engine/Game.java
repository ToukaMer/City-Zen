package engine;


import data.*;
import data.districtData.District;
import data.railRoadData.RailSquare;
import engine.managers.DistrictManager;
import engine.managers.RailWayManager;

public class Game {
	private static Game INSTANCE  = new Game();
	private District[][] districtMap;
	private RailSquare[][] railSquareMap;
	private Stats stats;
	
	private Game() {
		super();
		setStats(new Stats());
		setDistrictMap(DistrictManager.initDistrictMap());
		setRailSquareMap(RailWayManager.initRailSquareMap());
		getStats().setNbAdministrative(1);
		getStats().setNbWorkersAdministrative(Constants.STARTING_NUMBER_OF_ADMINISTRATIVE_WORKERS);
	}
	 
	public void reinitializeGame() {
		INSTANCE = new Game();
	}
	
	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public static Game getINSTANCE() {
		return INSTANCE;
	}

	public District[][] getDistrictMap() {
		return districtMap;
	}

	public void setDistrictMap(District[][] districtMap) {
		this.districtMap = districtMap;
	}

	public RailSquare[][] getRailSquareMap() {
		return railSquareMap;
	}

	public void setRailSquareMap(RailSquare[][] railSquareMap) {
		this.railSquareMap = railSquareMap;
	}

}
