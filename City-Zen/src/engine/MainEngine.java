package engine;

public class MainEngine {
	

	public static void main(String[] args) {
		int row = 10;
		int column = 10;
		
		Game game = new Game(0, 0, 0, 0, 0, 1, 10000000, 0, null, null);
		District[][] district = game.initDistrictMap(row, column);//cree une map 
		
		// tests pour residence creation + deletion
		game.printDistrictMap(district, row, column);
		game.addResidence(district, 3, 3);
		game.printDistrictMap(district, row, column);
		game.addResidence(district, 3, 4);
		game.printDistrictMap(district, row, column);
		game.destroyResidence(district, 3, 3);
		game.printDistrictMap(district, row, column);
		
		// tests pour Commercial creation + deletion
		
		game.printDistrictMap(district, row, column);
		game.addCommercial(district, 6, 3);
		game.printDistrictMap(district, row, column);
		game.addCommercial(district, 7, 4);
		game.printDistrictMap(district, row, column);
		game.destroyCommercial(district, 6, 3);
		game.printDistrictMap(district, row, column);
		
		// tests pour Administration creation + deletion
		
		game.printDistrictMap(district, row, column);
		game.addAdministration(district, 2, 8);
		game.printDistrictMap(district, row, column);
		game.addAdministration(district, 8, 1);
		game.printDistrictMap(district, row, column);
		game.destroyAdministration(district, 8, 1);
		game.printDistrictMap(district, row, column);
	}

}
