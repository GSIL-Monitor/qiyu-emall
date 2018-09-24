package com.qiyu.emall.param;

import java.io.Serializable;

public class BaseParam implements Serializable {

   private String  jessionId;

    public String getJessionId() {
        return jessionId;
    }

    public void setJessionId(String jessionId) {
        this.jessionId = jessionId;
    }
}
