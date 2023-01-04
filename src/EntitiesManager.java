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
        entities.add(new Obstacle(100,100, 800,20));
        entities.add(new Obstacle(100,700, 800,20));

        //pionowa ściana na pozycji x 100 y 100 o dlugości 20 i wysokości 200

        entities.add(new Obstacle(450,450, 140,20));
        entities.add(new Obstacle(450,450, 20,80));
        entities.add(new Obstacle(590,450, 20,150));
        entities.add(new Obstacle(450,580, 140,20));

        entities.add(new Obstacle(380,380, 310,20));
        entities.add(new Obstacle(380,380, 20,320));
        entities.add(new Obstacle(680,380, 20,100));
        entities.add(new Obstacle(680,380, 20,180));
        entities.add(new Obstacle(680,610, 20,90));
        entities.add(new Obstacle(525,600, 20,100));
        entities.add(new Obstacle(525,630, 85,20));
        entities.add(new Obstacle(680,450, 75,20));
        entities.add(new Obstacle(680,650, 75,20));
        entities.add(new Obstacle(735,320, 20,230));
        entities.add(new Obstacle(735,620, 20,100));
        entities.add(new Obstacle(500,320, 250,20));
        entities.add(new Obstacle(500,280, 20,50));
        entities.add(new Obstacle(500,200, 20,40));
        entities.add(new Obstacle(380,100, 20,40));
        entities.add(new Obstacle(380,180, 20,20));
        entities.add(new Obstacle(380,200, 20,110));
        entities.add(new Obstacle(380,350, 20,60));
        entities.add(new Obstacle(300,275, 20,380));
        entities.add(new Obstacle(180,275, 120,20));
        entities.add(new Obstacle(180,400, 20,300));
        entities.add(new Obstacle(180,400, 70,20));
        entities.add(new Obstacle(245,350, 20,150));
        entities.add(new Obstacle(725,100, 20,50));
        entities.add(new Obstacle(120,600, 30,20));
        entities.add(new Obstacle(610,170, 20,30));
        entities.add(new Obstacle(510,100, 20,40));

        entities.add(new Obstacle(800,180, 20,520));
        entities.add(new Obstacle(200,200, 600,20));


        entities.add(new Obstacle(100,100, 20,600));
        entities.add(new Obstacle(180,100, 20,45));
        entities.add(new Obstacle(180,200, 20,155));
        entities.add(new Obstacle(880,100, 20,400));
        entities.add(new Obstacle(880,560, 20,140));






        entities.add(new Quest(550,660,25,25,14,9));
        entities.add(new Quest(375,148,25,25,10,15));
        entities.add(new Quest(500,248,25,25,32,14));
        entities.add(new Quest(675,575,25,25,19,16));
        entities.add(new Quest(300,660,25,25,8,7));
        entities.add(new Quest(180,365,25,25,9,12));
        entities.add(new Quest(760,150,25,25,4,23));
        entities.add(new Quest(835,370,25,25,4,23));
        entities.add(new Gate(880, 500, 20,60));
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
