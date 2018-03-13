package com.test.unfolditem.bean;

/**
 * Created by lady_zhou on 2018/3/13.
 */

public class DataBean {
    public static final int PARENT_ITEM =  0;//父布局
    public static final int CHILD_ITEM =  1;//子布局

    private int type;// 显示类型
    private boolean isExpand;// 是否展开
    private DataBean childBean;

    private String ID;
    private String parentTxt;
    private String childTxt;

    public static int getParentItem() {
        return PARENT_ITEM;
    }

    public static int getChildItem() {
        return CHILD_ITEM;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public DataBean getChildBean() {
        return childBean;
    }

    public void setChildBean(DataBean childBean) {
        this.childBean = childBean;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParentTxt() {
        return parentTxt;
    }

    public void setParentTxt(String parentTxt) {
        this.parentTxt = parentTxt;
    }

    public String getChildTxt() {
        return childTxt;
    }

    public void setChildTxt(String childTxt) {
        this.childTxt = childTxt;
    }
}
