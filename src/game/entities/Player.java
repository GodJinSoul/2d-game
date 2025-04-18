package game.entities;

import game.input.KeyHandler;
import game.GamePanel;
import game.image.ImageHandler;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    BufferedImage img;

    KeyHandler key;
    GamePanel gp;

    public Player(GamePanel gp, KeyHandler key) {
        this.key = key;
        this.gp = gp;
        defaultValues();
        setPlayerSprite(defaultAction);
    }

    public void defaultValues() {
        posX = 100;
        posY = 100;
        speed = 4;
        defaultAction = "PASTA";
    }

    public void update() {
        setPlayerSprite("PASTA");
        playerMovement();
    }

    public void setPlayerSprite(String action) {
        switch (action) {
            case "PASTA" -> img = ImageHandler.GetImage(ImageHandler.PASTA);
            default -> img = ImageHandler.GetImage(ImageHandler.PASTA);

        }
    }

    public void playerMovement() {

        if (key.up)
            posY -= speed;
        if (key.down)
            posY += speed;
        if (key.left)
            posX -= speed;
        if (key.right)
            posX += speed;
    }

    public void draw(Graphics g) { // draw method

        g.drawImage(img, posX, posY, null);
    }
}
