package club.aspect.api.event;

import club.aspect.api.Client;

public class EventAPI {

    public static void register(final Object o) { Client.INSTANCE.getEventPubSub().subscribe(o); }


    public static void unregister(final Object o) { Client.INSTANCE.getEventPubSub().unsubscribe(o); }


    public static void fire(final Event event) { Client.INSTANCE.getEventPubSub().post(event).dispatch(); }
}
