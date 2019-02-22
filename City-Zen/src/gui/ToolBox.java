package gui;

import gui_data.BlockSize;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;

public class ToolBox extends VBox{
	
	private BlockSize blockSize;
	private Label lbl_toolBox;
	private Button buildResidence;
	private Button buildCommercial;
	private Button buildAdministrative;
	private Button destroyResidence;
	private Button destroyCommercial;
	private Button destroyAdministrative;
	private Tooltip BRTooltip = new Tooltip();
	private Tooltip BCTooltip = new Tooltip();
	private Tooltip BATooltip = new Tooltip();
	private Tooltip DRTooltip = new Tooltip();
	private Tooltip DCTooltip = new Tooltip();
	private Tooltip DATooltip = new Tooltip();
	
	public ToolBox(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		lbl_toolBox = new Label("TB");
		buildResidence = new Button("BR");
		BRTooltip.setText("Build a residence");
		buildResidence.setTooltip(BRTooltip);
		buildCommercial = new Button("BC");
		buildAdministrative = new Button("BA");
		destroyResidence = new Button("DR");
		destroyCommercial = new Button("DC");
		destroyAdministrative = new Button("DA");
		BCTooltip.setText("Build a commercial");
		buildCommercial.setTooltip(BCTooltip);
		BATooltip.setText("Build an administrative");
		buildAdministrative.setTooltip(BATooltip);
		DRTooltip.setText("Destroy a residence");
		destroyResidence.setTooltip(DRTooltip);
		DCTooltip.setText("Destroy a commercial");
		destroyCommercial.setTooltip(DCTooltip);
		DATooltip.setText("Destroy an administrative");
		destroyAdministrative.setTooltip(DATooltip);
		getChildren().add(lbl_toolBox);
		TilePane tilePane = new TilePane();
		tilePane.setHgap(20);
		tilePane.setVgap(20);
		tilePane.getChildren().add(buildAdministrative);
		tilePane.getChildren().add(buildCommercial);
		tilePane.getChildren().add(buildResidence);
		tilePane.getChildren().add(destroyResidence);
		tilePane.getChildren().add(destroyCommercial);
		tilePane.getChildren().add(destroyAdministrative);
		
		getChildren().add(tilePane);
		
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
