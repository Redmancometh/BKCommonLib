package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.wrappers.EntityTracker;
import java.util.Map;
import java.util.UUID;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.WorldServer</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class WorldServerHandle extends WorldHandle {
    /** @See {@link WorldServerClass} */
    public static final WorldServerClass T = new WorldServerClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(WorldServerHandle.class, "net.minecraft.server.WorldServer");

    /* ============================================================================== */

    public static WorldServerHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        WorldServerHandle handle = new WorldServerHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public PlayerChunkMapHandle getPlayerChunkMap() {
        return T.getPlayerChunkMap.invoke(instance);
    }

    public void saveLevel() {
        T.saveLevel.invoke(instance);
    }


    public static WorldServerHandle fromBukkit(org.bukkit.World world) {
        return createHandle(com.bergerkiller.bukkit.common.conversion.Conversion.toWorldHandle.convert(world));
    }

    public ChunkProviderServerHandle getChunkProviderServer() {
        if (T.getChunkProviderServer.isAvailable()) {
            return T.getChunkProviderServer.invoke(instance);
        } else if (WorldHandle.T.getChunkProvider.isAvailable()) {
            return ChunkProviderServerHandle.createHandle(WorldHandle.T.getChunkProvider.invoke(instance));
        } else if (T.field_chunkProviderServer.isAvailable()) {
            return T.field_chunkProviderServer.get(instance);   
        } else {
            throw new UnsupportedOperationException("Chunk Provider Server can not be accessed for worlds on this server");
        }
    }

    public void setChunkProviderServer(ChunkProviderServerHandle chunkProviderServerHandle) {
        if (T.field_chunkProviderServer.isAvailable()) {
            T.field_chunkProviderServer.set(instance, chunkProviderServerHandle);
        }
        if (WorldHandle.T.field_chunkProvider.isAvailable()) {
            WorldHandle.T.field_chunkProvider.set(instance, chunkProviderServerHandle.getRaw());
        }
    }
    public MinecraftServerHandle getMinecraftServer() {
        return T.minecraftServer.get(instance);
    }

    public void setMinecraftServer(MinecraftServerHandle value) {
        T.minecraftServer.set(instance, value);
    }

    public EntityTracker getEntityTracker() {
        return T.entityTracker.get(instance);
    }

    public void setEntityTracker(EntityTracker value) {
        T.entityTracker.set(instance, value);
    }

    public PlayerChunkMapHandle getPlayerChunkMapField() {
        return T.playerChunkMapField.get(instance);
    }

    public void setPlayerChunkMapField(PlayerChunkMapHandle value) {
        T.playerChunkMapField.set(instance, value);
    }

    public Map<UUID, EntityHandle> getEntitiesByUUID() {
        return T.entitiesByUUID.get(instance);
    }

    public void setEntitiesByUUID(Map<UUID, EntityHandle> value) {
        T.entitiesByUUID.set(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.WorldServer</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class WorldServerClass extends Template.Class<WorldServerHandle> {
        public final Template.Field.Converted<MinecraftServerHandle> minecraftServer = new Template.Field.Converted<MinecraftServerHandle>();
        public final Template.Field.Converted<EntityTracker> entityTracker = new Template.Field.Converted<EntityTracker>();
        public final Template.Field.Converted<PlayerChunkMapHandle> playerChunkMapField = new Template.Field.Converted<PlayerChunkMapHandle>();
        public final Template.Field.Converted<Map<UUID, EntityHandle>> entitiesByUUID = new Template.Field.Converted<Map<UUID, EntityHandle>>();
        @Template.Optional
        public final Template.Field.Converted<ChunkProviderServerHandle> field_chunkProviderServer = new Template.Field.Converted<ChunkProviderServerHandle>();

        public final Template.Method.Converted<PlayerChunkMapHandle> getPlayerChunkMap = new Template.Method.Converted<PlayerChunkMapHandle>();
        @Template.Optional
        public final Template.Method.Converted<ChunkProviderServerHandle> getChunkProviderServer = new Template.Method.Converted<ChunkProviderServerHandle>();
        public final Template.Method<Void> saveLevel = new Template.Method<Void>();

    }

}

