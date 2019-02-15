package gui;

import gui_data.BlockSize;
import gui_data.CameraPosition;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DistrictsMapCanvas extends Canvas {
	private static final double OUTLAND = 100;
	private static final int SQUARE_WIDTH = 50;
	private static final int SQUARE_HEIGHT = 50;
	private static final Color BACKGROUND = Color.BLACK;
	private static final double MAX_SIZE_WIDTH = SQUARE_WIDTH*30;
	private static final double MAX_SIZE_HEIGHT = SQUARE_HEIGHT*30;
	private static final int SQUARE_PER_COLUMN = 30;
	private static final int SQUARE_PER_ROW = 30;

	private BlockSize blockSize;
	private GraphicsContext map;
	
	private CameraPosition cameraPosition;
	private CameraPosition tracking;
	private int numberOfSquares;
	
	private Image districtSprite;
	
	int[][] area;
	
	public DistrictsMapCanvas(double width, double height, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setWidth(getBlockSize().getWidth());
		setHeight(getBlockSize().getHeight());

		setTracking(playableGrid.getTracking());
		setCameraPosition(playableGrid.getCameraPosition());
		setDistrictSprite(new Image(getClass().getResource("\\sprites\\district.png").toString()));
		
		setMap(getGraphicsContext2D());
		
		setArea(new int[SQUARE_PER_ROW][SQUARE_PER_COLUMN]);
		animatedMap();
	}
	
	public void animatedMap() {
		new AnimationTimer() {
			public void handle(long now) {
				getMap().setFill(BACKGROUND);
				getMap().fillRect(0, 0, getWidth(), getHeight());
				
				if(getTracking().getX() > 0 && getCameraPosition().getX() < MAX_SIZE_WIDTH - getBlockSize().getWidth() + OUTLAND) {
					getCameraPosition().setX(getCameraPosition().getX()+getTracking().getX());
				}
				else if(getTracking().getX() < 0 && getCameraPosition().getX() > 0 - OUTLAND) {
					getCameraPosition().setX(getCameraPosition().getX()+getTracking().getX());
				}
				
				if(getTracking().getY() > 0 && getCameraPosition().getY() < MAX_SIZE_HEIGHT - getBlockSize().getHeight() + OUTLAND) {
					getCameraPosition().setY(getCameraPosition().getY()+getTracking().getY());
				}
				else if(getTracking().getY() < 0 && getCameraPosition().getY() > 0 - OUTLAND) {
					getCameraPosition().setY(getCameraPosition().getY()+getTracking().getY());
				}
				
				double columnModulus = getCameraPosition().getX()%SQUARE_WIDTH;
				double rowModulus = getCameraPosition().getY()%SQUARE_HEIGHT;
				double columnPosition = -columnModulus;
				double rowPosition = -rowModulus;
				
				int firstColumn = (int)getCameraPosition().getX()/SQUARE_WIDTH;
				int firstRow = (int)getCameraPosition().getY()/SQUARE_HEIGHT;
				int currentRow = firstRow;
				int currentColumn = firstColumn;

				//System.out.println("trackX = "+getTracking().getX()+" trackY = "+getTracking().getY()+" | x = "+getCameraPosition().getX()+" y = "+getCameraPosition().getY()+" | columnPosition = "+columnPosition+" rowPosition = "+rowPosition+" | currentColumn = "+currentColumn+" currentRow = "+currentRow);
				
				while(rowPosition < getBlockSize().getHeight()-rowModulus+SQUARE_HEIGHT) {
					while(columnPosition < getBlockSize().getWidth()-columnModulus+SQUARE_WIDTH) {
						if(currentColumn >= 0 && currentRow >= 0 && currentColumn < SQUARE_PER_ROW && currentRow < SQUARE_PER_COLUMN) {
							getMap().drawImage(getDistrictSprite(), columnPosition, rowPosition);
						}
						currentColumn++;
						columnPosition += SQUARE_WIDTH;
						//System.out.println("columnPosition = "+columnPosition+" rowPosition = "+rowPosition+" currentColumn = "+currentColumn+" currentRow = "+currentRow);
					}
					currentColumn = firstColumn;
					columnPosition = -columnModulus;
					currentRow++;
					rowPosition += SQUARE_HEIGHT;
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
					int squareX = (int)(positionX/SQUARE_WIDTH);
					int squareY = (int)(positionY/SQUARE_HEIGHT);

					if(squareX < SQUARE_PER_ROW && squareY < SQUARE_PER_COLUMN) {
						System.out.println("X = "+mouseX+" Y = "+mouseY+" | square = ("+squareX+", "+squareY+")");
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

	public int[][] getArea() {
		return area;
	}

	public void setArea(int[][] area) {
		this.area = area;
	}

	
}
