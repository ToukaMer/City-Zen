package gui;

import gui_data.BlockSize;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;

public class ToolBox extends TilePane{
	
	private BlockSize blockSize;
	private Label lbl_toolBox;
	private Button buildResidence;
	private Button buildCommercial;
	private Button buildAdministrative;
	private Button destroyResidence;
	private Button destroyCommercial;
	private Button destroyAdministrative;
	
	public ToolBox(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setHgap(20);
		setVgap(20);
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		//lbl_toolBox = new Label("TB");
		buildResidence = new Button("BR");
		buildResidence.setTooltip(new Tooltip("Build a residance"));
		buildCommercial = new Button("BC");
		buildAdministrative = new Button("BA");
		destroyResidence = new Button("DR");
		destroyCommercial = new Button("DC");
		destroyAdministrative = new Button("DA");
		//getChildren().add(lbl_toolBox);
		getChildren().add(buildAdministrative);
		getChildren().add(buildCommercial);
		getChildren().add(buildResidence);
		getChildren().add(destroyResidence);
		getChildren().add(destroyCommercial);
		getChildren().add(destroyAdministrative);
		
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
