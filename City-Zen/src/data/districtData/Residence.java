package data.districtData;

import java.util.Random;

import data.Constants;
import data.Stats;

//NEED PATH FINDING

public class Residence extends District{
	private int nbHab=0;
	private int administrationWorkers=0;
	private int commercialWorkers=0;
	private int nbResidentMax=0;
	private int turnCount=0;
	private int inConstruction=1;
	private int constructionTime=30;
 	private int constructionTimeLeft=30;
	
	public Residence(int nbHab, int administrationWorkers, int commercialWorkers, int nbResidentMax, int turnCount,
			int inConstruction, int constructionTime, int constructionTimeLeft) {
		super();
		this.setType(Constants.RESIDENCE);
		this.setTypeName("Residence");
		this.nbHab = nbHab;
		this.administrationWorkers = administrationWorkers;
		this.commercialWorkers = commercialWorkers;
		this.nbResidentMax = nbResidentMax;
		this.turnCount = turnCount;
		this.inConstruction = inConstruction;
		this.constructionTime = constructionTime;
		this.constructionTimeLeft = constructionTimeLeft;
	}

	public void decrementConstructionTimeLeft() {
		if(constructionTimeLeft>1)
			setConstructionTimeLeft(getConstructionTimeLeft()-1);
		else {
			setInConstruction(0);
		}
	}
	
	
	public int getCommercialWorkers() {
		return commercialWorkers;
	}


	public void setCommercialWorkers(int commercialWorkers) {
		this.commercialWorkers = commercialWorkers;
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


	public int getConstructionTimeLeft() {
		return constructionTimeLeft;
	}


	public void setConstructionTimeLeft(int constructionTimeLeft) {
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
		if((turnCount%5)==0)
			incrementNbHab();
	}
	
	

	public void incrementNbHab() {
		if(nbHab<nbResidentMax)
		{
			nbHab += 1;
			Stats.nbHab +=1;
			
			// each new citizen must find a job either in a commercial or administrative district
			//first i check if not all administrative and commercial buildings are full
			if(Stats.nbWorkersAdministrative<Stats.nbMaxWorkersAdministrative && Stats.nbWorkersCommercial<Stats.nbMaxWorkersCommercial) {
				Random ran = new Random();
				int x = ran.nextInt(2);
				
				if(x==1) {
					administrationWorkers++;
					Stats.nbWorkersAdministrative++;
					// ici je dois incrementer la valeur de workers du bloc administratif le plus proche non maxé
				}
				else {
					commercialWorkers++;
					Stats.nbWorkersCommercial++;
					// ici je dois incrementer la valeur de workers du bloc administratif le plus proche non maxé
				}
			}
			
			else if(Stats.nbWorkersAdministrative<Stats.nbMaxWorkersAdministrative){
				administrationWorkers++;
				Stats.nbWorkersAdministrative++;
				// ici je dois incrementer la valeur de workers du bloc administratif le plus proche non maxé
			}
			
			else if(Stats.nbWorkersCommercial<Stats.nbMaxWorkersCommercial) {
				commercialWorkers++;
				Stats.nbWorkersCommercial++;
				// ici je dois incrementer la valeur de workers du bloc administratif le plus proche non maxé
			}
			else
				System.out.println("Everything is full , build more commercial/administrative districts !!\n");
			
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
