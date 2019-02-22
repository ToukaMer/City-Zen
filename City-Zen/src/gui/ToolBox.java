package gui;

import gui_data.BlockSize;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToolBox extends HBox{
	
	private BlockSize blockSize;
	private Label lbl_toolBox;
	private Button buildResidance;
	private Button buildCommercial;
	private Button buildAdministrative;
	
	public ToolBox(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		VBox root = new VBox(20);
		lbl_toolBox = new Label("ToolBox");
		buildResidance = new Button("Build a residance");
		buildCommercial = new Button("Build a commercial");
		buildAdministrative = new Button("buildAdministrative");
		
		root.getChildren().add(lbl_toolBox);
		root.getChildren().add(buildAdministrative);
		root.getChildren().add(buildCommercial);
		root.getChildren().add(buildResidance);
		
		getChildren().add(root);
		
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
