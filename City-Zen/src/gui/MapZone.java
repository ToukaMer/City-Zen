package gui;

import gui_data.BlockSize;
import javafx.scene.layout.HBox;

public class MapZone extends HBox {
	private final static double MAX_HEIGHT = 1.00;
	private final static double MAPS_WIDTH = 0.75;
	private final static double INTERACTIVITY_ZONE_WIDTH = 0.25;
	
	private BlockSize blockSize;
	
	private Maps maps;
	private InteractivityZone interactivityZone;

	public MapZone(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setMaps(new Maps(getBlockSize().getWidth()*MAPS_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT, root));
		setInteractivityZone(new InteractivityZone(getBlockSize().getWidth()*INTERACTIVITY_ZONE_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT));
		
		getChildren().add(getMaps());
		getChildren().add(getInteractivityZone());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public Maps getMaps() {
		return maps;
	}

	public void setMaps(Maps maps) {
		this.maps = maps;
	}

	public InteractivityZone getInteractivityZone() {
		return interactivityZone;
	}

	public void setInteractivityZone(InteractivityZone interactivityZone) {
		this.interactivityZone = interactivityZone;
	}
}
