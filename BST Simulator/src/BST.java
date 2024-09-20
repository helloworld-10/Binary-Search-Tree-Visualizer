
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class BST {
	public static TreeNode head;
	public BST(int key,int val) {
		this.head = new TreeNode();
		this.head.key = key;
		this.head.val = val;
	}
	
	public BST() {
		head = null;
	}
	public static void resetTree() {
		BSTSimulator.lock = false;
		resetTree(head);
	}
	private static void resetTree(TreeNode n) {
		n.r = 0;
		n.g = 0;
		n.b = 0;
		if(n.left != null) {
			resetTree(n.left);
		}
		if(n.right != null) {
			resetTree(n.right);
		}
	}
	public int insert(int key, int val) {
		if(head == null) {
			head = new TreeNode();
			head.key = key;
			head.val = val;
			BSTSimulator.graphics.add(head);
			head.x = 512;
			head.y = 490;
			BSTSimulator.animation.add(new ChangeColor(400,0,255,0,head));
			BSTSimulator.animation.add(new resetTree(1));
			return val;
		}
		TreeNode t = new TreeNode();
		t.key = key;
		t.val = val;
		BSTSimulator.animation.add(new ChangeColor(200,0,255,0,head));
		return insert(head, t,0,1024,490-50);
	}
	
	public int insert(int i) {
		return insert(i, i);
	}
	
	public int insert(TreeNode n, TreeNode t, float left, float right, int y) {
		float x = (left+right)/2;
		if(t.key>n.key) {
			if(n.right == null) {
				n.right = t;
				BSTSimulator.graphics.add(t);
				t.x = 20;
				t.y = 490;
				t.parent = n;

				t.L = x;
				t.R = right;
				BSTSimulator.animation.add(new MoveNode(t,(x+right)/2,y,200.0f));
				BSTSimulator.animation.add(new ChangeColor(200,0,255,0,t));
				BSTSimulator.animation.add(new resetTree(1));
				return t.val;
			}
			else {
				BSTSimulator.animation.add(new ChangeColor(150,255,0,0,n.left));
				BSTSimulator.animation.add(new ChangeColor(150,0,255,0,n.right));
				return insert(n.right,t,x,right,y-50);
			}
		}
		else {
			if(n.left == null) {
				n.left = t;
				BSTSimulator.graphics.add(t);
				t.x = 20;
				t.y = 490;
				t.parent = n;
				t.L = left;
				t.R = x;
				
				BSTSimulator.animation.add(new MoveNode(t,(x+left)/2,y,200.0f));
				BSTSimulator.animation.add(new ChangeColor(200,0,255,0,t));
				BSTSimulator.animation.add(new resetTree(1));
				
				return t.val;
			}
			else {
				BSTSimulator.animation.add(new ChangeColor(150,255,0,0,n.right));
				BSTSimulator.animation.add(new ChangeColor(150,0,255,0,n.left));
				return insert(n.left,t,left,x,y-50);
			}
		}
	}
  public int find(int key) {
	  if(head == null) {
		  BSTSimulator.lock = false;
		  return -1;
	  }
	  BSTSimulator.animation.add(new ChangeColor(300, 0, 255, 0, head));
		TreeNode n = find(head,key);
		if(n != null) {
			return n.val;
		}
		else {
			resetTree();
			return -1;
		}
	}
	public TreeNode find(TreeNode n, int key) {
		
		if(n == null) {
			BSTSimulator.lock = false;
			return null;
		}
		if(n.key == key) {
			BSTSimulator.animation.add(new ChangeColor(300, 0, 0, 255, n));
			BSTSimulator.animation.add(new resetTree(1));
			return n;
		}
		else if(n.key >= key) {
			if(n.left != null) {
			BSTSimulator.animation.add(new ChangeColor(300, 0, 255, 0, n.left));
			}
			if(n.right != null) {
			BSTSimulator.animation.add(new ChangeColor(300, 255, 0, 0, n.right));
			}
			return find(n.left, key);
		}
		else {
			if(n.left != null) {
				BSTSimulator.animation.add(new ChangeColor(300, 255, 0, 0, n.left));
				}
				if(n.right != null) {
				BSTSimulator.animation.add(new ChangeColor(300, 0, 255, 0, n.right));
				}
			return find(n.right, key);
		}
	}
	public int delete(int key) {
		if(head == null) {
			BSTSimulator.lock  = false;
			return -1;
		}
		
		if(head.key == key && head.right == null) {
			int v = head.val;
			if(head.left != null && head.right == null) {
				BSTSimulator.animation.add(new ChangeColor(200f,0,255,0,head));
				BSTSimulator.animation.add(new ChangeColor(200f,255,255,0,head.parent));
				BSTSimulator.animation.add(new ChangeColor(200f,0,0,255,head.left));
				TreeNode t = head.left;
				BSTSimulator.animation.add(new deleteArrow(t));
				if(t.left != null) {
					BSTSimulator.animation.add(new deleteArrow(t.left));
				}
				if(t.right != null) {
					BSTSimulator.animation.add(new deleteArrow(t.right));
				}
				BSTSimulator.animation.add(new MoveNode(t,head.x,t.y+50,100));
				t.L = 0;
				t.R = 1024;

				if(t.left != null) {
					shift(t.left, head.x);
				}
				if(t.right != null) {
					shift(t.right,head.x);
				}
			}
			BSTSimulator.animation.add(new deleteNode(head));
			BSTSimulator.animation.add(new resetTree(1));
			head.left.parent = null;
			head = head.left;
			return v;
		}
		else if(head.key == key) {
			TreeNode t = head.right;
			BSTSimulator.animation.add(new ChangeColor(100,255,0,0,head));
			
			while(t.left != null) {
				t = t.left;
			}
			BSTSimulator.animation.add(new ChangeColor(100,0,0,255,t));
			BSTSimulator.animation.add(new deleteArrow(t));
			if(t.left != null) {
				BSTSimulator.animation.add(new deleteArrow(t.left));
			}
			if(t.right != null) {
				BSTSimulator.animation.add(new deleteArrow(t.right));
			}
			BSTSimulator.animation.add(new MoveNode(t,head.x,head.y,200f));
			BSTSimulator.animation.add(new deleteNode(head));
			int v = head.val;
			t.L = 0;
			t.R = 1024;
			if(head.right.equals(t)) {
				shift(t.right,head.x);
			}
			//shift(t.right,head.x);
			t.left = head.left;
			if(!head.right.equals(t)) {
				t.right = head.right;
			}
			
			if(t.left != null) {
			t.left.parent =t;
			}
			if(t.right != null) {
			t.right.parent = t;
			}
			
			if(t.parent.key>t.key) {
				t.parent.left = null;
			}
			else {
				t.parent.right = null;
			}
			t.parent = null;
			head = t;
			BSTSimulator.animation.add(new resetTree(1));
			return -1;
		}
		TreeNode n;
		if(head.key>key) {
			n = head.left;
		}
		else {
			n= head.right;
		}
		
		while(n.key != key) {
			if(n.left == null && n.right == null) {
				BSTSimulator.lock  = false;
				return -1;
			}
			if(n.key<key) {
				n = n.right;
			}
			else {
				n = n.left;
			}
			if(n == null) {
				BSTSimulator.lock  = false;
				return -1;
			}
			
		}
		
		
		if(n.left == null && n.right == null) {
			BSTSimulator.animation.add(new ChangeColor(300.0f,255,0,0,n));
			BSTSimulator.animation.add(new deleteArrow(n));
			BSTSimulator.animation.add(new deleteNode(n));
			BSTSimulator.animation.add(new resetTree(1));
			
			int v = n.val;
			if(n.parent.key>key) {
				n.parent.left = null;
			}
			else {
				n.parent.right = null;
			}
			return v;
		}
		else if(n.left != null && n.right == null) {
			int v = n.val;
			BSTSimulator.animation.add(new ChangeColor(200f,255,0,0,n));
			BSTSimulator.animation.add(new ChangeColor(200f,0,0,255,n.left));
			TreeNode t = n.left;
			
			BSTSimulator.animation.add(new deleteArrow(t));
			BSTSimulator.animation.add(new deleteArrow(n));
			if(t.left != null) {
				BSTSimulator.animation.add(new deleteArrow(t.left));
			}
			if(t.right != null) {
				BSTSimulator.animation.add(new deleteArrow(t.right));
			}
			
			BSTSimulator.animation.add(new MoveNode(t,n.x,t.y+50,100));
			t.L = n.L;
			t.R = n.R;
			if(t.left != null) {
				shift(t.left, n.x);
			}
			if(t.right != null) {
				shift(t.right,n.x);
			}
			n.left.parent= n.parent;
			BSTSimulator.animation.add(new deleteNode(n));
			BSTSimulator.animation.add(new resetTree(1));
			
			if(n.parent.key>key) {
				n.parent.left = n.left;
			}
			else {
				n.parent.right= n.left;
			}
			return v;
		}
		else if(n.right != null) {
			TreeNode t = n.right;
			BSTSimulator.animation.add(new ChangeColor(100,255,0,0,n));
			
			while(t.left != null) {
				t = t.left;
			}
			BSTSimulator.animation.add(new ChangeColor(100,0,0,255,t));
			
			BSTSimulator.animation.add(new deleteArrow(t));
			BSTSimulator.animation.add(new deleteArrow(n));
			if(t.left != null) {
				BSTSimulator.animation.add(new deleteArrow(t.left));
			}
			if(t.right != null) {
				BSTSimulator.animation.add(new deleteArrow(t.right));
			}
			BSTSimulator.animation.add(new MoveNode(t,n.x,n.y,200f));
			BSTSimulator.animation.add(new deleteNode(n));
			int v = n.val;
			if(n.right.equals(t)) {
				shift(t.right,n.x);
			}

			t.left = n.left;
			if(!n.right.equals(t)) {
				t.right = n.right;
			}
			t.L = n.L;
			t.R = n.R;
			if(t.left != null) {
			t.left.parent =t;
			}
			if(t.right != null) {
			t.right.parent = t;
			}
			
			if(t.parent.key>t.key) {
				t.parent.left = null;
			}
			else {
				t.parent.right = null;
			}
			if(n.parent.key>t.key) {
				n.parent.left = t;
			}
			else {
				n.parent.right = t;
			}
			t.parent = n.parent;
			BSTSimulator.animation.add(new resetTree(1));
			
			return v;
		}
		return -1;
		
	}
	
	private void shift(TreeNode n, double x) {
		if(n == null) {
			return;
		}
		BSTSimulator.animation.add(new deleteArrow(n));
		if(n.left != null) {
			BSTSimulator.animation.add(new deleteArrow(n.left));
		}
		if(n.right != null) {
			BSTSimulator.animation.add(new deleteArrow(n.right));
		}
		if(n.key<n.parent.key && n != null) {
			BSTSimulator.animation.add(new MoveNode(n,(x+n.parent.L)/2,n.y+50,100));
			
			n.L = n.parent.L;
			n.R = (float) x;
			x = (x+n.parent.L)/2;
		}
		else{
			BSTSimulator.animation.add(new MoveNode(n,(x+n.parent.R)/2,n.y+50,100));
			
			n.L = (float)x;
			n.R = n.parent.R;
			x = (x+n.parent.R)/2;
		}
		
		if(n.left != null) {
			shift(n.left,x);
		}
		if(n.right != null) {
			shift(n.right,x);
		}
	}

	public void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".//src//save.txt"));
            String data = br.readLine();

            if (data != null) {
                String[] s = data.split(",");
                int[] vals = new int[s.length];
                for(int i = 0;i<s.length;i++) {
                	vals[i] = Integer.parseInt(s[i]);
                }
                BSTSimulator.lock = true;
                this.clear();
                for(int i : vals) {
                	
                	this.insert(i);
                	
                }
                BSTSimulator.lock = true;
            }
        } catch (IOException e) {
            System.out.println("File Error");
        }
		BSTSimulator.animation.add(new resetTree(1));;
	}

	
	public void save() {
		try {
			FileWriter fw = new FileWriter(".//src//save.txt");
            // Read the first line
			saveAnimation(head);
            String data = preOrderPrint();
            data = data.replace(' ', ',');
            fw.write(data.substring(0,data.length()-1));
            resetTree();
            fw.close();
        } catch (IOException e) {
            System.out.println("File Error");
        }
		
	}
	
	private void saveAnimation(TreeNode n) {
		TreeNode t = new TreeNode();
		if(n.left != null) {
			saveAnimation(n.left);
		}
		if(n.right != null) {
			saveAnimation(n.right);
		}
		t.x = n.x;
		t.y = n.y;
		t.val = n.val;
		BSTSimulator.graphics.add(t);
		BSTSimulator.animation.add(new MoveNode(t,900,100,300));
		BSTSimulator.animation.add(new deleteNode(t));
		
	}

	public String preOrderPrint() {
		return preOrderPrint(head);
	}
	
	public String preOrderPrint(TreeNode n) {
		if(n == null) {
			return "";
		}
		return n.val + " " + preOrderPrint(n.left) + preOrderPrint(n.right);
	}
	
	public String inOrderPrint() {
		return inOrderPrint(head);
	}
	public String inOrderPrint(TreeNode n) {
		if(n == null) {
			return "";
		}
		if(n.left == null) {
			return n.val + " " + inOrderPrint(n.right);
		}
		if(n.right == null) {
			return inOrderPrint(n.left) + " " + n.val;
		}
		return inOrderPrint(n.left) + " " + n.val + " " + inOrderPrint(n.right);
	}


	public String postOrderPrint() {
		return postOrderPrint(head);
	}
	public String postOrderPrint(TreeNode n) {
		if(n == null) {
			return "";
		}
		return  postOrderPrint(n.left) + postOrderPrint(n.right) + n.val + " ";
	}
	public void clear() {
		BST.head = null;
		StdDraw.clear();
		BSTSimulator.graphics.clear();
		BSTSimulator.animation.clear();
		BSTSimulator.lock = false;
	}

}
	
	
	



