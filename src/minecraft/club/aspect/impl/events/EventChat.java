package club.aspect.impl.events;

import club.aspect.api.event.Event;

public class EventChat extends Event {
    private String message;

    public EventChat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
