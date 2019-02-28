package gui_data;

public class MousePosition {
		private double x;
		private double y;
		
		public MousePosition() {
			this(0.0, 0.0);
		}
		public MousePosition(double x, double y) {
			setX(x);
			setY(y);
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		
	}