package gui;

import gui_data.BlockSize;
import javafx.scene.layout.VBox;

public class InteractivityZone extends VBox {

	private BlockSize blockSize;

	public InteractivityZone(double width, double height) {
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
