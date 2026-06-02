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
		PayloadTypeRegistry.clientboundPlay().register(DisablePacketPayload.TYPE, DisablePacketPayload.CODEC);

		// Request client to disable attribute swapping on join
		ServerPlayConnectionEvents.JOIN.register((handler, _, server) -> {
			// Ignore open to LAN worlds
			if (!server.isDedicatedServer()) return;

			final ServerPlayer player = handler.player;
			if (!ServerPlayNetworking.canSend(player, DisablePacketPayload.TYPE)) return;
            LOGGER.info("Requested {} to disable attribute swap", player.getPlainTextName());
			ServerPlayNetworking.send(player, DisablePacketPayload.INSTANCE);
		});
	}
}