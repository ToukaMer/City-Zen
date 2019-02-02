package engine;

public class Residence extends District{
	private int nbHab;
	private int administrationWorkers;
	private int nbResidentMax;
	
	public Residence(int nbHab, int administrationWorkers, int nbResidentMax) {
		super();
		this.type = 2;
		this.typeName = "Residence";
		this.nbHab = nbHab;
		this.administrationWorkers = administrationWorkers;
		this.nbResidentMax = nbResidentMax;
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
