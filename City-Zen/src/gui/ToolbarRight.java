package gui;

import gui_data.BlockSize;
import gui_data.GuiConstants;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ToolbarRight extends HBox {

	private BlockSize blockSize;
	
	private Button switchMapButton;
	private Button switchDisplayGridButton;

	public ToolbarRight(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeSwitchMapButton(root);
		initializeSwitchDisplayGridButton(root);
		
		getChildren().add(getSwitchMapButton());
		getChildren().add(getSwitchDisplayGridButton());
	}
	
	public void initializeSwitchMapButton(final Root root) {
		setSwitchMapButton(new Button());
		getSwitchMapButton().setText("Switch map");
		getSwitchMapButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
					ToolBox.setBuildDistricts(0);
					ToolBox.setDestroy(0);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
					ToolBox.setBuildRailway(0);
					ToolBox.setDestroy(0);
				}
		    }
		});
	}
	public void initializeSwitchDisplayGridButton(final Root root) {
		setSwitchDisplayGridButton(new Button());
		getSwitchDisplayGridButton().setText("Display grid");
		getSwitchDisplayGridButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().isDisplayGrid()) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setDisplayGrid(false);
					ToolBox.setBuildDistricts(0);
					ToolBox.setDestroy(0);
				}
				else {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setDisplayGrid(true);
					ToolBox.setBuildDistricts(0);
					ToolBox.setDestroy(0);
				}
		    }
		});
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public Button getSwitchMapButton() {
		return switchMapButton;
	}

	public void setSwitchMapButton(Button switchMapButton) {
		this.switchMapButton = switchMapButton;
	}

	public Button getSwitchDisplayGridButton() {
		return switchDisplayGridButton;
	}

	public void setSwitchDisplayGridButton(Button switchDisplayGridButton) {
		this.switchDisplayGridButton = switchDisplayGridButton;
	}
}
