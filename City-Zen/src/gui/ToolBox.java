package gui;

import gui_data.BlockSize;
import gui_data.GuiConstants;
import gui_data.SpritePaths;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import data.Constants;

public class ToolBox extends VBox{
	
	private BlockSize blockSize;
	private Label titleLabel;
	private Button buildResidentialButton;
	private Button buildCommercialButton;
	private Button buildAdministrativeButton;
	private Button buildStationButton;
	private Button buildRailWayButton;
	private Button destroyButton;
	private Tooltip buildResidentialTooltip;
	private Tooltip buildCommercialTooltip;
	private Tooltip buildAdministrativeTooltip;
	private Tooltip destroyTooltip;
	private Tooltip buildStationTooltip;
	private Tooltip buildRailWayTooltip;
	private static int buildRailway;
	private static int buildDistricts;
	private static int destroy;
	private TilePane tilePane;

	public ToolBox(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeTilePane();
		initializeButtons(root);
		initializeTitleLabel();
		initializeTooltips();
		
		getTilePane().getChildren().add(getBuildAdministrativeButton());
		getTilePane().getChildren().add(getBuildCommercialButton());
		getTilePane().getChildren().add(getBuildResidentialButton());
		getTilePane().getChildren().add(getBuildStationButton());
		getTilePane().getChildren().add(getBuildRailWayButton());
		getTilePane().getChildren().add(getDestroyButton());
		
		getChildren().add(getTitleLabel());
		getChildren().add(getTilePane());
		
	}
	
	public void initializeTilePane() {
		setTilePane(new TilePane());
		getTilePane().setAlignment(Pos.CENTER);
		getTilePane().setHgap(30);
		getTilePane().setVgap(20);
	}
	
	public TilePane getTilePane() {
		return tilePane;
	}

	public void setTilePane(TilePane tilePane) {
		this.tilePane = tilePane;
	}

	public void initializeButtons(final Root root) {
		initializeBuildResidentialButton(root);
		initializeBuildCommercialButton(root);
		initializeBuildAdministrativeButton(root);
		initializeBuildStationButton(root);
		initializeBuildRailWayButton(root);
		initializeDestroyButton();
	}


	public void initializeBuildResidentialButton(final Root root) {
		setBuildResidentialButton(new Button());
		getBuildResidentialButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.RESIDENTIAL_BUILD_ICON).toString())));
		getBuildResidentialButton().getStyleClass().remove("button");
		getBuildResidentialButton().getStyleClass().add("toolBoxButton");
		getBuildResidentialButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				setBuildDistricts(Constants.RESIDENCE);
		    }
		});
	}
	
	public void initializeBuildCommercialButton(final Root root) {
		setBuildCommercialButton(new Button());
		getBuildCommercialButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.COMMERCIAL_BUILD_ICON).toString())));
		getBuildCommercialButton().getStyleClass().remove("button");
		getBuildCommercialButton().getStyleClass().add("toolBoxButton");
		getBuildCommercialButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				setBuildDistricts(Constants.COMMERCIAL);
		    }
		});
	}
	
	public void initializeBuildAdministrativeButton(final Root root) {
		setBuildAdministrativeButton(new Button());
		getBuildAdministrativeButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.ADMINISTRATIVE_BUILD_ICON).toString())));
		getBuildAdministrativeButton().getStyleClass().remove("button");
		getBuildAdministrativeButton().getStyleClass().add("toolBoxButton");
		getBuildAdministrativeButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
				}
				setBuildRailway(0);
				setBuildDistricts(Constants.ADMINISTRATIVE);
		    }
		});
	}
	
	public void initializeBuildStationButton(final Root root) {
		setBuildStationButton(new Button());
		getBuildStationButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.STATION_BUILD_ICON).toString())));
		getBuildStationButton().getStyleClass().remove("button");
		getBuildStationButton().getStyleClass().add("toolBoxButton");
		getBuildStationButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
				}
				setBuildDistricts(0);
				setBuildRailway(Constants.STATION);
		    }
		});
	}
	
	public void initializeBuildRailWayButton(final Root root) {
		setBuildRailWayButton(new Button());
		getBuildRailWayButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.RAIL_BUILD_ICON).toString())));
		getBuildRailWayButton().getStyleClass().remove("button");
		getBuildRailWayButton().getStyleClass().add("toolBoxButton");
		getBuildRailWayButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
				}
				setBuildDistricts(0);
				setBuildRailway(Constants.RAILWAY);
		    }
		});
	}
	
	public void initializeDestroyButton() {
		setDestroyButton(new Button());
		getDestroyButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.DESTROY_ICON).toString())));
		getDestroyButton().getStyleClass().remove("button");
		getDestroyButton().getStyleClass().add("toolBoxButton");
		getDestroyButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				setDestroy(1);
		    }
		});
	}
	
	public void initializeBuildResidentialTooltip() {
		setBuildResidentialTooltip(new Tooltip());
		getBuildResidentialTooltip().setText("Build a residential");
		getBuildResidentialButton().setTooltip(buildResidentialTooltip);
	}
	
	public void initializeBuildCommercialTooltip() {
		setBuildCommercialTooltip(new Tooltip());
		getBuildCommercialTooltip().setText("Build a commercial");
		getBuildCommercialButton().setTooltip(buildCommercialTooltip);
	}
	
	public void initializeBuildAdministrativeTooltip() {
		setBuildAdministrativeTooltip(new Tooltip());
		getBuildAdministrativeTooltip().setText("Build an administrative");
		getBuildAdministrativeButton().setTooltip(buildAdministrativeTooltip);
	}
	
	public void initializeBuildStationTooltip() {
		setBuildStationTooltip(new Tooltip());
		getBuildStationTooltip().setText("Build a station");
		getBuildStationButton().setTooltip(buildStationTooltip);
	}
	
	public void initializeBuildRailWayTooltip() {
		setBuildRailWayTooltip(new Tooltip());
		getBuildRailWayTooltip().setText("Build an railway");
		getBuildRailWayButton().setTooltip(buildRailWayTooltip);
	}
	
	public void initializeDestroyTooltip() {
		setDestroyTooltip(new Tooltip());
		getDestroyTooltip().setText("Destroy");
		getDestroyButton().setTooltip(destroyTooltip);
	}
	
	public void initializeTooltips() {
		initializeBuildResidentialTooltip();
		initializeBuildCommercialTooltip();
		initializeBuildAdministrativeTooltip();
		initializeBuildStationTooltip();
		initializeBuildRailWayTooltip();
		initializeDestroyTooltip();
	}
		
	public void initializeTitleLabel() {
		setTitleLabel(new Label());
		getTitleLabel().setText("ToolBox");
		getTitleLabel().getStyleClass().remove("label");
		getTitleLabel().getStyleClass().add("toolBoxLabel");
	}
	
	public Button getBuildResidentialButton() {
		return buildResidentialButton;
	}

	public void setBuildResidentialButton(Button buildResidentialButton) {
		this.buildResidentialButton = buildResidentialButton;
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
	
	public static int getBuildRailway() {
		return buildRailway;
	}

	public static void setBuildRailway(int buildRailway) {
		ToolBox.buildRailway = buildRailway;
	}

	public static int getBuildDistricts() {
		return buildDistricts;
	}

	public static void setBuildDistricts(int buildDistricts) {
		ToolBox.buildDistricts = buildDistricts;
	}

	public static int getDestroy() {
		return destroy;
	}

	public static void setDestroy(int destroy) {
		ToolBox.destroy = destroy;
	}



	public Label getTitleLabel() {
		return titleLabel;
	}



	public void setTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
	}



	public Tooltip getBuildResidentialTooltip() {
		return buildResidentialTooltip;
	}



	public void setBuildResidentialTooltip(Tooltip buildResidentialTooltip) {
		this.buildResidentialTooltip = buildResidentialTooltip;
	}



	public Tooltip getBuildCommercialTooltip() {
		return buildCommercialTooltip;
	}



	public void setBuildCommercialTooltip(Tooltip buildCommercialTooltip) {
		this.buildCommercialTooltip = buildCommercialTooltip;
	}



	public Tooltip getBuildAdministrativeTooltip() {
		return buildAdministrativeTooltip;
	}



	public void setBuildAdministrativeTooltip(Tooltip buildAdministrativeTooltip) {
		this.buildAdministrativeTooltip = buildAdministrativeTooltip;
	}



	public Tooltip getDestroyTooltip() {
		return destroyTooltip;
	}



	public void setDestroyTooltip(Tooltip destroyTooltip) {
		this.destroyTooltip = destroyTooltip;
	}



	public Tooltip getBuildStationTooltip() {
		return buildStationTooltip;
	}



	public void setBuildStationTooltip(Tooltip buildStationTooltip) {
		this.buildStationTooltip = buildStationTooltip;
	}



	public Tooltip getBuildRailWayTooltip() {
		return buildRailWayTooltip;
	}

	public void setBuildRailWayTooltip(Tooltip buildRailWayTooltip) {
		this.buildRailWayTooltip = buildRailWayTooltip;
	}
	
}
