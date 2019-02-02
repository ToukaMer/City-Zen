package engine;

public class Game {
	private int money;
	private int monthlyRevenues;
	private int nbHab;
	private int nbResidence;
	private int nbCommercial;
	private int nbAdministration;
	private int maxMoney;
	private int nbStations;
	private District districts [] [];
	private RailRoad railRoads [] [];
	
	public Game(int money, int monthlyRevenues, int nbHab, int nbResidence, int nbCommercial, int nbAdministration,
			int maxMoney, int nbStations, District[][] districts, RailRoad[][] railRoads) {
		super();
		this.money = money;
		this.monthlyRevenues = monthlyRevenues;
		this.nbHab = nbHab;
		this.nbResidence = nbResidence;
		this.nbCommercial = nbCommercial;
		this.nbAdministration = nbAdministration;
		this.maxMoney = maxMoney;
		this.nbStations = nbStations;
		this.districts = districts;
		this.railRoads = railRoads;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMonthlyRevenues() {
		return monthlyRevenues;
	}

	public void setMonthlyRevenues(int monthlyRevenues) {
		this.monthlyRevenues = monthlyRevenues;
	}

	public int getNbHab() {
		return nbHab;
	}

	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}

	public int getNbResidence() {
		return nbResidence;
	}

	public void setNbResidence(int nbResidence) {
		this.nbResidence = nbResidence;
	}

	public int getNbCommercial() {
		return nbCommercial;
	}

	public void setNbCommercial(int nbCommercial) {
		this.nbCommercial = nbCommercial;
	}

	public int getNbAdministration() {
		return nbAdministration;
	}

	public void setNbAdministration(int nbAdministration) {
		this.nbAdministration = nbAdministration;
	}

	public int getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(int maxMoney) {
		this.maxMoney = maxMoney;
	}

	public int getNbStations() {
		return nbStations;
	}

	public void setNbStations(int nbStations) {
		this.nbStations = nbStations;
	}

	public District[][] getDistricts() {
		return districts;
	}

	public void setDistricts(District[][] districts) {
		this.districts = districts;
	}

	public RailRoad[][] getRailRoads() {
		return railRoads;
	}

	public void setRailRoads(RailRoad[][] railRoads) {
		this.railRoads = railRoads;
	}
	
	public void printDistrictMap(District[][] district, int row, int column) {
		
		for(int i =0; i<row; i++) {
			for(int j=0; j<column; j++) {
				System.out.print("|"+district[i][j].type+"|");
			}
			System.out.println("\n------------------------------");
		}
	}
	
	public District[][] initDistrictMap(int row, int column){
		District[][] district = new District[row][column]; 
	
		for(int i =0; i<row; i++) {
			for(int j=0; j<column; j++) {
				district[i][j] = new Wilderness();
			}
		}
		
		return district;
	}

}
