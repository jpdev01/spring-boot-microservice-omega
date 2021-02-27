package com.onroad.config;

public class AppUtils {
    private String appUrl = "http://localhost:8081/project_neusamoda_war_exploded";
    private static AppUtils instance;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public static AppUtils getInstance() {
        if (instance == null){
            instance = new AppUtils();
        }
        return instance;
    }

    public void setInstance(AppUtils instance) {
        this.instance = instance;
    }
}
