package gui;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.districtData.Administrative;
import data.districtData.Commercial;
import data.districtData.Residencial;
import data.railRoadData.Station;
import data.railRoadData.Rail;
import engine.Game;
import engine.managers.DistrictManager;
import engine.managers.RailWayManager;
import gui_data.BlockSize;
import gui_data.CameraPosition;
import gui_data.GuiConstants;
import gui_data.MousePosition;
import gui_data.SpritePaths;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class MapCanvas extends Canvas {

	private BlockSize blockSize;
	private GraphicsContext map;
	
	private CameraPosition cameraPosition;
	private CameraPosition tracking;
	private int numberOfSquares;
	private int currentMap;
	private boolean displayGrid;
	private Coordinates mouseOnSquare;
	private MousePosition movingMouse;
	
	private Image districtSprite;
	private Image railNetworkSquareSprite;
	private Image residentialSprite;
	private Image administrativeSprite;
	private Image commercialSprite;
	private Image stationSprite;
	private Image gridSprite;
	
	private Image railNorthDirectionSprite;
	private Image railSouthDirectionSprite;
	private Image railEastDirectionSprite;
	private Image railWestDirectionSprite;
	
	private ArrayList<Coordinates> railroad;
	private Coordinates startingStation;
	private Coordinates endingStation;
	private boolean draggingRailroad;

	public MapCanvas(double width, double height,  Root root, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setWidth(getBlockSize().getWidth());
		setHeight(getBlockSize().getHeight());

		setTracking(playableGrid.getTracking());
		setCameraPosition(playableGrid.getCameraPosition());
		
		setMovingMouse(new MousePosition());
		setMouseOnSquare(new Coordinates());
		setStartingStation(new Coordinates());
		setEndingStation(new Coordinates());
		setRailroad(new ArrayList<Coordinates>());
		setDraggingRailroad(false);
		setDisplayGrid(true);
		initializeSprites();
		setCurrentMap(GuiConstants.DISTRICT_MAP);
		
		setMap(getGraphicsContext2D());
		animatedMap(playableGrid);
		initializeMovingMouseListener();
		initializeReleasedMouseListener(playableGrid);
		initializeDraggingMouseListener();
		initializeMousePressedListener(playableGrid);
		
	}
	
	public void initializeSprites() {
		setDistrictSprite(new Image(getClass().getResource(SpritePaths.DISTRICT_SPRITE).toString()));
		setRailNetworkSquareSprite(new Image(getClass().getResource(SpritePaths.RAIL_NETWORK_BACKGROUND_SPRITE).toString()));
		setResidentialSprite(new Image(getClass().getResource(SpritePaths.RESIDENCE_SPRITE).toString()));
		setAdministrativeSprite(new Image(getClass().getResource(SpritePaths.ADMINISTRATIVE_SPRITE).toString()));
		setCommercialSprite(new Image(getClass().getResource(SpritePaths.COMMERCIAL_SPRITE).toString()));
		setStationSprite(new Image(getClass().getResource(SpritePaths.STATION_SPRITE).toString()));
		setRailNorthDirectionSprite(new Image(getClass().getResource(SpritePaths.RAIL_NORTH_SPRITE).toString()));
		setRailSouthDirectionSprite(new Image(getClass().getResource(SpritePaths.RAIL_SOUTH_SPRITE).toString()));
		setRailEastDirectionSprite(new Image(getClass().getResource(SpritePaths.RAIL_EAST_SPRITE).toString()));
		setRailWestDirectionSprite(new Image(getClass().getResource(SpritePaths.RAIL_WEST_SPRITE).toString()));
		setGridSprite(new Image(getClass().getResource(SpritePaths.GRID_SPRITE).toString()));
	}
	public void animatedMap(final PlayableGrid playableGrid) {
		new AnimationTimer() {
			public void handle(long now) {
				getMap().setFill(GuiConstants.BACKGROUND);
				getMap().fillRect(0, 0, getWidth(), getHeight());
				
				if(getTracking().getX() > 0 && getCameraPosition().getX() < GuiConstants.MAX_SIZE_WIDTH - getBlockSize().getWidth() + GuiConstants.OUTLAND) {
					getCameraPosition().setX(getCameraPosition().getX()+getTracking().getX());
				}
				else if(getTracking().getX() < 0 && getCameraPosition().getX() > 0 - GuiConstants.OUTLAND) {
					getCameraPosition().setX(getCameraPosition().getX()+getTracking().getX());
				}
				
				if(getTracking().getY() > 0 && getCameraPosition().getY() < GuiConstants.MAX_SIZE_HEIGHT - getBlockSize().getHeight() + GuiConstants.OUTLAND) {
					getCameraPosition().setY(getCameraPosition().getY()+getTracking().getY());
				}
				else if(getTracking().getY() < 0 && getCameraPosition().getY() > 0 - GuiConstants.OUTLAND) {
					getCameraPosition().setY(getCameraPosition().getY()+getTracking().getY());
				}
				
				double columnModulus = getCameraPosition().getX()%GuiConstants.SQUARE_WIDTH;
				double rowModulus = getCameraPosition().getY()%GuiConstants.SQUARE_HEIGHT;
				double columnPosition = -columnModulus;
				double rowPosition = -rowModulus;
				
				int firstColumn = (int)getCameraPosition().getX()/GuiConstants.SQUARE_WIDTH;
				int firstRow = (int)getCameraPosition().getY()/GuiConstants.SQUARE_HEIGHT;
				int currentRow = firstRow;
				int currentColumn = firstColumn;

				//Display background
				while(rowPosition < getBlockSize().getHeight()-rowModulus+GuiConstants.SQUARE_HEIGHT) {
					while(columnPosition < getBlockSize().getWidth()-columnModulus+GuiConstants.SQUARE_WIDTH) {
						if(currentColumn >= 0 && currentRow >= 0 && currentColumn < GuiConstants.SQUARE_PER_ROW && currentRow < GuiConstants.SQUARE_PER_COLUMN) {
							displayBackgroundMap(columnPosition, rowPosition, currentColumn, currentRow);
						}
						currentColumn++;
						columnPosition += GuiConstants.SQUARE_WIDTH;
					}
					currentColumn = firstColumn;
					columnPosition = -columnModulus;
					currentRow++;
					rowPosition += GuiConstants.SQUARE_HEIGHT;
				}
				columnPosition = -columnModulus;
				rowPosition = -rowModulus;
				currentRow = firstRow;
				currentColumn = firstColumn;
				displayOverviewRailroad();
				
				//Display district map
				if(getCurrentMap()==GuiConstants.DISTRICT_MAP) {
					while(rowPosition < getBlockSize().getHeight()-rowModulus+GuiConstants.SQUARE_HEIGHT) {
						while(columnPosition < getBlockSize().getWidth()-columnModulus+GuiConstants.SQUARE_WIDTH) {
							if(currentColumn >= 0 && currentRow >= 0 && currentColumn < GuiConstants.SQUARE_PER_ROW && currentRow < GuiConstants.SQUARE_PER_COLUMN) {
								displayDistrictMap(columnPosition, rowPosition, currentColumn, currentRow);
							}
							currentColumn++;
							columnPosition += GuiConstants.SQUARE_WIDTH;
						}
						currentColumn = firstColumn;
						columnPosition = -columnModulus;
						currentRow++;
						rowPosition += GuiConstants.SQUARE_HEIGHT;
					}
					columnPosition = -columnModulus;
					rowPosition = -rowModulus;
					currentRow = firstRow;
					currentColumn = firstColumn;
				}
				
				//Display rail network map
				else if(getCurrentMap()==GuiConstants.RAIL_NETWORK_MAP) {
					while(rowPosition < getBlockSize().getHeight()-rowModulus+GuiConstants.SQUARE_HEIGHT) {
						while(columnPosition < getBlockSize().getWidth()-columnModulus+GuiConstants.SQUARE_WIDTH) {
							if(currentColumn >= 0 && currentRow >= 0 && currentColumn < GuiConstants.SQUARE_PER_ROW && currentRow < GuiConstants.SQUARE_PER_COLUMN) {
								displayRailNetworkMap(columnPosition, rowPosition, currentColumn, currentRow);
							}
							currentColumn++;
							columnPosition += GuiConstants.SQUARE_WIDTH;
						}
						currentColumn = firstColumn;
						columnPosition = -columnModulus;
						currentRow++;
						rowPosition += GuiConstants.SQUARE_HEIGHT;
					}
					columnPosition = -columnModulus;
					rowPosition = -rowModulus;
					currentRow = firstRow;
					currentColumn = firstColumn;
				}
				
				//Display map's grid
				if(isDisplayGrid()) {
					while(rowPosition < getBlockSize().getHeight()-rowModulus+GuiConstants.SQUARE_HEIGHT) {
						while(columnPosition < getBlockSize().getWidth()-columnModulus+GuiConstants.SQUARE_WIDTH) {
							if(currentColumn >= 0 && currentRow >= 0 && currentColumn < GuiConstants.SQUARE_PER_ROW && currentRow < GuiConstants.SQUARE_PER_COLUMN) {
								getMap().drawImage(getGridSprite(), columnPosition, rowPosition);
							}
							currentColumn++;
							columnPosition += GuiConstants.SQUARE_WIDTH;
						}
						currentColumn = firstColumn;
						columnPosition = -columnModulus;
						currentRow++;
						rowPosition += GuiConstants.SQUARE_HEIGHT;
					}
					columnPosition = -columnModulus;
					rowPosition = -rowModulus;
					currentRow = firstRow;
					currentColumn = firstColumn;
				}
				initializeSquareClicks(firstRow, firstColumn, rowModulus, columnModulus, playableGrid);
				displayOverviewBuilding();
			}
		}.start();
	}
	
	public void displayBackgroundMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		if(getCurrentMap()==GuiConstants.DISTRICT_MAP) {
			getMap().drawImage(getDistrictSprite(), columnPosition, rowPosition);
		}
		else if(getCurrentMap()==GuiConstants.RAIL_NETWORK_MAP) {
			getMap().drawImage(getRailNetworkSquareSprite(), columnPosition, rowPosition);
		}
	}
	
	public void displayDistrictMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		
		if(Game.getINSTANCE().getDistrictMap()[currentColumn][currentRow].getType()==Constants.RESIDENCIAL) {
			getMap().drawImage(getResidentialSprite(), columnPosition, rowPosition);
		}
		else if(Game.getINSTANCE().getDistrictMap()[currentColumn][currentRow].getType()==Constants.ADMINISTRATIVE) {
			getMap().drawImage(getAdministrativeSprite(), columnPosition, rowPosition);
		}
		else if(Game.getINSTANCE().getDistrictMap()[currentColumn][currentRow].getType()==Constants.COMMERCIAL) {
			getMap().drawImage(getCommercialSprite(), columnPosition, rowPosition);
		}
	}
	public void displayRailNetworkMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		if(Game.getINSTANCE().getRailSquareMap()[currentColumn][currentRow].getType()==Constants.RAIL) {
			//int[] orientation = Game.getINSTANCE().getRailSquareMap()[currentRow][currentColumn];
			int orientation[] = ((Rail)Game.getINSTANCE().getRailSquareMap()[currentColumn][currentRow]).getDirection();
			if(orientation[Constants.NORTH_DIRECTION] > 0) {
				getMap().drawImage(getRailNorthDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.SOUTH_DIRECTION] > 0) {
				getMap().drawImage(getRailSouthDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.EAST_DIRECTION] > 0) {
				getMap().drawImage(getRailEastDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.WEST_DIRECTION] > 0) {
				getMap().drawImage(getRailWestDirectionSprite(), columnPosition, rowPosition);
			}	
		}
		if(Game.getINSTANCE().getRailSquareMap()[currentColumn][currentRow].getType()==Constants.STATION) {
			int[] orientation = ((Station)Game.getINSTANCE().getRailSquareMap()[currentColumn][currentRow]).getDirection();
			if(orientation[Constants.NORTH_DIRECTION] > 0) {
				getMap().drawImage(getRailNorthDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.SOUTH_DIRECTION] > 0) {
				getMap().drawImage(getRailSouthDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.EAST_DIRECTION] > 0) {
				getMap().drawImage(getRailEastDirectionSprite(), columnPosition, rowPosition);
			}
			if(orientation[Constants.WEST_DIRECTION] > 0) {
				getMap().drawImage(getRailWestDirectionSprite(), columnPosition, rowPosition);
			}	
			getMap().drawImage(getStationSprite(), columnPosition, rowPosition);
		}
	}
	public void initializeSquareClicks(int firstRow, int firstColumn, double rowModulus, double columnModulus, final PlayableGrid playableGrid) {
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				double mouseX = mouseEvent.getX();
				double mouseY = mouseEvent.getY();

				//Calculate the coordinates of the click on the canvas
				double positionX = getCameraPosition().getX()+mouseX;
				double positionY = getCameraPosition().getY()+mouseY;
				
				if(positionX >= 0 && positionX <= GuiConstants.SQUARE_PER_COLUMN*GuiConstants.SQUARE_WIDTH && positionY >= 0 && positionY <= GuiConstants.SQUARE_PER_ROW*GuiConstants.SQUARE_HEIGHT) {

					//Calculate the coordinates of the clicked square
					int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
					int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);

					if(squareX < GuiConstants.SQUARE_PER_ROW && squareY < GuiConstants.SQUARE_PER_COLUMN) {
						System.out.println("X = "+mouseX+" Y = "+mouseY+" | square = ("+squareX+", "+squareY+")");
						
						if(getCurrentMap()==GuiConstants.DISTRICT_MAP) {
							System.out.println("Quartier :"+Game.getINSTANCE().getDistrictMap()[squareX][squareY].getTypeName());
							if(ToolBox.getBuildDistricts()==Constants.RESIDENCIAL) {
								DistrictManager.buildDistrict(new Residencial(new Coordinates(squareY, squareX)));
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getBuildDistricts()==Constants.ADMINISTRATIVE) {
								DistrictManager.buildDistrict(new Administrative(new Coordinates(squareY, squareX)));
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getBuildDistricts()==Constants.COMMERCIAL) {
								DistrictManager.buildDistrict(new Commercial(new Coordinates(squareY, squareX)));
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getDestroy()==1) {
								DistrictManager.destroyDistrict(new Coordinates(squareY, squareX));
								ToolBox.setDestroy(0);
							}
						}
						else {
							System.out.println("Station :"+Game.getINSTANCE().getRailSquareMap()[squareX][squareY].getTypeName());
							if(ToolBox.getBuildRailway()==Constants.STATION) {
								RailWayManager.addStation(squareY, squareX);
								ToolBox.setBuildRailway(0);
							}
//							else if(ToolBox.getDestroy()==1) {
//								RailWayManager.destroyRailWay(startingStation, arrivalStation);
//								ToolBox.setDestroy(0);
//							}
						}
					}
				}
			}
		});
	}
	
	public void initializeMovingMouseListener() {
		setOnMouseMoved(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				getMovingMouse().setX(mouseEvent.getX());
				getMovingMouse().setY(mouseEvent.getY());
				double positionX = getCameraPosition().getX()+getMovingMouse().getX();
				double positionY = getCameraPosition().getY()+getMovingMouse().getY();
				
				//if the mouse is on the board and not out of bonds
				if(positionX >= 0 && positionX <= GuiConstants.SQUARE_PER_COLUMN*GuiConstants.SQUARE_WIDTH && positionY >= 0 && positionY <= GuiConstants.SQUARE_PER_ROW*GuiConstants.SQUARE_HEIGHT) {
					int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
					int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);
					getMouseOnSquare().setColumn(squareX);
					getMouseOnSquare().setRow(squareY);
				}
				else {
					getMouseOnSquare().setColumn(-1);
					getMouseOnSquare().setRow(-1);
				}
			}
		});
	}
	
	public void initializeReleasedMouseListener(final PlayableGrid playableGrid) {
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(ToolBox.getBuildRailway()==Constants.RAIL && isDraggingRailroad()) {
					double mouseX = mouseEvent.getX();
					double mouseY = mouseEvent.getY();

					//Calculate the coordinates of the released on the canvas
					double positionX = getCameraPosition().getX()+mouseX;
					double positionY = getCameraPosition().getY()+mouseY;
					
					if(positionX >= 0 && positionX <= GuiConstants.SQUARE_PER_COLUMN*GuiConstants.SQUARE_WIDTH && positionY >= 0 && positionY <= GuiConstants.SQUARE_PER_ROW*GuiConstants.SQUARE_HEIGHT) {
						//Calculate the coordinates of the released square
						int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
						int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);

						if(Game.getINSTANCE().getRailSquareMap()[squareX][squareY].getType()==Constants.STATION) {
							getEndingStation().setColumn(squareX);
							getEndingStation().setRow(squareY);
							if(getRailroad().contains(getEndingStation())) {
								getRailroad().remove(getEndingStation());
							}
							RailWayManager.addRailWay(getRailroad(), getStartingStation(), getEndingStation());
						}
						
					}
					getRailroad().clear();
					setDraggingRailroad(false);
					ToolBox.setBuildRailway(0);
				}
			}
		});
	}
	
	public void initializeMousePressedListener(final PlayableGrid playableGrid) {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(ToolBox.getBuildRailway()==Constants.RAIL) {
					double mouseX = mouseEvent.getX();
					double mouseY = mouseEvent.getY();

					//Calculate the coordinates of the released on the canvas
					double positionX = getCameraPosition().getX()+mouseX;
					double positionY = getCameraPosition().getY()+mouseY;
					
					if(positionX >= 0 && positionX <= GuiConstants.SQUARE_PER_COLUMN*GuiConstants.SQUARE_WIDTH && positionY >= 0 && positionY <= GuiConstants.SQUARE_PER_ROW*GuiConstants.SQUARE_HEIGHT) {
						//Calculate the coordinates of the released square
						int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
						int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);
						if(Game.getINSTANCE().getRailSquareMap()[squareX][squareY].getType()==Constants.STATION) {
							getStartingStation().setColumn(squareX);
							getStartingStation().setRow(squareY);
							setDraggingRailroad(true);
						}
						else {
							ToolBox.setBuildRailway(0);
						}
					}
				}
			}
		});
	}
	
	public void initializeDraggingMouseListener() {
		setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(isDraggingRailroad()) {
					getMovingMouse().setX(mouseEvent.getX());
					getMovingMouse().setY(mouseEvent.getY());
					double positionX = getCameraPosition().getX()+getMovingMouse().getX();
					double positionY = getCameraPosition().getY()+getMovingMouse().getY();

					int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
					int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);

					Coordinates square = new Coordinates(squareY,squareX);
					if(!getRailroad().contains(square) && !getStartingStation().equals(square)) {
						getRailroad().add(square);
						System.out.println("Added "+square.toString());
					}
					else if(getRailroad().contains(square)){
						int index = getRailroad().indexOf(square);
						int size = getRailroad().size();
						if(index < size) {
							for(int i = size-1; i>index; i--) {
								getRailroad().remove(i);
							}
						}
					}
					else if(square.equals(getStartingStation())) {
						getRailroad().clear();
					}
				}
			}
		});
	}
	
	public void displayOverviewBuilding() {
        if(getMouseOnSquare().getColumn()>=0 && getMouseOnSquare().getRow()>=0) {
            double positionX = getMouseOnSquare().getColumn()*GuiConstants.SQUARE_WIDTH - getCameraPosition().getX();
            double positionY = getMouseOnSquare().getRow()*GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY();
            
            if(ToolBox.getBuildDistricts()>0) {
				switch(ToolBox.getBuildDistricts()) {
					case(Constants.ADMINISTRATIVE): getMap().drawImage(getAdministrativeSprite(), positionX, positionY);
						break;
					case(Constants.COMMERCIAL): getMap().drawImage(getCommercialSprite(), positionX, positionY);
						break;
					case(Constants.RESIDENCIAL): getMap().drawImage(getResidentialSprite(), positionX, positionY);
						break;
				}
			}
			else if(ToolBox.getBuildRailway()>0) {
				switch(ToolBox.getBuildRailway()) {
					case(Constants.STATION): getMap().drawImage(getStationSprite(), positionX, positionY);
						break;
				}
			}
		}
	}
	
	public void displayOverviewRailroad() {
		if(isDraggingRailroad()) {
        	if(!getRailroad().isEmpty()) {
        		Image imageFrom;
        		Image imageTo;
        		int index = 1;
        		int nbOfRails = getRailroad().size();
        		double fromX;
        		double fromY;
        		double toX;
        		double toY;
        		if(getRailroad().get(0).getColumn()<getStartingStation().getColumn()) {
        			imageFrom = getRailWestDirectionSprite();
        			imageTo = getRailEastDirectionSprite();
        		}
        		else if(getRailroad().get(0).getColumn()>getStartingStation().getColumn()) {
            		imageFrom = getRailEastDirectionSprite();
            		imageTo = getRailWestDirectionSprite();
            	}
        		else if(getRailroad().get(0).getRow()<getStartingStation().getRow()) {
        			imageFrom = getRailNorthDirectionSprite();
        			imageTo = getRailSouthDirectionSprite();
        		}
        		else{
        			imageFrom = getRailSouthDirectionSprite();
        			imageTo = getRailNorthDirectionSprite();
        		}

        		fromX = getStartingStation().getColumn()*GuiConstants.SQUARE_WIDTH - getCameraPosition().getX();
        		fromY = getStartingStation().getRow()*GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY();
        		toX = getRailroad().get(0).getColumn()*GuiConstants.SQUARE_WIDTH - getCameraPosition().getX();
        		toY = getRailroad().get(0).getRow()*GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY();
        		
        		//System.out.println("column : "+getRailroad().get(index).getColumn()+" row : "+getRailroad().get(index).getRow());
        		
        		getMap().drawImage(imageFrom, fromX, fromY);
        		getMap().drawImage(imageTo, toX, toY);
        		
        		while(index < nbOfRails) {
        			if(getRailroad().get(index).getColumn()<getRailroad().get(index-1).getColumn()) {
            			imageFrom = new Image(getClass().getResource(SpritePaths.RAIL_WEST_SPRITE).toString());
            			imageTo = new Image(getClass().getResource(SpritePaths.RAIL_EAST_SPRITE).toString());
            		}
            		else if(getRailroad().get(index).getColumn()>getRailroad().get(index-1).getColumn()) {
                			imageFrom = new Image(getClass().getResource(SpritePaths.RAIL_EAST_SPRITE).toString());
                			imageTo = new Image(getClass().getResource(SpritePaths.RAIL_WEST_SPRITE).toString());
                	}
            		else if(getRailroad().get(index).getRow()<getRailroad().get(index-1).getRow()) {
            			imageFrom = new Image(getClass().getResource(SpritePaths.RAIL_NORTH_SPRITE).toString());
            			imageTo = new Image(getClass().getResource(SpritePaths.RAIL_SOUTH_SPRITE).toString());
            		}
            		else{
            			imageFrom = new Image(getClass().getResource(SpritePaths.RAIL_SOUTH_SPRITE).toString());
            			imageTo = new Image(getClass().getResource(SpritePaths.RAIL_NORTH_SPRITE).toString());
            		}

            		fromX = getRailroad().get(index-1).getColumn()*GuiConstants.SQUARE_WIDTH - getCameraPosition().getX();
            		fromY = getRailroad().get(index-1).getRow()*GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY();
            		toX = getRailroad().get(index).getColumn()*GuiConstants.SQUARE_WIDTH - getCameraPosition().getX();
            		toY = getRailroad().get(index).getRow()*GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY();
            		
            		getMap().drawImage(imageFrom, fromX, fromY);
            		getMap().drawImage(imageTo, toX, toY);
            		
            		index++;
        		}
        	}
        }
	}
	public int getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(int currentMap) {
		this.currentMap = currentMap;
	}

	public CameraPosition getCameraPosition() {
		return cameraPosition;
	}
	

	public void setCameraPosition(CameraPosition cameraPosition) {
		this.cameraPosition = cameraPosition;
	}

	public CameraPosition getTracking() {
		return tracking;
	}

	public void setTracking(CameraPosition tracking) {
		this.tracking = tracking;
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public GraphicsContext getMap() {
		return map;
	}

	public void setMap(GraphicsContext map) {
		this.map = map;
	}

	public int getNumberOfSquares() {
		return numberOfSquares;
	}

	public void setNumberOfSquares(int numberOfSquares) {
		this.numberOfSquares = numberOfSquares;
	}

	public Image getDistrictSprite() {
		return districtSprite;
	}

	public void setDistrictSprite(Image districtSprite) {
		this.districtSprite = districtSprite;
	}

	public Image getRailNetworkSquareSprite() {
		return railNetworkSquareSprite;
	}

	public void setRailNetworkSquareSprite(Image railNetworkSquareSprite) {
		this.railNetworkSquareSprite = railNetworkSquareSprite;
	}

	public Image getResidentialSprite() {
		return residentialSprite;
	}

	public void setResidentialSprite(Image residentialSprite) {
		this.residentialSprite = residentialSprite;
	}

	public Image getAdministrativeSprite() {
		return administrativeSprite;
	}

	public void setAdministrativeSprite(Image administrativeSprite) {
		this.administrativeSprite = administrativeSprite;
	}

	public Image getCommercialSprite() {
		return commercialSprite;
	}

	public void setCommercialSprite(Image commercialSprite) {
		this.commercialSprite = commercialSprite;
	}

	public Image getStationSprite() {
		return stationSprite;
	}

	public void setStationSprite(Image stationSprite) {
		this.stationSprite = stationSprite;
	}

	public ArrayList<Coordinates> getRailroad() {
		return railroad;
	}

	public void setRailroad(ArrayList<Coordinates> railroad) {
		this.railroad = railroad;
	}

	public Coordinates getMouseOnSquare() {
		return mouseOnSquare;
	}

	public void setMouseOnSquare(Coordinates mouseOnSquare) {
		this.mouseOnSquare = mouseOnSquare;
	}

	public MousePosition getMovingMouse() {
		return movingMouse;
	}

	public void setMovingMouse(MousePosition movingMouse) {
		this.movingMouse = movingMouse;
	}

	public Coordinates getStartingStation() {
		return startingStation;
	}

	public void setStartingStation(Coordinates startingStation) {
		this.startingStation = startingStation;
	}

	public Coordinates getEndingStation() {
		return endingStation;
	}

	public void setEndingStation(Coordinates endingStation) {
		this.endingStation = endingStation;
	}

	public boolean isDraggingRailroad() {
		return draggingRailroad;
	}

	public void setDraggingRailroad(boolean draggingRailroad) {
		this.draggingRailroad = draggingRailroad;
	}

	public Image getRailNorthDirectionSprite() {
		return railNorthDirectionSprite;
	}

	public void setRailNorthDirectionSprite(Image railNorthDirectionSprite) {
		this.railNorthDirectionSprite = railNorthDirectionSprite;
	}

	public Image getRailSouthDirectionSprite() {
		return railSouthDirectionSprite;
	}

	public void setRailSouthDirectionSprite(Image railSouthDirectionSprite) {
		this.railSouthDirectionSprite = railSouthDirectionSprite;
	}

	public Image getRailEastDirectionSprite() {
		return railEastDirectionSprite;
	}

	public void setRailEastDirectionSprite(Image railEastDirectionSprite) {
		this.railEastDirectionSprite = railEastDirectionSprite;
	}

	public Image getRailWestDirectionSprite() {
		return railWestDirectionSprite;
	}

	public void setRailWestDirectionSprite(Image railWestDirectionSprite) {
		this.railWestDirectionSprite = railWestDirectionSprite;
	}

	public boolean isDisplayGrid() {
		return displayGrid;
	}

	public void setDisplayGrid(boolean displayGrid) {
		this.displayGrid = displayGrid;
	}

	public Image getGridSprite() {
		return gridSprite;
	}

	public void setGridSprite(Image gridSprite) {
		this.gridSprite = gridSprite;
	}

	
	
}
