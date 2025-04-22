package src.game.ecs.components;

public class PositionComponent implements Component {
    public int x, y;

    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        
        this.y = y;
    }
     
}
