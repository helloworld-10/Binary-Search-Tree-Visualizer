import java.awt.Color;
import java.awt.event.KeyEvent;

public class NumberField {
	private static final Color NUMBERFIELD_DEFAULT_COLOR = new Color(148, 155, 156);
	private static final Color NUMBERFIELD_HOVERED_COLOR = new Color(100, 100, 100);
	private static final Color NUMBERFIELD_SELECTED_COLOR = new Color(66, 66, 66);
	
	private boolean hovered;
	private boolean selected;
	
	String nums;
	int x, y, maxLength;
	int w, h;
	
	public NumberField(int x, int y, int w, int maxLength) {
		nums = "";
		this.x = x;
		this.y = y;
		this.w = w;
		this.maxLength = maxLength;
		h = 12;
		hovered = false;
		selected = false;
	}
	
	public int getNumbers() {
		return Integer.parseInt(nums);
	}
	
	public String getString() {
		return nums;
	}
	
	public void reset() {
		nums = "";
	}
	
	public void draw() {
		keyInput();
		mouseInput();
		
		drawBackdrop();
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(x, y, nums);
	}
	
	private void keyInput() {
		if(selected) {
			if(nums.length() < maxLength) {
				if(KeyboardInputManager.keyDown(KeyEvent.VK_0)) {
					nums += "0";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_1)) {
					nums += "1";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_2)) {
					nums += "2";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_3)) {
					nums += "3";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_4)) {
					nums += "4";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_5)) {
					nums += "5";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_6)) {
					nums += "6";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_7)) {
					nums += "7";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_8)) {
					nums += "8";
				} else if(KeyboardInputManager.keyDown(KeyEvent.VK_9)) {
					nums += "9";
				} 
			}
			if(nums.length() > 0) {
				if(KeyboardInputManager.keyDown(KeyEvent.VK_BACK_SPACE)) {
					nums = nums.substring(0,nums.length() - 1);
				}
			}
		}
	}
	
	private void mouseInput() {
		hovered = intersects(x, y, w, h);
		if(StdDraw.isMousePressed()) {
			selected = hovered;
		}

	}
	
	private static boolean intersects(int x, int y, int w, int h) {
		double mx = StdDraw.mouseX();
		double my = StdDraw.mouseY();
		if(mx > x - w && mx < x + w) {
			if(my > y - h && my < y + h){
				return true;
			}
		}
		return false;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	private void drawBackdrop() {
		float r;
		if(w > h) {
			r = h/2.5f;
		} else {
			r = w/2.5f;
		}
		StdDraw.setPenColor(NUMBERFIELD_DEFAULT_COLOR);
		if(selected) {
			StdDraw.setPenColor(NUMBERFIELD_SELECTED_COLOR);
		} else if(hovered) {
			StdDraw.setPenColor(NUMBERFIELD_HOVERED_COLOR);
		}
		
		
		StdDraw.filledCircle(x - w + r, y + h - r, r);
		StdDraw.filledCircle(x + w - r, y - h + r, r);
		StdDraw.filledCircle(x - w + r, y - h + r, r);
		StdDraw.filledCircle(x + w - r, y + h - r, r);
		
		StdDraw.filledRectangle(x, y, w, h - r);
		StdDraw.filledRectangle(x, y, w - r, h);
	}
}