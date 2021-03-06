package com.bergerkiller.generated.org.bukkit.craftbukkit;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;

/**
 * Instance wrapper handle for type <b>org.bukkit.craftbukkit.CraftChunk</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class CraftChunkHandle extends Template.Handle {
    /** @See {@link CraftChunkClass} */
    public static final CraftChunkClass T = new CraftChunkClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(CraftChunkHandle.class, "org.bukkit.craftbukkit.CraftChunk");

    /* ============================================================================== */

    public static CraftChunkHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        CraftChunkHandle handle = new CraftChunkHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public Object getHandle() {
        return T.getHandle.invoke(instance);
    }

    /**
     * Stores class members for <b>org.bukkit.craftbukkit.CraftChunk</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class CraftChunkClass extends Template.Class<CraftChunkHandle> {
        public final Template.Method.Converted<Object> getHandle = new Template.Method.Converted<Object>();

    }

}

