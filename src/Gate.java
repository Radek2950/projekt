import java.awt.*;

/**
 * Klasa dziedziczy po BasicOperations sa to elemnty naszej gry
 * Klasa odpowiedzialna za nasze wyjście z gry
 */
public class Gate extends BasicOperations{

    public Gate(int x, int y, int sizex, int sizey){
        dataset.x = x;
        dataset.y = y;
        dataset.sizex = sizex;
        dataset.sizey = sizey;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(80, 50, 25));
        graphics.fillRect((int)dataset.x, (int)dataset.y, (int)dataset.sizex, (int)dataset.sizey);
    }

    @Override
    public void doSomething() {

    }
}
