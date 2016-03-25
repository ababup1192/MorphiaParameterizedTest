package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.List;
import java.util.Objects;

@org.mongodb.morphia.annotations.Entity("entityGroup")
class EntityGroup {
    @Embedded
    private List<Entity> entities;

    public EntityGroup() {
    }

    EntityGroup(List<Entity> entities) {
        this.entities = entities;
    }

    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof EntityGroup)) {
            return false;
        } else {
            EntityGroup targetEntity = (EntityGroup) target;
            return Objects.equals(this.entities, targetEntity.entities);
        }
    }
}
