package data;

public class Stats {
	public int money;
	public int monthlyRevenues;
	public int monthlyExpences;
	
	public int nbHab;
	public int nbMaxHab;
	
	public int nbWorkersAdministrative;
	public int nbWorkersCommercial;
	
	public int nbResidencial;
	public int nbCommercial;
	public int nbAdministrative;
	public int nbStations;
	
	public int maxMoney;

	public int gainsPerCommercialWorker;
	public int costsPerAdministrative;
	public int costsPerAdministrativeWorker;
	
	public Stats(int money, int monthlyRevenues, int monthlyExpences, int nbHab,
			int nbWorkersAdministrative, int nbWorkersCommercial, int nbResidencial, int nbCommercial,
			int nbAdministrative, int nbStations) {
		super();
		this.money = money;
		this.monthlyRevenues = monthlyRevenues;
		this.monthlyExpences = monthlyExpences;
		this.nbHab = nbHab;
		this.nbMaxHab = Constants.MAX_HAB;
		this.nbWorkersAdministrative = nbWorkersAdministrative;
		this.nbWorkersCommercial = nbWorkersCommercial;
		this.nbResidencial = nbResidencial;
		this.nbCommercial = nbCommercial;
		this.nbAdministrative = nbAdministrative;
		this.nbStations = nbStations;
		this.maxMoney = Constants.MAX_MONEY;
		this.gainsPerCommercialWorker = Constants.GAINS_PER_COMMERCIAL_WORKER;
		this.costsPerAdministrative = Constants.COSTS_PER_ADMINISTRATIVE;
		this.costsPerAdministrativeWorker = Constants.COSTS_PER_ADMINISTRATIVE_WORKER;
	}
	public Stats() {
		this(Constants.STARTING_MONEY, 0, 0, 0, 0, 0, 0, 0, 1, 0);
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
	public int getMonthlyExpences() {
		return monthlyExpences;
	}
	public void setMonthlyExpences(int monthlyExpences) {
		this.monthlyExpences = monthlyExpences;
	}
	public int getNbHab() {
		return nbHab;
	}
	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}
	public int getNbMaxHab() {
		return nbMaxHab;
	}
	public void setNbMaxHab(int nbMaxHab) {
		this.nbMaxHab = nbMaxHab;
	}
	public int getNbWorkersAdministrative() {
		return nbWorkersAdministrative;
	}
	public void setNbWorkersAdministrative(int nbWorkersAdministrative) {
		this.nbWorkersAdministrative = nbWorkersAdministrative;
	}
	public int getNbWorkersCommercial() {
		return nbWorkersCommercial;
	}
	public void setNbWorkersCommercial(int nbWorkersCommercial) {
		this.nbWorkersCommercial = nbWorkersCommercial;
	}
	public int getNbResidencial() {
		return nbResidencial;
	}
	public void setNbResidencial(int nbResidencial) {
		this.nbResidencial = nbResidencial;
	}
	public int getNbCommercial() {
		return nbCommercial;
	}
	public void setNbCommercial(int nbCommercial) {
		this.nbCommercial = nbCommercial;
	}
	public int getNbAdministrative() {
		return nbAdministrative;
	}
	public void setNbAdministrative(int nbAdministrative) {
		this.nbAdministrative = nbAdministrative;
	}
	public int getNbStations() {
		return nbStations;
	}
	public void setNbStations(int nbStations) {
		this.nbStations = nbStations;
	}
	public int getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(int maxMoney) {
		this.maxMoney = maxMoney;
	}
	public int getGainsPerCommercialWorker() {
		return gainsPerCommercialWorker;
	}
	public void setGainsPerCommercialWorker(int gainsPerCommercialWorker) {
		this.gainsPerCommercialWorker = gainsPerCommercialWorker;
	}
	public int getCostsPerAdministrative() {
		return costsPerAdministrative;
	}
	public void setCostsPerAdministrative(int costsPerAdministrative) {
		this.costsPerAdministrative = costsPerAdministrative;
	}
	public int getCostsPerAdministrativeWorker() {
		return costsPerAdministrativeWorker;
	}
	public void setCostsPerAdministrativeWorker(int costsPerAdministrativeWorker) {
		this.costsPerAdministrativeWorker = costsPerAdministrativeWorker;
	}
	@Override
	public String toString() {
		return money + "" + monthlyRevenues + "_" + monthlyExpences
				+ "_" + nbHab + "_" + nbMaxHab + "_" + nbWorkersAdministrative
				+ "_" + nbWorkersCommercial + "_" + nbResidencial
				+ "_" + nbCommercial + "_" + nbAdministrative + "_"
				+ nbStations + "_" + maxMoney + "_" + gainsPerCommercialWorker
				+ "_" + costsPerAdministrative + "_"
				+ costsPerAdministrativeWorker ;
	}
	
	
	
}
