package me.karven.client.mixin;

import net.minecraft.client.MouseHandler;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Redirect(
            method = "onScroll",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlotDeferred(I)V")
    )
    private void onSetSlotDeferred(final Inventory inventory, final int selected) {
        inventory.setSelectedSlot(selected);
    }
}
