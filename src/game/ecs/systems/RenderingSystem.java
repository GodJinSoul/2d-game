package src.game.ecs.systems;

import java.awt.Graphics;

import src.game.ecs.components.PositionComponent;
import src.game.ecs.components.SpriteComponent;
import src.game.ecs.entity.Entity;
import src.game.ecs.managers.EntityManager;

public class RenderingSystem implements Systms {
    EntityManager em;

    public RenderingSystem(EntityManager em) {
        this.em = em;
    }

    public void draw(Graphics g) {
        // Iterate over all entities with a PositionComponent
        for (Entity entity : em.getEntitiesWithComponents(PositionComponent.class,
                SpriteComponent.class)) {
            PositionComponent position = em.getComponent(entity,
                    PositionComponent.class);
            SpriteComponent sprite = em.getComponent(entity, SpriteComponent.class);

            // Draw the sprite at the entity's position
            g.drawImage(sprite.getSprite(), position.getX(), position.getY(), null);
        }
        // for (Entity entity : em.getEntitiesWithComponents(PositionComponent.class,
        // SpriteComponent.class)) {
        // PositionComponent position = em.getComponent(entity,
        // PositionComponent.class);
        // SpriteComponent sprite = em.getComponent(entity, SpriteComponent.class);

        // // Draw the current frame of the sprite at the entity's position
        // g.drawImage(sprite.getCurrentFrame(), position.getX(), position.getY(),
        // null);
        // }
    }

}
