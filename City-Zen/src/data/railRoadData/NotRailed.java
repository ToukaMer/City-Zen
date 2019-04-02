package data.railRoadData;

import data.Constants;
import data.Coordinates;

public class NotRailed extends RailSquare {

	public NotRailed(Coordinates coordinates) {
		super(Constants.NOT_RAILED, Constants.NOT_RAILED_NAME, coordinates);
	}
	
}
