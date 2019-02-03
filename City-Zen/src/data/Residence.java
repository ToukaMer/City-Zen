package data;

public class Residence extends District{
	private int nbHab=0;
	private int administrationWorkers=0;
	private int nbResidentMax=0;
	private int turnCount=0;
	
	public Residence(int nbHab, int administrationWorkers, int nbResidentMax) {
		super();
		this.setType(2);
		this.setTypeName("Residence");
		this.nbHab = nbHab;
		this.administrationWorkers = administrationWorkers;
		this.nbResidentMax = nbResidentMax;
		this.turnCount=turnCount;
	}
	
	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	
	public void incrementTurnCount() {
		turnCount += 1;
		if((turnCount%5)==0)
			incrementNbHab();
	}
	
	

	public void incrementNbHab() {
		if(nbHab<nbResidentMax)
		{
			nbHab += 1;
			Stats.nbHab +=1;
		}
		
	}
	
	public void decrementNbHab() {
		if(nbHab>0) {
			nbHab -= 1;
			Stats.monthlyRevenues-=Stats.moneyAmountPerHab;
		}
		
	}

	public int getNbHab() {
		return nbHab;
	}

	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}

	public int getAdministrationWorkers() {
		return administrationWorkers;
	}

	public void setAdministrationWorkers(int administrationWorkers) {
		this.administrationWorkers = administrationWorkers;
	}

	public int getNbResidentMax() {
		return nbResidentMax;
	}

	public void setNbResidentMax(int nbResidentMax) {
		this.nbResidentMax = nbResidentMax;
	}
	
	
	
	
}
