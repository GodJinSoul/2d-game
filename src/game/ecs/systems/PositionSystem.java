package src.game.ecs.systems;

import src.game.ecs.components.MovementComponent;
import src.game.ecs.components.PositionComponent;
import src.game.ecs.entity.Entity;
import src.game.ecs.managers.EntityManager;

public class PositionSystem implements Systms {
    private final EntityManager em;

    public PositionSystem(EntityManager em) {
        this.em = em; // Use the existing EntityManager
    }

    public void update() {
        
        // Iterate over all entities with PositionComponent and MovementComponent
        for (Entity e : em.getEntitiesWithComponents(PositionComponent.class, MovementComponent.class)) {
            PositionComponent pc = em.getComponent(e, PositionComponent.class);
            MovementComponent mc = em.getComponent(e, MovementComponent.class);
            // Update position based on movement
            if (mc.isUp()) pc.setY(pc.getY() - mc.getSpeed());
            if (mc.isDown()) pc.setY(pc.getY() + mc.getSpeed());
            if (mc.isLeft()) pc.setX(pc.getX() - mc.getSpeed());
            if (mc.isRight()) pc.setX(pc.getX() + mc.getSpeed());
            System.out.println("X: " + pc.getX() + "\nY: " + pc.getY());
        }
    }
}
