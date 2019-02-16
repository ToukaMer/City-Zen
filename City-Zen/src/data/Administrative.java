package data;

public class Administrative extends District{
	private int currentNbWorkers;
	private int nbUserMax;
	private int currentNbUsers;
	private int nbMaxWorkers;
	private int turnCount=0;
	 private int inConstruction;
	 private int constructionTime;
	 private int constructionTimeLeft;
	
	

	
	public Administrative(int currentNbWorkers, int nbUserMax, int currentNbUsers, int nbMaxWorkers, int turnCount,
			int inConstruction, int constructionTime, int constructionTimeLeft) {
		super();
		this.setType(1);
		this.setTypeName("Administrative");
		this.currentNbWorkers = currentNbWorkers;
		this.nbUserMax = nbUserMax;
		this.currentNbUsers = currentNbUsers;
		this.nbMaxWorkers = nbMaxWorkers;
		this.turnCount = turnCount;
		this.inConstruction = inConstruction;
		this.constructionTime = constructionTime;
		this.constructionTimeLeft = constructionTimeLeft;
	}

	public void decrementconstructionTimeLeft() {
		constructionTimeLeft --;
	}
	
	public int getInConstruction() {
		return inConstruction;
	}

	public void setInConstruction(int inConstruction) {
		this.inConstruction = inConstruction;
	}

	public int getConstructionTime() {
		return constructionTime;
	}

	public void setConstructionTime(int constructionTime) {
		this.constructionTime = constructionTime;
	}

	public int getconstructionTimeLeft() {
		return constructionTimeLeft;
	}

	public void setconstructionTimeLeft(int constructionTimeLeft) {
		this.constructionTimeLeft = constructionTimeLeft;
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
