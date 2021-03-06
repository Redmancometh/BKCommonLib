package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.PacketPlayOutSpawnEntityExperienceOrb</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class PacketPlayOutSpawnEntityExperienceOrbHandle extends PacketHandle {
    /** @See {@link PacketPlayOutSpawnEntityExperienceOrbClass} */
    public static final PacketPlayOutSpawnEntityExperienceOrbClass T = new PacketPlayOutSpawnEntityExperienceOrbClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(PacketPlayOutSpawnEntityExperienceOrbHandle.class, "net.minecraft.server.PacketPlayOutSpawnEntityExperienceOrb");

    /* ============================================================================== */

    public static PacketPlayOutSpawnEntityExperienceOrbHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        PacketPlayOutSpawnEntityExperienceOrbHandle handle = new PacketPlayOutSpawnEntityExperienceOrbHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */


    public double getPosX() {
        return getProtocolPosition(T.posX_1_8_8, T.posX_1_10_2);
    }

    public double getPosY() {
        return getProtocolPosition(T.posY_1_8_8, T.posY_1_10_2);
    }

    public double getPosZ() {
        return getProtocolPosition(T.posZ_1_8_8, T.posZ_1_10_2);
    }

    public void setPosX(double posX) {
        setProtocolPosition(T.posX_1_8_8, T.posX_1_10_2, posX);
    }

    public void setPosY(double posY) {
        setProtocolPosition(T.posY_1_8_8, T.posY_1_10_2, posY);
    }

    public void setPosZ(double posZ) {
        setProtocolPosition(T.posZ_1_8_8, T.posZ_1_10_2, posZ);
    }
    public int getEntityId() {
        return T.entityId.getInteger(instance);
    }

    public void setEntityId(int value) {
        T.entityId.setInteger(instance, value);
    }

    public int getExperience() {
        return T.experience.getInteger(instance);
    }

    public void setExperience(int value) {
        T.experience.setInteger(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.PacketPlayOutSpawnEntityExperienceOrb</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class PacketPlayOutSpawnEntityExperienceOrbClass extends Template.Class<PacketPlayOutSpawnEntityExperienceOrbHandle> {
        public final Template.Field.Integer entityId = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Integer posX_1_8_8 = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Integer posY_1_8_8 = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Integer posZ_1_8_8 = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Double posX_1_10_2 = new Template.Field.Double();
        @Template.Optional
        public final Template.Field.Double posY_1_10_2 = new Template.Field.Double();
        @Template.Optional
        public final Template.Field.Double posZ_1_10_2 = new Template.Field.Double();
        public final Template.Field.Integer experience = new Template.Field.Integer();

    }

}

