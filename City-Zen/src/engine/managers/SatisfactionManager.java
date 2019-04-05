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
	public double mathSatisfaction()
	{
		District[][] map = Game.getINSTANCE().getDistrictMap();
		double satisfaction;
		satisfaction = 0;
		satisfaction = 	Game.getINSTANCE().getStats().getMonthlyRevenues()/Game.getINSTANCE().getStats().getNbHab();
		return satisfaction;
	}
}
