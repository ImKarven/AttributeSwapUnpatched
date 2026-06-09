package me.karven;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeSwapUnpatched implements ModInitializer {
	public static final String MOD_ID = "attribute-swap-unpatched";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PayloadTypeRegistry.clientboundPlay().register(EnablePacketPayload.TYPE, EnablePacketPayload.CODEC);

		// Request client with this mod to enable attribute swapping on join
		ServerPlayConnectionEvents.JOIN.register((handler, _, _) -> {
			final ServerPlayer player = handler.player;
			if (!ServerPlayNetworking.canSend(player, EnablePacketPayload.TYPE)) return;
            LOGGER.info("Requested {} to enable attribute swap", player.getPlainTextName());
			ServerPlayNetworking.send(player, EnablePacketPayload.INSTANCE);
		});
	}
}