package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import java.util.Collection;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.PacketPlayOutScoreboardTeam</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class PacketPlayOutScoreboardTeamHandle extends PacketHandle {
    /** @See {@link PacketPlayOutScoreboardTeamClass} */
    public static final PacketPlayOutScoreboardTeamClass T = new PacketPlayOutScoreboardTeamClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(PacketPlayOutScoreboardTeamHandle.class, "net.minecraft.server.PacketPlayOutScoreboardTeam");

    /* ============================================================================== */

    public static PacketPlayOutScoreboardTeamHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        PacketPlayOutScoreboardTeamHandle handle = new PacketPlayOutScoreboardTeamHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public String getName() {
        return T.name.get(instance);
    }

    public void setName(String value) {
        T.name.set(instance, value);
    }

    public String getDisplayName() {
        return T.displayName.get(instance);
    }

    public void setDisplayName(String value) {
        T.displayName.set(instance, value);
    }

    public String getPrefix() {
        return T.prefix.get(instance);
    }

    public void setPrefix(String value) {
        T.prefix.set(instance, value);
    }

    public String getSuffix() {
        return T.suffix.get(instance);
    }

    public void setSuffix(String value) {
        T.suffix.set(instance, value);
    }

    public String getVisibility() {
        return T.visibility.get(instance);
    }

    public void setVisibility(String value) {
        T.visibility.set(instance, value);
    }

    public int getChatFormat() {
        return T.chatFormat.getInteger(instance);
    }

    public void setChatFormat(int value) {
        T.chatFormat.setInteger(instance, value);
    }

    public Collection<String> getPlayers() {
        return T.players.get(instance);
    }

    public void setPlayers(Collection<String> value) {
        T.players.set(instance, value);
    }

    public int getMode() {
        return T.mode.getInteger(instance);
    }

    public void setMode(int value) {
        T.mode.setInteger(instance, value);
    }

    public int getFriendlyFire() {
        return T.friendlyFire.getInteger(instance);
    }

    public void setFriendlyFire(int value) {
        T.friendlyFire.setInteger(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.PacketPlayOutScoreboardTeam</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class PacketPlayOutScoreboardTeamClass extends Template.Class<PacketPlayOutScoreboardTeamHandle> {
        public final Template.Field<String> name = new Template.Field<String>();
        public final Template.Field<String> displayName = new Template.Field<String>();
        public final Template.Field<String> prefix = new Template.Field<String>();
        public final Template.Field<String> suffix = new Template.Field<String>();
        public final Template.Field<String> visibility = new Template.Field<String>();
        @Template.Optional
        public final Template.Field<String> collisionRule = new Template.Field<String>();
        public final Template.Field.Integer chatFormat = new Template.Field.Integer();
        public final Template.Field<Collection<String>> players = new Template.Field<Collection<String>>();
        public final Template.Field.Integer mode = new Template.Field.Integer();
        public final Template.Field.Integer friendlyFire = new Template.Field.Integer();

    }

}

