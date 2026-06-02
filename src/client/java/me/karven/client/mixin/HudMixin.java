package me.karven.client.mixin;

import net.minecraft.client.gui.Hud;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Hud.class)
public class HudMixin {
    @Redirect(
            method = "extractItemHotbar",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getSelectedSlotDeferred()I")
    )
    private int onSetSlotDeferred(Inventory inventory) {
        return inventory.getSelectedSlot();
    }
}
