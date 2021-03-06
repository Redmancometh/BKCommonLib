package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.RegistryBlockID</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
@Template.Optional
public class RegistryBlockIDHandle extends Template.Handle {
    /** @See {@link RegistryBlockIDClass} */
    public static final RegistryBlockIDClass T = new RegistryBlockIDClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(RegistryBlockIDHandle.class, "net.minecraft.server.RegistryBlockID");

    /* ============================================================================== */

    public static RegistryBlockIDHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        RegistryBlockIDHandle handle = new RegistryBlockIDHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public int getId(Object value) {
        return T.getId.invoke(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.RegistryBlockID</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class RegistryBlockIDClass extends Template.Class<RegistryBlockIDHandle> {
        public final Template.Method<Integer> getId = new Template.Method<Integer>();

    }

}

