package dev.nquiles.dbehyperphysics;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DBEHyperPhysics.MOD_ID)
public final class DBEHyperPhysics {
    public static final String MOD_ID = "dbehyperphysics";

    public DBEHyperPhysics() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.CLIENT,
                HyperPhysicsConfig.SPEC,
                "dbe_hyper_physics-client.toml"
        );
    }
}
