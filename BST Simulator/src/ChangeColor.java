
public class ChangeColor extends AnimationComponent{
	private float dr,dg,db;
	private TreeNode g;
	public ChangeColor(float time,int r, int g, int b,TreeNode graphic) {
		
		if(graphic != null) {
		super.time = time;
		dr = (r)/time;
		dg = (g)/time;
		db = (b)/time;
		this.g = graphic;
		//System.out.println(dr);
		}
		else {
			super.time = 0;
		}
	}
	@Override
	public void update(float t) {
		time -= t;
		if(g.r + 10*(t*dr)<255) {
			g.r += 10*(t*dr);
		}
		if(g.g+10*(t*dg)<255) {
			g.g += 10*(t*dg);
		}
		if(g.b+10*(t*db)<255) {
			g.b += 10*(t*db);
		}
	}
}
