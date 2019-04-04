package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import data.Constants;
import data.districtData.Administrative;
import data.districtData.Commercial;
import data.districtData.District;
import data.districtData.Residencial;
import data.districtData.Wilderness;
import data.railRoadData.NotRailed;
import data.railRoadData.RailSquare;
import data.railRoadData.Station;
import engine.Game;
import engine.managers.RailWayManager;
import gui_data.GuiConstants;

public final class Save {
	
	public Save () {
		
	}
	
	public static void LoadDistrict(BufferedReader bufferedReader) {
		int val = 7;
		char chr = 0;
		String str;
		District district;
		for (int i = 0; i < GuiConstants.SQUARE_PER_ROW; i++) {
			try {
				str = bufferedReader.readLine();
				
				for (int j = 0; j < GuiConstants.SQUARE_PER_COLUMN; j++) {

					chr = str.charAt(j);
					val = Integer.parseInt(String.valueOf(chr));
				
						switch (val) {
						case Constants.ADMINISTRATIVE:
							district = new Administrative(new Coordinates(i, j));
							break;
						case Constants.COMMERCIAL:
							district = new Commercial(new Coordinates(i, j));
							break;
						case Constants.RESIDENCIAL:
							district = new Residencial(new Coordinates(i, j));
								
							break;
						case Constants.WILDERNESS:
						default:
							district = new Wilderness(new Coordinates(i, j));
							break;
						}
						Game.getINSTANCE().getDistrictMap()[j][i] = district;
					
				}			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		try {
			bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void LoadRailway(BufferedReader bufferedReader) {
		int val = 7;
		char chr = 0;
		String str;
		RailSquare railSquare = null;
		for (int i = 0; i < GuiConstants.SQUARE_PER_ROW; i++) {
			try {
				str = bufferedReader.readLine();
				
				for (int j = 0; j < GuiConstants.SQUARE_PER_COLUMN; j++) {

					chr = str.charAt(j);
					val = Integer.parseInt(String.valueOf(chr));
				
						switch (val) {
						case Constants.STATION:
							int direction[] = new int[4];
							railSquare = new Station(new Coordinates(i, j), direction);
							break;
						default :
							railSquare = new NotRailed(new Coordinates(i, j));
						}
						Game.getINSTANCE().getRailSquareMap()[j][i] = railSquare;					
					
				}			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		try {
			bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	public static void LoadStat(BufferedReader bufferedReader) {
		int  k=0;
		char chr = 0;
		String str;
		String tmp = new String();
		
		try {
			str = bufferedReader.readLine();
			
			for (int i = 0; i < str.length()-1; i++) {
				chr = str.charAt(i);
				
				if (chr != '_') {			
					tmp = tmp.concat(Character.toString(chr));

				}
				else {
					switch (k) {
					case 0:
						Game.getINSTANCE().getStats().money = Integer.parseInt(tmp);
						break;
					case 1:
						Game.getINSTANCE().getStats().monthlyRevenues = Integer.parseInt(tmp);
						break;
					case 2:
						Game.getINSTANCE().getStats().monthlyExpences = Integer.parseInt(tmp);
						break;
					case 3:
						Game.getINSTANCE().getStats().nbHab = Integer.parseInt(tmp);
						break;
					case 4:
						Game.getINSTANCE().getStats().nbMaxHab = Integer.parseInt(tmp);
						break;
					case 5:
						Game.getINSTANCE().getStats().nbWorkersAdministrative = Integer.parseInt(tmp);
						break;

					case 6:
						Game.getINSTANCE().getStats().nbWorkersCommercial = Integer.parseInt(tmp);
						break;
					case 7:
						Game.getINSTANCE().getStats().nbResidencial = Integer.parseInt(tmp);
						break;
					case 8:
						Game.getINSTANCE().getStats().nbCommercial = Integer.parseInt(tmp);
						break;
					case 9:
						Game.getINSTANCE().getStats().nbAdministrative = Integer.parseInt(tmp);
						break;
					case 10:
						Game.getINSTANCE().getStats().nbStations = Integer.parseInt(tmp);
						break;
					case 11:
						Game.getINSTANCE().getStats().maxMoney = Integer.parseInt(tmp);
						break;
					case 12:
						Game.getINSTANCE().getStats().gainsPerCommercialWorker = Integer.parseInt(tmp);
						break;
					case 13:
						Game.getINSTANCE().getStats().costsPerAdministrative = Integer.parseInt(tmp);
						break;
					case 14:
						Game.getINSTANCE().getStats().costsPerAdministrativeWorker = Integer.parseInt(tmp);
						break;

					default:
						break;
					}
					k++;
					tmp = "";
				}
				
			}		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
	}
	
	public static void LoadSubway(BufferedReader bufferedReader) {
		int  k=0;
		char chr = 0;
		int row = -1, column = -1;
		ArrayList<Coordinates> path = new ArrayList<>();
		String str;
		String tmp = new String();
		Coordinates start = new Coordinates(-1, -1), end = new Coordinates(-1, -1);
		boolean bool_start = false, bool_end = false, LR = false;
		
		try {
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println("readline : "+str);
				tmp = "";
				for (int i = 0; i < str.length(); i++) {
					chr = str.charAt(i);
					if (chr != '_' && chr != '=') {			
						tmp = tmp.concat(Character.toString(chr));
					}
					else {
						if(!LR) {
							row = Integer.parseInt(tmp);
							LR = true;
						}
						else {
							column = Integer.parseInt(tmp);
							LR = false;
							
							if(!bool_start) {
								start = new Coordinates(row, column);
								bool_start = true;
							}
							else if (!bool_end) {
								end = new Coordinates(row, column);
								bool_end = true;
							}
							else {
								path.add(new Coordinates(row, column));
								
							}
						}
						tmp="";
						
					}
					
					

				}
				if (!path.isEmpty())
				RailWayManager.addRailWay(path, start, end);
				bool_start = false;
				bool_end = false;
				path = new ArrayList<>();
				
			}
			str = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Load() {
		try {
			FileReader fileReader = new FileReader("memory.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileInputStream fileInputStream = new FileInputStream("memory.txt");
			LoadDistrict(bufferedReader);
			LoadRailway(bufferedReader);
			LoadStat(bufferedReader);
			LoadSubway(bufferedReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	public static void Save_() {
		try {
			//BufferedWriter writer = new BufferedWriter(new FileWriter("memory.txt"));
			FileOutputStream outputStream = new FileOutputStream("memory.txt");
		    
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
						//stations = stations.concat(((Station)Game.getINSTANCE().getRailSquareMap()[row][column]).toString_rails());
						stations = stations.concat((Game.getINSTANCE().getDistrictMap()[row][column]).toString());
					}
						
				}
				district = district.concat("\n");
				rail = rail.concat("\n");
			}
			district = district.concat("\n");
			rail = rail.concat("\n");
			stations = stations.concat("\n");
			
			stat = stat.concat(Game.getINSTANCE().getStats().toString());
			stat = stat.concat("\n\n");
			
			//data = data.concat("DISTRICT\n\n\n");
			data =data.concat(district);
			//data =data.concat("RAIL\n\n\n");
			data =data.concat(rail);		
			//data =data.concat("STATION\n\n\n");
			data =data.concat(stat);
			data =data.concat(stations);
			//data =data.concat("STAT\n\n\n");
			
			
			System.out.println(data);
			byte[] strToBytes = data.getBytes();
		    outputStream.write(strToBytes);
		 
		    outputStream.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

}
