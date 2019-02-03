package engine;

import java.util.Scanner;

public class Game {
	
	
	public Game(int width, int height) {
		super();

		DistrictManager districtmanager = new DistrictManager();
		District[][] district = districtmanager.initDistrictMap(width, height);//cree une map 
		
		Scanner sc = new Scanner(System.in);
		String scan;
		int widthScan;
		int heightScan;
	while(true) {

		districtmanager.printDistrictMap(district, width, height);
		scan = sc.nextLine();
		switch(scan) {
			case "addResidence": System.out.println("width?");
									widthScan = sc.nextInt();
									System.out.println("height?");
									heightScan = sc.nextInt();
									districtmanager.addResidence(district, widthScan, heightScan);
									break;
			case "destroyResidence": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyResidence(district, widthScan, heightScan);
										break;
			case "addCommercial": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.addCommercial(district, widthScan, heightScan);
										break;
			case "destroyCommercial": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyCommercial(district, widthScan, heightScan);
										break;
			case "addAdministrative": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.addAdministrative(district, widthScan, heightScan);
										break;
			case "destroyAdministrative": System.out.println("width?");
										widthScan = sc.nextInt();
										System.out.println("height?");
										heightScan = sc.nextInt();
										districtmanager.destroyAdministrative(district, widthScan, heightScan);
										break;
		
								
		}
	}
		
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

	
	
}
