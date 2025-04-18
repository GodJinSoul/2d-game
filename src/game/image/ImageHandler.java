package game.image;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageHandler {
    public static final String PASTA = "pasta.png";

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
