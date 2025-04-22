package src.game.ecs.systems;

import java.awt.Graphics;
import src.game.ecs.components.PositionComponent;
import src.game.ecs.entity.Entity;
import src.game.ecs.managers.EntityManager;
public class RenderingSystem implements Systms {
    EntityManager em;
    public RenderingSystem(EntityManager em) {
        this.em = em;
    }
    
    public void draw(Graphics g) {
       // Iterate over all entities with a PositionComponent
       for (Entity e : em.getEntitiesWithComponents(PositionComponent.class)) {
        PositionComponent pc = em.getComponent(e, PositionComponent.class);

        // Example: Draw a rectangle for each entity
        g.fillRect(pc.getX(), pc.getY(), 16, 16);
    }
    }
    
}
