package gui;

import gui_data.BlockSize;
import javafx.scene.layout.StackPane;

public class Root extends StackPane {
	
	private BlockSize blockSize;
	
	private PlayableGrid playableGrid;
	private Pause pause;
	
	public Root(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setPlayableGrid(new PlayableGrid(width, height, this));
		
		getChildren().add(getPlayableGrid());
		
		initPause();
		getChildren().add(getPause());
		
	}

	public void initPause() {
		setPause(new Pause());
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
