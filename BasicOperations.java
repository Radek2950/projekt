import java.awt.*;

public abstract class BasicOperations {
    public DataSet dataset = new DataSet();

    public abstract void draw(Graphics graphics);

    public abstract void doSomething();

    public class DataSet
    {
        int x = 0, y = 0, sizex = 0, sizey = 0;
    }

}
