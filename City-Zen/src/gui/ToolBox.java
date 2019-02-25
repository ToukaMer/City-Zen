package gui;

import gui_data.BlockSize;
import gui_data.GuiConstants;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;

public class ToolBox extends VBox{
	
	private BlockSize blockSize;
	private Label lbl_toolBox;
	private Button buildResidanceButton;
	private Button buildCommercialButton;
	private Button buildAdministrativeButton;
	private Button buildStationButton;
	private Button buildRailWayButton;
	private Button destroyButton;
	private Tooltip BRTooltip = new Tooltip();
	private Tooltip BCTooltip = new Tooltip();
	private Tooltip BATooltip = new Tooltip();
	private Tooltip DTooltip = new Tooltip();
	private Tooltip BSTooltip = new Tooltip();
	private Tooltip BRWTooltip = new Tooltip();
	
	public ToolBox(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		TilePane tilePane = new TilePane();
		tilePane.setHgap(20);
		tilePane.setVgap(20);
		initializeBuildResidanceButton(root);
		initializeBuildCommercialButton(root);
		initializeBuildAdministrativeButton(root);
		initializeBuildStationButton(root);
		initializeBuildRailWayButton(root);
		initializeDestroyButton(root);
		lbl_toolBox = new Label("TB");
		BRTooltip.setText("Build a residance");
		getBuildResidanceButton().setTooltip(BRTooltip);
		BCTooltip.setText("Build a commercial");
		getBuildCommercialButton().setTooltip(BCTooltip);
		BATooltip.setText("Build an administrative");
		getBuildAdministrativeButton().setTooltip(BATooltip);
		BSTooltip.setText("Build a station");
		getBuildStationButton().setTooltip(BSTooltip);
		BRWTooltip.setText("Build a railway");
		getBuildRailWayButton().setTooltip(BRWTooltip);
		DTooltip.setText("Destroy");
		getDestroyButton().setTooltip(DTooltip);
		getChildren().add(lbl_toolBox);
		tilePane.getChildren().add(getBuildAdministrativeButton());
		tilePane.getChildren().add(getBuildCommercialButton());
		tilePane.getChildren().add(getBuildResidanceButton());
		tilePane.getChildren().add(getBuildStationButton());
		tilePane.getChildren().add(getBuildRailWayButton());
		tilePane.getChildren().add(getDestroyButton());
		
		getChildren().add(tilePane);
		
	}
	


	public void initializeBuildResidanceButton(final Root root) {
		setBuildResidanceButton(new Button());
		getBuildResidanceButton().setText("BR");
		getBuildResidanceButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					
				}
		    }
		});
	}
	
	public void initializeBuildCommercialButton(final Root root) {
		setBuildCommercialButton(new Button());
		getBuildCommercialButton().setText("BC");
		getBuildCommercialButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					
				}
		    }
		});
	}
	
	public void initializeBuildAdministrativeButton(final Root root) {
		setBuildAdministrativeButton(new Button());
		getBuildAdministrativeButton().setText("BA");
		getBuildAdministrativeButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					
				}
		    }
		});
	}
	
	public void initializeBuildStationButton(final Root root) {
		setBuildStationButton(new Button());
		getBuildStationButton().setText("BS");
		getBuildStationButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					
				}
		    }
		});
	}
	
	public void initializeBuildRailWayButton(final Root root) {
		setBuildRailWayButton(new Button());
		getBuildRailWayButton().setText("BRW");
		getBuildRailWayButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					
				}
		    }
		});
	}
	
	public void initializeDestroyButton(final Root root) {
		setDestroyButton(new Button());
		getDestroyButton().setText("D");
		getDestroyButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				
		    }
		});
	}
	
	public Button getBuildResidanceButton() {
		return buildResidanceButton;
	}

	public void setBuildResidanceButton(Button buildResidanceButton) {
		this.buildResidanceButton = buildResidanceButton;
	}

	public Button getBuildCommercialButton() {
		return buildCommercialButton;
	}

	public void setBuildCommercialButton(Button buildCommercialButton) {
		this.buildCommercialButton = buildCommercialButton;
	}

	public Button getBuildAdministrativeButton() {
		return buildAdministrativeButton;
	}

	public void setBuildAdministrativeButton(Button buildAdministrativeButton) {
		this.buildAdministrativeButton = buildAdministrativeButton;
	}

	public Button getBuildStationButton() {
		return buildStationButton;
	}

	public void setBuildStationButton(Button buildStationButton) {
		this.buildStationButton = buildStationButton;
	}

	public Button getBuildRailWayButton() {
		return buildRailWayButton;
	}

	public void setBuildRailWayButton(Button buildRailWayButton) {
		this.buildRailWayButton = buildRailWayButton;
	}

	public Button getDestroyButton() {
		return destroyButton;
	}

	public void setDestroyButton(Button destroyButton) {
		this.destroyButton = destroyButton;
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
}
