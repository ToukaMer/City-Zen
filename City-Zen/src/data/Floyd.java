package data;

import java.util.ArrayList;
import data.districtData.District;
import data.districtData.TripPath;
import engine.Game;
import gui_data.GuiConstants;

public class Floyd {
	
	public static void FloydPathFinding(int[][] D, int[][] P) {
		int i = 0;
		int j = 0;
		int tmp;
		
		
		ArrayList<District> list = new ArrayList<>();
		for ( i = 0; i < GuiConstants.SQUARE_PER_ROW; i++) {
			for (j = 0; j < GuiConstants.SQUARE_PER_COLUMN; j++) {
				
				if (Game.getINSTANCE().getDistrictMap()[j][i].getType() != Constants.WILDERNESS) {
					list.add(Game.getINSTANCE().getDistrictMap()[j][i]);
					
				}
			}
		}
		
	
		
		D = new int[list.size()][list.size()];
		P = new int[list.size()][list.size()];
		for (i = 0; i < list.size(); i++) {
			for (j = 0; j < list.size(); j++) {
				D[j][i] = Integer.MAX_VALUE;
				P[j][i] = -1;
				if (list.get(j).getTripPaths().containsKey(list.get(i).getCoordinates())) {
					D[j][i] = list.get(j).getTripPaths().get(list.get(i).getCoordinates()).getTripTime();
					P[j][i] = j;
					
				}
				if (D[j][i]>D[i][j] && D[i][j]>0) {
					D[j][i] = D[i][j];
					P[j][i] = P[i][j];
				}
				
			}
			P[i][i]= i;
			D[i][i] = 0;				
		}		
		
//		System.out.println("D");
//		System.out.print("\t");
//		for (District entry : list) {
//			System.out.print(entry.getCoordinates().toString()+"|\t");
//			
//		}System.out.println();
//		for (int k = 0; k < list.size(); k++) {
//			System.out.print(list.get(k).getCoordinates()+"|\t");
//			for (int l = 0; l < list.size(); l++) {
//				System.out.print(D[k][l]+"|\t");
//			}
//			System.out.println();
//		}
//
//		System.out.println("P");
//		System.out.print("\t");
//		for (District entry : list) {
//			System.out.print(entry.getCoordinates().toString()+"|\t");
//			
//		}System.out.println();
//		for (int k = 0; k < list.size(); k++) {
//			System.out.print(list.get(k).getCoordinates()+"|\t");
//			for (int l = 0; l < list.size(); l++) {
//				System.out.print(P[k][l]+"|\t");
//			}
//			System.out.println();
//		}
//		System.out.println("_______________________________________________________________________");
//		
				
		for (int k = 0; k < list.size(); k++) {
			for (int s = 0; s < list.size(); s++) {
				for (int t = 0; t < list.size(); t++) {
					tmp = D[s][k] + D[k][t];
					if (D[s][t]> tmp && tmp>0) {
						D[s][t] = tmp;
						P[s][t] = P[k][t];
					}
					
					
				}
			}
		}
		
		
//		System.out.println("D");
//		System.out.print("\t");
//		for (District entry : list) {
//			System.out.print(entry.getCoordinates().toString()+"|\t");
//			
//		}System.out.println();
//		for (int k = 0; k < list.size(); k++) {
//			System.out.print(list.get(k).getCoordinates()+"|\t");
//			for (int l = 0; l < list.size(); l++) {
//				System.out.print(D[k][l]+"|\t");
//			}
//			System.out.println();
//		}
//
//		System.out.println("P");
//		System.out.print("\t");
//		for (District entry : list) {
//			System.out.print(entry.getCoordinates().toString()+"|\t");
//			
//		}System.out.println();
//		for (int k = 0; k < list.size(); k++) {
//			System.out.print(list.get(k).getCoordinates()+"|\t");
//			for (int l = 0; l < list.size(); l++) {
//				System.out.print(P[k][l]+"|\t");
//			}
//			System.out.println();
//		}
		
		
		for (int k = 0; k < list.size(); k++) {
			getShortestPath(P,D,k,list);
		}
		
		
		
	}

	public static ArrayList<Coordinates> getShortestPath(int [][]P,int[][]D ,int index, ArrayList<District>districts){
		ArrayList<Coordinates> path = new ArrayList<>();
		ArrayList<Coordinates> tmp = new ArrayList<>();
		int index_tmp = -1;
		for (int i = 0; i <districts.size(); i++) {
			if (index != i) {			
			
			index_tmp = P[index][i];
			if (index_tmp>=0) {
				
			
			//System.out.println("path from ["+districts.get(index).getCoordinates()+":"+districts.get(i).getCoordinates()+"]");
			
			path.addAll(districts.get(index_tmp).getTripPaths().get(districts.get(i).getCoordinates()).getSquares());
			
			
			while (index_tmp !=index) {
				//System.out.println(index_tmp+"----"+districts.indexOf(districts.get(index_tmp))+"-----"+P[index][districts.indexOf(districts.get(index_tmp))]);
							
				 
				tmp.addAll(0,districts.get(P[index][districts.indexOf(districts.get(index_tmp))]).getTripPaths().get(districts.get(index_tmp).getCoordinates()).getSquares());
				tmp.add(districts.get(index_tmp).getCoordinates());
				index_tmp = P[index][districts.indexOf(districts.get(index_tmp))];
				//System.out.println("tmp : "+tmp);
				
			}
			tmp.addAll(path);
			
			
			Game.getINSTANCE().getDistrictMap()	[districts.get(index).getCoordinates().getColumn()]
												[districts.get(index).getCoordinates().getRow()].getTripPaths().
												put(districts.get(i).getCoordinates(), new TripPath(tmp, D[index][i]));
			
			//System.out.println(tmp);
			path = new ArrayList<>();
			tmp = new ArrayList<>();
			}
			}
		}
		
		
		return path;
		
	}
}
