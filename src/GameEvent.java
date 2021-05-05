package lib.game;

public class GameEvent {
    public String eventName;
    public Object reciveObject;
    public Object targetObject;
    public GameEvent(String name) {
        eventName = name;
    }
    public GameEvent(String name, Object sendData) {
        eventName = name;
        reciveObject = sendData;
    }
    public GameEvent(String name, Object target ,Object sendData) {
        eventName = name;
        reciveObject = sendData;
        targetObject = target;
    }
}
