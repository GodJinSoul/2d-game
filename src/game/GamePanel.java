package game;

import game.entities.Player;
import game.input.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    public final int ORIGINALTILESIZE = 16; // 16x16 tile
    public final int SCALE = 3;
    public final int TILESIZE = ORIGINALTILESIZE * SCALE; // 48x48 tile
    public final int MAXSCREENCOL = 16;
    public final int MAXSCREENROW = 12;
    public final int SCREENWIDTH = TILESIZE * MAXSCREENCOL; // 768 pixel
    public final int SCREENHEIGHT = TILESIZE * MAXSCREENROW; // 576 pixel

    private Thread gameThread; // game thread
    private volatile boolean running = false;
    private final KeyHandler keyHandler = new KeyHandler();
    private final Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true); // to enable keyboard input
        this.setDoubleBuffered(true);
        this.requestFocusInWindow(); // to request focus on the window to be able to receive keyboard input
        this.addKeyListener(keyHandler);
    }

    public void startGameThread() { // method to start the thread
        if (gameThread == null || !running) {
            gameThread = new Thread(this); // creates a new thread to this class(GamePanel) can trigger run() method
                                           // inside THIS class
            running = true;
            gameThread.start(); // this triggers the run() method
        }
    }

    public void stopGameThread() { // method to stop the thread
        running = false;
        try {
            if (gameThread != null) {
                gameThread.join(); // this method waits until the game thread is done
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        try {
            final double fps = 60.0;
            final double timePerTick = 1000000000 / fps; // sinerch ko lang
            double delta = 0;
            long lastTime = System.nanoTime(); // angas

            while (running) { // for capping fps
                long now = System.nanoTime();
                delta += (now - lastTime) / timePerTick;
                lastTime = now;

                while (delta >= 1) {
                    update(); // calls update() method below
                    repaint(); // this method triggers paintComponent()
                    delta--;
                }
            }
        } catch (Exception e) {
        }
    }

    public void update() {
        if (player != null) {
            player.update(); // updates player's position
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // this method is necessary for visual glitches(cleaning the panel before fresh
                                 // draw)
        if (player != null) {
            player.draw(g); // draws the player's character(sprite) in the panel
        }
    }
}
