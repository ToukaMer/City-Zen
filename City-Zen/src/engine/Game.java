package engine;

public class Game {
	
	
	public Game(int width, int height) {
		super();

		DistrictManager districtmanager = new DistrictManager();
		District[][] district = districtmanager.initDistrictMap(width, height);//cree une map 
		
		// tests pour residence creation + deletion
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
		districtmanager.printDistrictMap(district, width, height);
	}

	
	
}
