package gui;

import data.Calendar;
import engine.Game;
import gui_data.BlockSize;
import gui_data.GuiConstants;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToolbarRight extends VBox {

	private BlockSize blockSize;
	
	private Label calendarLabel;
	private Button switchMapButton;
	private Button switchDisplayGridButton;

	public ToolbarRight(double width, double height, Root root) {
		super(10);
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());

		initializeCalendarLabel();
		initializeSwitchMapButton(root);
		initializeSwitchDisplayGridButton(root);
		
		getChildren().add(getCalendarLabel());
		getChildren().add(getSwitchMapButton());
		getChildren().add(getSwitchDisplayGridButton());
	}
	
	public void initializeSwitchMapButton(final Root root) {
		setSwitchMapButton(new Button());
		getSwitchMapButton().setText("Switch map");
		getSwitchMapButton().getStyleClass().add("menuButton");
		getSwitchMapButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.DISTRICT_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.RAIL_NETWORK_MAP);
					ToolBox.setDestroyDistrict(0);
					ToolBox.setDestroyRailway(0);
					ToolBox.setDestroyStation(0);
					ToolBox.setBuildRailway(0);
					ToolBox.setBuildDistricts(0);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.RAIL_NETWORK_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.GENERAL_MAP);
					ToolBox.setDestroyDistrict(0);
					ToolBox.setDestroyRailway(0);
					ToolBox.setDestroyStation(0);
					ToolBox.setBuildRailway(0);
					ToolBox.setBuildDistricts(0);
				}
				else if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().getCurrentMap() == GuiConstants.GENERAL_MAP) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setCurrentMap(GuiConstants.DISTRICT_MAP);
					ToolBox.setDestroyDistrict(0);
					ToolBox.setDestroyRailway(0);
					ToolBox.setDestroyStation(0);
					ToolBox.setBuildRailway(0);
					ToolBox.setBuildDistricts(0);
				}
		    }
		});
	}
	public void initializeSwitchDisplayGridButton(final Root root) {
		setSwitchDisplayGridButton(new Button());
		getSwitchDisplayGridButton().setText("Display grid");
		getSwitchDisplayGridButton().getStyleClass().add("menuButton");
		getSwitchDisplayGridButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if(root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().isDisplayGrid()) {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setDisplayGrid(false);
					ToolBox.setBuildDistricts(0);
					ToolBox.setDestroyDistrict(0);
				}
				else {
					root.getPlayableGrid().getGameBlock().getMapZone().getMapCanvas().setDisplayGrid(true);
					ToolBox.setBuildDistricts(0);
					ToolBox.setDestroyDistrict(0);
				}
		    }
		});
	}
	
	public void initializeCalendarLabel() {
		setCalendarLabel(new Label());
		getCalendarLabel().setId("calendarLabel");
		Calendar calendar = Game.getINSTANCE().getStats().getCalendar();
		getCalendarLabel().setText(calendar.getDayName()+", "+calendar.getMonthName()+" "+calendar.getDayNumber()+", Year "+calendar.getYearNumber());
	}
	
	public void updateCalendarLabel(Calendar calendar) {
		getCalendarLabel().setText(calendar.getDayName()+", "+calendar.getMonthName()+" "+calendar.getDayNumber()+", Year "+calendar.getYearNumber());
	
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

	public Label getCalendarLabel() {
		return calendarLabel;
	}

	public void setCalendarLabel(Label calendarLabel) {
		this.calendarLabel = calendarLabel;
	}
}
