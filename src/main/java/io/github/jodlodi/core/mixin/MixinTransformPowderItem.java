package io.github.jodlodi.core.mixin;

import io.github.jodlodi.core.setup.ConfigSetup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import twilightforest.item.TransformPowderItem;

import java.util.Map;

@Mixin(TransformPowderItem.class)
public abstract class MixinTransformPowderItem extends Item {
    //I know this can be OP, but it's meant for modpack creators to be able to set up exactly what turns into what
    public MixinTransformPowderItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Redirect(method = "interactLivingEntity", at = @At(value = "FIELD" , target = "Ltwilightforest/item/TransformPowderItem;transformMap:Ljava/util/Map;"))
    private Map<EntityType<?>, EntityType<?>> injected(TransformPowderItem transformPowderItem) {
        return ConfigSetup.customTransformMap;
    }
}
