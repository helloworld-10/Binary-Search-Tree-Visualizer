import java.awt.Color;

public class TreeNode extends GraphicsComponent{
	int r,g,b;
	int val;
	int key;
	float L;
	float R;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	Arrow arrow;
	@Override
	public void draw(){
		String str = val + "";
		double radius = 20f;
		StdDraw.setPenColor(Math.max(0,Math.min(r, 255)),Math.max(0,Math.min(g, 255)),Math.max(0,Math.min(b, 255)));
		StdDraw.filledCircle(x, y, radius);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(x, y, val + "");

	}
	public void addArrow(Arrow a) {
		arrow = a;
	}
}