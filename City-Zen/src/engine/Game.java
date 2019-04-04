package engine;


import java.util.Date;

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
	
	private Date clock;
	private long lastFrame;
	private long lastDay;
	
	private Game() {
		super();
		setStats(new Stats());
		setDistrictMap(DistrictManager.initDistrictMap());
		setRailSquareMap(RailWayManager.initRailSquareMap());
		getStats().setNbAdministrative(1);
		getStats().setNbWorkersAdministrative(Constants.STARTING_NUMBER_OF_ADMINISTRATIVE_WORKERS);
		
		setClock(new Date());
		setLastFrame(0);
		setLastDay(0);
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

	public long getLastFrame() {
		return lastFrame;
	}

	public void setLastFrame(long lastFrame) {
		this.lastFrame = lastFrame;
	}

	public Date getClock() {
		return clock;
	}

	public void setClock(Date clock) {
		this.clock = clock;
	}

	public long getLastDay() {
		return lastDay;
	}

	public void setLastDay(long lastDay) {
		this.lastDay = lastDay;
	}

}
