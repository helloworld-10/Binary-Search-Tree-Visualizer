
public class resetTree extends AnimationComponent{
	public resetTree(float time) {
		super.time = 1;
	}
	@Override
	public void update(float t) {
		super.time -= t;
		BST.resetTree();
	}
}
