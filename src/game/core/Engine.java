package src.game.core;

import src.game.ecs.components.PositionComponent;
import src.game.ecs.managers.EntityManager;
import src.game.ecs.systems.PositionSystem;
import src.game.ui.Panel;
public class Engine implements Runnable {
    private volatile boolean running = false;
    private Thread gameThread;
    public Panel panel;
    public PositionComponent pc;
    public PositionSystem ps;
    public EntityManager em = new EntityManager();
    public Engine(Panel panel, PositionSystem ps) {
        this.panel = panel;
        this.ps = ps;
    }

    public void startGameThread() { //method to start the thread
        if (gameThread == null || !running) { 
            gameThread = new Thread(this); //creates a new thread to this class(GamePanel) can trigger run() method inside THIS class
            running = true;
            gameThread.start(); //this triggers the run() method
        }
    }

    public void stopGameThread() { //method to stop the thread
        running = false; 
        try {
            if (gameThread != null) {
                gameThread.join(); //this method waits until the game thread is done
            }
        } catch (InterruptedException e) {
        }
    }
    @Override
    public void run() { 
        try {
            final double fps = 60.0;
            final double timePerTick = 1000000000 / fps; //sinerch ko lang
            double delta = 0;
            long lastTime = System.nanoTime(); //angas
    
            while (running) { //for capping fps
                long now = System.nanoTime();
                delta += (now - lastTime) / timePerTick;
                lastTime = now;
                
                while (delta >= 1) {
                    update(); //calls update() method below
                    panel.repaint(); //this method triggers paintComponent()
                    delta--;
                }
            }
        } catch (Exception e) {}
    }
    public void update() {
            ps.update();
        }
}
