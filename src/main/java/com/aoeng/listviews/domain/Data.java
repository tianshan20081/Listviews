package com.aoeng.listviews.domain;

import java.io.Serializable;

/**
 * Created by sczhang on 15/5/11.
 */
public class Data implements Serializable {
    private String name;

    public Data(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
