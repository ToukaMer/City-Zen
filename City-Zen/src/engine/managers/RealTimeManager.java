package engine.managers;

import data.Calendar;
import data.Constants;
import data.districtData.Administrative;
import data.districtData.Commercial;
import data.districtData.District;
import data.districtData.Residencial;
import engine.Game;
import gui_data.GuiConstants;

public final class RealTimeManager {
	
	public static void nextDay() {
		Calendar calendar = Game.getINSTANCE().getStats().getCalendar();
		calendar.setDay(calendar.getDay()+1);
		if(calendar.getDay() > 7) {
			calendar.setDay(1);
		}
		calendar.setDayNumber(calendar.getDayNumber()+1);
		switch(calendar.getMonthNumber()) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:if(calendar.getDayNumber() > 31) {
						calendar.setDayNumber(1);
						calendar.setMonthNumber(calendar.getMonthNumber()+1);
					}
					break;
			case 4:
			case 6:
			case 9:
			case 11:if(calendar.getDayNumber() > 30) {
						calendar.setDayNumber(1);
						calendar.setMonthNumber(calendar.getMonthNumber()+1);
					}
					break;
			case 2:if(calendar.getDayNumber() > 28) {
						calendar.setDayNumber(1);
						calendar.setMonthNumber(calendar.getMonthNumber()+1);
					}
					break;
			default : break;
		}
		if(calendar.getMonthNumber()>12) {
			calendar.setMonthNumber(1);
			calendar.setYearNumber(calendar.getYearNumber()+1);
		}
		calendar.setDayName(Constants.DAYS[calendar.getDayNumber()-1]);
		calendar.setMonthName(Constants.MONTHS[calendar.getMonthNumber()-1]);
	}
	
	public static void updateInBuildingDistricts() {
		for(int column =0; column<GuiConstants.SQUARE_PER_ROW; column++) {
			for(int row=0; row<GuiConstants.SQUARE_PER_COLUMN; row++) {
				if(Game.getINSTANCE().getDistrictMap()[column][row].isInConstruction()){
					int constructionTimeLeft = Game.getINSTANCE().getDistrictMap()[column][row].getConstructionTimeLeft();
					Game.getINSTANCE().getDistrictMap()[column][row].setConstructionTimeLeft(constructionTimeLeft);
					if(Game.getINSTANCE().getDistrictMap()[column][row].getConstructionTimeLeft() <= 0) {
						Game.getINSTANCE().getDistrictMap()[column][row].setInConstruction(false);
					}
				}
			}
		}
	}
	
	public static void updateDistricts(District[][] district) {
		for(int column =0; column<GuiConstants.SQUARE_PER_ROW; column++) {
			for(int row=0; row<GuiConstants.SQUARE_PER_COLUMN; row++) {
				switch(Game.getINSTANCE().getDistrictMap()[column][row].getType()) {
					case Constants.RESIDENCIAL : 
						((Residencial)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Residencial)district[column][row]).getTurnCount());
						break;
					case Constants.ADMINISTRATIVE :
						((Administrative)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Administrative)district[column][row]).getTurnCount());
						break;
					case Constants.COMMERCIAL :
						((Commercial)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Commercial)district[column][row]).getTurnCount());
						break;
					case Constants.WILDERNESS :
						break;
				}
			}
		}
	}
}
