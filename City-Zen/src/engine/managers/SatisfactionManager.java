package engine.managers;

import data.Coordinates;
import data.Stats;
import data.districtData.District;
import data.districtData.Residencial;
import data.railRoadData.NotRailed;
import data.railRoadData.RailSquare;
import engine.Game;
import gui_data.GuiConstants;

public final class SatisfactionManager 
{
	public double mathSatisfaction(){
		District[][] map = Game.getINSTANCE().getDistrictMap();
		double satisfaction;
		satisfaction = 0;
		RailSquare railSquare[][] = new RailSquare[GuiConstants.SQUARE_PER_COLUMN][GuiConstants.SQUARE_PER_ROW];
		int column = 0,row = 0;
		while( column<GuiConstants.SQUARE_PER_ROW){
			while(row<GuiConstants.SQUARE_PER_COLUMN){
				if (map[column][row].getType() == 2){
					satisfaction = satisfaction + map[column][row].getSatisfaction()*((Residencial)map[column][row]).getNbHab();
				}
				row++;
			}
			column++;
		}
		satisfaction = satisfaction/Game.getINSTANCE().getStats().getNbHab();
		return satisfaction;
	}
}
