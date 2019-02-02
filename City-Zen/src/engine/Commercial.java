package engine;

public class Commercial extends District{
	private int nbMaxWorkers;
	private int currentNbWorkers;
	
	public Commercial(int currentNbWorkers, int nbMaxWorkers) {
		super();
		this.setType(3);
		this.setTypeName("Commercial");
		this.nbMaxWorkers = nbMaxWorkers;
		this.currentNbWorkers = currentNbWorkers;
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
