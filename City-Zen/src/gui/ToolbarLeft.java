package gui;

import engine.Game;
import gui_data.BlockSize;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ToolbarLeft extends HBox {

	private BlockSize blockSize;
	
	private Button menuButton;
	
	private ProgressIndicator satisfactionCircle;

	public ToolbarLeft(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeMenuButton(root);
		initializeSatisfactionCircle(root);

		getChildren().add(getMenuButton());
		getChildren().add(getSatisfactionCircle());
	}
	
	public void initializeMenuButton(final Root root) {
		setMenuButton(new Button());
		getMenuButton().setText("Menu");
		getMenuButton().getStyleClass().add("menuButton");
		getMenuButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Root.getINSTANCE().switchToPause();
		    }
		});
	}
	
	public void initializeSatisfactionCircle(final Root root){
		
		setSatisfactionCircle(new ProgressIndicator(Game.getINSTANCE().getStats().getSatisfaction()));
		getSatisfactionCircle().getStyleClass().add("satisfaction");
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public Button getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(Button switchMapButton) {
		this.menuButton = switchMapButton;
	}

	public ProgressIndicator getSatisfactionCircle() {
		return satisfactionCircle;
	}

	public void setSatisfactionCircle(ProgressIndicator satisfactionCircle) {
		this.satisfactionCircle = satisfactionCircle;
	}
}
