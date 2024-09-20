import java.util.HashMap;
import java.util.Map;

public class KeyboardInputManager {
	private static Map<Integer, Boolean> keys = new HashMap<Integer, Boolean>();

	
	public static boolean keyDown(int key) {
		boolean down = StdDraw.isKeyPressed(key);
		if(keys.containsKey(key)) {
			if(!down) {
				keys.put(key, false);
			} else if(!keys.get(key)) {
				keys.put(key, true);
				return true;
			} else {
				return false;
			}
		} else {
			keys.put(key, down);
		}
		
		return down;
	}
}