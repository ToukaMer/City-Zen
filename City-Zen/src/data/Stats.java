package data;

public abstract class Stats {
	public static int money=3000; //begin game with 100 to buy shit
	public static int monthlyRevenues=0;
	public static int monthlyExpences=0;
	
	public static int nbHab=0;
	public static int nbMaxHab=0;
	
	public static int nbWorkersAdministrative=0;
	public static int nbWorkersCommercial=0;
	
	public static int nbMaxWorkersCommercial=0;
	public static int nbMaxWorkersAdministrative=0;
	
	public static int nbResidence=0;
	public static int nbCommercial=0;
	public static int nbAdministrative=0;
	public static int nbStations=0;
	
	public static int maxMoney=10000000;
	
	public static int moneyAmountPerHab=10;
	public static int moneyAmountPerCommercialWorker=5;
	public static int expencesPerAdministrativeBuildings=100;
	public static int expencesPerAdministrativeWorker=10;
	
	//public static District districts [] [];
	//public static RailRoad railRoads [] [];
	
	public static void printStats() {
		System.out.println("\nmoney:" +money+"\n"+ 
				"monthlyRevenues:" +monthlyRevenues+"\n" + 
				"monthlyExpences:" +monthlyExpences+"\n" + 
				"nbHab: "+nbHab+"\n" +
				"nbMaxHab: "+nbMaxHab+"\n" +
				"nbWorkersAdministrative: "+nbWorkersAdministrative+"\n" + 
				"nbMaxWorkersAdministrative: "+nbMaxWorkersAdministrative+"\n" + 
				"nbWorkersCommercial: "+nbWorkersCommercial+"\n" +
				"nbMaxWorkersCommercial: "+nbMaxWorkersCommercial+"\n" +  
				"nbResidence: "+nbResidence+"\n" + 
				"nbCommercial: "+nbCommercial+"\n" + 
				"nbAdministrative: "+nbAdministrative+"\n" + 
				"maxMoney: "+maxMoney+"\n" + 
				"nbStations: "+nbStations+"\n");
	}
	
}