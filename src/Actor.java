package lib.game;

import java.awt.*;
import java.util.Arrays;

public class Actor extends Messenger implements MessageReceiver {
    public int centerX;
    public int centerY;
    public int width;
    public int height;
    public int top;
    public int bottom;
    public int left;
    public int right;
    public Rectangle hitArea;
    public String[] tags;
    public boolean removeOutOfWindow = false;
    public Actor(int centerX, int centerY, int width, int height, Rectangle hitArea, String[] tags) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.top = centerY - height / 2;
        this.bottom = centerY + height / 2;
        this.left = centerX - width / 2;
        this.right = centerX + width / 2;
        this.hitArea = new Rectangle(hitArea.centerX+centerX, hitArea.centerY+centerY, hitArea.width, hitArea.height);
        this.tags = tags;
    }
    public void draw(Graphics g) {
        /* 継承先で実装 */
    }
    public void update(Input input) {
        GameInfo.getCurrentScene().addListener(this);
        /* 継承先で実装 */
        boolean isOut = bottom < 0 || right < 0 || left > GameInfo.getGameWidth() || top > GameInfo.getGameHeight();
        if (isOut && removeOutOfWindow) { destroyed(); }
    }
    public void move(int dx, int dy) {
        this.centerX += dx;
        this.centerY += dy;
        this.top += dy;
        this.bottom += dy;
        this.left += dx;
        this.right += dx;
        this.hitArea.centerX += dx;
        this.hitArea.centerY += dy;
        this.hitArea.top += dy;
        this.hitArea.bottom += dy;
        this.hitArea.left += dx;
        this.hitArea.right += dx;
    }
    public void drawHitArea(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(hitArea.left, hitArea.top, hitArea.width, hitArea.height);
    }
    public void drawHitArea(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(hitArea.left, hitArea.top, hitArea.width, hitArea.height);
    }
    public void collision(Actor other) {
        /* 継承先で実装 */
    }
    public boolean hasTag(String tag) {
        if (tag == null) return false;
        return Arrays.asList(tags).contains(tag);
    }
    public void spawnActor(Actor actor) {
        eventListener(new GameEvent("spawn", actor));
    }
    public void destroyed() {
        eventListener(new GameEvent("destroyed", this));
    }

    @Override
    public void receiveMessage(GameEvent e) {

    }
}
