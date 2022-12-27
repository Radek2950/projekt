import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Renderer extends JFrame {

    private Engine engine;
    private MyCanvas canvas;
    private RenderMode renderMode = RenderMode.GAME;

    public boolean up = false, down = false, left = false, right = false;

    public Renderer(Engine engine) {
        this.engine = engine;
        canvas = new MyCanvas();
        this.setName("Quiz");

        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    engine.exit();

                if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    left = true;
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                    right = true;
                }
                if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
                    up = true;
                }
                if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                    down = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    left = false;
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                    right = false;
                }
                if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
                    up = false;
                }
                if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                    down = false;
                }
            }
        };

        canvas.addKeyListener(listener);
        this.addKeyListener(listener);
        this.add(canvas);
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void drawAll() {
        canvas.draw();
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
    }

    public class MyCanvas extends Canvas {

        public MyCanvas(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        timer++;
                    }
                }
            }).start();
        }

        public void draw(){
            BufferStrategy bufferStrategy = this.getBufferStrategy();

            if(bufferStrategy == null)
            {
                createBufferStrategy(3);
                return;
            }

            Graphics graphics = bufferStrategy.getDrawGraphics();
            graphics.setColor(Color.lightGray);
            graphics.fillRect(0,0,1024,768);

            if(renderMode == RenderMode.GAME) {
                drawHud(graphics);
                engine.getEntitiesManager().drawAll(graphics);
            }
            else if (renderMode == RenderMode.WIN)
            {
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("ARIAL", Font.BOLD, 60));
                graphics.drawString("YOU WIN", 350,280);
            }
            graphics.dispose();
            bufferStrategy.show();
        }

        int timer = 0;

        public void drawHud(Graphics graphics){
            graphics.setColor(Color.black);
            graphics.drawString(("Time:" + timer), 14,24);
        }
    }


    public enum RenderMode
    {
        WIN,
        GAME
    }
}
