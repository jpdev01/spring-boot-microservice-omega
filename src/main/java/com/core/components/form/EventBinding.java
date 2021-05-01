package com.core.components.form;

public class EventBinding {
    private String event;
    private String message;
    private String route;

    public EventBinding(String message, String route)
    {
        this.message = message;
        this.route = route;
    }

    public EventBinding(String message)
    {
        this.message = message;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
