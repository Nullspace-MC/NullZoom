package net.nullspace_mc.nullzoom;

import net.minecraft.client.options.KeyBinding;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;
import net.ornithemc.osl.keybinds.api.KeyBindingEvents;
import org.lwjgl.input.Keyboard;

public class NullZoom implements ClientModInitializer {
	public static KeyBinding zoomKeybind;

	private static final float zoomLevel = 0.23f;

	@Override
	public void initClient() {
		KeyBindingEvents.REGISTER_KEYBINDS.register(registry -> {
			zoomKeybind = registry.register("key.nullzoom.zoom", Keyboard.KEY_C, "category.nullzoom.zoom");
		});
	}

	public static boolean isZooming() {
		return zoomKeybind.isPressed();
	}

	public static float getZoomLevel() {
		return zoomLevel;
	}
}
