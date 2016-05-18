package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Objects;

// 必ず決め打ちで、型パラメータを与えたクラスを用意する。
@Embedded
class IntegerParameter extends BaseParameter<Integer> {

    IntegerParameter(){
        super();
    }

    IntegerParameter(Integer value){
        this.value = value;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof IntegerParameter)) {
            return false;
        } else {
            IntegerParameter castedTarget = (IntegerParameter) target;
            return Objects.equals(this.value, castedTarget.value);
        }
    }
}
