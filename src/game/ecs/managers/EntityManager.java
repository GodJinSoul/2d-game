package src.game.ecs.managers;
import java.util.*;
import src.game.ecs.components.Component;
import src.game.ecs.entity.Entity;
public class EntityManager {
    private int nextId = 0;
    private final Map<Class<? extends Component>, Map<Integer, Component>> components = new HashMap<>();

    public Entity createEntity() {
        return new Entity(nextId++);
   }
    public <T extends Component> void addComponent(Entity e, T c) {
        components.computeIfAbsent(c.getClass(), _ -> new HashMap<>()).put(e.getId(), c);
    }
    public <T extends Component> T getComponent(Entity e, Class<T> cls) {
        return cls.cast(components.getOrDefault(cls, new HashMap<>()).get(e.getId()));
    }
    @SafeVarargs
    public final List<Entity> getEntitiesWithComponents(Class<? extends Component>... componentClasses) {
        List<Entity> entities = new ArrayList<>();
        Set<Integer> entityIds = null;
    
        for (Class<? extends Component> cls : componentClasses) {
            Map<Integer, Component> componentsOfType = components.get(cls);
            if (componentsOfType == null) {
                return entities; // No entities have this component type
            }
    
            if (entityIds == null) {
                entityIds = new HashSet<>(componentsOfType.keySet());
            } else {
                entityIds.retainAll(componentsOfType.keySet());
            }
        }
    
        if (entityIds != null) {
            for (Integer id : entityIds) {
                entities.add(new Entity(id));
            }
        }
    
        return entities;
    }
}
