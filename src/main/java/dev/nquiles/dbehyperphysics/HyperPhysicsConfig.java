package dev.nquiles.dbehyperphysics;

import net.minecraftforge.common.ForgeConfigSpec;

public final class HyperPhysicsConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue INTENSITY;
    public static final ForgeConfigSpec.DoubleValue MOVEMENT_RESPONSE;
    public static final ForgeConfigSpec.DoubleValue DAMPING;
    public static final ForgeConfigSpec.BooleanValue ENABLED;

    static {
        BUILDER.push("general");
        ENABLED = BUILDER
                .comment("Master switch for experimental DBE physics integration.")
                .define("enabled", true);
        INTENSITY = BUILDER
                .comment("Physics range multiplier, from 1 (normal) to 5 (extreme).")
                .defineInRange("intensity", 5, 1, 5);
        MOVEMENT_RESPONSE = BUILDER
                .comment("Spring stiffness and movement response multiplier.")
                .defineInRange("movementResponse", 2.8D, 0.1D, 3.5D);
        DAMPING = BUILDER
                .comment("Velocity retention control: lower values mean longer bounce and less friction.")
                .defineInRange("damping", 0.35D, 0.1D, 1.5D);
        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    private HyperPhysicsConfig() {}
}
