package src.game.ecs.components;

//test lang to di nagana gahaha

import java.awt.image.BufferedImage;
import src.game.util.LoadSave;

public class AnimationComponent implements Component {
    private BufferedImage[] frames;
    private int currentFrame;
    private int frameDelay;
    private int frameCounter;
    private int frameWidth = 32; // eto sinet ko na lang ng 16 kasi, 16 by 16 naman tayo diba?
    private int frameHeight = 32;
    private BufferedImage spriteSheet;

    public AnimationComponent(String imagePath, int frameDelay) {
        this.spriteSheet = LoadSave.getSprite(imagePath);
        int columns = spriteSheet.getWidth() / frameWidth;
        int rows = spriteSheet.getHeight() / frameHeight;
        int totalFrames = columns * rows;

        frames = new BufferedImage[totalFrames];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                frames[y * columns + x] = spriteSheet.getSubimage(x * frameWidth, y * frameHeight, frameWidth,
                        frameHeight);
            }
        }

        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.frameCounter = 0;
    }

    public BufferedImage getCurrentFrame() {
        return frames[currentFrame];
    }

    public void update() {
        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            currentFrame = (currentFrame + 1) % frames.length; // pang loop lang pag spritesheet gamit
        }
    }
}
