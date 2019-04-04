/**
 * 
 */
package gui;

import gui_data.BlockSize;
import javafx.event.EventHandler;
/**
 * @author Touka
 *
 */
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartMenu extends VBox{
	
	private BlockSize blockSize;
	
	private Label lbl_cityzen;
	private Button startButton;
	private Button loadButton;
	private Button quitButton;
	
	private static final double BUTTONS_GAP = 0.15;
	
	
	public StartMenu(double width, double height) {
		super(height*BUTTONS_GAP);
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());

		setAlignment(Pos.CENTER);
		
		initializeLabel();
		initializeButtons();
		initializeStartGame();
		initializeQuitGame();
		initializeLoadGame();
		
		getChildren().add(getLbl_cityzen());
		getChildren().add(getStartButton());
		getChildren().add(getLoadButton());
		getChildren().add(getQuitButton());
		setVisible(false);
	}
	
	public void initializeLabel() {
		setLbl_cityzen(new Label("City-Zen"));
		getLbl_cityzen().setPrefWidth(getBlockSize().getWidth());
		getLbl_cityzen().setAlignment(Pos.CENTER);
	}
	
	public void initializeButtons() {
		setStartButton(new Button("Start a new game"));
		getStartButton().setPrefWidth(getBlockSize().getWidth());
		getStartButton().setPrefHeight(getBlockSize().getWidth()*BUTTONS_GAP);
		setLoadButton(new Button("Load a game"));
		getLoadButton().setPrefWidth(getBlockSize().getWidth());
		getLoadButton().setPrefHeight(getBlockSize().getWidth()*BUTTONS_GAP);
		setQuitButton(new Button("Quit"));
		getQuitButton().setPrefWidth(getBlockSize().getWidth());
		getQuitButton().setPrefHeight(getBlockSize().getWidth()*BUTTONS_GAP);
	}
	
	public void initializeStartGame() {
		getStartButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Root.getINSTANCE().switchToStartGame();
		    }
		});
	}
	
	public void initializeQuitGame() {
		getQuitButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				//method to quit the game
		    }
		});
	}
	
	public void initializeLoadGame() {
		getLoadButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				//method to load a game
		    }
		});
	}

	public BlockSize getBlockSize() {
		return blockSize;
	}




	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}




	public Label getLbl_cityzen() {
		return lbl_cityzen;
	}




	public void setLbl_cityzen(Label lbl_cityzen) {
		this.lbl_cityzen = lbl_cityzen;
	}




	public Button getStartButton() {
		return startButton;
	}




	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}




	public Button getLoadButton() {
		return loadButton;
	}




	public void setLoadButton(Button loadButton) {
		this.loadButton = loadButton;
	}




	public Button getQuitButton() {
		return quitButton;
	}




	public void setQuitButton(Button quitButton) {
		this.quitButton = quitButton;
	}

}