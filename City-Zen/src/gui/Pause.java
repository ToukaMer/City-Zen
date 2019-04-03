package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Pause extends VBox{
	private boolean flip;
	Button save;
	Button load;
	Button quit;
	Button tuto;
	VBox pauseMenu;
	
	public Pause() {
		super();
		this.flip = false;
		save = new Button("save");
		load = new Button("load");
		quit = new Button("quit");
		tuto = new Button("tuto");

		pauseMenu = new VBox();
		pauseMenu.getChildren().addAll(save, load, quit, tuto);
		setVisible(false);
	}
	
	public void toggle(){
		if(!this.flip){
			//show the game menu and change the state of the game to pause

			System.out.println("show");
			setVisible(true);
			this.flip=true;
			/*
			save.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                
	            }
	        });
			
			load.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                
	            }
	        });
			
			quit.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                
	            }
	        });
			*/
		}
		else{
			//hide the menu and resume the game
			System.out.println("hide");
			setVisible(false);
			this.flip=false;
			
		}
	}
}
