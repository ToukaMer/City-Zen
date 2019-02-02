package engine;

public class MainEngine {
	

	public static void main(String[] args) {
		int row = 10;
		int column = 10;
		
		Game game = new Game(0, 0, 0, 0, 0, 1, 10000000, 0, null, null);
		District[][] district = game.initDistrictMap(row, column);
		game.printDistrictMap(district, row, column);

	}

}
