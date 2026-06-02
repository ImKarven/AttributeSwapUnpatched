package me.karven;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

// The server sends this packet to the client to force disable attribute swap on the client side.
public record DisablePacketPayload() implements CustomPacketPayload {
    public static final DisablePacketPayload INSTANCE = new DisablePacketPayload();

    public static final Identifier KEY = Identifier.fromNamespaceAndPath("attribute_swap_unpatched", "disable");
    public static final DisablePacketPayload.Type<DisablePacketPayload> TYPE = new CustomPacketPayload.Type<>(KEY);

    public static final StreamCodec<ByteBuf, DisablePacketPayload> CODEC = StreamCodec.unit(INSTANCE);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
