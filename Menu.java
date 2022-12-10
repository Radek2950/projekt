import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu extends JFrame {

    private Menu menu = this;

    public Menu() {
        createAndShow();
    }

    public void createAndShow() {
        this.setSize(290, 280);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        JButton start;
        JButton exit;

        start = new JButton("New game");
        start.setSize(120, 35);
        start.setLocation(getWidth() / 2 - start.getWidth() / 2, 80);
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

        exit = new JButton("Exit");
        exit.setSize(120, 35);
        exit.setLocation(getWidth() / 2 - exit.getWidth() / 2, 160);
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
