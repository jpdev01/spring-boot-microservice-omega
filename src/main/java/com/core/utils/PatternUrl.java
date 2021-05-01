package com.core.utils;

public class PatternUrl {
    private String home = "home";
    private String product = "product";
    private String customer = "customer";
    private String user = "user";
    private String category = "category";
    private String provider = "provider";
    private String storeSpace = "store";

    // components
    private String list= "list";
    private String frm= "frm";

    private String abstractURI = "abstract";

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStoreSpace() {
        return storeSpace;
    }

    public void setStoreSpace(String storeSpace) {
        this.storeSpace = storeSpace;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getFrm() {
        return frm;
    }

    public void setFrm(String frm) {
        this.frm = frm;
    }

    public String getAbstractURI() {
        return abstractURI;
    }

    public void setAbstractURI(String abstractURI) {
        this.abstractURI = abstractURI;
    }

    public String getHomeRoute(String route)
    {
        return this.home +"/"+ route;
    }
}
