package ca.fxco.revertelytra.mixin;

import net.minecraft.entity.projectile.FireworkRocketEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FireworkRocketEntity.class)
public class FireworkRocketEntityMixin {
    @ModifyConstant(method= "tick()V",constant = @Constant(doubleValue = 1.25D))
    public double modifySpeed(double val) {return 1.50D;}
}
