

import java.util.LinkedList;
import java.util.Queue;

public class Animation<T extends AnimationComponent> {
	private Queue<T> animation; 
	private T curr;
	public Animation(){
		this.animation = new LinkedList();
	}
	public void add(T component) {
		animation.add(component);
	}
	public T peek() {
		return animation.peek();
	}
	public void update(float time) {
		if(curr == null && animation.size()>0) {
			curr= animation.remove();
		}
		if(curr != null) {
		if(animation.size()>0 && curr.time <= 0) {
			curr = animation.remove();
		}
		else if(curr.time<= 0) {
			curr = null;
		}
		else{
			curr.update(time);
		}
		}
	}
	public void clear() {
		animation.clear();
		
	}
}
