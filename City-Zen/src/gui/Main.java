package gui;
	
import java.awt.Dimension;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import gui_data.BlockSize;

public class Main extends Application {
	
	public final static double WIDTH = 800;
	public final static double HEIGHT = 600;
	
	private BlockSize screenSize;
	private Root root;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			
			Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			setScreenSize(new BlockSize(dimension.getWidth(), dimension.getHeight()));
			Scene scene = new Scene(root, getScreenSize().getWidth(), getScreenSize().getHeight());
			//setScreenSize(new BlockSize(WIDTH, HEIGHT));
			//Scene scene = new Scene(root, WIDTH, HEIGHT);
			
			scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());
			primaryStage.setTitle("CityZen");

			primaryStage.setScene(scene);
			
			setRoot(Root.getINSTANCE(getScreenSize().getWidth(), getScreenSize().getHeight()));
			root.getChildren().add(getRoot());
			
			primaryStage.show();
			primaryStage.setFullScreen(true);

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

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}

}
