package data;

public class Administrative extends District{
	private int currentNbWorkers;
	private int nbUserMax;
	private int currentNumberUsers;
	private int nbMaxWorkers;
	
	public Administrative(int currentNbWorkers, int nbUserMax, int currentNumberUsers, int nbMaxWorkers) {
		super();
		this.setType(1);
		this.setTypeName("Administrative");
		this.currentNbWorkers = currentNbWorkers;
		this.nbUserMax = nbUserMax;
		this.currentNumberUsers = currentNumberUsers;
		this.nbMaxWorkers = nbMaxWorkers;
	}

	public int getcurrentNbWorkers() {
		return currentNbWorkers;
	}

	public void setcurrentNbWorkers(int currentNbWorkers) {
		this.currentNbWorkers = currentNbWorkers;
	}

	public int getNbUserMax() {
		return nbUserMax;
	}

	public void setNbUserMax(int nbUserMax) {
		this.nbUserMax = nbUserMax;
	}

	public int getCurrentNumberUsers() {
		return currentNumberUsers;
	}

	public void setCurrentNumberUsers(int currentNumberUsers) {
		this.currentNumberUsers = currentNumberUsers;
	}

	public int getNbMaxWorkers() {
		return nbMaxWorkers;
	}

	public void setNbMaxWorkers(int nbMaxWorkers) {
		this.nbMaxWorkers = nbMaxWorkers;
	}
	
	
	
	

}
