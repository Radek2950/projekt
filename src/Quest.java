import javax.swing.*;
import java.awt.*;

public class Quest extends BasicOperations{

    private int questValue1, questValue2;

    public Quest(int x, int y, int sizex, int sizey, int questValue1, int questValue2){
        dataset.x = x;
        dataset.y = y;
        dataset.sizex = sizex;
        dataset.sizey = sizey;
        this.questValue1 = questValue1;
        this.questValue2 = questValue2;
    }

    public void showQuest(){

        String answer = JOptionPane.showInputDialog("How much is " + questValue1 + " + " + questValue2);

        try{
            if(Integer.parseInt(answer) == questValue1+questValue2)
            {
                JOptionPane.showMessageDialog(null, "Correct answer!");
                dataset.x = -300;
                dataset.y = -300;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Inorrect answer!");
            }
        }
        catch (Exception ex)
        {

        }

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(dataset.x, dataset.y, dataset.sizex, dataset.sizey);
    }

    @Override
    public void doSomething() {

    }
}
