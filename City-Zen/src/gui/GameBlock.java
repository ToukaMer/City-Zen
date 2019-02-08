package gui;

import gui_data.BlockSize;
import gui_data.CameraPosition;
import javafx.scene.layout.VBox;

public class GameBlock extends VBox {

	private final static double MAX_WIDTH = 1.00;
	private final static double TOOLBAR_HEIGHT = 0.20;
	private final static double MAP_ZONE_HEIGHT = 0.80;

	private BlockSize blockSize;
	
	private Toolbar toolbar;
	private MapZone mapZone;

	public GameBlock(double width, double height, CameraPosition cameraPosition) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());

		setToolbar(new Toolbar(getBlockSize().getWidth()*MAX_WIDTH, getBlockSize().getHeight()*TOOLBAR_HEIGHT));
		setMapZone(new MapZone(getBlockSize().getWidth()*MAX_WIDTH, getBlockSize().getHeight()*MAP_ZONE_HEIGHT, cameraPosition));
	
		getChildren().add(getToolbar());
		getChildren().add(getMapZone());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public Toolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(Toolbar toolbar) {
		this.toolbar = toolbar;
	}

	public MapZone getMapZone() {
		return mapZone;
	}

	public void setMapZone(MapZone mapZone) {
		this.mapZone = mapZone;
	}
	
}
