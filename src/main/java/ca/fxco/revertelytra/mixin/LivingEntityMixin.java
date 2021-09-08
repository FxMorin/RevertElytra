package ca.fxco.revertelytra.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    LivingEntity self = (LivingEntity)(Object)this;

    @Inject(
            method= "tickFallFlying()V",
            locals= LocalCapture.CAPTURE_FAILHARD,
            at=@At(
                    shift= At.Shift.BEFORE,
                    value="INVOKE",
                    target="Lnet/minecraft/entity/LivingEntity;emitGameEvent(Lnet/minecraft/world/event/GameEvent;)V"
    ))
    private void reAddDurability(CallbackInfo ci, boolean bl, ItemStack itemStack, int i) {
        if ((i/10) % 2 == 0) {
            itemStack.damage(1, self, lvt0 -> lvt0.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
        }
    }

}
