package engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import data.*;
import data.districtData.District;
import data.railRoadData.RailRoad;
import engine.managers.DistrictManager;
import engine.managers.RailWayManager;

public class Game {
	private District[][] districtMap;
	private RailRoad[][] railRoadMap;
	private DistrictManager districtManager;
	private RailWayManager railWayManager;
	private int width;
	private int height;
	private Coordinates [] railWayCoord;
	
	public Game(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		
		initDistrictManager();
		initrailWayManager();
		
		initDistrictMap(width,height);
		initRailRoadMap(width,height);
	}
	
	public Game(int width, int height, District[][] districtMap, RailRoad[][] railRoadMap, DistrictManager districtManager, RailWayManager railWayManager) {
		super();
		setWidth(width);
		setHeight(height);
		setDistrictMap(districtMap);
		setRailRoadMap(railRoadMap);
		setDistrictManager(districtManager);
		setRailWayManager(railWayManager);
	}

	public void initDistrictMap(int width, int height) {
		setDistrictMap(getDistrictManager().initDistrictMap(width, height));//cree une map de la surface 
	}
	
	public void initRailRoadMap(int width, int height) {
		setRailRoadMap(getRailWayManager().initRailWay(width, height));//-- du metro
	}
	
	public void initDistrictManager() {
		districtManager = new DistrictManager();
	}
	
	public void initrailWayManager() {
		railWayManager = new RailWayManager();
	}
	
	public DistrictManager getDistrictManager() {
		return districtManager;
	}

	public void setDistrictManager(DistrictManager districtManager) {
		this.districtManager = districtManager;
	}

	public RailWayManager getRailWayManager() {
		return railWayManager;
	}

	public void setRailWayManager(RailWayManager railWayManager) {
		this.railWayManager = railWayManager;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public District[][] getDistrictMap() {
		return districtMap;
	}

	public void setDistrictMap(District[][] districtMap) {
		this.districtMap = districtMap;
	}

	public RailRoad[][] getRailRoadMap() {
		return railRoadMap;
	}

	public void setRailRoadMap(RailRoad[][] railRoadMap) {
		this.railRoadMap = railRoadMap;
	}
	 
	 public void buildDistrict(int type, DistrictManager districtManager, District[][] district, int xCoord, int yCoord) {
		 switch(type) { //wilderness = 0, admin = 1, residential = 2, commercial = 3
			 case 1: districtManager.addAdministrative(district, xCoord, yCoord);
				break;
			 case 2: districtManager.addResidence(district, xCoord, yCoord);
				break;
			 case 3: districtManager.addCommercial(district, xCoord, yCoord);
			 	break;
			 default: break;
		 }
	 }
	 
	 public void buildStation() {
		 
	 }
	 
	 public void destroyDistrict(int type, DistrictManager districtManager, District[][] district, int xCoord, int yCoord) {
		 switch(type) { //wilderness = 0, admin = 1, residential = 2, commercial = 3
			 case 1: districtManager.destroyAdministrative(district, xCoord, yCoord);
				break;
			 case 2: districtManager.destroyResidence(district, xCoord, yCoord);
				break;
			 case 3: districtManager.destroyCommercial(district, xCoord, yCoord);
			 	break;
			 default: break;
		 }
	 }

	public void destroyStation() {
		 
	 }
	 
	 public void buildRailway() {
		 
	 }
	 
	 public void firstTurnChecks(int type, DistrictManager districtmanager, District[][] district, int xCoord, int yCoord) {
		 Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
			districtmanager.updateDistrict(district, xCoord, yCoord);
	 }
	 
	public void Turn(int firstTurn, String command, int xCoord, int yCoord, DistrictManager districtmanager, RailWayManager railWayManager, int width, int height, District[][] district, RailRoad[][] railRoad) {
		
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
									railWayManager.addRailWay(railRoad,railWayCoord);
									break;
		case "buildStation": 
									railWayManager.addStation(railRoad, xCoord, yCoord);
									break;
		case "destroyRailRoad": 
									railWayManager.destroyRailRoad(railRoad, xCoord, yCoord);
									break;
		case "save" :								save();
									break;
		default: break;
	
							
	}
				
		
		
		districtmanager.updateDistrict(district, width, height);
		railWayManager.updateRailRoadMap(railRoad, width, height);
		moneyManager();
	}
	
	public void consoleTest(DistrictManager districtmanager, RailWayManager railWayManager, int width, int height, District[][] district, RailRoad[][] railRoad) {

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
		railWayManager.printRailWay(railRoad, width, height);
		
			scan = sc.nextLine();
			//railWayManager.addStation(railRoad, 3, 3);
			
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
										railWayManager.addRailWay(railRoad,railWayCoord);
										scan = sc.nextLine();
										break;
			case "buildStation": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										railWayManager.addStation(railRoad, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "destroyRailRoad": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										railWayManager.destroyRailRoad(railRoad, widthScan, heightScan);
										scan = sc.nextLine();
										break;
			case "save" :	System.out.println("Game Saved");
										save();
										break;
			case "endGame" :	System.out.println("Closing Game\n");	
								break;
		
								
		}
		
		
		districtmanager.updateDistrict(district, width, height);
		railWayManager.updateRailRoadMap(railRoad, width, height);
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
