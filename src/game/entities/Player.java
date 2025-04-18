package game.entities;

import game.input.KeyHandler;
import game.GamePanel;
import game.image.ImageHandler;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    KeyHandler key;
    GamePanel gp;

    BufferedImage img;

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
        playerMovement();
        setPlayerSprite("PASTA");
    }

    public void setPlayerSprite(String action) {
        switch (action) {
            case "PASTA" -> img = ImageHandler.GetImage(ImageHandler.PASTA);

            default -> img = ImageHandler.GetImage(ImageHandler.PASTA);

        }
    }

    public void playerMovement() {

        if (key.up == true) {
            posY -= speed;
        }

        if (key.down == true) {
            posY += speed;
        }

        if (key.left == true) {
            posX -= speed;
        }

        if (key.right == true) {
            posX += speed;
        }
    }

    public void draw(Graphics g) { // draw method

        g.drawImage(img, posX, posY, null);
    }
}
