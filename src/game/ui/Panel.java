package src.game.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import src.game.ecs.systems.RenderingSystem;

public class Panel extends JPanel {
    public final static int ORIGINALTILESIZE = 16; // 32x32 tile
    public final static int SCALE = 3;
    public final static int TILESIZE = ORIGINALTILESIZE * SCALE; // 48x48 tile
    public final static int MAXSCREENCOL = 16;
    public final static int MAXSCREENROW = 12;
    public final static int SCREENWIDTH = TILESIZE * MAXSCREENCOL; 
    public final static int SCREENHEIGHT = TILESIZE * MAXSCREENROW;
    
    public RenderingSystem rs;
    public Panel(RenderingSystem rs) {
        this.rs = rs;
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rs.draw(g);
        }
    }
    

