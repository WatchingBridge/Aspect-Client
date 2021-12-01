package club.aspect.api.event;

public class Event{

    private boolean cancelled;

    public final void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
