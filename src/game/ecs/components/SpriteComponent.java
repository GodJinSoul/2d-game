package src.game.ecs.components;

import java.awt.image.BufferedImage;
import src.game.util.LoadSave;

public class SpriteComponent implements Component {

    private BufferedImage sprite;

    public SpriteComponent(String imagePath) {
        this.sprite = LoadSave.getSprite(imagePath);
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(String imagePath) {
        this.sprite = LoadSave.getSprite(imagePath);
    }
}