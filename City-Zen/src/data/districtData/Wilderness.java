package data.districtData;

import data.Constants;
import data.Coordinates;

public class Wilderness extends District{

	public Wilderness(Coordinates coordinates) {
		super(Constants.WILDERNESS, Constants.WILDERNESS_NAME, Constants.WILDERNESS_PRICE, Constants.WILDERNESS_REVENUES, Constants.WILDERNESS_USING_TIME, Constants.WILDERNESS_SATISFACTION, coordinates, true, Constants.WILDERNESS_CONSTRUCTION_TIME, Constants.WILDERNESS_CONSTRUCTION_TIME_LEFT, Constants.WILDERNESS_TURN_COUNT);
	}
	
	
}
