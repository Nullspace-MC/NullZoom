package net.nullspace_mc.nullzoom.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import net.minecraft.client.gui.screen.TitleScreen;
import net.nullspace_mc.nullzoom.NullZoom;

@Mixin(GameRenderer.class)
abstract class MinecraftMixin {
	@Inject(
		method = "tick",
		at = @At()
	)
}
