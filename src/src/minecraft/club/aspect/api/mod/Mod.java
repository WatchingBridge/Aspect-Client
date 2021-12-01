package club.aspect.api.mod;

import net.minecraft.client.Minecraft;
import club.aspect.api.event.EventAPI;


public class Mod {

    protected Minecraft mc = Minecraft.getMinecraft();

    private String name = getClass().getAnnotation(ModInfo.class).name();

    private String renderName = getClass().getAnnotation(ModInfo.class).renderName();

    private int keyBind = getClass().getAnnotation(ModInfo.class).keybind();

    private Category category = getClass().getAnnotation(ModInfo.class).category();

    private String description = getClass().getAnnotation(ModInfo.class).description();

    private String suffix;

    private boolean toggled;

    public final void setToggled(boolean toggled)
    {
        this.onToggle();

        if (toggled)
        {
            this.toggled = true;
            this.onEnable();
            EventAPI.register(this);
        }
        else
        {
            this.toggled = false;
            EventAPI.unregister(this);
            this.onDisable();
        }
    }
    public void onEnable() {}
    public void onDisable() {}
    protected void onToggle(){}


    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public String getDescription() {
        return description;
    }

    public String getRenderName() {
        return renderName;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRenderName(String renderName) {
        this.renderName = renderName;
    }
    public boolean isToggled() {
        return toggled;
    }
}
