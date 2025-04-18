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
        setPlayerSprite(action);
    }

    public void defaultValues() {
        posX = 100;
        posY = 100;
        speed = 4;
        action = "PASTA";
    }

    public void update() {
        playerMovement();
        setPlayerSprite(action);
    }

    public void setPlayerSprite(String action) {
        switch (action) {
            case "PASTA" -> img = ImageHandler.GetImage(ImageHandler.PASTA);
            case "GULAT" -> img = ImageHandler.GetImage(ImageHandler.GULAT);
            case "GULAT2" -> img = ImageHandler.GetImage(ImageHandler.GULAT2);
            case "GULAT3" -> img = ImageHandler.GetImage(ImageHandler.GULAT3);
            default -> img = ImageHandler.GetImage(ImageHandler.PASTA);

        }
    }

    public void playerMovement() {

        if (key.up == true) {
            action = "PASTA";
            posY -= speed;
        }

        if (key.down == true) {
            action = "GULAT";
            posY += speed;
        }

        if (key.left == true) {
            action = "GULAT2";
            posX -= speed;
        }

        if (key.right == true) {
            action = "GULAT3";
            posX += speed;
        }
    }

    public void draw(Graphics g) { // draw method

        g.drawImage(img, posX, posY, 100, 100, null);
    }
}
