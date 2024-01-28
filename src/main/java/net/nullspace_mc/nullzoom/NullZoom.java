package net.nullspace_mc.nullzoom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.options.KeyBinding;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;
import net.ornithemc.osl.keybinds.api.KeyBindingEvents;

public class NullZoom implements ClientModInitializer {
	public static KeyBinding zoomKeybind;

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("NullZoom");

	@Override
	public void initClient() {
		KeyBindingEvents.REGISTER_KEYBINDS.register(registry -> {
			zoomKeybind = registry.register("key.nullzoom.zoom", Keyboard.KEY_C, "category.nullzoom.zoom");
		});
	}
}
