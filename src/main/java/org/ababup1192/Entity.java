package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Objects;

@org.mongodb.morphia.annotations.Entity("entity")
@Embedded
class Entity {
    @Embedded
    private IntegerParameter id;
    @Embedded
    private StringParameter name;
    @Embedded
    private BooleanParameter flag;


    public Entity() {
    }

    Entity(IntegerParameter id, StringParameter name, BooleanParameter flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof Entity)) {
            return false;
        } else {
            Entity targetEntity = (Entity) target;
            return Objects.equals(this.id, targetEntity.id) &&
                    Objects.equals(this.name, targetEntity.name) &&
                    Objects.equals(this.flag, targetEntity.flag);
        }
    }

    public String toString() {
        return "Entity(" + id + ", " + name + ", " + flag + ")";
    }
}
