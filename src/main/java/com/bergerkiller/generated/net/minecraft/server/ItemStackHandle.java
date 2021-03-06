package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.nbt.CommonTagCompound;
import org.bukkit.Material;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.ItemStack</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public class ItemStackHandle extends Template.Handle {
    /** @See {@link ItemStackClass} */
    public static final ItemStackClass T = new ItemStackClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(ItemStackHandle.class, "net.minecraft.server.ItemStack");

    /* ============================================================================== */

    public static ItemStackHandle createHandle(Object handleInstance) {
        if (handleInstance == null) return null;
        ItemStackHandle handle = new ItemStackHandle();
        handle.instance = handleInstance;
        return handle;
    }

    public static final ItemStackHandle createNew(Material type, int amount, int durability) {
        return T.constr_type_amount_durability.newInstance(type, amount, durability);
    }

    /* ============================================================================== */

    public Object getItem() {
        return T.getItem.invoke(instance);
    }

    public String getName() {
        return T.getName.invoke(instance);
    }

    public ItemStackHandle setName(String s) {
        return T.setName.invoke(instance, s);
    }

    public int getRepairCost() {
        return T.getRepairCost.invoke(instance);
    }

    public void setRepairCost(int cost) {
        T.setRepairCost.invoke(instance, cost);
    }

    public boolean hasName() {
        return T.hasName.invoke(instance);
    }

    public boolean hasTag() {
        return T.hasTag.invoke(instance);
    }

    public CommonTagCompound getTag() {
        return T.getTag.invoke(instance);
    }

    public CommonTagCompound saveToNBT(CommonTagCompound compound) {
        return T.saveToNBT.invoke(instance, compound);
    }

    public ItemStackHandle cloneAndSubtract(int n) {
        return T.cloneAndSubtract.invoke(instance, n);
    }


    public static final ItemStackHandle EMPTY_ITEM;
    static {
        if (T.OPT_EMPTY_ITEM.isAvailable()) {
            EMPTY_ITEM = T.OPT_EMPTY_ITEM.get();
        } else {
            EMPTY_ITEM = new ItemStackHandle();
            EMPTY_ITEM.instance = null;
        }
    }


    public static ItemStackHandle fromBukkit(org.bukkit.inventory.ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        } else {
            return createHandle(com.bergerkiller.bukkit.common.conversion.type.HandleConversion.toItemStackHandle(itemStack));
        }
    }
    public int getAmountField() {
        return T.amountField.getInteger(instance);
    }

    public void setAmountField(int value) {
        T.amountField.setInteger(instance, value);
    }

    public Material getTypeField() {
        return T.typeField.get(instance);
    }

    public void setTypeField(Material value) {
        T.typeField.set(instance, value);
    }

    public CommonTagCompound getTagField() {
        return T.tagField.get(instance);
    }

    public void setTagField(CommonTagCompound value) {
        T.tagField.set(instance, value);
    }

    public int getDurabilityField() {
        return T.durabilityField.getInteger(instance);
    }

    public void setDurabilityField(int value) {
        T.durabilityField.setInteger(instance, value);
    }

    /**
     * Stores class members for <b>net.minecraft.server.ItemStack</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class ItemStackClass extends Template.Class<ItemStackHandle> {
        public final Template.Constructor.Converted<ItemStackHandle> constr_type_amount_durability = new Template.Constructor.Converted<ItemStackHandle>();
        @Template.Optional
        public final Template.Constructor.Converted<ItemStackHandle> constr_type_amount_durability_convert = new Template.Constructor.Converted<ItemStackHandle>();

        @Template.Optional
        public final Template.StaticField.Converted<ItemStackHandle> OPT_EMPTY_ITEM = new Template.StaticField.Converted<ItemStackHandle>();

        public final Template.Field.Integer amountField = new Template.Field.Integer();
        public final Template.Field.Converted<Material> typeField = new Template.Field.Converted<Material>();
        public final Template.Field.Converted<CommonTagCompound> tagField = new Template.Field.Converted<CommonTagCompound>();
        public final Template.Field.Integer durabilityField = new Template.Field.Integer();

        public final Template.Method.Converted<Object> getItem = new Template.Method.Converted<Object>();
        public final Template.Method<String> getName = new Template.Method<String>();
        public final Template.Method.Converted<ItemStackHandle> setName = new Template.Method.Converted<ItemStackHandle>();
        public final Template.Method<Integer> getRepairCost = new Template.Method<Integer>();
        public final Template.Method<Void> setRepairCost = new Template.Method<Void>();
        public final Template.Method<Boolean> hasName = new Template.Method<Boolean>();
        public final Template.Method<Boolean> hasTag = new Template.Method<Boolean>();
        public final Template.Method.Converted<CommonTagCompound> getTag = new Template.Method.Converted<CommonTagCompound>();
        public final Template.Method.Converted<CommonTagCompound> saveToNBT = new Template.Method.Converted<CommonTagCompound>();
        public final Template.Method.Converted<ItemStackHandle> cloneAndSubtract = new Template.Method.Converted<ItemStackHandle>();

    }

}

