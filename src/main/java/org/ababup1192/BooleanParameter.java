package org.ababup1192;

import java.util.Date;

class BooleanParameter extends EntityParameter<Boolean> {
    BooleanParameter() {
        super();
    }

    BooleanParameter(Boolean value, Integer groupId, Boolean deleteFlag, Date createTime, Date updateTime) {
        super(value, groupId, deleteFlag, createTime, updateTime);
    }
}
