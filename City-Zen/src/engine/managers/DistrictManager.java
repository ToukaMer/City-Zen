package engine.managers;

import data.*;
import data.districtData.Administrative;
import data.districtData.Commercial;
import data.districtData.District;
import data.districtData.Residencial;
import data.districtData.Wilderness;
import engine.Game;
import gui_data.GuiConstants;

public final class DistrictManager {
	
	public static void printDistrictMap(District[][] district, int width, int height) 
	{
		
		for(int i =0; i<width; i++) {
			for(int j=0; j<height; j++) {
				System.out.print("|"+district[i][j].getType()+"|");
			}
			System.out.println("\n------------------------------");
		}		
		System.out.println(Game.getINSTANCE().getStats().toString());
		
		
	}
	
	
	
	public static District[][] initDistrictMap()
	{
		District[][] district = new District[GuiConstants.SQUARE_PER_COLUMN][GuiConstants.SQUARE_PER_ROW]; 
	
		for(int column =0; column<GuiConstants.SQUARE_PER_ROW; column++) {
			for(int row=0; row<GuiConstants.SQUARE_PER_COLUMN; row++) {
					// put the town center at the center
					
					district[column][row] = new Wilderness(new Coordinates(row, column));
			}
		}
		int y = GuiConstants.SQUARE_PER_ROW/2;
		int x = GuiConstants.SQUARE_PER_COLUMN/2;
		district[x][y] = new Administrative(new Coordinates(y, x));
		
		return district;
	}
	
	public static void incrementNbAdministrative() {
		Game.getINSTANCE().getStats().setNbAdministrative(Game.getINSTANCE().getStats().getNbAdministrative()+1);
	}
	public static void incrementNbCommercial() {
		Game.getINSTANCE().getStats().setNbCommercial(Game.getINSTANCE().getStats().getNbCommercial()+1);
	}
	public static void incrementNbResidencial() {
		Game.getINSTANCE().getStats().setNbResidencial(Game.getINSTANCE().getStats().getNbResidencial()+1);
	}
	public static void decrementNbAdministrative() {
		Game.getINSTANCE().getStats().setNbAdministrative(Game.getINSTANCE().getStats().getNbAdministrative()-1);
	}
	public static void decrementNbCommercial() {
		Game.getINSTANCE().getStats().setNbCommercial(Game.getINSTANCE().getStats().getNbCommercial()-1);
	}
	public static void decrementNbResidencial() {
		Game.getINSTANCE().getStats().setNbResidencial(Game.getINSTANCE().getStats().getNbResidencial()-1);
	}
	
	
	public static void buildDistrict(District district) {
		if(Game.getINSTANCE().getDistrictMap()[district.getCoordinates().getColumn()][district.getCoordinates().getRow()].getType() != 0) {	
			if (Constants.DEBUG_DISTRICT) {
				System.out.println("This spot isnt empty!");
			}
		}
		else {
			Game.getINSTANCE().getDistrictMap()[district.getCoordinates().getColumn()][district.getCoordinates().getRow()] = district;
			switch (district.getType()) {
			case Constants.RESIDENCIAL:
				incrementNbResidencial();
				if (Constants.DEBUG_DISTRICT) System.out.println("Add residencial done");
				
				break;
				
			case Constants.ADMINISTRATIVE:
				incrementNbAdministrative();
				if (Constants.DEBUG_DISTRICT) System.out.println("Add administrative done");
				break;

			case Constants.COMMERCIAL: 
				incrementNbCommercial();
				if (Constants.DEBUG_DISTRICT) System.out.println("Add commercial done");
				break;
			default:
				break;
			}
		}
//		for(int i = 0 ; i < GuiConstants.SQUARE_PER_COLUMN; i++) {
//			for(int j = 0 ; j < GuiConstants.SQUARE_PER_ROW; j++) {
//				System.out.print(Game.getINSTANCE().getDistrictMap()[j][i].getType());
//			}
//			System.out.println();
//		}
	}
	
	public static void destroyDistrict(Coordinates coordinates) {
		switch (Game.getINSTANCE().getDistrictMap()[coordinates.getColumn()][coordinates.getRow()].getType()) {
		case Constants.RESIDENCIAL:
			decrementNbResidencial();
			if (Constants.DEBUG_DISTRICT) System.out.println("Destroy residencial done");
			
			break;
			
		case Constants.ADMINISTRATIVE:
			decrementNbAdministrative();
			if (Constants.DEBUG_DISTRICT) System.out.println("Destroy administrative done");
			break;

		case Constants.COMMERCIAL: 
			decrementNbCommercial();
			if (Constants.DEBUG_DISTRICT) System.out.println("Destroy commercial done");
			break;
		default:
			break;
		}
		Game.getINSTANCE().getDistrictMap()[coordinates.getColumn()][coordinates.getRow()] = new Wilderness(coordinates);
		if(Game.getINSTANCE().getRailSquareMap()[coordinates.getColumn()][coordinates.getRow()].getType() == Constants.STATION) {
			RailWayManager.destroyStation(coordinates);
		}
	}
	

}
