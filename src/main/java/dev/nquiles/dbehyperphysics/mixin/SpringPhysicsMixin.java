package dev.nquiles.dbehyperphysics.mixin;

import dev.nquiles.dbehyperphysics.HyperPhysicsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Adjusts DBE's shared spring coefficients after construction.
 * The target is intentionally referenced by string because DBE owns this class.
 */
@Mixin(targets = "dev.dynamicbody.body.MinePreggoMotion$Spring")
public abstract class SpringPhysicsMixin {
    @Shadow @Final @Mutable private float stiff;
    @Shadow @Final @Mutable private float damp;
    @Shadow @Final @Mutable private float fric;
    @Shadow @Final @Mutable private float max;

    @Inject(method = "<init>(FFFF)V", at = @At("RETURN"))
    private void dbehyperphysics$applySettings(
            float originalStiff,
            float originalDamp,
            float originalFric,
            float originalMax,
            CallbackInfo ci
    ) {
        if (!HyperPhysicsConfig.ENABLED.get()) {
            return;
        }

        int level = HyperPhysicsConfig.INTENSITY.get();
        // Level 1 = 4x range; level 5 = 12x range (300% stronger than the previous 3x extreme preset).
        float intensityScale = (1.0F + (level - 1) * 0.50F) * 4.0F;
        float response = HyperPhysicsConfig.MOVEMENT_RESPONSE.get().floatValue();
        // Lower settling values retain more spring velocity and reduce friction.
        float settling = HyperPhysicsConfig.DAMPING.get().floatValue();

        this.stiff = originalStiff * response;
        this.damp = 1.0F - (1.0F - originalDamp) * settling;
        this.fric = originalFric * settling;
        this.max = originalMax * intensityScale;
    }
}
