package gui;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import engine.Game;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MapCanvas extends Canvas {

	private BlockSize blockSize;
	private GraphicsContext map;
	
	private Game game;
	
	private CameraPosition cameraPosition;
	private CameraPosition tracking;
	private int numberOfSquares;
	private int currentMap;
	private Coordinates mouseOnSquare;
	private MousePosition movingMouse;

	private Image districtSprite;
	private Image railNetworkSquareSprite;
	private Image residentialSprite;
	private Image administrativeSprite;
	private Image commercialSprite;
	private Image stationSprite;
	
	private ArrayList<Coordinates> railroad;
	private Coordinates startingStation;
	private Coordinates endingStation;
	private boolean draggingRailroad;

	public MapCanvas(double width, double height,  Root root, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setWidth(getBlockSize().getWidth());
		setHeight(getBlockSize().getHeight());

		setGame(playableGrid.getGame());
		setTracking(playableGrid.getTracking());
		setCameraPosition(playableGrid.getCameraPosition());
		
		setMovingMouse(new MousePosition());
		setMouseOnSquare(new Coordinates());
		setStartingStation(new Coordinates());
		setEndingStation(new Coordinates());
		setRailroad(new ArrayList<Coordinates>());
		setDraggingRailroad(false);
		initializeSprites();
		setCurrentMap(GuiConstants.DISTRICT_MAP);
		
		setMap(getGraphicsContext2D());
		animatedMap(playableGrid);
		initializeMovingMouseListener();
	}
	
	public void initializeSprites() {
		setDistrictSprite(new Image(getClass().getResource(SpritePaths.DISTRICT_SPRITE).toString()));
		setRailNetworkSquareSprite(new Image(getClass().getResource(SpritePaths.RAIL_NETWORK_SQUARE_SPRITE).toString()));
		setResidentialSprite(new Image(getClass().getResource(SpritePaths.RESIDENCE_SPRITE).toString()));
		setAdministrativeSprite(new Image(getClass().getResource(SpritePaths.ADMINISTRATIVE_SPRITE).toString()));
		setCommercialSprite(new Image(getClass().getResource(SpritePaths.COMMERCIAL_SPRITE).toString()));
		setStationSprite(new Image(getClass().getResource(SpritePaths.STATION_SPRITE).toString()));
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
				}
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
				}
				initializeSquareClicks(firstRow, firstColumn, rowModulus, columnModulus, playableGrid);
				displayOverviewBuilding();
			}
		}.start();
	}
	
	public void displayDistrictMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		if(getCurrentMap()==GuiConstants.DISTRICT_MAP) {
			if(getGame().getDistrictMap()[currentColumn][currentRow].getType()==Constants.RESIDENCE) {
				getMap().drawImage(getResidentialSprite(), columnPosition, rowPosition);
			}
			else if(getGame().getDistrictMap()[currentColumn][currentRow].getType()==Constants.ADMINISTRATIVE) {
				getMap().drawImage(getAdministrativeSprite(), columnPosition, rowPosition);
			}
			else if(getGame().getDistrictMap()[currentColumn][currentRow].getType()==Constants.COMMERCIAL) {
				getMap().drawImage(getCommercialSprite(), columnPosition, rowPosition);
			}
			else {
				getMap().drawImage(getDistrictSprite(), columnPosition, rowPosition);
			}
		}
	}
	public void displayRailNetworkMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		if(getCurrentMap()==GuiConstants.RAIL_NETWORK_MAP) {
			if(getGame().getRailRoadMap()[currentColumn][currentRow].getType()==Constants.STATION) {
				getMap().drawImage(getStationSprite(), columnPosition, rowPosition);
			}
			else {
				getMap().drawImage(getRailNetworkSquareSprite(), columnPosition, rowPosition);
			}
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
				
				if(positionX >= 0 && positionY >= 0) {

					//Calculate the coordinates of the clicked square
					int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
					int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);

					if(squareX < GuiConstants.SQUARE_PER_ROW && squareY < GuiConstants.SQUARE_PER_COLUMN) {
						System.out.println("X = "+mouseX+" Y = "+mouseY+" | square = ("+squareX+", "+squareY+")");
						
						if(getCurrentMap()==GuiConstants.DISTRICT_MAP) {
							System.out.println("Quartier :"+getGame().getDistrictMap()[squareX][squareY].getTypeName());
							if(ToolBox.getBuildDistricts()==Constants.RESIDENCE) {
								playableGrid.getGame().buildDistrict(Constants.RESIDENCE,playableGrid.getGame().getDistrictManager(),playableGrid.getGame().getDistrictMap(), squareX, squareY);
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getBuildDistricts()==Constants.ADMINISTRATIVE) {
								playableGrid.getGame().buildDistrict(Constants.ADMINISTRATIVE,playableGrid.getGame().getDistrictManager(),playableGrid.getGame().getDistrictMap(), squareX, squareY);
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getBuildDistricts()==Constants.COMMERCIAL) {
								playableGrid.getGame().buildDistrict(Constants.COMMERCIAL,playableGrid.getGame().getDistrictManager(),playableGrid.getGame().getDistrictMap(), squareX, squareY);
								ToolBox.setBuildDistricts(0);
							}
							else if(ToolBox.getDestroy()==1) {
								playableGrid.getGame().destroyDistrict(playableGrid.getGame().getDistrictManager(), playableGrid.getGame().getDistrictMap(), squareX, squareY);
								ToolBox.setDestroy(0);
							}
						}
						else {
							System.out.println("Station :"+getGame().getRailRoadMap()[squareX][squareY].getTypeName());
							if(ToolBox.getBuildRailway()==Constants.STATION) {
								playableGrid.getGame().buildStation(playableGrid.getGame().getRailWayManager(),playableGrid.getGame().getRailRoadMap(), squareX, squareY, playableGrid.getGame().getDistrictMap());
								ToolBox.setBuildRailway(0);
							}
							else if(ToolBox.getBuildRailway()==Constants.RAILWAY) {
								if(playableGrid.getGame().getRailRoadMap()[squareX][squareY].getType()==Constants.STATION) {
									getStartingStation().setColumn(squareX);
									getStartingStation().setRow(squareY);
									setDraggingRailroad(true);
								}
								else {
									ToolBox.setBuildRailway(0);
								}
							}
							else if(ToolBox.getDestroy()==1) {
								playableGrid.getGame().destroyStation(playableGrid.getGame().getRailWayManager(), playableGrid.getGame().getRailRoadMap(), squareX, squareY);
								ToolBox.setDestroy(0);
							}
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
				
				//System.out.println("mouseX : "+mouseX+" mouseY : "+mouseY+" positionX : "+positionX+" positionY : "+positionY);
				//if the mouse is on the board and not out of bonds
				if(positionX >= 0 && positionX <= GuiConstants.SQUARE_PER_COLUMN*GuiConstants.SQUARE_WIDTH && positionY >= 0 && positionY <= GuiConstants.SQUARE_PER_ROW*GuiConstants.SQUARE_HEIGHT) {
					int squareX = (int)positionX/GuiConstants.SQUARE_WIDTH;
					int squareY = (int)positionY/GuiConstants.SQUARE_HEIGHT;
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
	
	public void displayOverviewBuilding() {
		if(getMouseOnSquare().getColumn()>=0 && getMouseOnSquare().getRow()>=0) {
			double coordinateX = getMovingMouse().getX()+getTracking().getX();
			double coordinateY = getMovingMouse().getY()+getTracking().getY();

			double positionX = coordinateX - coordinateX%GuiConstants.SQUARE_WIDTH - getCameraPosition().getX()%GuiConstants.SQUARE_WIDTH;
			double positionY = coordinateY - coordinateY%GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY()%GuiConstants.SQUARE_HEIGHT;
			if(ToolBox.getBuildDistricts()>0) {
				switch(ToolBox.getBuildDistricts()) {
					case(Constants.ADMINISTRATIVE): getMap().drawImage(getAdministrativeSprite(), positionX, positionY);
						break;
					case(Constants.COMMERCIAL): getMap().drawImage(getCommercialSprite(), positionX, positionY);
						break;
					case(Constants.RESIDENCE): getMap().drawImage(getResidentialSprite(), positionX, positionY);
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
	
	public void initializeReleasedMouseListener(PlayableGrid playableGrid) {
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(ToolBox.getBuildRailway()==Constants.RAILWAY) {
					double mouseX = mouseEvent.getX();
					double mouseY = mouseEvent.getY();

					//Calculate the coordinates of the released on the canvas
					double positionX = getCameraPosition().getX()+mouseX;
					double positionY = getCameraPosition().getY()+mouseY;
					
					if(positionX >= 0 && positionY >= 0) {
						//Calculate the coordinates of the released square
						int squareX = (int)(positionX/GuiConstants.SQUARE_WIDTH);
						int squareY = (int)(positionY/GuiConstants.SQUARE_HEIGHT);

						if(playableGrid.getGame().getRailRoadMap()[squareX][squareY].getType()==Constants.STATION) {
							getEndingStation().setColumn(squareX);
							getEndingStation().setRow(squareY);
							//appeler fonction de création de ligne
						}
						
					}
					getRailroad().clear();
					setDraggingRailroad(false);
					ToolBox.setBuildRailway(0);
				}
			}
		});
	}
	
	public void initializeDraggingMouseListener() {
		setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(isDraggingRailroad()) {
					double mouseX = mouseEvent.getX();
					double mouseY = mouseEvent.getY();
					
					double coordinateOnMapX = getMovingMouse().getX()+getTracking().getX();
					double coordinateOnMapY = getMovingMouse().getY()+getTracking().getY();

					double positionX = coordinateOnMapX - coordinateOnMapX%GuiConstants.SQUARE_WIDTH - getCameraPosition().getX()%GuiConstants.SQUARE_WIDTH;
					double positionY = coordinateOnMapY - coordinateOnMapY%GuiConstants.SQUARE_HEIGHT - getCameraPosition().getY()%GuiConstants.SQUARE_HEIGHT;
					
					int column = (int)coordinateOnMapX/GuiConstants.SQUARE_WIDTH;
					int row = (int)coordinateOnMapY/GuiConstants.SQUARE_HEIGHT;
					
					Coordinates square = new Coordinates(row, column);
					if(!getRailroad().contains(square)) {
						getRailroad().add(square);
					}
					else {
						int index = getRailroad().indexOf(square);
						int size = getRailroad().size();
						if(index != size) {
							for(int i = size; i>index; i--) {
								getRailroad().remove(i);
							}
						}
					}
					/* Récupérer les coordonnées des cases sur lesquelles la souris passe et les enregistrer dans
					 * l'ArrayList Railroad
					 * 
					 * Faire une fonction d'affichage qui affiche les lignes de métro pendant qu'on les dessine à l'aide des
					 * coordonnées de la souris, de la même manière que pour le sprite qui suit la souris quand on crée un
					 * quartier ou une station
					 * 
					 * Ajouter l'affichage des lignes de métro existantes en fonction de leur direction
					 */
				}
			}
		});
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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

	
	
}
