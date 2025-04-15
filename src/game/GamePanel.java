package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    // SCREEN SETTINGS
    final int ORIGINALTILESIZE = 16; // 16x16 tile
    final int SCALE = 3;
    final int TILESIZE = ORIGINALTILESIZE * SCALE; // 48x48 tile
    final int MAXSCREENCOL = 16;
    final int MAXSCREENROW = 12;
    final int SCREENWIDTH = TILESIZE * MAXSCREENCOL; // 768 pixel
    final int SCREENHEIGHT = TILESIZE * MAXSCREENROW; // 576 pixel

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    // drawn in the panel
    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File("res\\sprites\\pasta.png"));
            g.drawImage(img, 0, 0, this);
        } catch (Exception e) {

        }
        // super.paintComponent(g);

        // Graphics2D g2 = (Graphics2D) g;

        // g2.setColor(Color.white);

        // g2.fillRect(0, 100, TILESIZE, TILESIZE);
        // g2.dispose();
    }
}
