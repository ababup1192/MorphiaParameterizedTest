package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Objects;

@org.mongodb.morphia.annotations.Entity("entity")
@Embedded
// このクラスはジェネリクスを持ってはいけない(morphiaが cast error を起こす)
class Entity {
    // BaseParameterに型パラメータ(Tなど)を渡してはいけない。
    // 必ずraw type もしくは決め打ちの型パラメータを渡す
    @Embedded
    private BaseParameter base;

    public Entity() {
    }

    Entity(BaseParameter base){
        this.base = base;
    }

    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof Entity)) {
            return false;
        } else {
            Entity targetEntity = (Entity) target;
            return Objects.equals(this.base, targetEntity.base);
        }
    }

    public String toString() {
        return "Entity(" + base + ")";
    }
}
