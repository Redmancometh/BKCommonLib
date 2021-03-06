package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import org.bukkit.inventory.InventoryView;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.Container</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class ContainerHandle extends Template.Handle {
    /** @See {@link ContainerClass} */
    public static final ContainerClass T = new ContainerClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(ContainerHandle.class, "net.minecraft.server.Container");

    /* ============================================================================== */

    public static ContainerHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        ContainerHandle handle = new ContainerHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public InventoryView getBukkitView() {
        return T.getBukkitView.invoke(instance);
    }

    /**
     * Stores class members for <b>net.minecraft.server.Container</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class ContainerClass extends Template.Class<ContainerHandle> {
        public final Template.Method<InventoryView> getBukkitView = new Template.Method<InventoryView>();

    }

}

