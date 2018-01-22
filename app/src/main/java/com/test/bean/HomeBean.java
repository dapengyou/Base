package com.test.bean;

import java.io.Serializable;

/**
 * Created by lady_zhou on 2018/1/22.
 */

public class HomeBean implements Serializable {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
