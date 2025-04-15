package game.entities;

import game.input.KeyHandler;
import java.awt.Color;
import java.awt.Graphics;
public class Player {
    int posX = 100, posY = 100, speed = 4; //positions and speed of the player
    KeyHandler key;
    public Player(KeyHandler key) {
        this.key = key;
    }
    public void update() { //position update
        if(key.up)posY -= speed; 
        if(key.down) posY += speed;
        if(key.left) posX -= speed;
        if(key.right) posX += speed;
   }
    public void draw(Graphics g) { //draw method
        g.setColor(Color.white);
        g.fillRect(posX, posY, 16*3, 16*3);
   }
}
 