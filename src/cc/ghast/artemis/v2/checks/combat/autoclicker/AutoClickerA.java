/*
 * Decompiled with CFR 0.148.
 */
package cc.ghast.artemis.v2.checks.combat.autoclicker;

import cc.ghast.artemis.v2.api.check.AbstractCheck;
import cc.ghast.artemis.v2.api.check.annotations.Check;
import cc.ghast.artemis.v2.api.data.PlayerData;
import cc.ghast.artemis.v2.api.packet.tinyprotocol.api.NMSObject;
import cc.ghast.artemis.v2.api.packet.tinyprotocol.packet.in.WrappedInArmAnimationPacket;
import cc.ghast.artemis.v2.api.packet.tinyprotocol.packet.in.WrappedInFlyingPacket;

@Check
public class AutoClickerA
extends AbstractCheck {
    private int swings;
    private int movements;

    @Override
    public void handle(PlayerData data, NMSObject packet) {
        if (packet instanceof WrappedInArmAnimationPacket) {
            ++this.swings;
        } else if (packet instanceof WrappedInFlyingPacket && ++this.movements == 20 && this.swings > 20) {
            this.log(data, "swing=" + this.swings);
            data.combat.setLastCps(this.swings);
            this.swings = 0;
            this.movements = 0;
        }
    }
}

