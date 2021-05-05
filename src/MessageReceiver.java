package lib.game;

import java.util.EventListener;
public interface MessageReceiver extends EventListener {
    public void receiveMessage(GameEvent e);
}