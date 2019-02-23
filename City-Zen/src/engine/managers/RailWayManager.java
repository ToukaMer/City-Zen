package engine.managers;

import data.*;
import data.railRoadData.RailRoad;
import data.railRoadData.RailWay;
import data.railRoadData.Station;
import data.railRoadData.WildernessRR;

public class RailWayManager 
{
	public void printRailWay(RailRoad[][] railRoadMap, int width, int height)
	{//Trace la carte des m�tro sous terrain.
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
	{//Fonction d'initialisation de la carte du m�tro.
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
	
	public int addRailWay (RailRoad[][] railRoadMap, Coordinates [] coord)
	{//checking if both sides of the array are stations 
		if((railRoadMap[coord[0].getRow()][coord[0].getColumns()].getType() == Constants.STATION)&&(railRoadMap[coord[coord.length-1].getRow()][coord[coord.length-1].getColumns()].getType() == Constants.STATION)) {
			
			int bool=0;
			
			for(int i=1; i<coord.length-1; i++) {//checking if there is something in the way
				if(railRoadMap[coord[i].getRow()][coord[i].getColumns()].getType() != Constants.WILDERNESSRR)
					bool =1;
			}
			
			if(bool == 0) {
				for(int j=1; j<coord.length-1; j++) {
					railRoadMap[coord[j].getRow()][coord[j].getColumns()] = new RailWay(coord);
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
			return 3;
		}
	}
	
	public int destroyRailWay(RailRoad[][] railRoadMap, int row, int column) {
		Coordinates [] coord = ((RailWay) railRoadMap[row][column]).getCoord(); // we save the array of rails
		if(railRoadMap[row][column].getType() != 1) { // verifying if the cliqued object is a rail
			System.out.println("This spot isnt a RailWay!");
			return 2;
		}
			
		else
		{
			for(int i=1; i<coord.length-1; i++)
			railRoadMap[coord[i].getRow()][coord[i].getColumns()]= new WildernessRR(); // deleting each object that are in the coordinates of the array
			return 1;
		}
	}
	
	public void addStation(RailRoad[][] railRoadMap, int row, int column)
	{//Fonction d'ajout d'une station.
		if(railRoadMap[row][column].getType() != 0 )
		{
			if (railRoadMap[row][column].getType() == 1)
			{//Si la case �tait occup� par une ligne de m�tro, on remplace celle ci par une nouvelle station.
				railRoadMap[row][column] = new Station(1, 1, 1);//
				Stats.nbStations++;
				System.out.println("station added");

				//Il faut definir les caract�ristique de la station
			}
			else {
				System.out.println("This spot isnt empty!");
			}
		}
		else
		{
		//Add railway line
			railRoadMap[row][column] = new Station(1,1,1);
			Stats.nbStations++;
			
			System.out.println("station added, value : "+railRoadMap[row][column].getType());

			//Il faut definir les caract�ristique de la station

		}	
	}
	
	public void destroyStation(RailRoad[][] railRoadMap, int width, int height) 
	{//Detruit un �l�ment de la carte
		if(railRoadMap[width][height].getType() == 0)
			System.out.println("There is no Railway or station in this place!");
		else
		{//L'objet WildernessRR est cr�er � la place.
			
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
