package club.aspect.impl.mods;

import org.lwjgl.input.Keyboard;

import club.aspect.api.mod.Category;
import club.aspect.api.mod.Mod;
import club.aspect.api.mod.ModInfo;

@ModInfo(category = Category.COMBAT, name = "testmod", renderName = "test", description = "test mod", keybind = Keyboard.KEY_Z)
public class testmod extends Mod {

	@Override
	public void onEnable() {
		System.out.println("test is now running");
	}
	
	@Override
	public void onDisable() {
		System.out.println("test is now disabled");
	}
	
	protected void onToggle() {
		
		System.out.println("test is toggled");
	};
	
}
