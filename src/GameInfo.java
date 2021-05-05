package lib.game;

import java.awt.*;
import java.util.*;

public class GameInfo {
    private static int currentScene = 0;
    private static Dimension gameSize;
    private static Scene[] scenes;
    private static Map<Integer, Boolean> keyMap;
    private static Map<Integer, Boolean> previewKeyMap;
    private static int fps;
    public GameInfo(int fps, Dimension size) {
        GameInfo.fps = fps;
        GameInfo.gameSize = size;
        GameInfo.keyMap = new HashMap<>();
        GameInfo.previewKeyMap = new HashMap<>();
    }

    public static void setSceneNum(int num) { currentScene = num; }
    public static void nextScene() { currentScene++; }
    public static Scene getCurrentScene() { return scenes[currentScene]; }
    public static int getfps() { return fps; }
    public static double getGameWidth(){ return gameSize.getWidth();}
    public static double getGameHeight(){ return gameSize.getHeight();}
    public static Dimension getDimension() { return gameSize; }
    public static void setScenes(Scene[] scenes) { GameInfo.scenes = scenes; }
    public static void setKeyMap(int i, boolean b) { keyMap.put(i, b); }
    public static void setPreviewKeyMap(int i, boolean b) { previewKeyMap.put(i, b); }
    public static Input getInput() {
        Map<Integer, Boolean> keyMap = new HashMap<>(GameInfo.keyMap);
        Map<Integer, Boolean> previewKeyMap = new HashMap<>(GameInfo.previewKeyMap);
        GameInfo.previewKeyMap = new HashMap<>(GameInfo.keyMap);
        return new Input(keyMap, previewKeyMap);
    }
    public static Scene[] getScenes() { return scenes; }
}
