package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Pause extends VBox{
	private boolean flip;
	
	public Pause() {
		super();
		this.flip = false;
	}
	
	public void toggle(){
		if(!this.flip){
			//show the game menu and change the state of the game to pause

			Button save = new Button();
			Button load = new Button();
			Button quit = new Button();
			
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
			
		}
		else{
			//hide the menu and resume the game
			
			
			
		}
	}
}
