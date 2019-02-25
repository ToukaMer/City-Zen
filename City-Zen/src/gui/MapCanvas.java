package gui;

import data.Constants;
import data.Coordinates;
import engine.Game;
import gui_data.BlockSize;
import gui_data.CameraPosition;
import gui_data.GuiConstants;
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
	
	private Game game;
	
	private CameraPosition cameraPosition;
	private CameraPosition tracking;
	private int numberOfSquares;
	private int currentMap;

	private Image districtSprite;
	private Image railNetworkSquareSprite;
	private Image residenceSprite;

	public MapCanvas(double width, double height,  Root root, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setWidth(getBlockSize().getWidth());
		setHeight(getBlockSize().getHeight());

		setGame(playableGrid.getGame());
		setTracking(playableGrid.getTracking());
		setCameraPosition(playableGrid.getCameraPosition());
		initializeSprites();
		setCurrentMap(GuiConstants.DISTRICT_MAP);
		
		setMap(getGraphicsContext2D());
		animatedMap(playableGrid);
	}
	
	public void initializeSprites() {
		setDistrictSprite(new Image(getClass().getResource(SpritePaths.DISTRICT_SPRITE).toString()));
		setRailNetworkSquareSprite(new Image(getClass().getResource(SpritePaths.RAIL_NETWORK_SQUARE_SPRITE).toString()));
		setResidenceSprite(new Image(getClass().getResource(SpritePaths.RESIDENCE_SPRITE).toString()));
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
			}
		}.start();
	}
	
	public void displayDistrictMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		if(getGame().getDistrictMap()[currentColumn][currentRow].getType()==Constants.WILDERNESS) {
			getMap().drawImage(getDistrictSprite(), columnPosition, rowPosition);
		}
		else if(getGame().getDistrictMap()[currentColumn][currentRow].getType()==Constants.RESIDENCE) {
			getMap().drawImage(getResidenceSprite(), columnPosition, rowPosition);
		}
	}
	public void displayRailNetworkMap(double columnPosition, double rowPosition, int currentColumn, int currentRow) {
		getMap().drawImage(getRailNetworkSquareSprite(), columnPosition, rowPosition);
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
						System.out.println("Quartier :"+getGame().getDistrictMap()[squareX][squareY].getTypeName());
						if(ToolBox.getBuild()==Constants.RESIDENCE) {
							playableGrid.getGame().buildDistrict(Constants.RESIDENCE,playableGrid.getGame().getDistrictManager(),playableGrid.getGame().getDistrictMap(), squareX, squareY);
							ToolBox.setBuild(0);
						}
					}
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
	
	public Image getResidenceSprite() {
		return residenceSprite;
	}

	public void setResidenceSprite(Image residenceSprite) {
		this.residenceSprite = residenceSprite;
	}
	
}
