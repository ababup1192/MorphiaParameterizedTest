package org.ababup1192;

import java.util.Date;

class IntegerParameter extends EntityParameter<Integer> {
    IntegerParameter() {
        super();
    }

    IntegerParameter(Integer value, Integer groupId, Boolean deleteFlag, Date createTime, Date updateTime) {
        super(value, groupId, deleteFlag, createTime, updateTime);
    }
}
