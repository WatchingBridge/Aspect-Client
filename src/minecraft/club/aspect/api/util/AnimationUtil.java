package club.aspect.api.util;

public class AnimationUtil {
    public static int animate(int i, int end, int speed) {
        if (i < end) {
            i += speed;
        }
        if (i > end) {
            i = end;
        }
        return  i;
    }
}
