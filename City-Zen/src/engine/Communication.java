package engine;

public class Communication extends District{
	private int nbMaxWorkers;
	private int currentHab;
	
	public Communication(int nbMaxWorkers, int currentHab) {
		super();
		this.nbMaxWorkers = nbMaxWorkers;
		this.currentHab = currentHab;
	}

	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}

	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}

	public int getCurrentHab() {
		return currentHab;
	}

	public void setCurrentHab(int currentHab) {
		this.currentHab = currentHab;
	}
	
	
	
	
}
