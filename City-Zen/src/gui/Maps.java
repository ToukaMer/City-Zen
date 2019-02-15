package gui;

import gui_data.BlockSize;
import javafx.scene.layout.StackPane;

public class Maps extends StackPane {
	
	private BlockSize blockSize;
	
	private DistrictsMapCanvas districtsMap;
	private RailNetworkMapCanvas railNetworkMap;

	public Maps(double width, double height, Root root, PlayableGrid playableGrid) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setDistrictsMap(new DistrictsMapCanvas(getBlockSize().getWidth(), getBlockSize().getHeight(), playableGrid));
		setRailNetworkMap(new RailNetworkMapCanvas(getBlockSize().getWidth(), getBlockSize().getHeight(), playableGrid));
		
		getChildren().add(getDistrictsMap());
		getChildren().add(getRailNetworkMap());
		
		switchToDistrictsMap();
	}

	void switchToDistrictsMap() {
		getDistrictsMap().toFront();
		getDistrictsMap().setVisible(true);
		getRailNetworkMap().setVisible(false);
	}
	void switchToRailNetworkMap() {
		getRailNetworkMap().toFront();
		getRailNetworkMap().setVisible(true);
		getDistrictsMap().setVisible(false);
	}
	
	public DistrictsMapCanvas getDistrictsMap() {
		return districtsMap;
	}


	public void setDistrictsMap(DistrictsMapCanvas districtsMap) {
		this.districtsMap = districtsMap;
	}


	public RailNetworkMapCanvas getRailNetworkMap() {
		return railNetworkMap;
	}


	public void setRailNetworkMap(RailNetworkMapCanvas railNetworkMap) {
		this.railNetworkMap = railNetworkMap;
	}


	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

}
