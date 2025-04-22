package src.game.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadSave {
    public static final String PLAYER_SPRITE_SHEET = "res/sprites/player/sprites/bates/olala.png";
    public static final String placeHolder = "res/sprites/player/sprites/bates/olala.png";

    // more spritesheets plz
    public static BufferedImage getSprite(String spriteSheet) {
        switch (spriteSheet) {
            case "PLAYER_SPRITE_SHEET":
                return getTheImageFromSomeWhere(PLAYER_SPRITE_SHEET);
            case "ENEMY":
                return getTheImageFromSomeWhere(placeHolder);
            default:
                System.out.println("HINDI MA LOCATE ANG IMAGE KAYA NAG EEROR");
                return null;
        }
    }

    public static BufferedImage getTheImageFromSomeWhere(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(LoadSave.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException | NullPointerException e) {
            System.err.println("Failed to load image: ");

        }
        return img;
    }
}
