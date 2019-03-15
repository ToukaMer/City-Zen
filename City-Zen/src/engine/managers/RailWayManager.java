package engine.managers;

import java.util.ArrayList;

import data.*;
import data.districtData.District;
import data.railRoadData.RailRoad;
import data.railRoadData.RailWay;
import data.railRoadData.Station;
import data.railRoadData.WildernessRR;

public class RailWayManager 
{
	public void printRailWay(RailRoad[][] railRoadMap, int width, int height)
	{//Trace la carte des métro sous terrain.
		for(int i =0; i<width; i++) 
		{
			for(int j=0; j<height; j++) 
			{
				System.out.print("|"+railRoadMap[i][j].getType()+"|");
			}
			System.out.println("\n------------------------------");
		}
	}
	
	public RailRoad[][] initRailWay(int width, int height)
	{//Fonction d'initialisation de la carte du métro.
		//La carte est initialement vide, donc on la parcours en 2D et on la rempli de WildernessRR
		RailRoad[][] railRoadMap = new RailRoad[width][height]; 
		for(int column =0; column<height; column++) 
		{
			for(int row=0; row<width; row++) 
			{
				railRoadMap[column][row] = new WildernessRR();
			}
		}
		
		return railRoadMap;
	}
	
	public int addRailWay (RailRoad[][] railRoadMap, ArrayList<Coordinates> coord, Coordinates stationDepart, Coordinates stationArrivee)
	{//checking if both sides of the array are stations 
		if((railRoadMap[stationDepart.getColumn()][stationDepart.getRow()].getType() == Constants.STATION)&&(railRoadMap[stationArrivee.getColumn()][stationArrivee.getRow()].getType() == Constants.STATION)) {
				boolean bool=true;
				boolean [] orientation = {false,false,false,false};
			for(int i=1; i<coord.size(); i++) {//checking if there is something in the way
				if(railRoadMap[coord.get(i).getColumn()][coord.get(i).getRow()].getType() != Constants.WILDERNESSRR && railRoadMap[coord.get(i).getColumn()][coord.get(i).getRow()].getType() != Constants.RAILWAY)
					bool =false;
			}
			
			if(bool) {
				for(int j=0; j<coord.size(); j++) {
					//i need to replace so it does tab[column][row]
					//look around to make the boolean
				
					//check where the next is and place boolean accordingly
					if(j<coord.size()-2) {
						
						if(coord.get(j+1).getRow() - coord.get(j).getRow()>0)
							orientation[Constants.SOUTH_DIRECTION]=true;
						else orientation[Constants.NORTH_DIRECTION]=true;
						
						if(coord.get(j+1).getColumn() - coord.get(j).getColumn()>0)
							orientation[Constants.EAST_DIRECTION]=true;
						else orientation[Constants.WEST_DIRECTION]=true;
							
					}
					
					//check where is the begin/end station to put orientation too;
					if(j==0) {
						if(stationDepart.getColumn()>coord.get(j).getColumn())
							orientation[Constants.EAST_DIRECTION]=true;
						else if(stationDepart.getColumn()<coord.get(j).getColumn())
							orientation[Constants.WEST_DIRECTION]=true;
						if(stationDepart.getRow()>coord.get(j).getRow())
							orientation[Constants.SOUTH_DIRECTION]=true;
						else if(stationDepart.getRow()<coord.get(j).getRow())
							orientation[Constants.NORTH_DIRECTION]=true;
					}
					
					if(j==coord.size()-2) {
						if(stationArrivee.getColumn()>coord.get(j).getColumn())
							orientation[Constants.EAST_DIRECTION]=true;
						else if(stationArrivee.getColumn()<coord.get(j).getColumn())
							orientation[Constants.WEST_DIRECTION]=true;
						if(stationArrivee.getRow()>coord.get(j).getRow())
							orientation[Constants.SOUTH_DIRECTION]=true;
						else if(stationArrivee.getRow()<coord.get(j).getRow())
							orientation[Constants.NORTH_DIRECTION]=true;
					}
					
					
			
					railRoadMap[coord.get(j).getColumn()][coord.get(j).getRow()] = new RailWay(coord);
					railRoadMap[coord.get(j).getColumn()][coord.get(j).getRow()].setOrientation(orientation);
					System.out.println("x="+coord.get(j).getColumn()+" y="+coord.get(j).getRow()+" \n {n,s,e,w} = {"+orientation[0]+","+orientation[1]+","+orientation[2]+","+orientation[3]+"} \n");
				
					updateStationOrientation(railRoadMap, stationDepart.getColumn(), stationDepart.getRow());
					updateStationOrientation(railRoadMap, stationArrivee.getColumn(), stationArrivee.getRow());
				}
				return 1;
			}
			else {
				System.out.println("There is an obstacle on the path\n");
				return 2;
			}
			
		}
		else {
			System.out.println("That railway isnt connected to 2 stations\n");
			System.out.println("Depart type: "+railRoadMap[stationDepart.getColumn()][stationDepart.getRow()].getType()+"\n Arrivee type :"+railRoadMap[stationArrivee.getRow()][stationArrivee.getColumn()].getType()+"\n");
			return 3;
		}
	}
	
	public int destroyRailWay(RailRoad[][] railRoadMap, int column, int row) {
		ArrayList<Coordinates> coord  = ((RailWay) railRoadMap[column][row]).getCoord(); // we save the array of rails
		if(railRoadMap[column][row].getType() != 1) { // verifying if the cliqued object is a rail
			System.out.println("This spot isnt a RailWay!");
			return 2;
		}
			
		else
		{
			for(int i=1; i<coord.size(); i++) {
				boolean[] orientation = railRoadMap[column][row].getOrientation();
				
				if((orientation[1] ? 1 :0) + (orientation[2] ? 1 :0) + (orientation[3] ? 1 : 0) + (orientation[4] ? 1 :0)==2)
					railRoadMap[coord.get(i).getColumn()][coord.get(i).getRow()]= new WildernessRR(); // deleting each object that are in the coordinates of the array
				else {
					if(i<coord.size()) { // we check whats the orientation of what we are destroying and substract it to keep the right orientation 
						if(coord.get(i+1).getRow() - coord.get(i).getRow()>0)
							orientation[Constants.SOUTH_DIRECTION]=true;
						else orientation[Constants.NORTH_DIRECTION]=true;
						
						if(coord.get(i+1).getColumn() - coord.get(i).getColumn()>0)
							orientation[Constants.EAST_DIRECTION]=true;
						else orientation[Constants.WEST_DIRECTION]=true;
						
					(railRoadMap[coord.get(i).getColumn()][coord.get(i).getRow()]).setOrientation(orientation);
					}
				}
			}
			
			return 1;
		}
	}
	
	public void addStation(RailRoad[][] railRoadMap, int column, int row, District[][] district)
	{//Fonction d'ajout d'une station.
		if(district[column][row].getType() != 0 ) {
			if(railRoadMap[column][row].getType() != 0 && railRoadMap[column][row].getType() != 1 )
			{
				if (railRoadMap[column][row].getType() == 1)
				{//Si la case était occupé par une ligne de métro, on remplace celle ci par une nouvelle station.
					railRoadMap[column][row] = new Station(1, 1, 1);//
					Stats.nbStations++;
					System.out.println("station added");

					//Il faut definir les caractéristique de la station
				}
				else {
					System.out.println("This spot isnt empty!");
				}
			}
			else
			{
			//Add railway line
				railRoadMap[column][row] = new Station(1,1,1);
				boolean [] orientation = {false,false,false,false};
				Stats.nbStations++;
				
						//look around to make the boolean
						
						if((column-1)>0) //top//left
							if(railRoadMap[column-1][row].getType()==Constants.RAILWAY || railRoadMap[column-1][row].getType()==Constants.STATION)
								orientation[Constants.WEST_DIRECTION] = true;
						
						if((row+1)>Stats.WIDTH)//right//south
							if(railRoadMap[column][row+1].getType()==Constants.RAILWAY || railRoadMap[column][row+1].getType()==Constants.STATION)
									orientation[Constants.SOUTH_DIRECTION] = true;
						if((column+1)<Stats.HEIGHT)//bottom//right
							if(railRoadMap[column+1][row].getType()==Constants.RAILWAY || railRoadMap[column+1][row].getType()==Constants.STATION)
									orientation[Constants.EAST_DIRECTION] = true;
						if((row-1) > 0) //left//north
							if(railRoadMap[column][row-1].getType()==Constants.RAILWAY || railRoadMap[column][row-1].getType()==Constants.STATION)
									orientation[Constants.NORTH_DIRECTION] = true;
						
						

			railRoadMap[column][row].setOrientation(orientation);
			System.out.println("x="+column+" y="+row+" \n {n,s,e,w} = {"+orientation[Constants.NORTH_DIRECTION]+","+orientation[Constants.SOUTH_DIRECTION]+","+orientation[Constants.EAST_DIRECTION]+","+orientation[Constants.WEST_DIRECTION]+"} \n");
					
				
				System.out.println("station added, value : "+railRoadMap[column][row].getType());

				//Il faut definir les caractéristique de la station

			}	
		}
	}
	
	public void updateStationOrientation(RailRoad[][] railRoadMap, int column, int row) {
		boolean [] orientation = {false,false,false,false};
		Stats.nbStations++;
		
				//look around to make the boolean
				
				if((column-1)>0) //top//left
					if(railRoadMap[column-1][row].getType()==Constants.RAILWAY || railRoadMap[column-1][row].getType()==Constants.STATION)
						orientation[Constants.WEST_DIRECTION] = true;
				
				if((row+1)>Stats.WIDTH)//right//south
					if(railRoadMap[column][row+1].getType()==Constants.RAILWAY || railRoadMap[column][row+1].getType()==Constants.STATION)
							orientation[Constants.SOUTH_DIRECTION] = true;
				if((column+1)<Stats.HEIGHT)//bottom//right
					if(railRoadMap[column+1][row].getType()==Constants.RAILWAY || railRoadMap[column+1][row].getType()==Constants.STATION)
							orientation[Constants.EAST_DIRECTION] = true;
				if((row-1) > 0) //left//north
					if(railRoadMap[column][row-1].getType()==Constants.RAILWAY || railRoadMap[column][row-1].getType()==Constants.STATION)
							orientation[Constants.NORTH_DIRECTION] = true;
				
				railRoadMap[column][row].setOrientation(orientation);
		
	}
	
	public void destroyStation(RailRoad[][] railRoadMap, int width, int height) 
	{//Detruit un élément de la carte
		if(railRoadMap[width][height].getType() == 0)
			System.out.println("There is no Railway or station in this place!");
		else
		{//L'objet WildernessRR est créé à la place.
			
				if((width-1) > 0) //left
					if(railRoadMap[width-1][height].getType()==Constants.RAILWAY)
						destroyRailWay(railRoadMap, width-1, height);
				if((height+1)<Stats.HEIGHT)//bottom
					if(railRoadMap[width][height+1].getType()==Constants.RAILWAY)
						destroyRailWay(railRoadMap, width, height+1);
				if((width+1)>Stats.WIDTH)//right
					if(railRoadMap[width+1][height].getType()==Constants.RAILWAY)
						destroyRailWay(railRoadMap, width+1, height);
				if((height-1)>0) //top
					if(railRoadMap[width][height-1].getType()==Constants.RAILWAY)
						destroyRailWay(railRoadMap, width, height-1);
				
				railRoadMap[width][height] = new WildernessRR();
		}
	}
	
	public void updateRailRoadMap(RailRoad[][] railRoadMap, int width, int height)
	{//Fonction d'actualisation de la RailRoadMap.
		for(int column =0; column<height; column++) 
		{
			for(int row=0; row<width; row++) 
			{
				//railRoadMap[column][row] = new WildernessRR();
			}
		}
	}
	
}
