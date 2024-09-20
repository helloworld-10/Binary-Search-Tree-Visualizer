import java.awt.Color;

public class Button {
	private String text;
	private int x, y, w, h;
	
	private float r = -1;
	
	private boolean mouseDown = false;
	
	private boolean pressed = false;
	
	private static final Color BUTTON_DEFAULT_COLOR = new Color(148, 155, 156);
	private static final Color BUTTON_HOVERED_COLOR = new Color(100, 100, 100);
	private static final Color BUTTON_CLICKED_COLOR = new Color(66, 66, 66);
	private static final Color BUTTON_TEXT_COLOR = Color.WHITE;
	
	public Button(String text, int x, int y, int w, int h) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void draw() {
		// TODO Auto-generated method stub
		StdDraw.setPenColor(BUTTON_DEFAULT_COLOR);
		
		r = -1;
		if(w > h) {
			r = h/2.5f;
		} else {
			r = w/2.5f;
		}
		if(hovered()) {
			StdDraw.setPenColor(BUTTON_HOVERED_COLOR);
			if(StdDraw.isMousePressed()) {
				StdDraw.setPenColor(BUTTON_CLICKED_COLOR);
			}
			if(clicked()) {
				if(!pressed) {
					pressed = true;
				}
			} else {
				pressed = false;
			}
		} else {
			pressed = false;
		}

		StdDraw.filledCircle(x - w + r, y + h - r, r);
		StdDraw.filledCircle(x + w - r, y - h + r, r);
		StdDraw.filledCircle(x - w + r, y - h + r, r);
		StdDraw.filledCircle(x + w - r, y + h - r, r);
		
		//StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(x, y, w, h - r);
		StdDraw.filledRectangle(x, y, w - r, h);
		
		StdDraw.setPenColor(BUTTON_TEXT_COLOR);
		StdDraw.text(x, y, text);
		
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	
	private boolean hovered() {
		double mx = StdDraw.mouseX();
		double my = StdDraw.mouseY();
		/*
		if(dist(mx, my, x - w + r, y + h - r) <= r) {
			return true;
		} else if(dist(mx, my, x + w - r, y - h + r) <= r) {
			return true;
		} else if(dist(mx, my, x - w + r, y - h + r) <= r) {
			return true;
		} else if(dist(mx, my, x - w + r, y - h + r) <= r) {
			return true;
		} else if(dist(mx, my, x + w - r, y + h - r) <= r) {
			return true;
		} else if(intersects(mx, my, x - w, x + w, y + h - r, y - h + r)) {
			return true;
		} else if(intersects(mx, my, x - w + r, x + w - r, y + h, y - h)) {
			return true;
		}
		*/
		float left = x - w + r;
		float right = x + w - r;
		float top = y + h - r;
		float bottom = y - h + r;
		
		if(mx > left && mx < right && my > bottom && my < top) {
			return true;
		}
		
		return false;
	}
	
	private double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
	}
	
	private boolean intersects(double x, double y, double left, double right, double top, double bottom) {
		if(x >= left && x <= right && y > bottom && y < top) {
			return true;
		}
		return false;
	}
	
	private boolean clicked() {
		if(StdDraw.isMousePressed()) {
			if(!mouseDown) {
				mouseDown = true;
				return true;
			}
			
		} else {
			mouseDown = false;
		}
		return false;
	}
}