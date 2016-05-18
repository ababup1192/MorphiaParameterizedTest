package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Objects;

@Embedded
class StringParameter extends BaseParameter<String> {
    public StringParameter(){
        super();
    }

    StringParameter(String value){
        this.value = value;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) return true;
        else if (!(target instanceof StringParameter)) {
            return false;
        } else {
            StringParameter castedTarget = (StringParameter) target;
            return Objects.equals(this.value, castedTarget.value);
        }
    }
}
