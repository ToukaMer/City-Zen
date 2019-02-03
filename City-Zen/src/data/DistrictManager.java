package data;

public class DistrictManager {
	
	private District districts [] [];
	private RailRoad railRoads [] [];
	
public void printDistrictMap(District[][] district, int width, int height) {
		
		for(int i =0; i<width; i++) {
			for(int j=0; j<height; j++) {
				System.out.print("|"+district[i][j].getType()+"|");
			}
			System.out.println("\n------------------------------");
		}
		
		Stats.printStats();
		
		
	}
	
	public District[][] initDistrictMap(int width, int height){
		District[][] district = new District[width][height]; 
	
		for(int column =0; column<height; column++) {
			for(int row=0; row<width; row++) {
				if(((column*height)+row+1) == ((height*height/2)+(width/2))) // get the center of the map , +1 because it begins at 0
					district[column][row] = new Administrative(30, 100, 0, 100); // put the town center at the center
				else
				district[column][row] = new Wilderness();
			}
		}
		
		return district;
	}
	
	public void addResidence(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Residence(10, 0, 30);
			Stats.nbHab+=((Residence)district[width][height]).getNbHab();
			Stats.nbResidence++;
			
			System.out.println("nbHab: "+Stats.nbHab);
		}	
	}
	
	public void destroyResidence(District[][] district, int width, int height) {
		if(district[width][height].getType() != 2)
			System.out.println("This spot isnt a Residence!");
		else
		{
			Stats.nbResidence--;
			Stats.nbHab -= ((Residence) district[width][height]).getNbHab(); //voir pour virer le cast
			district[width][height] = new Wilderness();
			System.out.println("nbHab: "+Stats.nbHab);
			
		}
	}
	
	public void addAdministrative(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Administrative(10, 30, 0, 30);
			Stats.nbAdministrative++;
		}	
	}
	
	public void destroyAdministrative(District[][] district, int width, int height) {
		if(district[width][height].getType() != 1)
			System.out.println("This spot isnt an Adminitrative District!");
		else
		{
			Stats.nbAdministrative--;
			district[width][height] = new Wilderness();
		}
	}
	
	public void addCommercial(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Commercial(0, 30);
			Stats.nbCommercial++;
		}	
	}
	
	public void destroyCommercial(District[][] district, int width, int height) {
		if(district[width][height].getType() != 3)
			System.out.println("This spot isnt a Commercial District!");
		else
		{
			Stats.nbCommercial--;
			district[width][height] = new Wilderness();
		}
	}
	
	public void updateDistrict(District[][] district, int width, int height) {
		for(int column =0; column<height; column++) {
			for(int row=0; row<width; row++) {
				switch(district[column][row].getTypeName()) {
					case "Residence" : 
						((Residence)district[column][row]).incrementTurnCount();
						break;
					case "Administrative" :
						break;
					case "Commercial" :
						break;
					case "Wilderness" :
						break;
				}
			}
		}
	}
	

}
