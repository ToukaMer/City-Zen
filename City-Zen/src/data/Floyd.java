package data;

import java.util.ArrayList;
import java.util.Map.Entry;

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
					System.out.println(Game.getINSTANCE().getDistrictMap()[j][i].getCoordinates());
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
		
		
		
		System.out.println("D");
		System.out.print("\t");
		for (District entry : list) {
			System.out.print(entry.getCoordinates().toString()+"|\t");
			
		}System.out.println();
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k).getCoordinates()+"|\t");
			for (int l = 0; l < list.size(); l++) {
				System.out.print(D[k][l]+"|\t");
			}
			System.out.println();
		}

		System.out.println("P");
		System.out.print("\t");
		for (District entry : list) {
			System.out.print(entry.getCoordinates().toString()+"|\t");
			
		}System.out.println();
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k).getCoordinates()+"|\t");
			for (int l = 0; l < list.size(); l++) {
				System.out.print(P[k][l]+"|\t");
			}
			System.out.println();
		}
		System.out.println("_______________________________________________________________________");
		
				
		for (int k = 0; k < list.size(); k++) {
			for (int s = 0; s < list.size(); s++) {
				for (int t = 0; t < list.size(); t++) {
					tmp = D[s][k] + D[k][t];
					if (D[s][t]> tmp && tmp>0) {
						D[s][t] = tmp;
						P[s][t] = P[k][t];
					}
					///////////////////////////
					System.out.println("_______________________________________________________________________");
					System.out.println("D");
					System.out.print("\t");
					for (District entry : list) {
						System.out.print(entry.getCoordinates().toString()+"|\t");
						
					}System.out.println();
					for (int w = 0; w < list.size(); w++) {
						System.out.print(list.get(w).getCoordinates()+"|\t");
						for (int l = 0; l < list.size(); l++) {
							System.out.print(D[w][l]+"|\t");
						}
						System.out.println();
					}

					System.out.println("P");
					System.out.print("\t");
					for (District entry : list) {
						System.out.print(entry.getCoordinates().toString()+"|\t");
						
					}System.out.println();
					for (int w = 0; w < list.size(); w++) {
						System.out.print(list.get(w).getCoordinates()+"|\t");
						for (int l = 0; l < list.size(); l++) {
							System.out.print(P[w][l]+"|\t");
						}
						System.out.println();
					}
					////////////////////////////////
					
				}
			}
		}
		
		
		System.out.println("D");
		System.out.print("\t");
		for (District entry : list) {
			System.out.print(entry.getCoordinates().toString()+"|\t");
			
		}System.out.println();
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k).getCoordinates()+"|\t");
			for (int l = 0; l < list.size(); l++) {
				System.out.print(D[k][l]+"|\t");
			}
			System.out.println();
		}

		System.out.println("P");
		System.out.print("\t");
		for (District entry : list) {
			System.out.print(entry.getCoordinates().toString()+"|\t");
			
		}System.out.println();
		for (int k = 0; k < list.size(); k++) {
			System.out.print(list.get(k).getCoordinates()+"|\t");
			for (int l = 0; l < list.size(); l++) {
				System.out.print(P[k][l]+"|\t");
			}
			System.out.println();
		}
		
		
	}
}
