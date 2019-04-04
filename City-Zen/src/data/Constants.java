package data;

public class Constants {
	
	/* CONSTANTS FOR DISTRICTS */
	
	public static final int RESIDENCIAL = 2;
	public static final int COMMERCIAL = 3;
	public static final int ADMINISTRATIVE = 1;
	public static final int WILDERNESS = 0;
	
	public static final String ADMINISTRATIVE_NAME = "Administrative";
	public static final int ADMINISTRATIVE_PRICE = 0;
	public static final int ADMINISTRATIVE_REVENUES = 0;
	public static final int ADMINISTRATIVE_USING_TIME = 0;
	public static final int ADMINISTRATIVE_SATISFACTION = 0;
	public static final int ADMINISTRATIVE_CONSTRUCTION_TIME = 0;
	public static final int ADMINISTRATIVE_CONSTRUCTION_TIME_LEFT = 0;
	public static final int ADMINISTRATIVE_TURN_COUNT = 0;
	
	public static final String COMMERCIAL_NAME = "Commercial";
	public static final int COMMERCIAL_PRICE = 0;
	public static final int COMMERCIAL_REVENUES = 0;
	public static final int COMMERCIAL_USING_TIME = 0;
	public static final int COMMERCIAL_SATISFACTION = 0;
	public static final int COMMERCIAL_CONSTRUCTION_TIME = 0;
	public static final int COMMERCIAL_CONSTRUCTION_TIME_LEFT = 0;
	public static final int COMMERCIAL_TURN_COUNT = 0;
	
	public static final String RESIDENCIAL_NAME = "Residencial";
	public static final int RESIDENCIAL_PRICE = 0;
	public static final int RESIDENCIAL_REVENUES = 0;
	public static final int RESIDENCIAL_USING_TIME = 0;
	public static final int RESIDENCIAL_SATISFACTION = 0;
	public static final int RESIDENCIAL_CONSTRUCTION_TIME = 0;
	public static final int RESIDENCIAL_CONSTRUCTION_TIME_LEFT = 0;
	public static final int RESIDENCIAL_TURN_COUNT = 0;
	
	public static final String WILDERNESS_NAME = "Wilderness";
	public static final int WILDERNESS_PRICE = 0;
	public static final int WILDERNESS_REVENUES = 0;
	public static final int WILDERNESS_USING_TIME = 0;
	public static final int WILDERNESS_SATISFACTION = 0;
	public static final int WILDERNESS_CONSTRUCTION_TIME = 0;
	public static final int WILDERNESS_CONSTRUCTION_TIME_LEFT = 0;
	public static final int WILDERNESS_TURN_COUNT = 0;
	
	//residencial
	public static final int STARTING_NUMBER_OF_HABITANTS = 0;
	public static final int ADMINISTRATION_WORKERS = 0;
	public static final int COMMERCIAL_WORKERS = 0;
	public static final int MAX_NUMBER_OF_RESIDENTS = 0;

	//administrative
	public static final int STARTING_NUMBER_OF_USERS = 0;
	public static final int MAX_NUMBER_OF_USERS = 0;
	public static final int STARTING_NUMBER_OF_ADMINISTRATIVE_WORKERS = 0;
	public static final int MAX_NUMBER_OF_ADMINISTRATIVE_WORKERS = 0;

	//commercial
	public static final int STARTING_NUMBER_OF_COMMERCIAL_WORKERS = 0;
	public static final int MAX_NUMBER_OF_COMMERCIAL_WORKERS = 0;
	
	public static final boolean DEBUG_DISTRICT = false;
	public static final boolean DEBUG_RAILROAD = false;
	public static final boolean DEBUG_PATHFINDING = false;

	public static final int WILDERNESS_TIME = 10; 
	
	/* CONSTANTS FOR RAILROADS */
	
	public static final int NOT_RAILED = 0;
	public static final int RAIL = 1;
	public static final int STATION = 2;
	
	public static final String NOT_RAILED_NAME = "Not railed";
	public static final String RAIL_NAME = "Rail";
	public static final String STATION_NAME = "Station";

	public static final int NB_USER_MAX_STATION = 1000;
	public static final int NB_USER_MAX_RAILWAY = 300;
	
	public static final int ORIENTATION_MAX = 4;
	
	public static final int NORTH_DIRECTION = 0;
	public static final int SOUTH_DIRECTION = 1;
	public static final int EAST_DIRECTION = 2;
	public static final int WEST_DIRECTION = 3;
	
	public static final int RAIL_TIME = 5;
	
	/* CONSTANTS FOR STATS */
	
	public static final int STARTING_MONEY = 3000;
	public static final int MAX_MONEY = 10000000;
	public static final int GAINS_PER_COMMERCIAL_WORKER = 5;
	public static final int COSTS_PER_ADMINISTRATIVE = 100;
	public static final int COSTS_PER_ADMINISTRATIVE_WORKER = 10;

	public static final int MAX_HAB = 1000000;

	/* CONSTANTS FOR CALENDAR */
	public static final String DAYS[] = {"Monday", "Thursday", "Wednesday", "Tuesday", "Friday", "Saturday", "Sunday"};
	public static final String MONTHS[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
}
