package data;

public class Administrative extends District{
	private int currentNbWorkers;
	private int nbUserMax;
	private int currentNbUsers;
	private int nbMaxWorkers;
	private int turnCount=0;
	
	public Administrative(int currentNbWorkers, int nbUserMax, int currentNbUsers, int nbMaxWorkers, int turnCount) {
		super();
		this.setType(1);
		this.setTypeName("Administrative");
		this.currentNbWorkers = currentNbWorkers;
		this.nbUserMax = nbUserMax;
		this.currentNbUsers = currentNbUsers;
		this.nbMaxWorkers = nbMaxWorkers;
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
		/*if((turnCount%5)==0) //for testing only
			incrementNbWorkers();*/
	}
	
	public void incrementNbWorkers() {
		if(currentNbWorkers<nbMaxWorkers)
		{
			currentNbWorkers += 1;
			Stats.nbWorkersAdministrative++;
		}
		
	}
	
	public void decrementNbWorkers() {
		if(currentNbWorkers>0)
		{
			currentNbWorkers -= 1;
			Stats.nbWorkersAdministrative--;
		}
		
	}
	

	public int getCurrentNbWorkers() {
		return currentNbWorkers;
	}

	public void setCurrentNbWorkers(int currentNbWorkers) {
		this.currentNbWorkers = currentNbWorkers;
	}

	public int getNbUserMax() {
		return nbUserMax;
	}

	public void setNbUserMax(int nbUserMax) {
		this.nbUserMax = nbUserMax;
	}

	public int getCurrentNbUsers() {
		return currentNbUsers;
	}

	public void setCurrentNbUsers(int currentNumberUsers) {
		this.currentNbUsers = currentNumberUsers;
	}

	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}

	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}
	
	
	
	

}
