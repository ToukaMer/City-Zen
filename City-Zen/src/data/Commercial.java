package data;

public class Commercial extends District{
	private int nbMaxWorkers=0;
	private int currentNbWorkers=0;
	private int turnCount=0;
	 private int inConstruction;
	 private int constructionTime;
	 private int constructionTimeLeft;
	 
	 public Commercial(int currentNbWorkers, int nbMaxWorkers, int turnCount) {
			super();
			this.setType(3);
			this.setTypeName("Commercial");
			this.nbMaxWorkers = nbMaxWorkers;
			this.currentNbWorkers = currentNbWorkers;
			this.turnCount = turnCount;
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
