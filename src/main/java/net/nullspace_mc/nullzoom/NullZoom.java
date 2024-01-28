package net.nullspace_mc.nullzoom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;
import net.ornithemc.osl.keybinds.api.KeyBindingEvents;
import net.ornithemc.osl.lifecycle.api.client.MinecraftClientEvents;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.text.DecimalFormat;

public class NullZoom implements ClientModInitializer {
	public static KeyBinding zoomKeybind;

	private static float zoomLevel = 0.23f;

	@Override
	public void initClient() {
		MinecraftClientEvents.TICK_START.register(listener -> {
			int scrollDeltaZ = -Mouse.getDWheel();
			if (zoomKeybind.isPressed()) {
				if (scrollDeltaZ == 0) return;
				changeZoomLevel((float) scrollDeltaZ / 1000);
				Minecraft.getInstance().gui.getChat().addMessage(
					new LiteralText(
						"New zoom level: "
						+ new DecimalFormat("#.0").format(getZoomLevel() * 10)
					)
				);
			}
		});
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

	public static void changeZoomLevel(float value) {
		float MAX_ZOOM = 1f;
		float MIN_ZOOM = 0.05f;

		float newVal = zoomLevel + value;
		if (newVal >= MIN_ZOOM && newVal <= MAX_ZOOM) zoomLevel = newVal;
		else if (newVal < MIN_ZOOM) zoomLevel = MIN_ZOOM;
		else zoomLevel = MAX_ZOOM;
	}
}
