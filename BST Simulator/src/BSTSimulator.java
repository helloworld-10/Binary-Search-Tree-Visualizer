import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 
 * Use this class to handle the main features of your application.
 * You should add additional classes as appropriate to support good modularity and reduce redundancy.
 *
 */
public class BSTSimulator {
	public static Animation animation;
	public static ArrayList<GraphicsComponent> graphics;
	public static boolean lock = false;
	public static void main(String[] args) {
		
		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setXscale(0,1024);
		StdDraw.setYscale(0, 512);
		StdDraw.enableDoubleBuffering();

		
		
		
		TreeVisualizer tv = new TreeVisualizer();
		
		tv.draw();
		
		StdDraw.show();
		animation = new Animation();
		String addstr = "";
		String findstr = "";
		String delstr = "";
		
		String printstr = "";
		double time = 0;
		
		long start;
		long end;
		graphics = new ArrayList<GraphicsComponent>();
		
		Button addBtn = new Button("Add", 100, 100, 25, 15);
		Button findBtn = new Button("Find", 210, 100, 25, 15);
		Button deleteBtn = new Button("Delete", 320, 100, 25, 15);
		Button inOrderPrintBtn = new Button("In Order", 430, 100, 30, 15);
		Button preOrderPrintBtn = new Button("Pre Order", 530, 100, 33, 15);
		Button postOrderPrintBtn = new Button("Post Order", 630, 100, 36, 15);
		Button clearBtn = new Button("Clear", 730, 100, 25, 15);
		Button loadBtn = new Button("Load",900,60,25,15);
		Button saveBtn = new Button("Save",900,100,25,15);
		NumberField addNf = new NumberField(100, 60, 25, 4);
		NumberField findNf = new NumberField(210, 60, 25, 4);
		NumberField deleteNf = new NumberField(320, 60, 25, 4);

		String printString = "";
		
		
		while(true)
		{
			
			
			StdDraw.clear();
			start = System.nanoTime();
			
			addBtn.draw();
			findBtn.draw();
			deleteBtn.draw();
			inOrderPrintBtn.draw();
			preOrderPrintBtn.draw();
			postOrderPrintBtn.draw();
			clearBtn.draw();
			loadBtn.draw();
			saveBtn.draw();
			addNf.draw();
			findNf.draw();
			deleteNf.draw();

			if(!lock && (addBtn.isPressed() || (KeyboardInputManager.keyDown(KeyEvent.VK_ENTER) && addNf.isSelected())) && addNf.getString().length() > 0) {
				lock = true;
				tv.addNode(addNf.getNumbers());
				addNf.reset();
			}
			if(!lock && (findBtn.isPressed() || (KeyboardInputManager.keyDown(KeyEvent.VK_ENTER) && findNf.isSelected())) && findNf.getString().length() > 0) {
				lock = true;
				tv.find(findNf.getNumbers());
				findNf.reset();
			}
			if(!lock && (deleteBtn.isPressed() || (KeyboardInputManager.keyDown(KeyEvent.VK_ENTER) && deleteNf.isSelected())) && deleteNf.getString().length() > 0) {
				lock = true;
				tv.delete(deleteNf.getNumbers());
				StdDraw.clear();
				deleteNf.reset();
			}
			
			if(inOrderPrintBtn.isPressed()) {
				printString = tv.inOrder();
			}			
			if(preOrderPrintBtn.isPressed()) {
				printString = tv.preOrder();
			}
			if(postOrderPrintBtn.isPressed()) {
				printString = tv.postOrder();
			}
			if(!lock && clearBtn.isPressed()) {
				lock = true;
				tv.clear();
				
			}
			if(!lock && loadBtn.isPressed()) {
				lock = true;
				tv.load();
				
			}
			if(!lock && saveBtn.isPressed()) {
				lock = true;
				tv.save();
				
			}
			tv.draw(graphics);

			animation.update((float)time);
			end = System.nanoTime();
			time = (end-start)/1000000.0f;

			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(200, 150, printString);
			
			StdDraw.show();
			StdDraw.clear();

		}		 

	}
}
