package gui;

import gui_data.BlockSize;
import gui_data.CameraPosition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class RailNetworkMapCanvas extends Canvas{

		private BlockSize blockSize;
		private GraphicsContext map;
		
		private CameraPosition tracking;
		private CameraPosition cameraPosition;
		private int numberOfSquares;
		
		public RailNetworkMapCanvas(double width, double height, PlayableGrid playableGrid) {
			super();
			setBlockSize(new BlockSize(width, height));
			setWidth(getBlockSize().getWidth());
			setHeight(getBlockSize().getHeight());

			setTracking(playableGrid.getTracking());
			setCameraPosition(playableGrid.getCameraPosition());
			
			setMap(getGraphicsContext2D());
		}

		public CameraPosition getTracking() {
			return tracking;
		}

		public void setTracking(CameraPosition tracking) {
			this.tracking = tracking;
		}

		public CameraPosition getCameraPosition() {
			return cameraPosition;
		}

		public void setCameraPosition(CameraPosition cameraPosition) {
			this.cameraPosition = cameraPosition;
		}

		public BlockSize getBlockSize() {
			return blockSize;
		}

		public void setBlockSize(BlockSize blockSize) {
			this.blockSize = blockSize;
		}

		public GraphicsContext getMap() {
			return map;
		}

		public void setMap(GraphicsContext map) {
			this.map = map;
		}

		public int getNumberOfSquares() {
			return numberOfSquares;
		}

		public void setNumberOfSquares(int numberOfSquares) {
			this.numberOfSquares = numberOfSquares;
		}
		
		
	}

