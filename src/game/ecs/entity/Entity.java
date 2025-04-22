package src.game.ecs.entity;

public class Entity {
    private final int id;
    
    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Entity && ((Entity)obj).id == this.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
