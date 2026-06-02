package me.karven.client;

import net.minecraft.world.entity.player.Inventory;

import java.util.concurrent.atomic.AtomicBoolean;

public class Values {
    public static final AtomicBoolean USE_ATTRIBUTE_SWAP = new AtomicBoolean(true);

    public static final String SET_SELECTED_SLOT_METHOD_BYTECODE = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlotDeferred(I)V";

    public static void onSetSlotDeferred(final Inventory inventory, final int slot) {
        // deferred slot only applies to the actual slot on the next tick
        // we apply the actual slot immediately to replicate older versions behavior
        if (Values.USE_ATTRIBUTE_SWAP.get()) {
            inventory.setSelectedSlot(slot);
        } else {
            inventory.setSelectedSlotDeferred(slot);
        }
    }
}
