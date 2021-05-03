package com.core.components.nav;

public class FieldNav implements FieldNavInterface{
    private String title;
    private String icon;
    private String link;
    //private SecurityLevel security;
    private boolean enable = true;
    private boolean newTab = false;

    public FieldNav(String title)
    {
        this.title = title;
    }

    public FieldNav(String title, String icon, String link, boolean enable, boolean newTab) {
        this.title = title;
        this.icon = icon;
        this.link = link;
        this.enable = enable;
        this.newTab = newTab;
    }

    public FieldNav(String title, String icon, String link) {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }

    public FieldNav(String title, String link)
    {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isNewTab() {
        return newTab;
    }

    public void setNewTab(boolean newTab) {
        this.newTab = newTab;
    }
}
