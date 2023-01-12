import java.awt.*;

/**
 * Klasa abstrakcyjna elemnty gry takie jak Quest, Gate,User,Obstacle dziedzicza po tej klasie
 */

public abstract class BasicOperations {

    public DataSet dataset = new DataSet();

    /**
     * Klasa abstrakcyjna umozliwijaca nam rysowanie grafiki
     * @param graphics
     */
    public abstract void draw(Graphics graphics);

    /**
     * Abstrakcyjna metoda która zalezy od klasy co bedzie dokładnie wykonywac
     */


    public abstract void doSomething();

    /**
     * Klasa przechowujaca nasze polozenienie i rozmiar danego obiektu
     */
    public class DataSet
    {
        double x = 0, y = 0, sizex = 0, sizey = 0;
    }
}
