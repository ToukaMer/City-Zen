package gui;

import gui_data.BlockSize;
import javafx.scene.layout.StackPane;

public class Root extends StackPane {
	
	private static final double PAUSE_WIDTH = 0.25;
	private static final double PAUSE_HEIGHT = 0.25;
	
	public static Root INSTANCE = null;
	
	private BlockSize blockSize;
	
	private PlayableGrid playableGrid;
	
	private Pause pause;
	
	private Root(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setPlayableGrid(new PlayableGrid(width, height, this));
		setPause(new Pause(width*PAUSE_WIDTH, height*PAUSE_HEIGHT));
		
		getChildren().add(getPlayableGrid());
		getChildren().add(getPause());

		getPlayableGrid().setVisible(true);
		getPause().setVisible(false);
	}

	public static Root getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new Root(0, 0);
		}
		return INSTANCE;
	}
	
	public static Root getINSTANCE(double width, double height) {
		if(INSTANCE == null) {
			INSTANCE = new Root(width, height);
		}
		return INSTANCE;
	}
	
	public void switchToPause() {
		getPause().setVisible(true);
		getPause().toFront();
	}
	
	public void switchToGame() {
		getPause().setVisible(false);
		getPlayableGrid().toFront();
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public PlayableGrid getPlayableGrid() {
		return playableGrid;
	}

	public void setPlayableGrid(PlayableGrid playableGrid) {
		this.playableGrid = playableGrid;
	}

	public Pause getPause() {
		return this.pause;
	}

	public void setPause(Pause pause) {
		this.pause = pause;
	}

}
