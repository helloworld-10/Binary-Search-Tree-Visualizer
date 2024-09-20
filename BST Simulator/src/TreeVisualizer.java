import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class TreeVisualizer {
	ArrayList<Integer> nodes;
	ArrayList<Point> positions;
	
	BST tree;
	
	int findVal = -1;
	
	public TreeVisualizer() {
		nodes = new ArrayList<Integer>();
		positions = new ArrayList<Point>();
		
		tree = new BST();
	}
	
	public void draw() {
		//System.out.println(1);
		if(tree.head != null) {
			
			draw(0, 1024, 500, tree.head);
		}
		
		/*
		if(nodes.size() >= 1) {
			// first row
			drawNode(1024/2, 500, nodes.get(0));
			int acc = 1;
			// complete rows
			int px = 0, py = 0;
			for(int row = 1; row <= height(); row++) {
				int nodesInRow = (int) Math.pow(2, row);
				for(int node = 0; node < nodesInRow; node++) {
					if(acc >= nodes.size()) {
						break;
					}
					
					int x = (int)(1024*((node+1)/(Math.pow(2, row) + 1)));
					int y = 500-(row*25);
					positions.set(acc, new Point(x,y));
					drawNode(x, y, nodes.get(acc));
					
					acc++;
				}
			}
			//System.out.println(positions.size());
			positions.set(0, new Point(1024/2,500));
			for(int i = 1; i < positions.size(); i++) {
				StdDraw.setPenRadius(0.001f);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.line(positions.get(i).x, positions.get(i).y, positions.get((i-1)/2).x, positions.get((i-1)/2).y);
			}
			//System.out.println(nodes.size());
		}
		*/
	}
	
	private void draw(int left, int right, int y, TreeNode node) {
		int x = (left + right) / 2;
		StdDraw.setPenColor(Color.BLACK);
		if(node.val == findVal) {
			StdDraw.setPenColor(Color.RED);
		}
		drawNode(x, y, node.val);
		if(node.left != null) {
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.line(x, y, (left + x) / 2, y - 50);
			draw(left, x, y - 50, node.left);
		}
		if(node.right != null) {
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.line(x, y, (right+x)/2, y - 50);
			draw(x, right, y - 50, node.right);
		}
	}

	
	private int height() {
		int n = nodes.size();
		return (int)Math.ceil(Math.log(n)/Math.log(2));
	}
	
	public void addNode(int node) {
		/*
		nodes.add(node);
		positions.add(new Point(-1,-1));
		*/
		tree.insert(node);
		//System.out.println(2);
	}
	public static void draw(ArrayList<GraphicsComponent> g) {
		for(GraphicsComponent t : g) {
			t.draw();
		}
	}
	public static void drawNode(float x, float y, int val) {
		
		
		// diameter 36 = 4 letters
		// 1 letter = 9
		String str = val + "";
		double radius = str.length() * 5f;
		if(str.length() == 1) {
			radius = 9f;
		}
		StdDraw.filledCircle(x, y, radius);
		StdDraw.setPenColor(Color.WHITE);

		StdDraw.text(x, y, val + "");
	}
	

	public static void drawNode(float x, float y, int val,Color color) {
		

		// diameter 36 = 4 letters
		// 1 letter = 9
		String str = val + "";
		double radius = str.length() * 5f;
		if(str.length() == 1) {
			radius = 9f;
		}
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
		StdDraw.setPenColor(Color.WHITE);

		StdDraw.text(x, y, val + "");
	}
	public void delete(int n) {
		tree.delete(n);
	}
	
	public int size() {
		return nodes.size();
	}

	public void find(int val) {
		findVal = val;
		tree.find(val);
	}
	
	public String inOrder() {
		return tree.inOrderPrint();
	}
	public String preOrder() {
		return tree.preOrderPrint();
	}

	public String postOrder() {
		return tree.postOrderPrint();
	}

	public void clear() {
		tree.clear();
		
	}

	public void load() {
		tree.load();
	}

	public void save() {
		tree.save();
		
	}
	
}
