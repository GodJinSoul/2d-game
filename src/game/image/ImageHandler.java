package game.image;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageHandler {
    // just put the correct relative path to the image

    public static final String PASTA = "res/sprites/pasta.png";
    public static final String GULAT = "res/sprites/gulat.jpg";
    public static final String GULAT2 = "res/sprites/gulat2.jpg";
    public static final String GULAT3 = "res/sprites/gulat3.jpg";

    public static BufferedImage GetImage(String filename) {
        BufferedImage img = null;
        try {
            // universal, to get image
            img = ImageIO.read(ImageHandler.class.getResourceAsStream("/" + filename));

        } catch (Exception e) {
            System.out.println("Image not found");
        }
        return img;
    }

}
