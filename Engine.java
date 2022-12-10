public class Engine {
    private Renderer renderer;
    private EntitiesManager entitiesManager;
    public User user;

    public Engine() {
        renderer = new Renderer(this);
        entitiesManager = new EntitiesManager(this);
        start();
    }

    public void start() {
        engineLoop();
    }

    public void engineLoop() {
        while (true)
        {
            entitiesManager.callAll();
            renderer.drawAll();
        }
    }

    public void resetUserPosition(){
        user.dataset.x = 500;
        user.dataset.y = 500;
    }

    public void exit() {
        renderer.dispose();
        new Menu();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public EntitiesManager getEntitiesManager() {
        return entitiesManager;
    }
}
