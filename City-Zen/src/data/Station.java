package data;

public class Station extends RailRoad{
	private int nbUsers;
	private int nbMaxUsers;
	private int revenues;
	
	public Station(int nbUsers, int nbMaxUsers, int revenues) {
		super();
		this.nbUsers = nbUsers;
		this.nbMaxUsers = nbMaxUsers;
		this.revenues = revenues;
		this.setType(2);
	}

	public int getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(int nbUsers) {
		this.nbUsers = nbUsers;
	}

	public int getNbMaxUsers() {
		return nbMaxUsers;
	}

	public void setNbMaxUsers(int nbMaxUsers) {
		this.nbMaxUsers = nbMaxUsers;
	}

	public int getRevenues() {
		return revenues;
	}

	public void setRevenues(int revenues) {
		this.revenues = revenues;
	}
	
	
	
}
