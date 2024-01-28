package net.nullspace_mc.nullzoom.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.GameRenderer;
import net.nullspace_mc.nullzoom.NullZoom;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
abstract class GameRendererMixin {
	@Shadow
	private Minecraft minecraft;

	@Inject(
		method = "getFov",
		at = @At("RETURN"),
		cancellable = true
	)
	private void getZoomingFov(float fovChanged, boolean par2, CallbackInfoReturnable<Float> cir) {
		if (NullZoom.isZooming()) {
			cir.setReturnValue(cir.getReturnValue() * NullZoom.getZoomLevel());
		}
	}
}
