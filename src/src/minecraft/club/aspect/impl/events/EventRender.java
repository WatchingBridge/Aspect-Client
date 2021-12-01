package club.aspect.impl.events;

import club.aspect.api.event.Event;
import net.minecraft.client.gui.ScaledResolution;

public class EventRender extends Event {
    private final float partialTicks;

    private final ScaledResolution scaledResolution;

    private final State state;


    public EventRender(final float partialTicks, final ScaledResolution scaledResolution, final State state)
    {
        this.partialTicks = partialTicks;
        this.scaledResolution = scaledResolution;
        this.state = state;
    }

    public final float getPartialTicks()
    {
        return partialTicks;
    }

    public ScaledResolution getScaledResolution()
    {
        return scaledResolution;
    }

    public State getState()
    {
        return state;
    }

    public enum State
    {
        Render2D, Render3D
    }
}
