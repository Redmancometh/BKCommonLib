package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.wrappers.DataWatcher.Key;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.EntityMinecartFurnace</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class EntityMinecartFurnaceHandle extends EntityMinecartAbstractHandle {
    /** @See {@link EntityMinecartFurnaceClass} */
    public static final EntityMinecartFurnaceClass T = new EntityMinecartFurnaceClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(EntityMinecartFurnaceHandle.class, "net.minecraft.server.EntityMinecartFurnace");

    public static final Key<Boolean> DATA_SMOKING = T.DATA_SMOKING.getSafe();
    /* ============================================================================== */

    public static EntityMinecartFurnaceHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        EntityMinecartFurnaceHandle handle = new EntityMinecartFurnaceHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public int getFuel() {
        return T.fuel.getInteger(instance);
    }

    public void setFuel(int value) {
        T.fuel.setInteger(instance, value);
    }

    public double getPushForceX() {
        return T.pushForceX.getDouble(instance);
    }

    public void setPushForceX(double value) {
        T.pushForceX.setDouble(instance, value);
    }

    public double getPushForceZ() {
        return T.pushForceZ.getDouble(instance);
    }

    public void setPushForceZ(double value) {
        T.pushForceZ.setDouble(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.EntityMinecartFurnace</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class EntityMinecartFurnaceClass extends Template.Class<EntityMinecartFurnaceHandle> {
        public final Template.StaticField.Converted<Key<Boolean>> DATA_SMOKING = new Template.StaticField.Converted<Key<Boolean>>();

        public final Template.Field.Integer fuel = new Template.Field.Integer();
        public final Template.Field.Double pushForceX = new Template.Field.Double();
        public final Template.Field.Double pushForceZ = new Template.Field.Double();

    }

}

