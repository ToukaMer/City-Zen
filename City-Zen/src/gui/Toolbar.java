package gui;

import gui_data.BlockSize;
import javafx.scene.layout.HBox;

public class Toolbar extends HBox {

	private final static double MAX_HEIGHT = 1.00;
	private final static double TOOLBAR_LEFT_WIDTH = 0.60;
	private final static double TOOLBAR_RIGHT_WIDTH = 0.40;

	private BlockSize blockSize;
	private ToolbarLeft toolbarLeft;
	private ToolbarRight toolbarRight;

	public Toolbar(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setToolbarLeft(new ToolbarLeft(getBlockSize().getWidth()*TOOLBAR_LEFT_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT, root));
		setToolbarRight(new ToolbarRight(getBlockSize().getWidth()*TOOLBAR_RIGHT_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT, root));
		
		getChildren().add(getToolbarLeft());
		getChildren().add(getToolbarRight());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public ToolbarLeft getToolbarLeft() {
		return toolbarLeft;
	}

	public void setToolbarLeft(ToolbarLeft toolbarLeft) {
		this.toolbarLeft = toolbarLeft;
	}

	public ToolbarRight getToolbarRight() {
		return toolbarRight;
	}

	public void setToolbarRight(ToolbarRight toolbarRight) {
		this.toolbarRight = toolbarRight;
	}
}
