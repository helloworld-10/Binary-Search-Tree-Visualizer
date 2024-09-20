
public class Arrow extends GraphicsComponent {
	double fx,fy;
	public Arrow(double x, double y, double x2, double y2) {
		super.x = x;
		super.y = y;
		this.fy = y2;
		this.fx = x2;
	}
	@Override
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x, y, fx, fy);
	}

}
