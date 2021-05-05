import lib.game.*;
import java.awt.*;

public class GameOverScene extends Scene {
    GameOverScene(String name) {
        super(name);
    }
    @Override
    public void bgDraw(Graphics g) {
        super.bgDraw(g);
        g.setColor(Color.RED);
        g.fillRect(0, 0, (int)GameInfo.getGameWidth(), (int)GameInfo.getGameHeight());
        Font font = new Font(Font.SERIF, Font.ITALIC, 36);
        String str = "Game Over";
        g.setFont(font);
        int textWidth = g.getFontMetrics().stringWidth(str);
        int textHeight = g.getFontMetrics().getHeight();
        g.setColor(Color.BLACK);
        g.drawString(str, ( textWidth ) / 2, ( (int)GameInfo.getGameHeight()/2 - textHeight ) / 2);
    }
}
