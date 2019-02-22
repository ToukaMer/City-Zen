package gui;

import engine.Game;
import gui_data.BlockSize;
import gui_data.CameraPosition;
import gui_data.GuiConstants;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class DistrictsMapCanvas extends Canvas {

	private BlockSize blockSize;
	private GraphicsContext map;
	
	private Game game;
	
	private CameraPosition cameraPosition;
	private CameraPosition tracking;
	private int numberOfSquares;
	
	private Image districtSprite;
	
	public DistrictsMapCanvas(double width, double height, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setWidth(getBlockSize().getWidth());
		setHeight(getBlockSize().getHeight());

		setGame(playableGrid.getGame());
		setTracking(playableGrid.getTracking());
		setCameraPosition(playableGrid.getCameraPosition());
		setDistrictSprite(new Image(getClass().getResource("\\sprites\\district.png").toString()));
		
		setMap(getGraphicsContext2D());
		animatedMap();
	}
	
	public void animatedMap() {
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

				//System.out.println("trackX = "+getTracking().getX()+" trackY = "+getTracking().getY()+" | x = "+getCameraPosition().getX()+" y = "+getCameraPosition().getY()+" | columnPosition = "+columnPosition+" rowPosition = "+rowPosition+" | currentColumn = "+currentColumn+" currentRow = "+currentRow);
				
				while(rowPosition < getBlockSize().getHeight()-rowModulus+GuiConstants.SQUARE_HEIGHT) {
					while(columnPosition < getBlockSize().getWidth()-columnModulus+GuiConstants.SQUARE_WIDTH) {
						if(currentColumn >= 0 && currentRow >= 0 && currentColumn < GuiConstants.SQUARE_PER_ROW && currentRow < GuiConstants.SQUARE_PER_COLUMN) {
							getMap().drawImage(getDistrictSprite(), columnPosition, rowPosition);
						}
						currentColumn++;
						columnPosition += GuiConstants.SQUARE_WIDTH;
						//System.out.println("columnPosition = "+columnPosition+" rowPosition = "+rowPosition+" currentColumn = "+currentColumn+" currentRow = "+currentRow);
					}
					currentColumn = firstColumn;
					columnPosition = -columnModulus;
					currentRow++;
					rowPosition += GuiConstants.SQUARE_HEIGHT;
				}
				
				initializeSquareClicks(firstRow, firstColumn, rowModulus, columnModulus);
			}
		}.start();
	}
	
	public void initializeSquareClicks(int firstRow, int firstColumn, double rowModulus, double columnModulus) {
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
					}
				}
			}
		});
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

	
}
