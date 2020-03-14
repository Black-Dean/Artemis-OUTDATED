/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package cc.ghast.artemis.v2.api.packet.tinyprotocol.packet.in;

import cc.ghast.artemis.v2.api.packet.tinyprotocol.api.NMSObject;
import cc.ghast.artemis.v2.api.packet.tinyprotocol.api.ProtocolVersion;
import cc.ghast.artemis.v2.api.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import org.bukkit.entity.Player;

public class WrappedInChatPacket
extends NMSObject {
    private static String packet = "PacketPlayInChat";
    private static FieldAccessor<String> messageAccessor = WrappedInChatPacket.fetchField(packet, String.class, 0);
    private String message;

    public WrappedInChatPacket(Object object, Player player) {
        super(object, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        this.message = this.fetch(messageAccessor);
    }

    public String getMessage() {
        return this.message;
    }
}

