package gui;

import gui_data.BlockSize;
import javafx.scene.layout.VBox;

public class InteractivityZone extends VBox {
	
	private final static double MAX_HEIGHT = 1.00;
	private final static double DATA_DISPLAYER_WIDTH = 0.8;
	private final static double TOOLBOX_WIDTH = 0.2;
	
	private BlockSize blockSize;
	private DataDisplayer dataDisplayer;
	private ToolBox toolBox;
	
	public InteractivityZone(double width, double height) {
		super();
		
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setDataDisplayer(new DataDisplayer(getBlockSize().getWidth()*DATA_DISPLAYER_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT));
		setToolBox(new ToolBox(getBlockSize().getWidth()*TOOLBOX_WIDTH, getBlockSize().getHeight()*MAX_HEIGHT));
		
		getChildren().add(getDataDisplayer());
		getChildren().add(getToolBox());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
	
	public DataDisplayer getDataDisplayer() {
		return dataDisplayer;
	}
	
	public void setDataDisplayer(DataDisplayer dataDisplayer) {
		this.dataDisplayer = dataDisplayer;
	}
	
	public ToolBox getToolBox() {
		return toolBox;
	}
	
	public void setToolBox(ToolBox toolBox) {
		this.toolBox = toolBox;
	}
}
