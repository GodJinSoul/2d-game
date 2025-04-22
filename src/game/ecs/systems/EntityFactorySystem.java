package src.game.ecs.systems;

import src.game.ecs.components.MovementComponent;
import src.game.ecs.components.PlayerComponent;
import src.game.ecs.components.PositionComponent;
import src.game.ecs.components.SpriteComponent;
import src.game.ecs.entity.Entity;
import src.game.ecs.managers.EntityManager;

public class EntityFactorySystem {

    public static Entity createPlayer(EntityManager entityManager, int x, int y, int speed, String name,
            String spriteSheet, int frameDelay) {
        Entity player = entityManager.createEntity();
        entityManager.addComponent(player, new PositionComponent(x, y));
        entityManager.addComponent(player, new MovementComponent(speed));
        entityManager.addComponent(player, new PlayerComponent(name));
        entityManager.addComponent(player, new SpriteComponent(spriteSheet));

        return player;
    }

    public static Entity createMob(EntityManager entityManager, int x, int y, int speed, String spriteSheet,
            int frameDelay) {
        Entity mob = entityManager.createEntity();
        entityManager.addComponent(mob, new PositionComponent(x, y));
        entityManager.addComponent(mob, new MovementComponent(speed));
        entityManager.addComponent(mob, new SpriteComponent(spriteSheet));
        return mob;
    }

}
