package src.game.ecs.systems;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import src.game.ecs.components.MovementComponent;

public class KeyboardInputSystem implements KeyListener, Systms {
    MovementComponent mc;
    public KeyboardInputSystem(MovementComponent mc) {
        this.mc = mc;
    }
    @Override
    public void keyPressed(KeyEvent e) { //checks if the key is pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> { mc.up = true;
            System.out.println("up pressed!" + mc.up);} 
            case KeyEvent.VK_S -> mc.down = true;
            case KeyEvent.VK_A -> mc.left = true;
            case KeyEvent.VK_D -> mc.right = true;
        }
           
    }
    @Override
    public void keyReleased(KeyEvent e) { //checks if the key is released
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> { mc.up = false;
            System.out.println("up pressed!" + mc.up);}
            case KeyEvent.VK_S -> mc.down = false;
            case KeyEvent.VK_A -> mc.left = false;
            case KeyEvent.VK_D -> mc.right = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
}