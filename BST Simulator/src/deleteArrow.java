
public class deleteArrow extends AnimationComponent {
	GraphicsComponent n;
	public deleteArrow(GraphicsComponent n) {
		this.n = n;
				super.time = 10;
	}
	@Override
	public void update(float t) {
		super.time = 0;
		if(n == null) {
			return;
		}
		for(int i = 0;i<BSTSimulator.graphics.size();i++) {
			if(BSTSimulator.graphics.get(i).getClass() == Arrow.class) {
				//if(((Arrow)BSTSimulator.graphics.get(i)).fx == n.x &&((Arrow)BSTSimulator.graphics.get(i)).fy == n.y) {
				if(((Arrow)BSTSimulator.graphics.get(i)).equals(((TreeNode)n).arrow)){
					BSTSimulator.graphics.remove(i);
					return;
				}
				//}
			}
		}
	}
}
