import javax.swing.*;
import java.awt.*;

/**
 * Klasa dziedziczy po BasicOperations sa to elemnty naszej gry
 * Jest to klasa odpowiedzialna za nasze zadania matematyczne
 */

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


    /**
     * Metoda odpowiedzialna za wyswietlenie naszej zagadki matematycznej i sprawdzenie poprawność naszej odpowiedzi
     */
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

    /**
     * Metoda odpowiedzialna za rysowanie naszych zagadek na mapie i ustawienie koloru cyan
     * @param graphics przekazuej grafike
     */
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect((int)dataset.x, (int)dataset.y, (int)dataset.sizex, (int)dataset.sizey);
    }

    @Override
    public void doSomething() {

    }
}
