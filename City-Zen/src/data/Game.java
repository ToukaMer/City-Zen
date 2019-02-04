package data;

import java.util.Scanner;

public class Game {
	
	
	public Game(int width, int height) {
		super();

		DistrictManager districtmanager = new DistrictManager();
		District[][] district = districtmanager.initDistrictMap(width, height);//cree une map 
		
		//il faut update les depenses du à la mairie ainsi que le nb max de workers ----------------------------------
		
		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
		districtmanager.updateDistrict(district, width, height);
		
		//-----------------------------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		String scan="";
		int widthScan;
		int heightScan;
		
	while(!scan.equals("endGame")) {

		districtmanager.printDistrictMap(district, width, height);
		
			scan = sc.nextLine();
			
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
			case "endGame" :	System.out.println("Closing Game\n");	
								break;
		
								
		}
		
		
		districtmanager.updateDistrict(district, width, height);
		moneyManager();
	}
	
	sc.close();
		
	/*// tests pour residence creation + deletion
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addResidence(district, 3, 3);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addResidence(district, 3, 4);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.destroyResidence(district, 3, 3);
		districtmanager.printDistrictMap(district, width, height);
		
		// tests pour Commercial creation + deletion
		
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addCommercial(district, 6, 3);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addCommercial(district, 7, 4);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.destroyCommercial(district, 6, 3);
		districtmanager.printDistrictMap(district, width, height);
		
		// tests pour Administration creation + deletion
		
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addAdministrative(district, 2, 8);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.addAdministrative(district, 8, 1);
		districtmanager.printDistrictMap(district, width, height);
		districtmanager.destroyAdministrative(district, 8, 1);
		districtmanager.printDistrictMap(district, width, height);*/
	}
	
	public void moneyManager() {
		Stats.monthlyRevenues=(Stats.nbHab*Stats.moneyAmountPerHab)+(Stats.nbWorkersCommercial*Stats.moneyAmountPerCommercialWorker);
		Stats.monthlyExpences=(Stats.nbAdministrative*Stats.expencesPerAdministrativeBuildings)
				+(Stats.nbWorkersAdministrative*Stats.expencesPerAdministrativeWorker);
		Stats.money+=(Stats.monthlyRevenues-Stats.monthlyExpences);
	}

	
	
}
