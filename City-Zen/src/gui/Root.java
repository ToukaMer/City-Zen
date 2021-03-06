package gui;

import data.Calendar;
import data.Save;
import engine.Game;
import gui_data.BlockSize;
import javafx.scene.layout.StackPane;

public class Root extends StackPane {
	
	private static final double PAUSE_WIDTH = 0.25;
	private static final double PAUSE_HEIGHT = 0.25;
	
	private static final double START_MENU_WIDTH = 0.3;
	private static final double START_MENU_HEIGHT = 0.3;
	
	public static Root INSTANCE = null;
	
	private BlockSize blockSize;
	
	private StartMenu startMenu;
	
	private PlayableGrid playableGrid;
	
	private Pause pause;
	
	private Root(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		setStartMenu(new StartMenu(width*START_MENU_WIDTH,height*START_MENU_HEIGHT));
		setPlayableGrid(new PlayableGrid(width, height, this));
		setPause(new Pause(width*PAUSE_WIDTH, height*PAUSE_HEIGHT));
		
		getPause().getStyleClass().remove("button");
		getPause().getStyleClass().add("pause");
		
		getChildren().add(getStartMenu());
		getChildren().add(getPlayableGrid());
		getChildren().add(getPause());

		getStartMenu().setVisible(true);
		getPlayableGrid().setVisible(false);
		getPause().setVisible(false);
		
	}

	public static Root getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new Root(0, 0);
		}
		return INSTANCE;
	}
	
	public static Root getINSTANCE(double width, double height) {
		if(INSTANCE == null) {
			INSTANCE = new Root(width, height);
		}
		return INSTANCE;
	}
	
	public void switchToPause() {
		getPause().setVisible(true);
		getPause().toFront();
		Game.getINSTANCE().setPlaying(false);
	}
	
	public void switchToGame() {
		getPause().setVisible(false);
		getPlayableGrid().toFront();
		Game.getINSTANCE().setPlaying(true);
	}

	public void startGame() {
		getStartMenu().setVisible(false);
		getStartMenu().toBack();
		getPlayableGrid().setVisible(true);
		getPlayableGrid().toFront();
		Game.getINSTANCE().setPlaying(true);
		Game.getINSTANCE().reinitializeGame();
		Game.getINSTANCE().getStats().setCalendar(new Calendar());
	}

	public void switchToMainMenu() {
		getStartMenu().setVisible(true);
		getStartMenu().toFront();
		getPlayableGrid().setVisible(false);
		getPlayableGrid().toBack();
		getPause().setVisible(false);
		getPause().toBack();
		Game.getINSTANCE().setPlaying(false);
	}
	
	public void quitGame() {
		getScene().getWindow().hide();
	}
	
	public void loadGame() {
		Save.Load();
		getStartMenu().setVisible(false);
		getStartMenu().toBack();
		getPlayableGrid().setVisible(true);
		getPlayableGrid().toFront();
		Game.getINSTANCE().setPlaying(true);
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}

	public StartMenu getStartMenu() {
		return startMenu;
	}

	public void setStartMenu(StartMenu startMenu) {
		this.startMenu = startMenu;
	}

	public PlayableGrid getPlayableGrid() {
		return playableGrid;
	}

	public void setPlayableGrid(PlayableGrid playableGrid) {
		this.playableGrid = playableGrid;
	}

	public Pause getPause() {
		return this.pause;
	}

	public void setPause(Pause pause) {
		this.pause = pause;
	}

}
