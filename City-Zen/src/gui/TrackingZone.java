package gui;

import gui_data.BlockSize;
import gui_data.CameraPosition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TrackingZone extends Pane {

	private final static int COEFFICIENT = 10;
	
	private int horizontalTracking;
	private int verticalTracking;
	private BlockSize blockSize;
	
	private CameraPosition cameraPosition;
	
	public TrackingZone(double width, double height, int horizontalTracking, int verticalTracking, CameraPosition cameraPosition) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setHorizontalTracking(horizontalTracking);
		setVerticalTracking(verticalTracking);
		setMapPosition(cameraPosition);
		
		initializeTracking();
	}
	
	public void initializeTracking() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				double x = getCameraPosition().getX()+getHorizontalTracking()*COEFFICIENT;
				double y = getCameraPosition().getY()+getVerticalTracking()*COEFFICIENT;
				getCameraPosition().setX(x);
				getCameraPosition().setY(y);
			}
		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				getCameraPosition().setX(0);
				getCameraPosition().setY(0);
			}
		});
	}
	public int getHorizontalTracking() {
		return horizontalTracking;
	}

	public void setHorizontalTracking(int horizontalTracking) {
		this.horizontalTracking = horizontalTracking;
	}

	public int getVerticalTracking() {
		return verticalTracking;
	}

	public void setVerticalTracking(int verticalTracking) {
		this.verticalTracking = verticalTracking;
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public CameraPosition getCameraPosition() {
		return cameraPosition;
	}

	public void setMapPosition(CameraPosition cameraPosition) {
		this.cameraPosition = cameraPosition;
	}
	
}
