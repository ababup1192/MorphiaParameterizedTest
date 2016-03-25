package org.ababup1192;

import java.util.Date;

class StringParameter extends EntityParameter<String> {
    StringParameter() {
        super();
    }

    StringParameter(String value, Integer groupId, Boolean deleteFlag, Date createTime, Date updateTime) {
        super(value, groupId, deleteFlag, createTime, updateTime);
    }
}
