import java.awt.Color;
import java.awt.event.KeyEvent;

public class UI {
	private static boolean pressed = false;
	private static boolean bsPressed = false;
	private static boolean zeroPressed = false;
	private static boolean onePressed = false;
	private static boolean twoPressed = false;
	private static boolean threePressed = false;
	private static boolean fourPressed = false;
	private static boolean fivePressed = false;
	private static boolean sixPressed = false;
	private static boolean sevenPressed = false;
	private static boolean eightPressed = false;
	private static boolean ninePressed = false;
	
	private static final int BUTTON_WIDTH = 25;
	private static final int BUTTON_HEIGHT = BUTTON_WIDTH / 2;
	
	private static final int TF_WIDTH = 50;
	private static final int TF_HEIGHT = 25 / 2;
	
	private static final Color BUTTON_DEFAULT_COLOR = new Color(148, 155, 156);
	private static final Color BUTTON_DEFAULT_BORDER_COLOR = new Color(66,66,66);
	private static final Color BUTTON_HOVERED_COLOR = new Color(100, 100, 100);
	private static final Color BUTTON_CLICKED_COLOR = new Color(66, 66, 66);
	private static final Color BUTTON_TEXT_COLOR = Color.WHITE;
	
	private static final Color TF_DEFAULT_COLOR = new Color(148, 155, 156);
	private static final Color TF_HOVERED_COLOR = new Color(100, 100, 100);
	private static final Color TF_DEFAULT_BORDER_COLOR = new Color(66,66,66);
	
	private static final double BUTTON_BORDER_WIDTH = 0.004f;
	private static final double TF_BORDER_WIDTH = 0.004f;
	
	public static boolean Button(int x, int y, String text)
	{
		boolean b = false;
		
		if(intersects(x, y, BUTTON_WIDTH, BUTTON_HEIGHT)) {
			if(clicked())
			{
				StdDraw.setPenColor(BUTTON_CLICKED_COLOR);
				b = true;
			} else {
				StdDraw.setPenColor(BUTTON_HOVERED_COLOR);
			}
		} else {
			StdDraw.setPenColor(BUTTON_DEFAULT_COLOR);
		}
		
		StdDraw.filledRectangle(x,  y, BUTTON_WIDTH, BUTTON_HEIGHT);
		StdDraw.setPenColor(BUTTON_TEXT_COLOR);
		StdDraw.text(x, y, text);
		

		drawBorders(x, y, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_DEFAULT_BORDER_COLOR, BUTTON_BORDER_WIDTH);
		
		
		
		

		return b;
	}
	public static void drawBorders(int x, int y, int w, int h, Color color, double radius) {
		StdDraw.setPenRadius(radius);
		StdDraw.setPenColor(color);
		StdDraw.line(x - w, y - h, x + w, y - h);
		StdDraw.line(x - w, y + h, x + w, y + h);
		StdDraw.line(x - w, y - h, x - w, y + h);
		StdDraw.line(x + w, y - h, x + w, y + h);
	}
	
	public static void TextBox(int x, int y, String text) {
		StdDraw.setPenColor(TF_DEFAULT_COLOR);
		double radius = text.length() * 5f;
		if(text.length() == 1) {
			radius = 9f;
		}
		StdDraw.filledRectangle(x, y, radius, TF_HEIGHT);
		drawBorders(x, y, (int) radius, TF_HEIGHT,TF_DEFAULT_BORDER_COLOR, TF_BORDER_WIDTH);

		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(x, y, text);
	}
	
	public static String TextField(int x, int y, String text) {
		StdDraw.setPenColor(TF_DEFAULT_COLOR);
		if(intersects(x, y, TF_WIDTH, TF_HEIGHT)) {
			StdDraw.setPenColor(TF_HOVERED_COLOR);
			// backspace
			if(isBsPressed() && text.length() >= 1) {
				text = text.substring(0, text.length() - 1);
			}
			if(text.length() < 10) {
				if(isZeroPressed()) {
					text += "0";
				} else if(isOnePressed()) {
					text += "1";
				} else if(isTwoPressed()) {
					text += "2";
				} else if(isThreePressed()) {
					text += "3";
				} else if(isFourPressed()) {
					text += "4";
				} else if(isFivePressed()) {
					text += "5";
				} else if(isSixPressed()) {
					text += "6";
				} else if(isSevenPressed()) {
					text += "7";
				} else if(isEightPressed()) {
					text += "8";
				} else if(isNinePressed()) {
					text += "9";
				}
			}
		}

		StdDraw.filledRectangle(x, y, TF_WIDTH, TF_HEIGHT);
		drawBorders(x, y, TF_WIDTH, TF_HEIGHT,TF_DEFAULT_BORDER_COLOR, TF_BORDER_WIDTH);

		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(x, y, text);

		return text;
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
	private static boolean clicked() {
		boolean mousePressed = StdDraw.isMousePressed();
		if(mousePressed) {
			if(!pressed) {
				pressed = true;
				return true;
			}
			
		} else {
			pressed = false;
		}
		return false;
	}
	private static boolean isZeroPressed() {
		boolean zp = StdDraw.isKeyPressed(KeyEvent.VK_0);
		if(zp) {
			if(!zeroPressed) {
				zeroPressed = true;
				return true;
			}
			
		} else {
			zeroPressed = false;
		}
		return false;
	}
	private static boolean isBsPressed() {
		boolean bsp = StdDraw.isKeyPressed(KeyEvent.VK_BACK_SPACE);
		if(bsp) {
			if(!bsPressed) {
				bsPressed = true;
				return true;
			}
			
		} else {
			bsPressed = false;
		}
		return false;
	}
	private static boolean isOnePressed() {
		boolean op = StdDraw.isKeyPressed(KeyEvent.VK_1);
		if(op) {
			if(!onePressed) {
				onePressed = true;
				return true;
			}
			
		} else {
			onePressed = false;
		}
		return false;
	}
	private static boolean isTwoPressed() {
		boolean tp = StdDraw.isKeyPressed(KeyEvent.VK_2);
		if(tp) {
			if(!twoPressed) {
				twoPressed = true;
				return true;
			}
			
		} else {
			twoPressed = false;
		}
		return false;
	}
	private static boolean isThreePressed() {
		boolean tp = StdDraw.isKeyPressed(KeyEvent.VK_3);
		if(tp) {
			if(!threePressed) {
				threePressed = true;
				return true;
			}
			
		} else {
			threePressed = false;
		}
		return false;
	}
	private static boolean isFourPressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_4);
		if(b) {
			if(!fourPressed) {
				fourPressed = true;
				return true;
			}
			
		} else {
			fourPressed = false;
		}
		return false;
	}
	private static boolean isFivePressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_5);
		if(b) {
			if(!fivePressed) {
				fivePressed = true;
				return true;
			}
			
		} else {
			fivePressed = false;
		}
		return false;
	}
	
	private static boolean isSixPressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_6);
		if(b) {
			if(!sixPressed) {
				sixPressed = true;
				return true;
			}
			
		} else {
			sixPressed = false;
		}
		return false;
	}
	
	private static boolean isSevenPressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_7);
		if(b) {
			if(!sevenPressed) {
				sevenPressed = true;
				return true;
			}
			
		} else {
			sevenPressed = false;
		}
		return false;
	}
	
	private static boolean isEightPressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_8);
		if(b) {
			if(!eightPressed) {
				eightPressed = true;
				return true;
			}
			
		} else {
			eightPressed = false;
		}
		return false;
	}
	
	private static boolean isNinePressed() {
		boolean b = StdDraw.isKeyPressed(KeyEvent.VK_9);
		if(b) {
			if(!ninePressed) {
				ninePressed = true;
				return true;
			}
			
		} else {
			ninePressed = false;
		}
		return false;
	}
}
