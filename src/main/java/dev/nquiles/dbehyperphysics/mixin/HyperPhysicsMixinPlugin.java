package dev.nquiles.dbehyperphysics.mixin;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Emits a clear startup marker so mobile game logs can confirm whether
 * Forge/ModLauncher discovered this add-on's mixin configuration.
 */
public final class HyperPhysicsMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
        System.out.println("[DBE Hyper Physics] MIXIN CONFIG LOADED: " + mixinPackage);
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        System.out.println("[DBE Hyper Physics] MIXIN CHECK: " + targetClassName + " <- " + mixinClassName);
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        System.out.println("[DBE Hyper Physics] MIXIN APPLYING: " + targetClassName);
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        System.out.println("[DBE Hyper Physics] MIXIN APPLIED: " + targetClassName);
    }
}
