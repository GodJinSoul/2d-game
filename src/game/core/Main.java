package src.game.core;

import javax.swing.JFrame;
import src.game.ecs.components.MovementComponent;
import src.game.ecs.entity.Entity;
import src.game.ecs.managers.EntityManager;
import src.game.ecs.systems.EntityFactorySystem;
import src.game.ecs.systems.KeyboardInputSystem;
import src.game.ecs.systems.PositionSystem;
import src.game.ecs.systems.RenderingSystem;
import src.game.ui.Panel;

public class Main {
    public static void main(String[] args) {
        // Initialize the EntityManager
        EntityManager entityManager = new EntityManager();

        // Create entities using the factory system
        Entity player = EntityFactorySystem.createPlayer(entityManager, 100, 100, 4, "Josh", "PLAYER_SPRITE_SHEET", 4);
        EntityFactorySystem.createMob(entityManager, 200, 200, 2, "PLAYER_SPRITE_SHEET", 4);
        // EntityFactorySystem.createMob(entityManager, 300, 300, 3, "Image", 4);

        // Initialize systems
        RenderingSystem rs = new RenderingSystem(entityManager);
        PositionSystem ps = new PositionSystem(entityManager);
        KeyboardInputSystem kis = new KeyboardInputSystem(entityManager.getComponent(player, MovementComponent.class));

        // Set up the game window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game");

        Panel panel = new Panel(rs);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Start the game engine
        Engine engine = new Engine(panel, ps);
        panel.addKeyListener(kis); // Attach input system
        engine.startGameThread();
    }
}