package engine.managers;

import data.Coordinates;
import data.Stats;
import data.districtData.District;
import data.districtData.Residencial;
import data.railRoadData.NotRailed;
import data.railRoadData.RailSquare;
import engine.Game;
import gui.Root;
import gui_data.GuiConstants;

public final class SatisfactionManager 
{
	public static void mathSatisfaction()
	{
		District[][] map = Game.getINSTANCE().getDistrictMap();
		double satisfaction;
		satisfaction = 0;
		//satisfaction = Game.getINSTANCE().getStats().getSatisfaction() + 0.01;
		if(Game.getINSTANCE().getStats().getNbHab()!=0) {
		 satisfaction = (Game.getINSTANCE().getStats().getMonthlyRevenues()/Game.getINSTANCE().getStats().getNbHab());
		}
		else {
			satisfaction = 0.5;
		}
		 Game.getINSTANCE().getStats().setSatisfaction(satisfaction);
		 Root.getINSTANCE().getPlayableGrid().getGameBlock().getToolbar().getToolbarLeft().updateSatisfactionGauge();
		 //		return satisfaction;
	}
}
