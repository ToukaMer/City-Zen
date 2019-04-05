package gui;

import data.Save;
import gui_data.BlockSize;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

		setAlignment(Pos.CENTER);

		initializeButtons();
		initializeBackToGame();
		initializeSave();
		initializeLoad();
		initializeQuit();
		
		setSpacing(20);
		
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
		
		getBackToGame().getStyleClass().add("menuButton");
		getSave().getStyleClass().add("menuButton");
		getLoad().getStyleClass().add("menuButton");
		getQuit().getStyleClass().add("menuButton");
		
		getBackToGame().getStyleClass().add("backToGame");
		getSave().getStyleClass().add("save");
		getLoad().getStyleClass().add("load");
		getQuit().getStyleClass().add("quit");
	}
	
	public void initializeBackToGame() {
		getBackToGame().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Root.getINSTANCE().switchToGame();
		    }
		});
	}
	
	public void initializeSave() {
		getSave().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Save.Save_();
		    }
		});
	}
	
	public void initializeLoad() {
		getLoad().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Save.Load();
				Root.getINSTANCE().switchToGame();
		    }
		});
	}
	
	public void initializeQuit() {
		getQuit().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Root.getINSTANCE().switchToMainMenu();
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
