import java.awt.*;
import lib.game.*;

public class ClearScene extends Scene {
    ClearScene(String name) {
        super(name);
    }
    @Override
    public void bgDraw(Graphics g) {
        super.bgDraw(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, (int)GameInfo.getGameWidth(), (int)GameInfo.getGameHeight());
        Font font = new Font(Font.SERIF, Font.ITALIC, 36);
        String str = "Clear";
        g.setFont(font);
        int textWidth = g.getFontMetrics().stringWidth(str);
        int textHeight = g.getFontMetrics().getHeight();
        g.setColor(Color.WHITE);
        g.drawString(str, ( (int)GameInfo.getGameWidth()/2 - textWidth ) / 2, ( (int)GameInfo.getGameHeight()/2 - textHeight ) / 2);
    }
}
