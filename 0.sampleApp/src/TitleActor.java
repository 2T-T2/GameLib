import lib.game.*;
import lib.game.Rectangle;
import java.awt.*;

public class TitleActor extends Actor {
    private String str = "Start";
    TitleActor(int centerX, int centerY, int width, int height, Rectangle hitArea) {
        super(centerX, centerY, width, height, hitArea, null);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Font font = new Font(Font.SERIF, Font.ITALIC, 36);
        g.setFont(font);
        int textWidth = g.getFontMetrics().stringWidth(str);
        int textHeight = g.getFontMetrics().getHeight();
        g.setColor(Color.WHITE);
        g.drawString(str, ( centerX - textWidth ) / 2, ( centerY - textHeight ) / 2);
    }
}
