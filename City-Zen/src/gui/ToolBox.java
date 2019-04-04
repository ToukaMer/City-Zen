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
	private Button destroyDistrictButton;
	private Button destroyStationButton;
	private Button destroyRailwayButton;
	private Tooltip buildResidencialTooltip;
	private Tooltip buildCommercialTooltip;
	private Tooltip buildAdministrativeTooltip;
	private Tooltip buildStationTooltip;
	private Tooltip buildRailWayTooltip;
	private Tooltip destroyRailwayTooltip;
	private Tooltip destroyDistrictTooltip;
	private Tooltip destroyStationTooltip;
	private static int buildRailway;
	private static int buildDistricts;
	private static int destroyDistrict;
	private static int destroyStation;
	private static int destroyRailway;
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
		getTilePane().getChildren().add(getBuildResidencialButton());
		getTilePane().getChildren().add(getBuildStationButton());
		getTilePane().getChildren().add(getBuildRailWayButton());
		getTilePane().getChildren().add(getDestroyDistrictButton());
		getTilePane().getChildren().add(getDestroyStationButton());
		getTilePane().getChildren().add(getDestroyRailwayButton());
		
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
		initializeBuildResidencialButton(root);
		initializeBuildCommercialButton(root);
		initializeBuildAdministrativeButton(root);
		initializeBuildStationButton(root);
		initializeBuildRailWayButton(root);
		initializeDestroyDistrictButton();
		initializeDestroyRailwayButton();
		initializeDestroyStationButton();
	}


	public void initializeBuildResidencialButton(final Root root) {
		setBuildResidentialButton(new Button());
		getBuildResidencialButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.RESIDENTIAL_BUILD_ICON).toString())));
		getBuildResidencialButton().getStyleClass().remove("button");
		getBuildResidencialButton().getStyleClass().add("toolBoxButton");
		getBuildResidencialButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(0);
				setBuildRailway(0);
				setBuildDistricts(Constants.RESIDENCIAL);
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
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(0);
				setBuildRailway(0);
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
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(0);
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
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(0);
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
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(0);
				setBuildDistricts(0);
				setBuildRailway(Constants.RAIL);
		    }
		});
	}
	
	public void initializeDestroyDistrictButton() {
		setDestroyDistrictButton(new Button());
		getDestroyDistrictButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.DESTROY_ICON).toString())));
		getDestroyDistrictButton().getStyleClass().remove("button");
		getDestroyDistrictButton().getStyleClass().add("toolBoxButton");
		getDestroyDistrictButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(1);
				setDestroyRailway(0);
				setDestroyStation(0);
				setBuildRailway(0);
				setBuildDistricts(0);
		    }
		});
	}
	
	public void initializeDestroyStationButton() {
		setDestroyStationButton(new Button());
		getDestroyStationButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.DESTROY_ICON).toString())));
		getDestroyStationButton().getStyleClass().remove("button");
		getDestroyStationButton().getStyleClass().add("toolBoxButton");
		getDestroyStationButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(0);
				setDestroyStation(1);
				setBuildRailway(0);
				setBuildDistricts(0);
		    }
		});
	}
	
	public void initializeDestroyRailwayButton() {
		setDestroyRailwayButton(new Button());
		getDestroyRailwayButton().setGraphic(new ImageView(new Image(getClass().getResource(SpritePaths.DESTROY_RAILWAY_ICON).toString())));
		getDestroyRailwayButton().getStyleClass().remove("button");
		getDestroyRailwayButton().getStyleClass().add("toolBoxButton");
		getDestroyRailwayButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					Root.getINSTANCE().getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
				}
				setDestroyDistrict(0);
				setDestroyRailway(1);
				setDestroyStation(0);
				setBuildRailway(0);
				setBuildDistricts(0);

		    }
		});
	}
	
	public void initializeBuildResidencialTooltip() {
		setBuildResidencialTooltip(new Tooltip());
		getBuildResidencialTooltip().setText("Build a residential");
		getBuildResidencialButton().setTooltip(buildResidencialTooltip);
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
		getBuildStationButton().setTooltip(getBuildStationTooltip());
	}
	
	public void initializeDestroyStationTooltip() {
		setDestroyStationTooltip(new Tooltip());
		getDestroyStationTooltip().setText("Destroy a station");
		getDestroyStationButton().setTooltip(getDestroyStationTooltip());
	}
	
	public void initializeBuildRailWayTooltip() {
		setBuildRailWayTooltip(new Tooltip());
		getBuildRailWayTooltip().setText("Build a railway");
		getBuildRailWayButton().setTooltip(buildRailWayTooltip);
	}
	
	public void initializeDestroyDistrictTooltip() {
		setDestroyDistrictTooltip(new Tooltip());
		getDestroyDistrictTooltip().setText("Destroy a district");
		getDestroyDistrictButton().setTooltip(destroyDistrictTooltip);
	}
	
	public void initializeDestroyRailwayTooltip() {
		setDestroyRailwayTooltip(new Tooltip());
		getDestroyRailwayTooltip().setText("Destroy a railway");
		getDestroyRailwayButton().setTooltip(getDestroyRailwayTooltip());
	}
	
	public void initializeTooltips() {
		initializeBuildResidencialTooltip();
		initializeBuildCommercialTooltip();
		initializeBuildAdministrativeTooltip();
		initializeBuildStationTooltip();
		initializeBuildRailWayTooltip();
		initializeDestroyDistrictTooltip();
		initializeDestroyRailwayTooltip();
		initializeDestroyStationTooltip();
	}
		
	public void initializeTitleLabel() {
		setTitleLabel(new Label());
		getTitleLabel().setText("ToolBox");
		getTitleLabel().getStyleClass().remove("label");
		getTitleLabel().getStyleClass().add("toolBoxLabel");
	}
	
	public Button getBuildResidencialButton() {
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

	public Label getTitleLabel() {
		return titleLabel;
	}



	public void setTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
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
	
	public static int getDestroyRailway() {
		return destroyRailway;
	}

	public static void setDestroyRailway(int destroyRailway) {
		ToolBox.destroyRailway = destroyRailway;
	}

	public Button getDestroyRailwayButton() {
		return destroyRailwayButton;
	}

	public void setDestroyRailwayButton(Button destroyRailwayButton) {
		this.destroyRailwayButton = destroyRailwayButton;
	}

	public Tooltip getDestroyRailwayTooltip() {
		return destroyRailwayTooltip;
	}

	public void setDestroyRailwayTooltip(Tooltip destroyRailwayTooltip) {
		this.destroyRailwayTooltip = destroyRailwayTooltip;
	}

	public Button getDestroyDistrictButton() {
		return destroyDistrictButton;
	}

	public void setDestroyDistrictButton(Button destroyDistrictButton) {
		this.destroyDistrictButton = destroyDistrictButton;
	}

	public Tooltip getBuildResidencialTooltip() {
		return buildResidencialTooltip;
	}

	public void setBuildResidencialTooltip(Tooltip buildResidencialTooltip) {
		this.buildResidencialTooltip = buildResidencialTooltip;
	}

	public Tooltip getDestroyDistrictTooltip() {
		return destroyDistrictTooltip;
	}

	public void setDestroyDistrictTooltip(Tooltip destroyDistrictTooltip) {
		this.destroyDistrictTooltip = destroyDistrictTooltip;
	}

	public Button getBuildResidentialButton() {
		return buildResidentialButton;
	}

	public Button getDestroyStationButton() {
		return destroyStationButton;
	}

	public void setDestroyStationButton(Button destroyStationButton) {
		this.destroyStationButton = destroyStationButton;
	}

	public Tooltip getDestroyStationTooltip() {
		return destroyStationTooltip;
	}

	public void setDestroyStationTooltip(Tooltip destroyStationTooltip) {
		this.destroyStationTooltip = destroyStationTooltip;
	}

	public static int getDestroyDistrict() {
		return destroyDistrict;
	}

	public static void setDestroyDistrict(int destroyDistrict) {
		ToolBox.destroyDistrict = destroyDistrict;
	}

	public static int getDestroyStation() {
		return destroyStation;
	}

	public static void setDestroyStation(int destroyStation) {
		ToolBox.destroyStation = destroyStation;
	}
}
