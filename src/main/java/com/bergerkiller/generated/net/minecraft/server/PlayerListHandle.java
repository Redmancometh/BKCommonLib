package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.protocol.CommonPacket;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import java.util.List;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.PlayerList</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class PlayerListHandle extends Template.Handle {
    /** @See {@link PlayerListClass} */
    public static final PlayerListClass T = new PlayerListClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(PlayerListHandle.class, "net.minecraft.server.PlayerList");

    /* ============================================================================== */

    public static PlayerListHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        PlayerListHandle handle = new PlayerListHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public void savePlayers() {
        T.savePlayers.invoke(instance);
    }

    public void sendPacketNearby(HumanEntity human, double x, double y, double z, double radius, int dimension, CommonPacket packet) {
        T.sendPacketNearby.invokeVA(instance, human, x, y, z, radius, dimension, packet);
    }

    public List<Player> getPlayers() {
        return T.players.get(instance);
    }

    public void setPlayers(List<Player> value) {
        T.players.set(instance, value);
    }

    public IPlayerFileDataHandle getPlayerFileData() {
        return T.playerFileData.get(instance);
    }

    public void setPlayerFileData(IPlayerFileDataHandle value) {
        T.playerFileData.set(instance, value);
    }

    public int getMaxPlayers() {
        return T.maxPlayers.getInteger(instance);
    }

    public void setMaxPlayers(int value) {
        T.maxPlayers.setInteger(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.PlayerList</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class PlayerListClass extends Template.Class<PlayerListHandle> {
        public final Template.Field.Converted<List<Player>> players = new Template.Field.Converted<List<Player>>();
        public final Template.Field.Converted<IPlayerFileDataHandle> playerFileData = new Template.Field.Converted<IPlayerFileDataHandle>();
        public final Template.Field.Integer maxPlayers = new Template.Field.Integer();

        public final Template.Method<Void> savePlayers = new Template.Method<Void>();
        public final Template.Method.Converted<Void> sendPacketNearby = new Template.Method.Converted<Void>();

    }

}

