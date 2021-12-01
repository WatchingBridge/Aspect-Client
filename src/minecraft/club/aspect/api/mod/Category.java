package club.aspect.api.mod;

import java.awt.*;

public enum Category {

    COMBAT("Combat",new Color(128, 5, 5).getRGB()),MOVEMENT("Movement",new Color(4, 88, 169).getRGB()),OTHER("Other",new Color(255, 166, 0).getRGB()),VISUALS("Visuals",new Color(74, 194, 3).getRGB());

    private String name;
    private int color;
    Category(String name,int color) {
        this.name = name;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
