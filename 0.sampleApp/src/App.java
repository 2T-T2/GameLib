import lib.game.*;

import java.awt.Dimension;

public class App extends Game {
    public static void main(String[] args) throws Exception {
        new GameInfo(60, new Dimension(300, 400));
        Scene[] scenes = new Scene[4];
        scenes[0] = new StartScene("Start");
        scenes[1] = new GameScene("Game");
        scenes[2] = new ClearScene("Clear");
        scenes[3] = new GameOverScene("GameOver");

        GameInfo.setScenes(scenes);
        App app = new App();
        app.setVisible(true);
    }
    App() {
        super("My Game", GameInfo.getDimension());
    }
}
