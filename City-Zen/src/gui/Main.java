package gui;
	
import gui_data.BlockSize;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;




public class Main extends Application {
	
	public final static double WIDTH = 800;
	public final static double HEIGHT = 600;
	
	private BlockSize screenSize;
	private PlayableGrid playableGrid;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			
			//Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			//setScreenSize(new BlockSize(dimension.getWidth(), dimension.getHeight()));
			//Scene scene = new Scene(root, getScreenSize().getWidth(), getScreenSize().getHeight(), Color.LIGHTSTEELBLUE);
			setScreenSize(new BlockSize(WIDTH, HEIGHT));
			Scene scene = new Scene(root, WIDTH, HEIGHT);
			
			scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());
			primaryStage.setTitle("CityZen");

			primaryStage.setScene(scene);
			
			setPlayableGrid(new PlayableGrid(getScreenSize().getWidth(), getScreenSize().getHeight()));
			root.getChildren().add(getPlayableGrid());
			
			primaryStage.show();
			//primaryStage.setFullScreen(true);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public BlockSize getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(BlockSize screenSize) {
		this.screenSize = screenSize;
	}

	public PlayableGrid getPlayableGrid() {
		return playableGrid;
	}

	public void setPlayableGrid(PlayableGrid playableGrid) {
		this.playableGrid = playableGrid;
	}

}
