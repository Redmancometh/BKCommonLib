package com.bergerkiller.bukkit.common.wrappers;

import com.bergerkiller.bukkit.common.bases.ExtendedEntity;
import com.bergerkiller.bukkit.common.bases.IntVector3;
import com.bergerkiller.bukkit.common.conversion.DuplexConversion;
import com.bergerkiller.bukkit.common.internal.CommonDisabledEntity;
import com.bergerkiller.bukkit.common.utils.CommonUtil;
import com.bergerkiller.generated.net.minecraft.server.BlockPositionHandle;
import com.bergerkiller.generated.net.minecraft.server.DataWatcherHandle;
import com.bergerkiller.generated.net.minecraft.server.DataWatcherObjectHandle;
import com.bergerkiller.generated.net.minecraft.server.DataWatcherRegistryHandle;
import com.bergerkiller.generated.net.minecraft.server.EntityHandle;
import com.bergerkiller.generated.net.minecraft.server.IChatBaseComponentHandle;
import com.bergerkiller.mountiplex.conversion.Conversion;
import com.bergerkiller.mountiplex.conversion.type.DuplexConverter;
import com.bergerkiller.mountiplex.conversion.util.ConvertingList;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.mountiplex.reflection.declarations.TypeDeclaration;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class is a wrapper of the DataWatcher class from CraftBukkit<br>
 * It is used to store data and to keep track of changes so they can be
 * synchronized
 */
public class DataWatcher extends BasicWrapper<DataWatcherHandle> {

    public DataWatcher(org.bukkit.entity.Entity entityOwner) {
        setHandle(DataWatcherHandle.createNew(entityOwner));
    }

    /**
     * Initializes a new Empty DataWatcher. Please avoid binding this
     * constructed DataWatcher to live entities. When doing so, instead use the
     * Entity-accepting constructor.
     */
    public DataWatcher() {
        setHandle(DataWatcherHandle.createNew(CommonDisabledEntity.INSTANCE));
    }

    public DataWatcher(Object handle) {
        setHandle(DataWatcherHandle.createHandle(handle));
    }

    /**
     * Write a new value to the watched objects.
     * If the key does not yet exist, the key is added with the default value specified.
     *
     * @param key Object key
     * @param value Value to set to
     */
    public <V> void set(Key<V> key, V value) {
        if (isWatched(key)) {
            handle.set(key, value);
        } else {
            watch(key, value);
        }
    }

    /**
     * Read an object from the watched objects
     *
     * @param ket Object key
     * @return Object value at the key
     */
    public <V> V get(Key<V> key) {
        Item<?> item = handle.read(key);
        if (item == null) {
            throw new IllegalArgumentException("This key is not watched in this DataWatcher");
        } else {
            return key.getType().getConverter().convert(item.getValue());
        }
    }

    /**
     * Watch an object
     *
     * @param key of the watched item
     * @param defaultValue of the watched item
     */
    public <T> void watch(Key<T> key, T defaultValue) {
        handle.register(key, defaultValue);
    }

    /**
     * Checks whether a particular key is registered for watching
     * 
     * @param key to check
     * @return True if watched, False if not
     */
    public boolean isWatched(Key<?> key) {
        return handle.read(key) != null;
    }

    /**
     * Get all watched objects
     *
     * @return Watched objects
     */
    public List<Item<?>> getWatchedItems() {
        return getWatchedItems(false);
    }

    /**
     * Get all watched objects
     *
     * @param unwatch to unwatch all the items before returning them
     * @return Watched objects
     */
    public List<Item<?>> getWatchedItems(boolean unwatch) {
        List<?> itemHandles;
        if (unwatch) {
            itemHandles = (List<?>) DataWatcherHandle.T.unwatchAndReturnAllWatched.raw.invoke(handle.getRaw());
        } else {
            itemHandles = (List<?>) DataWatcherHandle.T.returnAllWatched.raw.invoke(handle.getRaw());
        }
        return new ConvertingList<Item<?>>(itemHandles, DuplexConversion.dataWatcherItem);
    }

    /**
     * Gets whether this Data Watcher has changed since the last tick
     *
     * @return True if it had changed, False if not
     */
    public boolean isChanged() {
        return handle.isChanged();
    }

    /**
     * Gets whether this Data Watcher is empty or not. An empty Data Watcher
     * does not require any update messages to the players.
     *
     * @return True if empty, False if not
     */
    public boolean isEmpty() {
        return handle.isEmpty();
    }

    @Override
    public String toString() {
        String str = "DataWatcher Items[";
        boolean first = true;
        for (Item<?> item : getWatchedItems()) {
            if (first) {
                first = false;
            } else {
                str += ", ";
            }
            str += item.toString();
        }
        str += "]";
        return str;
    }

    /**
     * References a single watched item, containing the key, value, and changed state
     * 
     * @param <V> value type of the item
     */
    public static class Item<V> extends BasicWrapper<DataWatcherHandle.ItemHandle> {

        public Item(Object handle) {
            setHandle(DataWatcherHandle.ItemHandle.createHandle(handle));
        }

        /**
         * Gets the key associated with this DataWatcher Item.
         * Note that only internal types are available. It is recommended
         * to only use this key for comparison with existing Key constants.
         * 
         * @return Item Key
         */
        @SuppressWarnings("unchecked")
        public Key<V> getKey() {
            // This is for MC >= 1.10.2
            if (DataWatcherHandle.ItemHandle.T.key.isAvailable())  {
                return (Key<V>) DataWatcherHandle.ItemHandle.T.key.get(this.handle.getRaw());
            }

            // This is for MC 1.8.8, where we use a proxy object storing typeId (serializer token) and keyId
            int typeId = DataWatcherHandle.ItemHandle.T.typeId.getInteger(this.handle.getRaw());
            int keyId = DataWatcherHandle.ItemHandle.T.keyId.getInteger(this.handle.getRaw());
            Object token = Integer.valueOf(typeId);
            Object handle = new com.bergerkiller.bukkit.common.internal.proxy.DataWatcherObject<V>(keyId, token);
            return new Key<V>(handle);
        }

        public boolean isChanged() {
            return this.handle.isChanged();
        }

        @SuppressWarnings("unchecked")
        public V getValue() {
            return (V) this.handle.getValue();
        }

        public void setValue(V value, boolean changed) {
            this.handle.setValue(value);
            this.handle.setChanged(true);
        }

        @Override
        public String toString() {
            Key<V> key = getKey();
            return "{id=" + key.getId() + ",type=" + key.getType().getInternalType().getSimpleName() + 
                    ",changed=" + isChanged() + ",value=" + getValue() + "}";
        }
    }

    /**
     * References the value bound to a DataWatcher Key for a particular Entity
     *
     * @param <V> value type bound to the key
     */
    public static class EntityItem<V> {
        private final ExtendedEntity<?> owner;
        private final Key<V> key;

        public EntityItem(ExtendedEntity<?> owner, Key<V> key) {
            this.owner = owner;
            this.key = key;
        }

        /**
         * Gets the value of this DataWatcher metadata property
         * 
         * @return current value
         */
        public V get() {
            Object dataWatcher = EntityHandle.T.datawatcherField.raw.get(owner.getHandle());
            return DataWatcherHandle.createHandle(dataWatcher).get(this.key);
        }

        /**
         * Sets a new value for this DataWatcher metadata property. Watchers will be notified.
         * 
         * @param value to set to
         */
        public void set(V value) {
            Object dataWatcher = EntityHandle.T.datawatcherField.raw.get(owner.getHandle());
            DataWatcherHandle.createHandle(dataWatcher).set(this.key, value);
        }

        /**
         * Translates the internally stored value to another type using a converter pair
         * 
         * @param converterPair to use for translation
         * @return translated item
         */
        public <C> EntityItem<C> translate(DuplexConverter<V, C> converterPair) {
            return new ConvertingEntityItem<V, C>(this, converterPair);
        }
    }

    private static class ConvertingEntityItem<A, B> extends EntityItem<B> {
        private final EntityItem<A> item;
        private final DuplexConverter<A, B> pair;

        public ConvertingEntityItem(EntityItem<A> item, DuplexConverter<A, B> pair) {
            super(null, null);
            this.item = item;
            this.pair = pair;
        }

        @Override
        public B get() {
            return pair.convert(item.get());
        }

        @Override
        public void set(B value) {
            this.item.set(pair.convertReverse(value));
        }

    }

    /**
     * Wrapper around a raw DataWatcher key object
     * 
     * @param <V> value type bound to the key
     */
    public static class Key<V> extends BasicWrapper<DataWatcherObjectHandle> {
        private final Type<V> _serializer;

        @SuppressWarnings("unchecked")
        public Key(Object handle) {
            setHandle(DataWatcherObjectHandle.createHandle(handle));

            Object token = this.handle.getSerializer();
            Class<V> type = (Class<V>) DataSerializerRegistry.getInternalTypeFromToken(token);
            this._serializer = Type.getForType(type);
        }

        public Key(Object handle, Type<V> serializer) {
            setHandle(DataWatcherObjectHandle.createHandle(handle));

            this._serializer = serializer;
        }

        /**
         * Gets the Serializer used when storing/restoring values bound to this key from the DataWatcher
         * 
         * @return serializer
         */
        public Type<V> getType() {
            return this._serializer;
        }

        /**
         * Gets the value type that is internally stored under this Key
         * 
         * @return internal key type
         */
        public Class<?> getInternalType() {
            return this._serializer.getInternalType();
        }

        /**
         * Gets the unique global serializer Id of this key.
         * This id is unique for this data value type.
         * 
         * @return Serializer Id
         */
        public int getSerializerId() {
            Object rawSerializer = this.handle.getSerializer();
            return DataWatcherRegistryHandle.T.getSerializerId.invoke(rawSerializer);
        }

        /**
         * Gets the datawatcher object Id of this key
         * 
         * @return Id
         */
        public int getId() {
            return DataWatcherObjectHandle.T.getId.invoke(this.handle.getRaw());
        }

        @Override
        public int hashCode() {
            return this.getId();
        }

        @Override
        public String toString() {
            return "{id=" + getId() + ", type=" + getType().getInternalType() + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof Key)) {
                return false;
            } else {
                Key<?> other = (Key<?>) o;
                if (this.getId() != other.getId()) {
                    return false;
                }
                if (this.getInternalType() != other.getInternalType()) {
                    return false;
                }
                return true;
            }
        }

        /**
         * Stores Key Type Serialization information to enable conversion from/to the internally stored type.
         */
        public static class Type<T> {
            private static final HashMap<Class<?>, Type<?>> byTypeMapping = new HashMap<Class<?>, Type<?>>();
            private final Object _token;
            private final DuplexConverter<Object, T> _converter;

            // All below serializers are guaranteed to always be available
            public static final Type<Boolean> BOOLEAN = getForType(Boolean.class);
            public static final Type<Byte> BYTE = getForType(Byte.class);
            public static final Type<Integer> INTEGER = getForType(Integer.class);
            public static final Type<Float> FLOAT = getForType(Float.class);
            public static final Type<String> STRING = getForType(String.class);
            public static final Type<UUID> UUID = getForType(UUID.class);
            public static final Type<IntVector3> BLOCK_POSITION = getForType(IntVector3.class);
            public static final Type<ChatText> CHAT_TEXT = getForType(ChatText.class);

            @SuppressWarnings("unchecked")
            private Type(Class<?> internalType, Class<T> externalType) {
                this._token = DataSerializerRegistry.getSerializerToken(internalType);
                if (this._token == null) {
                    throw new RuntimeException("No token found for internal type " + internalType.getName());
                }

                this._converter = Conversion.findDuplex((Class<Object>) internalType, externalType);
                if (this._converter == null) {
                    throw new RuntimeException("Failed to find converter from internal type " + 
                            internalType.getName() + " to " + externalType.getName());
                }
            }

            /**
             * Creates a new Serializer Key. Only for internal use.
             * 
             * @param tokenField the field where the internal Key Handle can be read from
             * @param alternativeId to use when the field is unavailable (MC 1.8.8)
             * @return Key for accessing the item in the DataWatcher
             */
            public Key<T> createKey(Template.StaticField.Converted<? extends Key<?>> tokenField, int alternativeId) {
                Object handle;
                if (tokenField.isAvailable()) {
                    handle = tokenField.raw.get();
                } else {
                    handle = new com.bergerkiller.bukkit.common.internal.proxy.DataWatcherObject<T>(alternativeId, this._token);
                }
                return new Key<T>(handle, this);
            }

            /**
             * Gets the Serializer Token Object that is used as a key to identify this Serializer internal type.
             * On >= MC 1.10.2 this points to an internal Serializer type, on MC 1.8.8 it is the Type Id Integer.
             * 
             * @return serializer key object
             */
            public Object getToken() {
                return this._token;
            }

            /**
             * Retrieves the duplex converter used to convert from/to the internally stored type
             * 
             * @return duplex converter
             */
            public DuplexConverter<Object, T> getConverter() {
                return this._converter;
            }

            /**
             * Gets the type that is internally stored
             * 
             * @return internal type
             */
            public Class<?> getInternalType() {
                return this._converter.input.type;
            }

            /**
             * Gets the type that is externally used (as input / output of getters / setters)
             * 
             * @return external type
             */
            public Class<?> getExternalType() {
                return this._converter.output.type;
            }

            /**
             * Retrieves the Serializer that is used to internally store and restore a particular type
             * 
             * @param type that is being serialized/deserialized from/to.
             * @return serializer, or null if not found
             */
            @SuppressWarnings("unchecked")
            public static <V> Type<V> getForType(Class<V> type) {
                Type<?> result = byTypeMapping.get(type);
                if (result == null) {
                    Class<?> internalType = DataSerializerRegistry.getInternalType(type);
                    if (internalType == null) {
                        throw new IllegalArgumentException("Object of type " + type.getName() + " can not be stored in a DataWatcher");
                    }
                    result = new Type<V>(internalType, type);
                    byTypeMapping.put(type, result);
                }
                return (Type<V>) result;
            }
        }
    }

    // Stores the internal type Serializer mapping, and how exposed types (IntVector3) are internally stored (BlockPosition)
    private static class DataSerializerRegistry {
        private static final HashMap<Object, Class<?>> tokenRegistryRev = new HashMap<Object, Class<?>>();
        private static final HashMap<Class<?>, Object> tokenRegistry = new HashMap<Class<?>, Object>();
        private static final HashMap<Class<?>, Class<?>> typeMapping = new HashMap<Class<?>, Class<?>>();

        static {
            Class<?> registryClass = CommonUtil.getNMSClass("DataWatcherRegistry");
            Class<?> serializerClass = CommonUtil.getNMSClass("DataWatcherSerializer");
            Class<?> googleOptional = CommonUtil.getClass("com.google.common.base.Optional");
            if (registryClass != null && serializerClass != null) {
                // Use MC 1.10.2 serializer registry for this
                for (Field f : registryClass.getDeclaredFields()) {
                    if (f.getType().equals(serializerClass) && Modifier.isStatic(f.getModifiers())) {
                        try {
                            if (!(Modifier.isPublic(f.getModifiers()))) {
                                f.setAccessible(true);
                            }
                            TypeDeclaration typeDec = TypeDeclaration.fromType(f.getGenericType());
                            if (typeDec.genericTypes.length == 1) {
                                TypeDeclaration dataType = typeDec.genericTypes[0];

                                // Sometimes google Optional is used to wrap null values. We aren't interested in that ourselves.
                                if (dataType.type.equals(googleOptional) && dataType.genericTypes.length == 1) {
                                    dataType = dataType.genericTypes[0];
                                }

                                // Store in map for future use, mapped to the serializer instance
                                register(dataType.type, f.get(null));
                            }
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    }
                }

                // ChatText -> IChatbaseComponent
                typeMapping.put(ChatText.class, IChatBaseComponentHandle.T.getType());
            } else {
                // Use our own kind of tokens
                register(Byte.class, 0);
                register(Short.class, 1);
                register(Integer.class, 2);
                register(Float.class, 3);
                register(String.class, 4);
                register(UUID.class, 5);
                register(BlockPositionHandle.T.getType(), 6);
                register(CommonUtil.getNMSClass("Vector3f"), 7);

                // Booleans are stored as Byte
                typeMapping.put(Boolean.class, Byte.class);

                // IChatBaseComponent -> String
                typeMapping.put(IChatBaseComponentHandle.T.getType(), String.class);

                // ChatText -> String
                typeMapping.put(ChatText.class, String.class);
            }

            // Add all type mappings to self
            for (Class<?> type : tokenRegistry.keySet()) {
                typeMapping.put(type, type);
            }

            // IntVector3 -> BlockPosition
            typeMapping.put(IntVector3.class, BlockPositionHandle.T.getType());
        }

        private static void register(Class<?> type, Object token) {
            tokenRegistry.put(type, token);
            tokenRegistryRev.put(token, type);
        }

        public static Class<?> getInternalType(Class<?> exposedType) {
            return typeMapping.get(exposedType);
        }

        public static Object getSerializerToken(Class<?> type) {
            return tokenRegistry.get(type);
        }

        public static Class<?> getInternalTypeFromToken(Object token) {
            return tokenRegistryRev.get(token);
        }
    }

}
