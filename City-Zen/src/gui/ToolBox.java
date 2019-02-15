package gui;

import gui_data.BlockSize;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ToolBox extends HBox{
	
	private BlockSize blockSize;
	private Label lbl_toolBox;
	
	public ToolBox(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		lbl_toolBox = new Label("ToolBox");
		
		getChildren().add(lbl_toolBox);
		
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
