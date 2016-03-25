package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Date;
import java.util.Objects;

@Embedded
abstract class EntityParameter<E> {
    private E value;
    private Integer groupId;
    private Boolean deleteFlag;
    private Date createTime;
    private Date updateTime;

    EntityParameter(){
    }

    EntityParameter(E value, Integer groupId, Boolean deleteFlag, Date createTime, Date updateTime) {
        this.value = value;
        this.groupId = groupId;
        this.deleteFlag = deleteFlag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof EntityParameter)) {
            return false;
        } else {
            EntityParameter castedTarget = (EntityParameter) target;
            return Objects.equals(this.value, castedTarget.value) &&
                    Objects.equals(this.groupId, castedTarget.groupId) &&
                    Objects.equals(this.deleteFlag, castedTarget.deleteFlag);
        }
    }

    @Override
    public String toString() {
        return "Entity(" + value + ")";
    }
}
