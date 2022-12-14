import java.awt.*;
import java.util.ArrayList;

public class EntitiesManager {

    private Engine engine;

    public EntitiesManager(Engine engine){
        this.engine = engine;
        loadMap();
    }

    public ArrayList<BasicOperations> entities = new ArrayList<>();

    public void loadMap(){
        engine.user = new User(engine, 500,500);

        entities.add(engine.user);

        //pozioma ściana na pozycji x 100 y 100 o dlugości 200 i wysokości 20
        entities.add(new Obstacle(100,100, 200,20));

        //pionowa ściana na pozycji x 100 y 100 o dlugości 20 i wysokości 200
        entities.add(new Obstacle(100,100, 20,200));

        entities.add(new Quest(300,300,50,50,8,13));

        entities.add(new Gate(800, 500, 30,60));
    }

    public void drawAll(Graphics graphics){
        for(BasicOperations bo : entities)
        {
            bo.draw(graphics);
        }
    }

    public void callAll(){
        detectCollision();
        for(BasicOperations bo : entities)
        {
            bo.doSomething();
        }
    }

    public void detectCollision(){
        for (BasicOperations bo : entities) {
            if (bo.dataset.x < engine.user.dataset.x + engine.user.dataset.sizex &&
                    bo.dataset.x + bo.dataset.sizex > engine.user.dataset.x &&
                    bo.dataset.y < engine.user.dataset.y + engine.user.dataset.sizey &&
                    bo.dataset.sizey + bo.dataset.y > engine.user.dataset.y) {

                if(bo instanceof Obstacle)
                {
                    engine.resetUserPosition();
                }

                if(bo instanceof Gate)
                {
                    engine.gate();
                }

                if(bo instanceof Quest)
                {
                    ((Quest)bo).showQuest();
                    engine.turnOffControls();
                }
            }
        }
    }
}
