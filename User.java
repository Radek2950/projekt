import java.awt.*;

public class User extends BasicOperations{

    private Engine engine;

    public User(Engine engine, int x, int y){

        dataset.x = x;
        dataset.y = y;

        dataset.sizex = 30;
        dataset.sizey = 30;

        this.engine = engine;
    }

    private Image image = Toolkit.getDefaultToolkit().createImage("user.png");

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, dataset.x, dataset.y, dataset.sizex, dataset.sizey, null);
    }

    @Override
    public void doSomething() {
        if (engine.getRenderer().up && dataset.y > 0)
            dataset.y -= 1.2;
        if (engine.getRenderer().down && dataset.y + dataset.sizey + 34 < 768)
            dataset.y += 1.2;
        if (engine.getRenderer().left && dataset.x >= 0)
            dataset.x -= 1.2;
        if (engine.getRenderer().right && dataset.x + dataset.sizex + 12 < 1024)
            dataset.x += 1.2;
    }
}

