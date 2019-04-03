package gui;

import gui_data.BlockSize;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Pause extends VBox{

	private BlockSize blockSize;

	private Button backToGame;
	private Button save;
	private Button load;
	private Button quit;
	
	public Pause(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());

		initializeButtons();
		initializeBackToGame();
		
		getChildren().add(getBackToGame());
		getChildren().add(getSave());
		getChildren().add(getLoad());
		getChildren().add(getQuit());
		setVisible(false);
	}
	
	public void initializeButtons() {
		setBackToGame(new Button("Back to game"));
		setSave(new Button("Save"));
		setLoad(new Button("Load"));
		setQuit(new Button("Quit game"));
	}
	
	public void initializeBackToGame() {
		getBackToGame().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Root.getINSTANCE().switchToGame();
		    }
		});
	}
	
	public Button getSave() {
		return save;
	}

	public void setSave(Button save) {
		this.save = save;
	}

	public Button getLoad() {
		return load;
	}

	public void setLoad(Button load) {
		this.load = load;
	}

	public Button getQuit() {
		return quit;
	}

	public void setQuit(Button quit) {
		this.quit = quit;
	}
	

	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public Button getBackToGame() {
		return backToGame;
	}

	public void setBackToGame(Button backToGame) {
		this.backToGame = backToGame;
	}
}
