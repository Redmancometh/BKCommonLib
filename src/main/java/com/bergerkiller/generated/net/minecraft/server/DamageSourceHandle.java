package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.DamageSource</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class DamageSourceHandle extends Template.Handle {
    /** @See {@link DamageSourceClass} */
    public static final DamageSourceClass T = new DamageSourceClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(DamageSourceHandle.class, "net.minecraft.server.DamageSource");

    /* ============================================================================== */

    public static DamageSourceHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        DamageSourceHandle handle = new DamageSourceHandle();
        handle.instance = handleInstance;
        return handle;
    }

    /* ============================================================================== */

    public static DamageSourceHandle mobAttack(LivingEntity livingEntity) {
        return T.mobAttack.invoke(livingEntity);
    }

    public static DamageSourceHandle playerAttack(HumanEntity humanEntity) {
        return T.playerAttack.invoke(humanEntity);
    }

    public static DamageSourceHandle arrowHit(Arrow arrow, Entity damager) {
        return T.arrowHit.invoke(arrow, damager);
    }

    public static DamageSourceHandle fireballHit(Fireball fireball, Entity damager) {
        return T.fireballHit.invoke(fireball, damager);
    }

    public static DamageSourceHandle thrownHit(Entity projectile, Entity damager) {
        return T.thrownHit.invoke(projectile, damager);
    }

    public static DamageSourceHandle magicHit(Entity magicEntity, Entity damager) {
        return T.magicHit.invoke(magicEntity, damager);
    }

    public static DamageSourceHandle thorns(Entity entity) {
        return T.thorns.invoke(entity);
    }

    public static DamageSourceHandle explosion(ExplosionHandle explosion) {
        return T.explosion.invoke(explosion);
    }

    public boolean isExplosion() {
        return T.isExplosion.invoke(instance);
    }

    public boolean isFireDamage() {
        return T.isFireDamage.invoke(instance);
    }

    public Entity getEntity() {
        return T.getEntity.invoke(instance);
    }


    public static DamageSourceHandle entityExplosion(org.bukkit.entity.Entity explodableEntity) {
        ExplosionHandle explosionHandle = null;
        if (explodableEntity != null) {
            org.bukkit.Location loc = explodableEntity.getLocation();
            explosionHandle = ExplosionHandle.createNew(explodableEntity.getWorld(), explodableEntity, loc.getX(), loc.getY(), loc.getZ(), 0.0f, false, true);
        }
        return explosion(explosionHandle);
    }


    private static final java.util.HashMap<String, DamageSourceHandle> _values = new java.util.HashMap<String, DamageSourceHandle>();
    public static DamageSourceHandle byName(String name) {
        if (_values.size() == 0) {
            for (Object rawValue : com.bergerkiller.bukkit.common.utils.CommonUtil.getClassConstants(T.getType())) {
                DamageSourceHandle handle = createHandle(rawValue);
                _values.put(handle.getTranslationIndex(), handle);
            }
        }
        DamageSourceHandle result = _values.get(name);
        if (result == null) {
            result = _values.get("generic");
        }
        return result;
    }
    public String getTranslationIndex() {
        return T.translationIndex.get(instance);
    }

    public void setTranslationIndex(String value) {
        T.translationIndex.set(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.DamageSource</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class DamageSourceClass extends Template.Class<DamageSourceHandle> {
        public final Template.Field<String> translationIndex = new Template.Field<String>();

        public final Template.StaticMethod.Converted<DamageSourceHandle> mobAttack = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> playerAttack = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> arrowHit = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> fireballHit = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> thrownHit = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> magicHit = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> thorns = new Template.StaticMethod.Converted<DamageSourceHandle>();
        public final Template.StaticMethod.Converted<DamageSourceHandle> explosion = new Template.StaticMethod.Converted<DamageSourceHandle>();

        public final Template.Method<Boolean> isExplosion = new Template.Method<Boolean>();
        public final Template.Method<Boolean> isFireDamage = new Template.Method<Boolean>();
        public final Template.Method.Converted<Entity> getEntity = new Template.Method.Converted<Entity>();

    }

}

