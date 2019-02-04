package data;

public class Commercial extends District{
	private int nbMaxWorkers=0;
	private int currentNbWorkers=0;
	private int turnCount=0;
	
	public Commercial(int currentNbWorkers, int nbMaxWorkers, int turnCount) {
		super();
		this.setType(3);
		this.setTypeName("Commercial");
		this.nbMaxWorkers = nbMaxWorkers;
		this.currentNbWorkers = currentNbWorkers;
		this.turnCount = turnCount;
	}
	
	
	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	
	public void incrementTurnCount() {
		turnCount += 1;
		/*if((turnCount%5)==0) //for testing only
			incrementNbWorkers();*/
	}
	
	public void incrementNbWorkers() {
		if(currentNbWorkers<nbMaxWorkers)
		{
			currentNbWorkers += 1;
			Stats.nbWorkersCommercial++;
		}
		
	}
	
	public void decrementNbWorkers() {
		if(currentNbWorkers>0)
		{
			currentNbWorkers -= 1;
			Stats.nbWorkersCommercial--;
		}
		
	}

	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}

	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}

	public int getCurrentNbWorkers() {
		return currentNbWorkers;
	}

	public void setCurrentNbWorkers(int currentHab) {
		this.currentNbWorkers = currentHab;
	}
	
	
	
	
}
