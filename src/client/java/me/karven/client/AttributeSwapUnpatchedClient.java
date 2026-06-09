package me.karven.client;

import me.karven.EnablePacketPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class AttributeSwapUnpatchedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		// Enable attribute swapping when server requests
		ClientPlayNetworking.registerGlobalReceiver(EnablePacketPayload.TYPE, (_, _) -> Values.USE_ATTRIBUTE_SWAP.set(true));

		// Reset USE_ATTRIBUTE_SWAP value on join
		ClientPlayConnectionEvents.JOIN.register((_, _, _) -> Values.USE_ATTRIBUTE_SWAP.set(false));
	}
}