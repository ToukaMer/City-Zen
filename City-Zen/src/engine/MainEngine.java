package engine;

import data.districtData.District;
import data.railRoadData.RailRoad;
import engine.managers.DistrictManager;
import engine.managers.RailWayManager;

public class MainEngine {
	

	public static void main(String[] args) {
		int width = 10;
		int height = 10;
		
		Game game = new Game(width, height);
		DistrictManager districtmanager = game.getDistrictManager();
		RailWayManager railWayManager = game.getRailWayManager();
		District[][] district = game.getDistrictMap();
		RailRoad[][] railRoad = game.getRailRoadMap();
		game.consoleTest(districtmanager, railWayManager, width, height, district, railRoad);
		
	}
	
}
