package gui;

import gui_data.BlockSize;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ToolbarLeft extends HBox {

	private BlockSize blockSize;
	
	private Button menuButton;

	public ToolbarLeft(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeMenuButton(root);
		
		getChildren().add(getMenuButton());
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
}
