package data;

import java.io.FileOutputStream;

import data.Constants;
import data.railRoadData.Station;
import engine.Game;
import gui_data.GuiConstants;

public final class Save {
	
	public Save () {
		
	}
	public static void Load() {
		Game game = Game.getINSTANCE();

	}
	public static void Save_() {
		Game game = Game.getINSTANCE();
		try {
			FileOutputStream save = new FileOutputStream("memory.txt");
			String data = new String("");
			String district = new String("");
			String rail = new String("");
			String stations = new String("");
			String stat = new String("");
			for(int row =0; row<GuiConstants.SQUARE_PER_ROW; row++) {
				for(int column=0; column<GuiConstants.SQUARE_PER_COLUMN; column++) {
					district = district.concat(String.valueOf(Game.getINSTANCE().getDistrictMap()[row][column].getType()));
					rail = rail.concat(String.valueOf(Game.getINSTANCE().getRailSquareMap()[row][column].getType()));
					
					if (Game.getINSTANCE().getRailSquareMap()[row][column].getType() == Constants.STATION) {
						stations = stations.concat(((Station)Game.getINSTANCE().getRailSquareMap()[row][column]).toString_rails());
						
					}
						
				}
				district = district.concat("\n");
				rail = rail.concat("\n");
			}
			district = district.concat("\n");
			rail = rail.concat("\n");
			stations = stations.concat("\n");
			
			stat = stat.concat(Game.getINSTANCE().getStats().toString());
			stat = stat.concat("\n");
			
			data = data.concat("DISTRICT\n\n\n");
			data =data.concat(district);
			data =data.concat("RAIL\n\n\n");
			data =data.concat(rail);		
			data =data.concat("STATION\n\n\n");
			data =data.concat(stations);
			data =data.concat("STAT\n\n\n");
			data =data.concat(stat);
			
			System.out.println(data);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

}
