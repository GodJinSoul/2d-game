package src.game.ecs.components;

public class MobComponent {
    private String type;
    private int health;
    public MobComponent(String type) {
        this.type = type;
        this.health = 100;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}
