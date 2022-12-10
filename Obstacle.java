import java.awt.*;

public class Obstacle extends BasicOperations{

    public Obstacle(int x, int y, int sizex, int sizey){
        dataset.x = x;
        dataset.y = y;
        dataset.sizex = sizex;
        dataset.sizey = sizey;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.darkGray);
        graphics.fillRect(dataset.x, dataset.y, dataset.sizex, dataset.sizey);
    }

    @Override
    public void doSomething() {

    }
}
