package game.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {
   public boolean up, down, left, right;
    @Override
    public void keyPressed(KeyEvent e) { //checks if the key is pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }
           
    }
    @Override
    public void keyReleased(KeyEvent e) { //checks if the key is released
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_S -> down = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_D -> right = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    //getters :)
    public boolean isUp() {return up;}
    public boolean isDown() {return down;}
    public boolean isLeft() {return left;}
    public boolean isRight() {return right;}   
}
