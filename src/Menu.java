import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa odpwodzielna za tworzenie naszego menu
 * Ta klasa która rozszerza kalsę JFrame
 *
 */
public class Menu extends JFrame {

    private Menu menu = this;

    public Menu(){
        createAndShow();
    }


    public void createAndShow(){
        this.setSize(290,230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setName("Menu");

        JButton start;
        JButton exit;

        /**
         * Po kliknięciu przycisku new game zostaje otworzona nowa gra
         */
        start = new JButton("New game");
        start.setSize(120,35);
        start.setLocation(getWidth()/2-start.getWidth()/2, 50);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Engine();

                    }
                }).start();
            }
        });

        add(start);

        /**
         * PO kliknięciu przycisku EXIT program kończy swoje działanie
         */
        exit = new JButton("Exit");
        exit.setSize(120,35);
        exit.setLocation(getWidth()/2-exit.getWidth()/2, 110);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

        this.setVisible(true);
    }



}
