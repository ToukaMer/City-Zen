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
	
	public void printDistrictMap(District[][] district, int width, int height) {
		
		for(int i =0; i<width; i++) {
			for(int j=0; j<height; j++) {
				System.out.print("|"+district[i][j].type+"|");
			}
			System.out.println("\n------------------------------");
		}
		
		System.out.println("\nmoney:" +money+"\n"+ 
				"monthlyRevenues:" +monthlyRevenues+"\n" + 
				"nbHab: "+nbHab+"\n" + 
				"nbResidence: "+nbResidence+"\n" + 
				"nbCommercial: "+nbCommercial+"\n" + 
				"nbAdministration: "+nbAdministration+"\n" + 
				"maxMoney: "+maxMoney+"\n" + 
				"nbStations: "+nbStations+"\n");
	}
	
	public District[][] initDistrictMap(int width, int height){
		District[][] district = new District[width][height]; 
	
		for(int column =0; column<height; column++) {
			for(int row=0; row<width; row++) {
				if(((column*height)+row+1) == ((height*height/2)+(width/2))) // get the center of the map , +1 because it begins at 0
					district[column][row] = new Administrative(30, 100, 0, 100); // put the town center at the center
				else
				district[column][row] = new Wilderness();
			}
		}
		
		return district;
	}
	
	public void addResidence(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Residence(10, 0, 30);
			nbHab+=((Residence)district[width][height]).getNbHab();
			nbResidence++;
			
			System.out.println("nbHab: "+nbHab);
		}	
	}
	
	public void destroyResidence(District[][] district, int width, int height) {
		if(district[width][height].getType() != 2)
			System.out.println("This spot isnt a Residence!");
		else
		{
			nbResidence--;
			nbHab -= ((Residence) district[width][height]).getNbHab(); //voir pour virer le cast
			district[width][height] = new Wilderness();
			System.out.println("nbHab: "+nbHab);
			
		}
	}
	
	public void addAdministration(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Administrative(10, 30, 0, 30);
			nbAdministration++;
		}	
	}
	
	public void destroyAdministration(District[][] district, int width, int height) {
		if(district[width][height].getType() != 1)
			System.out.println("This spot isnt an Adminitrative District!");
		else
		{
			nbAdministration--;
			district[width][height] = new Wilderness();
		}
	}
	
	public void addCommercial(District[][] district, int width, int height) {
		if(district[width][height].getType() != 0)
			System.out.println("This spot isnt empty!");
		else
		{
			district[width][height] = new Commercial(0, 30);
			nbCommercial++;
		}	
	}
	
	public void destroyCommercial(District[][] district, int width, int height) {
		if(district[width][height].getType() != 3)
			System.out.println("This spot isnt a Commercial District!");
		else
		{
			nbCommercial--;
			district[width][height] = new Wilderness();
		}
	}

}
