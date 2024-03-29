package com.example.mysejahtera.ui.notifications;

public class Notification {

    private String title;
    private String desc;
    private boolean expanded;

    public Notification(String title, String desc) {
        this.title = title;
        this.desc = desc;
        this.expanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
