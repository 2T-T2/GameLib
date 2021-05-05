package lib.game;

public class Messenger {
    private MessageReceiver listener = null;
    public void eventListener(GameEvent e) {
        if (listener != null) {
            listener.receiveMessage(e);
        }
    }
    public void addListener(MessageReceiver listener) {
        this.listener = listener;
    }
}
