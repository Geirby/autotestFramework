package com.framework.enums;

public enum DemoQaElements {
    BROWSER_WINDOWS("item-0"), ALERTS("item-1");
    private final String IdItem;

    DemoQaElements(String id) {
        this.IdItem = id;
    }

    public String getIdItem() {
        return IdItem;
    }
}

