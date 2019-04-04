package engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import data.Coordinates;
import data.Stats;
import data.districtData.Commercial;
import data.districtData.District;
import data.railRoadData.*;
import engine.managers.DistrictManager;
import engine.managers.RailWayManager;

public class MainEngine {


	public static void main(String[] args) {
	
		DistrictManager.buildDistrict(new Commercial(new Coordinates(3, 4)));
        DistrictManager.buildDistrict(new Commercial(new Coordinates(3, 7)));
        RailWayManager.addStation(new Coordinates(3,4));
        RailWayManager.addStation(new Coordinates(3,7));

        ArrayList<Coordinates> railss = new ArrayList<>();
        railss.add(new Coordinates(3, 5));
        railss.add(new Coordinates(3, 6));
        RailWayManager.addRailWay(railss, new Coordinates(3, 4), new Coordinates(3, 7));
        System.out.println("ah booon "+((Station)Game.getINSTANCE().getRailSquareMap()[4][3]).getRailWays().get(new Coordinates(3,7)).rails.toString());
        //RailWayManager.destroyStation(new Coordinates(3,4));
	}
//	public void firstTurnChecks(int type, DistrictManager districtmanager, District[][] district) {
//		 Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
//			DistrictManager.updateDistrict(district);
//	 }
//	 
//	public void Turn(int firstTurn, String command, int xCoord, int yCoord) {
//		
//		if(firstTurn ==1) {
//			Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
//			DistrictManager.updateDistrict(Game.getINSTANCE().getDistrictMap());
//		}
//		
//		switch(command) {
//		case "addResidence":
//								DistrictManager.addResidence( xCoord, yCoord);
//								break;
//		case "destroyResidence":
//			DistrictManager.destroyResidence(districtMap, xCoord, yCoord);
//									break;
//		case "addCommercial":
//			DistrictManager.addCommercial(districtMap, xCoord, yCoord);
//									break;
//		case "destroyCommercial": 
//			DistrictManager.destroyCommercial(districtMap, xCoord, yCoord);
//									break;
//		case "addAdministrative":
//			DistrictManager.addAdministrative(district, xCoord, yCoord);
//									break;
//		case "destroyAdministrative": 
//			DistrictManager.destroyAdministrative(district, xCoord, yCoord);
//									break;
//		case "buildRailWay": 
//									//railWayManager.addRailWay(railRoad,railWayCoord);
//									break;
//		case "buildStation": 
//									RailWayManager.addStation(railRoad, xCoord, yCoord, district);
//									break;
//		case "destroyRailRoad": 
//									RailWayManager.destroyStation(railRoad, xCoord, yCoord);
//									break;
//		case "destroyRailWay": 
//				RailWayManager.destroyRailWay(railRoad, xCoord, yCoord);
//				break;
//		case "save" :								save();
//									break;
//		default: break;
//	
//							
//	}
//				
//		
//		
//		DistrictManager.updateDistrict(district);
//		RailWayManager.updateRailRoadMap(railRoad, width, height);
//		moneyManager();
//	}
//	
//	public void consoleTest(DistrictManager DistrictManager, RailWayManager RailWayManager, int width, int height, District[][] district, RailRoad[][] railRoad) {
//
//		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
//				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
//		DistrictManager.updateDistrict(district);
//		
//		//-----------------------------------------------------------------------------
//		
//		Scanner sc = new Scanner(System.in);
//		String scan="";
//		int widthScan;
//		int heightScan;
//		
//		System.out.println("newGame or loadGame?\n");
//		
//		scan = sc.nextLine();
//		
//		
//		do {
//			switch(scan) {
//				case "newGame" : System.out.println("New game started\n");
//									break;
//				case "loadGame" : System.out.println("Loading last game\n");
//									load();
//									break;
//				default : break;
//			}
//		}while(!scan.equals("newGame")&&!scan.equals("loadGame"));
//		
//		
//	while(!scan.equals("endGame")) 
//	{
//		System.out.println("Print DistrictMap\n");
//		DistrictManager.printDistrictMap(district, width, height);
//		
//		 System.out.println("Print RailWayNetwork Map\n");
//		RailWayManager.printRailWay(railRoad, width, height);
//		
//			scan = sc.nextLine();
//			//railWayManager.addStation(railRoad, 3, 3);
//			
//			//logs System.out.println("input :"+scan+"\n");
//		
//		
//		switch(scan) {
//			case "addResidence": System.out.println("width?");
//									widthScan = sc.nextInt();
//									System.out.println("height?");
//									heightScan = sc.nextInt();
//									DistrictManager.addResidence(district, widthScan, heightScan);
//									scan = sc.nextLine();
//									break;
//			case "destroyResidence": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										DistrictManager.destroyResidence(district, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "addCommercial": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										DistrictManager.addCommercial(district, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "destroyCommercial": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										DistrictManager.destroyCommercial(district, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "addAdministrative": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										DistrictManager.addAdministrative(district, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "destroyAdministrative": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										DistrictManager.destroyAdministrative(district, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "buildRailWay": System.out.println("building test railway");
//										//railWayManager.addRailWay(railRoad,railWayCoord);
//										break;
//										
//			case "buildStation": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										RailWayManager.addStation(railRoad, widthScan, heightScan, district);
//										scan = sc.nextLine();
//										break;
//			case "destroyRailRoad": System.out.println("width?");
//										widthScan = sc.nextInt();
//										System.out.println("height?");
//										heightScan = sc.nextInt();
//										RailWayManager.destroyStation(railRoad, widthScan, heightScan);
//										scan = sc.nextLine();
//										break;
//			case "destroyRailWay": 
//									System.out.println("width?");
//									widthScan = sc.nextInt();
//									System.out.println("height?");
//									heightScan = sc.nextInt();
//									RailWayManager.destroyRailWay(railRoad, widthScan, heightScan);
//									scan = sc.nextLine();
//									break;
//									
//			case "destroyStation": 
//				System.out.println("width?");
//				widthScan = sc.nextInt();
//				System.out.println("height?");
//				heightScan = sc.nextInt();
//				RailWayManager.destroyStation(railRoad, widthScan, heightScan);
//				scan = sc.nextLine();
//				break;
//									
//			case "save" :	System.out.println("Game Saved");
//										save();
//										break;
//			case "endGame" :	System.out.println("Closing Game\n");	
//								break;
//		
//								
//		}
//		
//		
//		DistrictManager.updateDistrict(district);
//		RailWayManager.updateRailRoadMap(railRoad, width, height);
//		moneyManager();
//	}
//	
//	sc.close();
//	}
//	public void moneyManager() {
//		Stats.monthlyRevenues=(Stats.nbHab*Stats.moneyAmountPerHab)+(Stats.nbWorkersCommercial*Stats.moneyAmountPerCommercialWorker);
//		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
//				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
//		Stats.money+=(Stats.monthlyRevenues-Stats.monthlyExpences);
//	}
//	
//	public void load() {
//		Properties prop = new Properties();
//	    InputStream input = null;
//
//	    try {
//
//	        input = new FileInputStream("config.properties");
//
//	        // load a properties file
//	        prop.load(input);
//
//	        // get the property value and print it out
//	        Stats.money=Integer.parseInt(prop.getProperty("money"));
//	        Stats.monthlyRevenues=Integer.parseInt(prop.getProperty("monthlyRevenues"));
//	        Stats.monthlyExpences=Integer.parseInt(prop.getProperty("monthlyExpences"));
//	        Stats.nbHab=Integer.parseInt(prop.getProperty("nbHab"));
//	        Stats.nbMaxHab=Integer.parseInt( prop.getProperty("nbMaxHab"));
//	        Stats.nbWorkersAdministrative=Integer.parseInt(  prop.getProperty("nbWorkersAdministrative"));
//		    Stats.nbWorkersCommercial=Integer.parseInt( prop.getProperty("nbWorkersCommercial"));
//		    Stats.nbMaxWorkersCommercial=Integer.parseInt( prop.getProperty("nbMaxWorkersCommercial"));
//           Stats.nbMaxWorkersAdministrative=Integer.parseInt(prop.getProperty("nbMaxWorkersAdministrative"));
//	        Stats.nbResidence=Integer.parseInt(prop.getProperty("nbResidence"));
//		    Stats.nbCommercial=Integer.parseInt(prop.getProperty("nbCommercial"));
//		    Stats.nbAdministrative=Integer.parseInt(prop.getProperty("nbAdministrative"));
//		    Stats.nbStations=Integer.parseInt( prop.getProperty("nbStations"));
//		    Stats.maxMoney=Integer.parseInt( prop.getProperty("maxMoney"));
//		    Stats.moneyAmountPerHab=Integer.parseInt( prop.getProperty("moneyAmountPerHab"));
//		    Stats.moneyAmountPerCommercialWorker=Integer.parseInt(prop.getProperty("moneyAmountPerCommercialWorker"));
//		    Stats.expencesPerAdministrativeBuildings=Integer.parseInt(prop.getProperty("expencesPerAdministrativeBuildings"));
//		    Stats.expencesPerAdministrativeWorker=Integer.parseInt(prop.getProperty("expencesPerAdministrativeWorker"));
//		       
//
//	    } catch (IOException ex) {
//	        ex.printStackTrace();
//	    } finally {
//	        if (input != null) {
//	            try {
//	                input.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    }
//	}
//	
//	public void save() {
//		Properties prop = new Properties();
//	    InputStream input = null;
//
//	    try {
//
//	        input = new FileInputStream("config.properties");
//
//	        // load a properties file
//	        prop.load(input);
//
//	        // get the property value and print it out
//	       prop.setProperty("money", Integer.toString(Stats.money));
//	       prop.setProperty("monthlyRevenues", Integer.toString(Stats.monthlyRevenues));
//	       prop.setProperty("monthlyExpences", Integer.toString(Stats.monthlyExpences));
//	       prop.setProperty("nbHab", Integer.toString(Stats.nbHab));
//	       prop.setProperty("nbMaxHab", Integer.toString(Stats.nbMaxHab));
//	       prop.setProperty("nbWorkersAdministrative", Integer.toString(Stats.nbWorkersAdministrative));
//	       prop.setProperty("nbWorkersCommercial", Integer.toString(Stats.nbWorkersCommercial));
//	       prop.setProperty("nbMaxWorkersCommercial", Integer.toString(Stats.nbMaxWorkersCommercial));
//	       prop.setProperty("nbMaxWorkersAdministrative", Integer.toString(Stats.nbMaxWorkersAdministrative));
//	       prop.setProperty("nbResidence", Integer.toString(Stats.nbResidence));
//	       prop.setProperty("nbCommercial", Integer.toString(Stats.nbCommercial));
//	       prop.setProperty("nbAdministrative", Integer.toString(Stats.nbAdministrative));
//	       prop.setProperty("nbStations", Integer.toString(Stats.nbStations));
//	       prop.setProperty("maxMoney", Integer.toString(Stats.maxMoney));
//	       prop.setProperty("moneyAmountPerHab", Integer.toString(Stats.moneyAmountPerHab));
//	       prop.setProperty("moneyAmountPerCommercialWorker", Integer.toString(Stats.moneyAmountPerCommercialWorker));
//	       prop.setProperty("expencesPerAdministrativeBuildings", Integer.toString(Stats.expencesPerAdministrativeBuildings));
//	       prop.setProperty("expencesPerAdministrativeWorker", Integer.toString(Stats.expencesPerAdministrativeWorker));
//	       
//	       prop.store(new FileOutputStream("config.properties"), null);
//	    		 
//	    } catch (IOException ex) {
//	        ex.printStackTrace();
//	    } finally {
//	        if (input != null) {
//	            try {
//	                input.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	    }
//	}
//
//	
	
}
