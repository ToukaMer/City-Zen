package gui;

import gui_data.BlockSize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Toolbar extends HBox {

	private BlockSize blockSize;
	private Button menu;
	private Root root;

	public Toolbar(double width, double height, Root root) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		setRoot(root);
		initMenu();
		getChildren().add(getMenu());
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
	
	public void initMenu(){
		setMenu(new Button("Menu"));
		this.menu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                root.getPause().toggle();
            }
        });
	}

	public Button getMenu() {
		return menu;
	}

	public void setMenu(Button menu) {
		this.menu = menu;
	}

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}
}
