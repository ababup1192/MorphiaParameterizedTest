package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Objects;

@Embedded
class BooleanParameter extends BaseParameter<Boolean> {

    BooleanParameter(){
        super();
    }

    BooleanParameter(Boolean value){
        this.value = value;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof BooleanParameter)) {
            return false;
        } else {
            BooleanParameter castedTarget = (BooleanParameter) target;
            return Objects.equals(this.value, castedTarget.value);
        }
    }
}
