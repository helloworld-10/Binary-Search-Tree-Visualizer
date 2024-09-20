public class MoveNode extends AnimationComponent{
	GraphicsComponent n;
	double sx,sy;
	float totTime;
	double s,nx,ny;
	public MoveNode(GraphicsComponent n, double x, double y, float time) {
		this.n = n;
		super.time = time;
		totTime = time;
		this.sx = ((x-n.x));
		//sx= x-n.x/time;
		this.sy = ((y-n.y));
		nx = n.x;
		ny = n.y;
	}
	@Override
	public void update(float t) {
		super.time -= t;	
		if(n == null) {
			return;
		}
		s += t;
		double easeCubic = 1.0-Math.pow(1.0-(Math.abs((s)/totTime)), 3.0);
		//n.x += t*sx
		n.x = nx+ (sx*easeCubic);
	    n.y = ny+ (sy*easeCubic);
	    if(n.getClass() == TreeNode.class && super.time<=0 && ((TreeNode)n).parent != null) {
	    	Arrow a = new Arrow(((TreeNode)n).parent.x,((TreeNode)n).parent.y,n.x,n.y);
	    	BSTSimulator.graphics.add(0,a);
	    	((TreeNode)n).addArrow(a);
	    }
	}
}
