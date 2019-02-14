package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Game {
	
	
	public Game(int width, int height) {
		super();

		
	}
	
	public void initMaps(int width, int height) {
		DistrictManager districtmanager = new DistrictManager();
		RailWayMapManager railwaymanager = new RailWayMapManager();
		District[][] district = districtmanager.initDistrictMap(width, height);//cree une map de la surface 
		RailRoad[][] railroad = railwaymanager.initRailWayMap(width, height);//-- du metro
	}
	
	public void Turn(int firstTurn, String command, int xCoord, int yCoord, DistrictManager districtmanager, RailWayMapManager railwaymanager, int width, int height, District[][] district, RailRoad[][] railroad) {
		
		if(firstTurn ==1) {
			Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
			districtmanager.updateDistrict(district, width, height);
		}
		
		switch(command) {
		case "addResidence":
								districtmanager.addResidence(district, xCoord, yCoord);
								break;
		case "destroyResidence":
									districtmanager.destroyResidence(district, xCoord, yCoord);
									break;
		case "addCommercial":
									districtmanager.addCommercial(district, xCoord, yCoord);
									break;
		case "destroyCommercial": 
									districtmanager.destroyCommercial(district, xCoord, yCoord);
									break;
		case "addAdministrative":
									districtmanager.addAdministrative(district, xCoord, yCoord);
									break;
		case "destroyAdministrative": 
									districtmanager.destroyAdministrative(district, xCoord, yCoord);
									break;
		case "buildRailWay": 
									railwaymanager.addRailWay(railroad, xCoord, yCoord);
									break;
		case "buildStation": 
									railwaymanager.addStation(railroad, xCoord, yCoord);
									break;
		case "destroyRailRoad": 
									railwaymanager.destroyRailRoad(railroad, xCoord, yCoord);
									break;
		case "save" :								save();
									break;
		default: break;
	
							
	}
				
		
		
		districtmanager.updateDistrict(district, width, height);
		railwaymanager.updateRailRoadMap(railroad, width, height);
		moneyManager();
	}
	
	public void consoleTest(DistrictManager districtmanager, RailWayMapManager railwaymanager, int width, int height, District[][] district, RailRoad[][] railroad) {

		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
		districtmanager.updateDistrict(district, width, height);
		
		//-----------------------------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		String scan="";
		int widthScan;
		int heightScan;
		
		System.out.println("newGame or loadGame?\n");
		
		scan = sc.nextLine();
		
		
		do {
			switch(scan) {
				case "newGame" : System.out.println("New game started\n");
									break;
				case "loadGame" : System.out.println("Loading last game\n");
									load();
									break;
				default : break;
			}
		}while(!scan.equals("newGame")&&!scan.equals("loadGame"));
		
		
	while(!scan.equals("endGame")) 
	{
		System.out.println("Print DistrictMap\n");
		districtmanager.printDistrictMap(district, width, height);
		
		 System.out.println("Print RailWayNetwork Map\n");
		railwaymanager.printRailWayMap(railroad, width, height);
		
			scan = sc.nextLine();
			//railwaymanager.addStation(railroad, 3, 3);
			
			//logs System.out.println("input :"+scan+"\n");
		
		
		switch(scan) {
			case "addResidence": System.out.println("width?");
									widthScan = sc.nextInt();
									System.out.println("height?");
									heightScan = sc.nextInt();
									districtmanager.addResidence(district, widthScan, heightScan);
									scan = sc.nextLine();
									break;
			case "destroyResidence": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyResidence(district, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "addCommercial": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.addCommercial(district, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "destroyCommercial": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyCommercial(district, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "addAdministrative": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.addAdministrative(district, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "destroyAdministrative": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyAdministrative(district, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "buildRailWay": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										railwaymanager.addRailWay(railroad, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "buildStation": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										railwaymanager.addStation(railroad, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "destroyRailRoad": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										railwaymanager.destroyRailRoad(railroad, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "save" :	System.out.println("Game Saved");
										save();
										break;
			case "endGame" :	System.out.println("Closing Game\n");	
								break;
		
								
		}
		
		
		districtmanager.updateDistrict(district, width, height);
		railwaymanager.updateRailRoadMap(railroad, width, height);
		moneyManager();
	}
	
	sc.close();
	}
	public void moneyManager() {
		Stats.monthlyRevenues=(Stats.nbHab*Stats.moneyAmountPerHab)+(Stats.nbWorkersCommercial*Stats.moneyAmountPerCommercialWorker);
		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
		Stats.money+=(Stats.monthlyRevenues-Stats.monthlyExpences);
	}
	
	public void load() {
		Properties prop = new Properties();
	    InputStream input = null;

	    try {

	        input = new FileInputStream("config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        Stats.money=Integer.parseInt(prop.getProperty("money"));
	        Stats.monthlyRevenues=Integer.parseInt(prop.getProperty("monthlyRevenues"));
	        Stats.monthlyExpences=Integer.parseInt(prop.getProperty("monthlyExpences"));
	        Stats.nbHab=Integer.parseInt(prop.getProperty("nbHab"));
	        Stats.nbMaxHab=Integer.parseInt( prop.getProperty("nbMaxHab"));
	        Stats.nbWorkersAdministrative=Integer.parseInt(  prop.getProperty("nbWorkersAdministrative"));
		    Stats.nbWorkersCommercial=Integer.parseInt( prop.getProperty("nbWorkersCommercial"));
		    Stats.nbMaxWorkersCommercial=Integer.parseInt( prop.getProperty("nbMaxWorkersCommercial"));
            Stats.nbMaxWorkersAdministrative=Integer.parseInt(prop.getProperty("nbMaxWorkersAdministrative"));
	        Stats.nbResidence=Integer.parseInt(prop.getProperty("nbResidence"));
		    Stats.nbCommercial=Integer.parseInt(prop.getProperty("nbCommercial"));
		    Stats.nbAdministrative=Integer.parseInt(prop.getProperty("nbAdministrative"));
		    Stats.nbStations=Integer.parseInt( prop.getProperty("nbStations"));
		    Stats.maxMoney=Integer.parseInt( prop.getProperty("maxMoney"));
		    Stats.moneyAmountPerHab=Integer.parseInt( prop.getProperty("moneyAmountPerHab"));
		    Stats.moneyAmountPerCommercialWorker=Integer.parseInt(prop.getProperty("moneyAmountPerCommercialWorker"));
		    Stats.expencesPerAdministrativeBuildings=Integer.parseInt(prop.getProperty("expencesPerAdministrativeBuildings"));
		    Stats.expencesPerAdministrativeWorker=Integer.parseInt(prop.getProperty("expencesPerAdministrativeWorker"));
		       

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public void save() {
		Properties prop = new Properties();
	    InputStream input = null;

	    try {

	        input = new FileInputStream("config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	       prop.setProperty("money", Integer.toString(Stats.money));
	       prop.setProperty("monthlyRevenues", Integer.toString(Stats.monthlyRevenues));
	       prop.setProperty("monthlyExpences", Integer.toString(Stats.monthlyExpences));
	       prop.setProperty("nbHab", Integer.toString(Stats.nbHab));
	       prop.setProperty("nbMaxHab", Integer.toString(Stats.nbMaxHab));
	       prop.setProperty("nbWorkersAdministrative", Integer.toString(Stats.nbWorkersAdministrative));
	       prop.setProperty("nbWorkersCommercial", Integer.toString(Stats.nbWorkersCommercial));
	       prop.setProperty("nbMaxWorkersCommercial", Integer.toString(Stats.nbMaxWorkersCommercial));
	       prop.setProperty("nbMaxWorkersAdministrative", Integer.toString(Stats.nbMaxWorkersAdministrative));
	       prop.setProperty("nbResidence", Integer.toString(Stats.nbResidence));
	       prop.setProperty("nbCommercial", Integer.toString(Stats.nbCommercial));
	       prop.setProperty("nbAdministrative", Integer.toString(Stats.nbAdministrative));
	       prop.setProperty("nbStations", Integer.toString(Stats.nbStations));
	       prop.setProperty("maxMoney", Integer.toString(Stats.maxMoney));
	       prop.setProperty("moneyAmountPerHab", Integer.toString(Stats.moneyAmountPerHab));
	       prop.setProperty("moneyAmountPerCommercialWorker", Integer.toString(Stats.moneyAmountPerCommercialWorker));
	       prop.setProperty("expencesPerAdministrativeBuildings", Integer.toString(Stats.expencesPerAdministrativeBuildings));
	       prop.setProperty("expencesPerAdministrativeWorker", Integer.toString(Stats.expencesPerAdministrativeWorker));
	       
	       prop.store(new FileOutputStream("config.properties"), null);
	    		 
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	
	
}
