package data;

public class RailWayMapManager 
{
	public RailWayMapManager()
	{
	}
	public void printRailWayMap(RailRoad[][] railRoadMap, int width, int height)
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
	public RailRoad[][] initRailWayMap(int width, int height)
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
	public void addRailWay (RailRoad[][] railRoadMap, int row, int column)
	{//Fonction d'ajout d'un RailWay à la carte 
		if(railRoadMap[row][column].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
		//Add railway line
			railRoadMap[row][column] = new RailWay();
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
