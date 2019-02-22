package gui;

import gui_data.BlockSize;
import javafx.scene.layout.HBox;

public class Toolbar extends HBox {

	private BlockSize blockSize;

	public Toolbar(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
