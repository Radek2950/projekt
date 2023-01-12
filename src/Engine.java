/**
 * Jest to klasa odpowiedzialna za  tworzenie,sprawdzanie mozliwsoci naszego ruchu, uruchomienie naszej gry
 *
 */
public class Engine {



    private Renderer renderer;

    private EntitiesManager entitiesManager;

    public User user;

    /**
     * Konstruktor w ktorym tworzyny jest nowy Renderer i EntitiesManger i uruchamiana metoda start
     */
    public Engine() {
        renderer = new Renderer(this);
        entitiesManager = new EntitiesManager(this);
        start();
    }

    /**
     * metoda która uruchumia engineLoop
     */
    public void start() {
        engineLoop();
    }

    /**
     * Funkcja opdowiedzialna ze tworzenie nieskonczonej petli while i odpowiada za to ze co każde przejscie petli obiekty wykonuja jakis ruch
     * A rendener rendeneruje nam caly czas nasza plansze
     */
    public void engineLoop() {
        while (true)
        {
            entitiesManager.callAll();
            renderer.drawAll();
        }
    }

    /**
     * Funkcja resetujaca polozenie uzytkownika po zderzeniu ze scinom
     */
    public void resetUserPosition(){
        user.dataset.x = 500;
        user.dataset.y = 500;
    }

    /**
     * zakmniecie programy
     */
    public void exit() {
        renderer.dispose();
        new Menu();
    }

    /**
     * Metoda uruchamiana gdy wejdziemy w nasze wyjscie i sprawie ze jest wyswietlana informacja o wygranej
     */
    public void gate(){
        renderer.setRenderMode(Renderer.RenderMode.WIN);
    }

    /**
     * Metoda odpowiadająca za to że nie mozemy się poruszac naszym obiektem np w sciane czy nie wyjechac poza nasze pole rozgrywki
     */
    public void turnOffControls(){
        renderer.up = false;
        renderer.down = false;
        renderer.left = false;
        renderer.right = false;
    }


    public Renderer getRenderer() {
        return renderer;
    }

    public EntitiesManager getEntitiesManager() {
        return entitiesManager;
    }
}
