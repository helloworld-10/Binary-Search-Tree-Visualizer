
public class deleteNode extends AnimationComponent {
	GraphicsComponent n;
	public deleteNode(GraphicsComponent n) {
		super.time = 10;
		this.n = n;
	}
	@Override
	public void update(float t) {
		super.time = -1;
		BSTSimulator.graphics.remove(BSTSimulator.graphics.indexOf(n));
	}
}
