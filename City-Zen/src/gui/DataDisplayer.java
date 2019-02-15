package gui;

import gui_data.BlockSize;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DataDisplayer extends HBox {
	
	private BlockSize blockSize;
	private Label lbl_dataDisplayer;
	

	public DataDisplayer(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		lbl_dataDisplayer = new Label("Data");
		
		getChildren().add(lbl_dataDisplayer);
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
	
}
