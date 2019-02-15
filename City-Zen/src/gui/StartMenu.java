/**
 * 
 */
package gui;

/**
 * @author Touka
 *
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartMenu extends Application{
	
	private Label lbl_cityzen;
	private Button startButton;
	private Button loadButton;
	private Button quitButton;
	private Button guideButton;

	@Override
	public void start(Stage stage) throws Exception {
		lbl_cityzen = new Label("CityZen");
		lbl_cityzen.setId("lbl_cityzen");
		lbl_cityzen.setPrefWidth(200);
		lbl_cityzen.setAlignment(Pos.CENTER);
		startButton = new Button("Start a new game");
		startButton.setPrefWidth(200);
		loadButton = new Button("Load a game");
		loadButton.setPrefWidth(200);
		quitButton = new Button("Quit");
		quitButton.setPrefWidth(90);
		guideButton = new Button("Guide");
		guideButton.setPrefWidth(90);
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				
			}
			
		});
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(guideButton,quitButton);
		hbox.setAlignment(Pos.CENTER);
		VBox root = new VBox();
		root.getChildren().addAll(lbl_cityzen,startButton,loadButton,hbox);
		root.setAlignment(Pos.CENTER);
		
	}

}