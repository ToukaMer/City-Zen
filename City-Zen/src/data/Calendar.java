package data;


public class Calendar {

	private int day;
	private int dayNumber;
	private String dayName;
	private int monthNumber;
	private String monthName;
	private int yearNumber;
	
	public Calendar(int day, int dayNumber, int monthNumber, int yearNumber) {
		this.day = day;
		this.dayNumber = dayNumber;
		this.monthNumber = monthNumber;
		this.yearNumber = yearNumber;
		this.dayName = Constants.DAYS[dayNumber-1];
		this.monthName = Constants.MONTHS[monthNumber-1];
	}
	public Calendar() {
		this(1,1,1,1);
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	public int getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getYearNumber() {
		return yearNumber;
	}
	public void setYearNumber(int yearNumber) {
		this.yearNumber = yearNumber;
	}
}
