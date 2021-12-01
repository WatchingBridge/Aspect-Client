package club.aspect.api.mod;

import java.util.ArrayList;
import java.util.List;

import club.aspect.impl.mods.testmod;

public class ModManager {
    private static final List<Mod> savedMods = new ArrayList<>();

    public static void initMods() {
    	savedMods.add(new testmod());
    }
    public static void onKey(final int key)
    {
        savedMods.stream().filter(mod -> mod.getKeyBind() == key).forEach(mod -> mod.setToggled(!mod.isToggled()));
    }
    public static List<Mod> getSavedMods()
    {
        return savedMods;
    }

    public static Mod getMod(final Class<?> modClass)
    {
        return savedMods.stream().filter(mod -> mod.getClass() == modClass).findAny().orElse(null);
    }

    public static List<Mod> getModsInCategory(final Category category)
    {
        final List<Mod> modArrayList = new ArrayList<>();
        savedMods.stream().filter(mod -> mod.getCategory() == category).forEach(modArrayList::add);
        return modArrayList;
    }

    public static List<Mod> getToggledMods()
    {
        final List<Mod> toggledMods = new ArrayList<>();
        savedMods.stream().filter(Mod::isToggled).forEach(toggledMods::add);
        return toggledMods;
    }

    public static Mod getModByName(String name)
    {
        return savedMods.stream().filter(mod -> mod.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }

}
