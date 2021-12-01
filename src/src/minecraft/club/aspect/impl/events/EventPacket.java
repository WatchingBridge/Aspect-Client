package club.aspect.impl.events;

import club.aspect.api.event.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event {

    private Packet<?> packet;
    private final State state;

    public EventPacket(final Packet<?> packet,final State state)
    {
        this.packet = packet;
        this.state = state;

    }

    public final Packet<?> getPacket()
    {
        return packet;
    }

    public final void setPacket(final Packet<?> packet)
    {
        this.packet = packet;
    }

    public final State getState()
    {
        return state;
    }

    public enum State
    {
        INCOMING, OUTCOMING
    }
}
