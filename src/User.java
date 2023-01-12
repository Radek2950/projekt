import java.awt.*;

/**
 * Klasa dziedzica po BasicOperations i odpwoiedzialna za wyrysowanie naszego uzytkownika i jego ruchh
 */

public class User extends BasicOperations{

    private Engine engine;

    public User(Engine engine, int x, int y){

        dataset.x = x;
        dataset.y = y;

        dataset.sizex = 30;
        dataset.sizey = 30;

        this.engine = engine;
    }

    /**
     * Wczytujemny obiekt kalsy image ktory jest naszym obiektem ktorym poruszamy się po labiryncie
     */
    private Image image = Toolkit.getDefaultToolkit().createImage("user.png");

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int)dataset.x, (int)dataset.y, (int)dataset.sizex, (int)dataset.sizey, null);
    }

    /**
     * Funkcja odpowiedzialna za przesuwanie sie naszego obiektu (kwadratu)
     */
    @Override
    public void doSomething() {
       if (engine.getRenderer().up && dataset.y > 0)
            dataset.y -= 0.1;
        if (engine.getRenderer().down && dataset.y + dataset.sizey + 34 < 768)
            dataset.y += 0.1;
        if (engine.getRenderer().left && dataset.x >= 0)
            dataset.x -= 0.1;
        if (engine.getRenderer().right && dataset.x + dataset.sizex + 12 < 1024)
           dataset.x += 0.1;
    }
}
