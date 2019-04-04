package data.railRoadData;

import java.util.HashMap;
import java.util.Map;

import data.Constants;
import data.Coordinates;

public class Station extends RailSquare{
	private int nbUsers;
	private int nbMaxUsers;
	private int revenues;
	private int[] direction;
	private HashMap<Coordinates, RailWay> railWays;
	
	public Station(Coordinates coordinates, int nbUsers, int nbMaxUsers, int revenues, int[] direction, HashMap<Coordinates, RailWay> railWays) {
		super(Constants.STATION, Constants.STATION_NAME, coordinates);
		this.nbUsers = nbUsers;
		this.nbMaxUsers = nbMaxUsers;
		this.revenues = revenues;
		this.direction = direction;
		this.railWays = railWays;
	}
	public Station(Coordinates coordinates, int[] direction) {
		this(coordinates, 0, Constants.NB_USER_MAX_STATION, 0, direction, new HashMap<Coordinates, RailWay>());
	}
	
	public String toString_rails() {
		String data = new String();
		for (Map.Entry<Coordinates, RailWay> entry : railWays.entrySet()) {			
			data.concat(this.getCoordinates().toString());	
		    data.concat(entry.getValue().toString_rails_list());
			data.concat(entry.getKey().toString());
			data.concat("\n");
		}

		data.concat("\n");
		return data;
	}

	public int getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(int nbUsers) {
		this.nbUsers = nbUsers;
	}

	public int getNbMaxUsers() {
		return nbMaxUsers;
	}

	public void setNbMaxUsers(int nbMaxUsers) {
		this.nbMaxUsers = nbMaxUsers;
	}

	public int getRevenues() {
		return revenues;
	}

	public void setRevenues(int revenues) {
		this.revenues = revenues;
	}
	public HashMap<Coordinates, RailWay> getRailWays() {
		return railWays;
	}
	public void setRailWays(HashMap<Coordinates, RailWay> railWays) {
		this.railWays = railWays;
	}
	public int[] getDirection() {
		return direction;
	}
	public void setDirection(int[] direction) {
		this.direction = direction;
	}
}
