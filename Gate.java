import java.awt.*;
public class Gate extends BasicOperations{
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(80, 50, 25));
        graphics.fillRect(dataset.x, dataset.y, dataset.sizex, dataset.sizey);
    }

    @Override
    public void doSomething() {

    }
}
