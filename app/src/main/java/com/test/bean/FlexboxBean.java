package com.test.bean;

import java.io.Serializable;

/**
 * Created by lady_zhou on 2018/1/22.
 */

public class FlexboxBean implements Serializable {
    private String text;//文字

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
