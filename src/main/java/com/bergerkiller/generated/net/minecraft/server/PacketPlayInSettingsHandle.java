package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.wrappers.HumanHand;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.PacketPlayInSettings</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class PacketPlayInSettingsHandle extends PacketHandle {
    /** @See {@link PacketPlayInSettingsClass} */
    public static final PacketPlayInSettingsClass T = new PacketPlayInSettingsClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(PacketPlayInSettingsHandle.class, "net.minecraft.server.PacketPlayInSettings");

    /* ============================================================================== */

    public static PacketPlayInSettingsHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        PacketPlayInSettingsHandle handle = new PacketPlayInSettingsHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */


    public HumanHand getMainHand() {
        if (T.mainHand.isAvailable()) {
            return T.mainHand.get(instance);
        } else {
            return HumanHand.RIGHT;
        }
    }

    public void setMainHand(HumanHand mainHand) {
        if (T.mainHand.isAvailable()) {
            T.mainHand.set(instance, mainHand);
        }
    }
    public String getLang() {
        return T.lang.get(instance);
    }

    public void setLang(String value) {
        T.lang.set(instance, value);
    }

    public int getView() {
        return T.view.getInteger(instance);
    }

    public void setView(int value) {
        T.view.setInteger(instance, value);
    }

    public Object getChatVisibility() {
        return T.chatVisibility.get(instance);
    }

    public void setChatVisibility(Object value) {
        T.chatVisibility.set(instance, value);
    }

    public boolean isEnableColors() {
        return T.enableColors.getBoolean(instance);
    }

    public void setEnableColors(boolean value) {
        T.enableColors.setBoolean(instance, value);
    }

    public int getModelPartFlags() {
        return T.modelPartFlags.getInteger(instance);
    }

    public void setModelPartFlags(int value) {
        T.modelPartFlags.setInteger(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.PacketPlayInSettings</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class PacketPlayInSettingsClass extends Template.Class<PacketPlayInSettingsHandle> {
        public final Template.Field<String> lang = new Template.Field<String>();
        public final Template.Field.Integer view = new Template.Field.Integer();
        public final Template.Field.Converted<Object> chatVisibility = new Template.Field.Converted<Object>();
        public final Template.Field.Boolean enableColors = new Template.Field.Boolean();
        public final Template.Field.Integer modelPartFlags = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Converted<HumanHand> mainHand = new Template.Field.Converted<HumanHand>();

    }

}

