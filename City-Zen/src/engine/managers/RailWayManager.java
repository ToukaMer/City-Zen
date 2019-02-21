package engine.managers;

import data.*;
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
	
	public void addRailWay (RailRoad[][] railRoadMap, Coordinates [] coord)
	{
		if((railRoadMap[coord[0].getRow()][coord[0].getColumns()].getType() != 2)&&(railRoadMap[coord[coord.length].getRow()][coord[coord.length].getColumns()].getType() != 2)) {
			
			int bool=0;
			
			for(int i=1; i<coord.length-1; i++) {
				if(railRoadMap[coord[i].getRow()][coord[i].getColumns()].getType() != 0)
					bool =1;
			}
			
			if(bool == 0) {
				for(int i=1; i<coord.length-1; i++) {
					railRoadMap[coord[i].getRow()][coord[i].getColumns()] = new RailWay();
				}
			}
			else System.out.println("There is an obstacle on the path\n");
			
		}
		else {
			System.out.println("That railway isnt connected to 2 stations\n");
		}
	}
	
	public void destroyRailWay(RailRoad[][] railRoadMap, int row, int column) {
		if(railRoadMap[row][column].getType() != 1)
			System.out.println("This spot isnt a RailWay!");
		else
		{
			railRoadMap[row][column]= new WildernessRR();
			
		}
	}
	
	public void addStation(RailRoad[][] railRoadMap, int row, int column)
	{//Fonction d'ajout d'une station.
		if(railRoadMap[row][column].getType() != 0 )
		{
			if (railRoadMap[row][column].getType() == 1)
			{//Si la case était occupé par une ligne de métro, on remplace celle ci par une nouvelle station.
				railRoadMap[row][column] = new Station(1, 1, 1);//
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
			railRoadMap[row][column] = new Station(1,1,1);
			Stats.nbStations++;
			
			System.out.println("station added, value : "+railRoadMap[row][column].getType());

			//Il faut definir les caractéristique de la station

		}	
	}
	
	public void destroyRailRoad(RailRoad[][] railRoadMap, int row, int column) 
	{//Detruit un élément de la carte
		if(railRoadMap[row][column].getType() == 0)
			System.out.println("There is no Railway or station in this place!");
		else
		{//L'objet WildernessRR est créer à la place.
			railRoadMap[row][column] = new WildernessRR();
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
