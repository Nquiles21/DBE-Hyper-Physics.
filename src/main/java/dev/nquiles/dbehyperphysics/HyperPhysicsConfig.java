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
                .comment("Requested physics intensity, from 1 (subtle) to 5 (strong).")
                .defineInRange("intensity", 4, 1, 5);
        MOVEMENT_RESPONSE = BUILDER
                .comment("Movement response multiplier.")
                .defineInRange("movementResponse", 1.0D, 0.1D, 2.5D);
        DAMPING = BUILDER
                .comment("Damping multiplier. Higher values settle motion faster.")
                .defineInRange("damping", 1.0D, 0.1D, 3.0D);
        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    private HyperPhysicsConfig() {}
}
