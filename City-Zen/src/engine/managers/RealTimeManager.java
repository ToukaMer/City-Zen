package engine.managers;


import java.util.Date;

import data.Calendar;
import data.Constants;
import data.districtData.Administrative;
import data.districtData.Commercial;
import data.districtData.District;
import data.districtData.Residencial;
import engine.Game;
import gui.PlayableGrid;
import gui.Root;
import gui_data.GuiConstants;
import javafx.animation.AnimationTimer;

public final class RealTimeManager {
	
	public static void realTime(PlayableGrid playableGrid) {
		Game.getINSTANCE().setClock(new Date());
		Game.getINSTANCE().setLastFrame(Game.getINSTANCE().getClock().getTime());
		Game.getINSTANCE().setLastDay(Game.getINSTANCE().getClock().getTime());
		new AnimationTimer() {
			public void handle(long now) {
				Game.getINSTANCE().setClock(new Date());
				if((Game.getINSTANCE().getClock().getTime() - Game.getINSTANCE().getLastFrame()) > ((double)1000)/GuiConstants.FRAME_PER_SECOND){
					Game.getINSTANCE().setLastFrame(Game.getINSTANCE().getClock().getTime());
					if((Game.getINSTANCE().getClock().getTime() - Game.getINSTANCE().getLastDay()) > ((double)1000)/GuiConstants.DAY_PER_SECOND){
						Game.getINSTANCE().setLastDay(Game.getINSTANCE().getClock().getTime());
						nextDay();
						updateInBuildingDistricts();
						updateDistricts();
						if(Game.getINSTANCE().getStats().getCalendar().getDayNumber() == 1) {
							int money = Game.getINSTANCE().getStats().getMoney();
							money += Game.getINSTANCE().getStats().getMonthlyRevenues()-Game.getINSTANCE().getStats().getMonthlyExpences();
							if(money > Game.getINSTANCE().getStats().getMaxMoney()) {
								money = Game.getINSTANCE().getStats().getMaxMoney();
							}
							Game.getINSTANCE().getStats().setMoney(money);
						}
					}
					playableGrid.getGameBlock().getMapZone().getMapCanvas().animatedMap(playableGrid);
				}
			}
		}.start();
	}
	
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
		calendar.setDayName(Constants.DAYS[calendar.getDay()-1]);
		calendar.setMonthName(Constants.MONTHS[calendar.getMonthNumber()-1]);
		Game.getINSTANCE().getStats().setCalendar(calendar);

		Root.getINSTANCE().getPlayableGrid().getGameBlock().getToolbar().getToolbarRight().updateCalendarLabel(calendar);
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
	
	public static void updateDistricts() {
		for(int column =0; column<GuiConstants.SQUARE_PER_ROW; column++) {
			for(int row=0; row<GuiConstants.SQUARE_PER_COLUMN; row++) {
				switch(Game.getINSTANCE().getDistrictMap()[column][row].getType()) {
					case Constants.RESIDENCIAL : 
						((Residencial)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Residencial)Game.getINSTANCE().getDistrictMap()[column][row]).getTurnCount());
						break;
					case Constants.ADMINISTRATIVE :
						((Administrative)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Administrative)Game.getINSTANCE().getDistrictMap()[column][row]).getTurnCount());
						break;
					case Constants.COMMERCIAL :
						((Commercial)Game.getINSTANCE().getDistrictMap()[column][row]).setTurnCount(((Commercial)Game.getINSTANCE().getDistrictMap()[column][row]).getTurnCount());
						break;
					case Constants.WILDERNESS :
						break;
				}
			}
		}
	}
}
