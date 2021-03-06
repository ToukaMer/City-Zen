package gui_data;

import javafx.scene.paint.Color;

public class GuiConstants {
	
	public static final double FRAME_PER_SECOND = 100; 
	public static final double DAY_PER_SECOND = 1; 

	public static final double OUTLAND = 100;
	public static final int SQUARE_WIDTH = 64;
	public static final int SQUARE_HEIGHT = 64;
	public static final Color BACKGROUND = Color.BLACK;
	public static final int SQUARE_PER_COLUMN = 30;
	public static final int SQUARE_PER_ROW = 30;
	public static final double MAX_SIZE_WIDTH = SQUARE_WIDTH*SQUARE_PER_COLUMN;
	public static final double MAX_SIZE_HEIGHT = SQUARE_HEIGHT*SQUARE_PER_ROW;
	public static final int DISTRICT_MAP = 1;
	public static final int RAIL_NETWORK_MAP = 2;
	public static final int GENERAL_MAP = 3;
	public GuiConstants() {

	}
	
}
