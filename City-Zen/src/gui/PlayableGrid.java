package gui;

import gui_data.BlockSize;
import gui_data.CameraPosition;
import javafx.scene.layout.GridPane;

public class PlayableGrid extends GridPane {

	private final static double MAX_WIDTH_BOX = 0.94;
	private final static double MAX_HEIGHT_BOX = 0.94;
	private final static double MIN_WIDTH_BOX = 0.03;
	private final static double MIN_HEIGHT_BOX = 0.03;
	
	private BlockSize blockSize;
	private CameraPosition tracking;
	private CameraPosition cameraPosition;

	private TrackingZone northWestTracking;
	private TrackingZone northTracking;
	private TrackingZone northEastTracking;
	private TrackingZone eastTracking;
	private TrackingZone southEastTracking;
	private TrackingZone southTracking;
	private TrackingZone southWestTracking;
	private TrackingZone westTracking;
	
	private GameBlock gameBlock;
	
	public PlayableGrid(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setTracking(new CameraPosition());
		setCameraPosition(new CameraPosition());

		setNorthWestTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, -1, -1, getTracking()));
		setNorthTracking(new TrackingZone(getBlockSize().getWidth()*MAX_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, 0, -1, getTracking()));
		setNorthEastTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, 1, -1, getTracking()));
		setEastTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MAX_HEIGHT_BOX, 1, 0, getTracking()));
		setSouthEastTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, 1, 1, getTracking()));
		setSouthTracking(new TrackingZone(getBlockSize().getWidth()*MAX_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, 0, 1, getTracking()));
		setSouthWestTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MIN_HEIGHT_BOX, -1, 1, getTracking()));
		setWestTracking(new TrackingZone(getBlockSize().getWidth()*MIN_WIDTH_BOX, getBlockSize().getHeight()*MAX_HEIGHT_BOX, -1, 0, getTracking()));
	
		setGameBlock(new GameBlock(getBlockSize().getWidth()*MAX_WIDTH_BOX, getBlockSize().getHeight()*MAX_HEIGHT_BOX, this));

		add(getNorthWestTracking(), 0, 0);
		add(getNorthTracking(), 1, 0);
		add(getNorthEastTracking(), 2, 0);
		add(getEastTracking(), 2, 1);
		add(getSouthEastTracking(), 2, 2);
		add(getSouthTracking(), 1, 2);
		add(getSouthWestTracking(), 0, 2);
		add(getWestTracking(), 0, 1);
		
		add(getGameBlock(), 1, 1);
	}
	
	
	public CameraPosition getTracking() {
		return tracking;
	}


	public void setTracking(CameraPosition tracking) {
		this.tracking = tracking;
	}


	public GameBlock getGameBlock() {
		return gameBlock;
	}


	public void setGameBlock(GameBlock gameBlock) {
		this.gameBlock = gameBlock;
	}


	public BlockSize getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}


	public TrackingZone getNorthWestTracking() {
		return northWestTracking;
	}


	public void setNorthWestTracking(TrackingZone northWestTracking) {
		this.northWestTracking = northWestTracking;
	}


	public TrackingZone getNorthTracking() {
		return northTracking;
	}


	public void setNorthTracking(TrackingZone northTracking) {
		this.northTracking = northTracking;
	}


	public TrackingZone getNorthEastTracking() {
		return northEastTracking;
	}


	public void setNorthEastTracking(TrackingZone northEastTracking) {
		this.northEastTracking = northEastTracking;
	}


	public TrackingZone getEastTracking() {
		return eastTracking;
	}


	public void setEastTracking(TrackingZone eastTracking) {
		this.eastTracking = eastTracking;
	}


	public TrackingZone getSouthEastTracking() {
		return southEastTracking;
	}


	public void setSouthEastTracking(TrackingZone southEastTracking) {
		this.southEastTracking = southEastTracking;
	}


	public TrackingZone getSouthTracking() {
		return southTracking;
	}


	public void setSouthTracking(TrackingZone southTracking) {
		this.southTracking = southTracking;
	}


	public TrackingZone getSouthWestTracking() {
		return southWestTracking;
	}


	public void setSouthWestTracking(TrackingZone southWestTracking) {
		this.southWestTracking = southWestTracking;
	}


	public TrackingZone getWestTracking() {
		return westTracking;
	}


	public void setWestTracking(TrackingZone westTracking) {
		this.westTracking = westTracking;
	}


	public CameraPosition getCameraPosition() {
		return cameraPosition;
	}


	public void setCameraPosition(CameraPosition cameraPosition) {
		this.cameraPosition = cameraPosition;
	}
	
}
