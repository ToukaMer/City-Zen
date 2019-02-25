package gui;

import gui_data.BlockSize;
import javafx.scene.layout.HBox;

public class MapZone extends HBox {
	private final static double MAX_HEIGHT = 1.00;
	private final static double MAP_CANVAS_WIDTH = 0.75;
	private final static double INTERACTIVITY_ZONE_WIDTH = 0.25;
	
	private BlockSize blockSize;
	
	private MapCanvas mapCanvas;
	private InteractivityZone interactivityZone;

	public MapZone(double width, double height, Root root, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setMapCanvas(new MapCanvas(getBlockSize().getWidth()*MAP_CANVAS_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT, root, playableGrid));
		setInteractivityZone(new InteractivityZone(getBlockSize().getWidth()*INTERACTIVITY_ZONE_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT,root));
		
		getChildren().add(getMapCanvas());
		getChildren().add(getInteractivityZone());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}


	public MapCanvas getMapCanvas() {
		return mapCanvas;
	}

	public void setMapCanvas(MapCanvas mapCanvas) {
		this.mapCanvas = mapCanvas;
	}

	public InteractivityZone getInteractivityZone() {
		return interactivityZone;
	}

	public void setInteractivityZone(InteractivityZone interactivityZone) {
		this.interactivityZone = interactivityZone;
	}
}
