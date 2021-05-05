package lib.game;

import java.util.*;
import java.awt.*;

public class Scene extends Messenger implements MessageReceiver {
    public String name;
    public ArrayList<Actor> actors;
    private ArrayList<Actor> destroyedActors;
    public Scene(String name) {
        actors = new ArrayList<>();
        destroyedActors = new ArrayList<>();
        this.name = name;
    }
    public void update(Graphics g, Input input) {
        GameInfo.getCurrentScene().bgDraw(g);
        updateActors(input);
        collision();
        desposeDestroyActors();
        drawActors(g);
    }
    private void drawActors(Graphics g) {
        actors.forEach(actor -> { actor.draw(g); });
    }
    private void updateActors(Input input) {
        for(int i = 0; i < actors.size(); i++ ) { actors.get(i).update(input); }
    }
    private void collision() {
        for (int i = 0; i < actors.size(); i++) {
            for (int j = i+1; j < actors.size(); j++) {
                if ( actors.get(i).hitArea.collision(actors.get(j).hitArea) ){
                    actors.get(i).collision(actors.get(j));
                    actors.get(j).collision(actors.get(i));
                }
            }
        }
    }
    private void desposeDestroyActors() {
        for(int i = 0; i < destroyedActors.size(); i++) {
            actors.remove(destroyedActors.get(i));
        }
        destroyedActors.clear();
    }
    public void addActor(Actor actor) {
        actor.addListener(this);
        actors.add(actor);
    }
    public void bgDraw(Graphics g) {
        /* 継承先で実装 */
    }

    @Override
    public void receiveMessage(GameEvent e) {
        String eName = e.eventName;
        if (eName.equals("spawn")) {
            addActor((Actor)e.reciveObject);
        }else if (eName.equals("destroyed")) {
            destroyedActors.add((Actor)e.reciveObject);
        }
    }
}
