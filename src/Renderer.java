import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 * Klasa sluzy do wyswietlania naszej grafiki
 */

public class Renderer extends JFrame {

    private Engine engine;

    private MyCanvas canvas;

    private RenderMode renderMode = RenderMode.GAME;

    public boolean up = false, down = false, left = false, right = false;

    public Renderer(Engine engine) {
        this.engine = engine;
        canvas = new MyCanvas();
        this.setName("Quiz");

        /**
         * Dodanie KeyListenera który odpowiada za spwadzanie co wciskamy
         */
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * Jesli klikniemy ESC to gra zostaje zakonczona a wciskajac a,s,w,d porusza nas sie nasz uzytkownik w lewo,dol,gore i prawo
             * @param e
             */
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
        /**
         * Ustawienie interwejsu graficznego na 1024x768 i zablokowanie mozliwosci rozszerzania
         */
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

        /**
         * Konstruktor ktory odpowiada za niezalezna zmiane stoperu co kazadą sekunde
         */
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
            /**
             * Tworzymy obiek  bufferStrategy ktory jest wykorzystywany przy rysowaniu grafiki
             */
            BufferStrategy bufferStrategy = this.getBufferStrategy();

            if(bufferStrategy == null)
            {
                createBufferStrategy(3);
                return;
            }

            /**
             * Obiekt graphics jest to obiekt po ktorym bezposredni mozemy rysowac
             * Ustawiamy kolor tla na jasny-szary i wypelniamy cała wielkosc naszego okienka tym kolorem
             * i na to beda nadrukowane kolejne elemnty
             */
            Graphics graphics = bufferStrategy.getDrawGraphics();
            graphics.setColor(Color.lightGray);
            graphics.fillRect(0,0,1024,768);

            /**
             * Jezeli jestesmy w rozgrywce to rysujemy nasz stoper i wywolujemy metode drawall z grafika na naszym EntitesManger ktorego pobieramy z kalsy engine
             * I wyrysowane są nasze obiekty
             */
            if(renderMode == RenderMode.GAME) {
                drawHud(graphics);
                engine.getEntitiesManager().drawAll(graphics);
            }
            /**
             * Po przejsciu naszej gry czyli trafieniu do wyjscia wyswietlany jest napis win na czarnym tle
             */
            else if (renderMode == RenderMode.WIN)
            {
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("ARIAL", Font.BOLD, 60));
                graphics.drawString("YOU WIN", 350,280);
            }
            /**
             * Zwolnienie zasobow i ponowne wyswietlenie naszej grafiki z bufferStrategy
             */
            graphics.dispose();
            bufferStrategy.show();
        }

        int timer = 0;

        public void drawHud(Graphics graphics){
            graphics.setColor(Color.black);
            graphics.drawString(("Time:" + timer), 14,24);
        }
    }


    /**
     * Klasa enum przyjmujaca dwie wartosci win kiedy uda nam sie przejsc labirynt i game kiedy jestesmy w trakcie rozgrywki
     */
    public enum RenderMode
    {
        WIN,
        GAME
    }
}
