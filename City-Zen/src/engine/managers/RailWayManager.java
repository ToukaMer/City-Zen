package engine.managers;

import java.util.ArrayList;
import java.util.Map.Entry;


import data.*;
import data.districtData.TripPath;
import data.railRoadData.NotRailed;
import data.railRoadData.Rail;
import data.railRoadData.RailSquare;
import data.railRoadData.RailWay;
import data.railRoadData.Station;
import engine.Game;
import gui_data.GuiConstants;

public final class RailWayManager 
{
//	
//	public static void printRailWay()
//	{//Trace la carte des métro sous terrain.
//		for(int i =0; i<GuiConstants.SQUARE_PER_COLUMN; i++) 
//		{
//			for(int j=0; j<GuiConstants.SQUARE_PER_ROW; j++) 
//			{
//				System.out.print("|"+Game.getINSTANCE().getRailRoadMap().getType()+"|");
//			}
//			System.out.println("\n------------------------------");
//		}
//	}
//	
//	
	public static RailSquare[][] initRailSquareMap(){
		
		RailSquare railSquare[][] = new RailSquare[GuiConstants.SQUARE_PER_COLUMN][GuiConstants.SQUARE_PER_ROW];
		for(int column = 0; column<GuiConstants.SQUARE_PER_ROW; column++) 
		{
			for(int row= 0; row<GuiConstants.SQUARE_PER_COLUMN; row++) 
			{
				railSquare[column][row] = new NotRailed(new Coordinates(row, column));
			}
		}
		return railSquare;
	}

	public static void incrementNbStation() {
		Game.getINSTANCE().getStats().setNbStations(Game.getINSTANCE().getStats().getNbStations()+1);
	}
	public static void decrementNbStation() {
		Game.getINSTANCE().getStats().setNbStations(Game.getINSTANCE().getStats().getNbStations()-1);
	}
	
	public static void addRailWay (ArrayList<Coordinates> coord, Coordinates stationDepart, Coordinates stationArrivee){
		//checking if both sides of the array are stations 
		if((Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()].getType() == Constants.STATION)
				&& ((Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()].getType() 
						== Constants.STATION))) {
			boolean stationInTheMiddle = false;
			boolean validRailWay = true;
			for(Coordinates current : coord) {//checking if there is something in the way
				if(current.getColumn() < 0 || current.getColumn() >= GuiConstants.SQUARE_PER_COLUMN) {
					validRailWay = false;
				}
				else if(current.getRow() < 0 || current.getRow() >= GuiConstants.SQUARE_PER_ROW) {
					validRailWay = false;
				}
				else if(Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()].getType() == Constants.STATION) {
					//If there is a station in the way, split it in two parts and create a line going to the station and coming from it
					stationInTheMiddle = true;
					ArrayList<Coordinates> firstPart = new ArrayList<Coordinates>();
					ArrayList<Coordinates> secondPart = new ArrayList<Coordinates>();
					for(int i = 0; i< coord.size(); i++) {
						if(i < coord.indexOf(current)) {
							firstPart.add(coord.get(i));
						}
						else if(i > coord.indexOf(current)) {
							secondPart.add(coord.get(i));
						}
					}
					addRailWay(firstPart, stationDepart, current);
					addRailWay(secondPart, current, stationArrivee);
				}
			}
			
			if(!stationInTheMiddle && validRailWay) {
				if(((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getRailWays().containsKey(stationArrivee)) {
					System.out.println("There is already a railway between those stations");
				}
				else {
					ArrayList<Coordinates> coordinates = new ArrayList<>();
					//Create rails if necessary
					for(Coordinates current : coord) {
						if(Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()].getType() == Constants.NOT_RAILED) {
							int[] direction = new int[4];
							direction[0] = 0; 
							direction[1] = 0; 
							direction[2] = 0; 
							direction[3] = 0; 
							Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()] = new Rail(current, direction);
						}
						//Set all the rails in an arrayList that will be used to create the RailWay object
						coordinates.add(current);
					}

					//Verify next square in the list to decide of the direction
					for(Coordinates current : coordinates) {
						//Set directions for ArrayList<Coordinates>
						int[] direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()]).getDirection();
	 					if(coord.indexOf(current) > 0) {
	 						if(current.getColumn() < coord.get(coord.indexOf(current)-1).getColumn()) {
	 							direction[Constants.EAST_DIRECTION]++;
	 						}
	 						else if(current.getColumn() > coord.get(coord.indexOf(current)-1).getColumn()) {
	 							direction[Constants.WEST_DIRECTION]++;
	 	 					}
	 						else if(current.getRow() > coord.get(coord.indexOf(current)-1).getRow()) {
	 							direction[Constants.NORTH_DIRECTION]++;
		 					}
	 						else {
	 							direction[Constants.SOUTH_DIRECTION]++;
	 						}
						}
	 					if(coord.indexOf(current) < coordinates.size()-1) {
	 						if(current.getColumn() < coordinates.get(coordinates.indexOf(current)+1).getColumn()) {
	 							direction[Constants.EAST_DIRECTION]++;
	 						}
	 						else if(current.getColumn() > coordinates.get(coordinates.indexOf(current)+1).getColumn()) {
	 							direction[Constants.WEST_DIRECTION]++;
	 	 					}
	 						else if(current.getRow() > coordinates.get(coordinates.indexOf(current)+1).getRow()) {
	 							direction[Constants.NORTH_DIRECTION]++;
		 					}
	 						else {
	 							direction[Constants.SOUTH_DIRECTION]++;
	 						}
						}
	 					((Rail)Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()]).setDirection(direction);
					}
					//Set directions for starting station
					if(coordinates.size() > 0) {
						if(stationDepart.getColumn() < coordinates.get(0).getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
						}
						else if(stationDepart.getColumn() > coord.get(0).getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
						}
						else if(stationDepart.getRow() < coord.get(0).getRow()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
						}
						else {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(0).getColumn()][coordinates.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
						}
	
						//Set directions for arrival station
						if(stationArrivee.getColumn() < coordinates.get(coordinates.size()-1).getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
						}
						else if(stationArrivee.getColumn() > coordinates.get(coordinates.size()-1).getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
						}
						else if(stationArrivee.getRow() < coord.get(coord.size()-1).getRow()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
						}
						else {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
							direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Rail)Game.getINSTANCE().getRailSquareMap()[coordinates.get(coordinates.size()-1).getColumn()][coordinates.get(coordinates.size()-1).getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
						}	
					}
					else {
						//Case there is no middle square in the railway
						if(stationDepart.getColumn() < stationArrivee.getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
							direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
						}
						else if(stationDepart.getColumn() > stationArrivee.getColumn()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.WEST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction+1;
							direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.EAST_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction+1;
						}
						else if(stationDepart.getRow() < stationArrivee.getRow()) {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
							direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
						}
						else {
							int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction+1;
							direction = ((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
							((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction+1;
						}
					}
					
					RailWay railWay = new RailWay(coordinates, Constants.RAIL_TIME*coordinates.size()+2);
					((Station)Game.getINSTANCE().getRailSquareMap()[stationDepart.getColumn()][stationDepart.getRow()]).getRailWays().put(stationArrivee, railWay);
					if(Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().containsKey(stationDepart)) {
						if(railWay.getTripTime() < Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().get(stationArrivee).getTripTime()) {
							TripPath tripPath = new TripPath(coordinates, railWay.getTripTime());
							Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().put(stationArrivee, tripPath);
						}
					}
					else {
						TripPath tripPath = new TripPath(coordinates, railWay.getTripTime());
						Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().put(stationArrivee, tripPath);
					}
					
					//Create also the reversed railway, starting from the arrival station
					ArrayList<Coordinates> reversedCoordinates = new ArrayList<Coordinates>();
					for(int i = coordinates.size()-1; i >= 0; i--) {
						reversedCoordinates.add(coordinates.get(i));
					}
					RailWay reversedRailWay = new RailWay(reversedCoordinates, Constants.RAIL_TIME*coordinates.size()+2);
					((Station)Game.getINSTANCE().getRailSquareMap()[stationArrivee.getColumn()][stationArrivee.getRow()]).getRailWays().put(stationDepart, reversedRailWay);
					if(Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().containsKey(stationDepart)) {
						if(railWay.getTripTime() < Game.getINSTANCE().getDistrictMap()[stationDepart.getColumn()][stationDepart.getRow()].getTripPaths().get(stationArrivee).getTripTime()) {
							TripPath tripPath = new TripPath(reversedCoordinates, railWay.getTripTime());
							Game.getINSTANCE().getDistrictMap()[stationArrivee.getColumn()][stationArrivee.getRow()].getTripPaths().put(stationDepart, tripPath);
						}
					}
					else {
						TripPath tripPath = new TripPath(reversedCoordinates, railWay.getTripTime());
						Game.getINSTANCE().getDistrictMap()[stationArrivee.getColumn()][stationArrivee.getRow()].getTripPaths().put(stationDepart, tripPath);
					}
				}
			}
			else if(!validRailWay){
				System.out.println("Invalid railway");
			}
		}
	}

	public static void destroyRailWay(Coordinates startingStation, Coordinates arrivalStation) {
		if(Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()].getType() != Constants.STATION) {
			System.out.println("Starting coordinates are not station coordinates");
		}
		else if(Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()].getType() != Constants.STATION) {
			System.out.println("Arrival coordinates are not station coordinates");
		}
		else {
			if(((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getRailWays().containsKey(arrivalStation)){
				ArrayList<Coordinates> coord = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getRailWays().get(arrivalStation).getRails();
				
				if(coord.size()>0) {
					for(Coordinates current : coord) {
						int[] direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection();
						int index = coord.indexOf(current);
						if(index > 0) {
							if(current.getColumn() < coord.get(coord.indexOf(current)-1).getColumn()) {
								direction[Constants.WEST_DIRECTION]--;
							}
							else if(current.getColumn() > coord.get(coord.indexOf(current)-1).getColumn()) {
								direction[Constants.EAST_DIRECTION]--;
		 					}
							else if(current.getRow() > coord.get(coord.indexOf(current)-1).getRow()) {
								direction[Constants.SOUTH_DIRECTION]--;
							}
							else {
								direction[Constants.NORTH_DIRECTION]--;
							}
						}
						if(index < coord.size()-1) {
							if(current.getColumn() < coord.get(coord.indexOf(current)+1).getColumn()) {
								direction[Constants.WEST_DIRECTION]--;
							}
							else if(current.getColumn() > coord.get(coord.indexOf(current)+1).getColumn()) {
								direction[Constants.EAST_DIRECTION]--;
		 					}
							else if(current.getRow() > coord.get(coord.indexOf(current)+1).getRow()) {
								direction[Constants.SOUTH_DIRECTION]--;
							}
							else {
								direction[Constants.NORTH_DIRECTION]--;
							}
						}
						((Rail)Game.getINSTANCE().getRailSquareMap()[current.getColumn()][current.getRow()]).setDirection(direction);
					}
					//Set directions for starting station
					if(startingStation.getColumn() < coord.get(0).getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
					}
					else if(startingStation.getColumn() > coord.get(0).getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
					}
					else if(startingStation.getRow() < coord.get(0).getRow()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
					}
					else {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
					}
		
					//Set directions for arrival station
					if(arrivalStation.getColumn() < coord.get(coord.size()-1).getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
					}
					else if(arrivalStation.getColumn() > coord.get(coord.size()-1).getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
					}
					else if(arrivalStation.getRow() < coord.get(coord.size()-1).getRow()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
					}
					else {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
						direction = ((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Rail)Game.getINSTANCE().getRailSquareMap()[coord.get(0).getColumn()][coord.get(0).getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
					}	
				}
				else {
					//Case there is no middle square in the railway
					if(startingStation.getColumn() < arrivalStation.getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
						direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
					}
					else if(startingStation.getColumn() > arrivalStation.getColumn()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.WEST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.WEST_DIRECTION] = direction-1;
						direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.EAST_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.EAST_DIRECTION] = direction-1;
					}
					else if(startingStation.getRow() < arrivalStation.getRow()) {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
						direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
					}
					else {
						int direction = ((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getDirection()[Constants.NORTH_DIRECTION] = direction-1;
						direction = ((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION];
						((Station)Game.getINSTANCE().getRailSquareMap()[arrivalStation.getColumn()][arrivalStation.getRow()]).getDirection()[Constants.SOUTH_DIRECTION] = direction-1;
					}
				}
				((Station)Game.getINSTANCE().getRailSquareMap()[startingStation.getColumn()][startingStation.getRow()]).getRailWays().remove(arrivalStation);
			}
			else {
				System.out.println("No railway between those stations");
			}
		}
	}
	
	public static void addStation(Coordinates coordinates){
		if(Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()].getType() == Constants.NOT_RAILED) {
			if(Game.getINSTANCE().getDistrictMap()[coordinates.getColumn()][coordinates.getRow()].getType() != Constants.WILDERNESS) {
				int direction[] = new int[4];
				direction[0] = direction[1] = direction[2] = direction[3] = 0;
				Station station = new Station(coordinates, direction);
				Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()] = station;
				/***** FAIRE DIJKSTRA *****/
			}
			else {
				System.out.println("This square has no district on it");
			}
		}
		else {
			System.out.println("This square is already used");
		}
//		for(int i = 0 ; i < GuiConstants.SQUARE_PER_COLUMN; i++) {
//			for(int j = 0 ; j < GuiConstants.SQUARE_PER_ROW; j++) {
//				System.out.print(Game.getINSTANCE().getRailSquareMap()[j][i].getType());
//			}
//			System.out.println();
//		}
	}
	
	public static void destroyStation(Coordinates coordinates) {
		if(Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()].getType() == Constants.STATION) {
			for(Entry<Coordinates, RailWay> entry : ((Station)Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()]).getRailWays().entrySet()) {
				destroyRailWay(coordinates, entry.getKey());
			}
			Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()] = new NotRailed(coordinates);
			/***** FAIRE DIJKSTRA *****/
		}
		else {
			System.out.println("There is no station on this square");
		}
	}
	
}
