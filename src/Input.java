package lib.game;

import java.util.Map;

public class Input {
    public Map<Integer, Boolean> keyMap;
    public Map<Integer, Boolean> previewKeyMap;
	public Input(Map<Integer, Boolean> keyMap, Map<Integer, Boolean> previewKeyMap) {
        this.keyMap = keyMap;
        this.previewKeyMap = previewKeyMap;
	}
    private boolean getKeyFromMap(int key, Map<Integer, Boolean> map) {
        if (map.containsKey(key) && map.getOrDefault(key, false)) {
            return true;
        }else {
            return false;
        }
    }
    private boolean getPreviewKey(int key) {
        return getKeyFromMap(key, previewKeyMap);
    }
    public boolean getKey(int key) {
        return getKeyFromMap(key, keyMap);
    }
    public boolean getKeyDown(int key) {
        boolean previewDown = getPreviewKey(key);
        boolean currentDown = getKey(key);
        return !previewDown && currentDown;
    }
    public boolean getKeyUp(int key) {
        boolean previewDown = getPreviewKey(key);
        boolean currentDown = getKey(key);
        return previewDown && !currentDown;
    }
}
