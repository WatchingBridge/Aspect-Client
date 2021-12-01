package club.aspect.api.util;

public class TimeHelper {
    private long time;

    public TimeHelper()
    {
        time = System.nanoTime() / 1000000L;
    }


    public boolean reach(final long time)
    {
        return time() >= time;
    }


    public void reset()
    {
        time = System.nanoTime() / 1000000L;
    }


    public void setTime(long time) {
        this.time = time;
    }


    public boolean sleep(final double time)
    {
        if (time() >= time) {
            reset();
            return true;
        }
        return false;
    }

    public short convertToMS(final float perSecond)
    {
        return (short) (int) (1000.0F / perSecond);
    }

    public long time()
    {
        return System.nanoTime() / 1000000L - time;
    }
}
