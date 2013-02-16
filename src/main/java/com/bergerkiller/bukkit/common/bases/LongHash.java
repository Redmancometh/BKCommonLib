package com.bergerkiller.bukkit.common.bases;

/**
 * This clas sis coppied from: org.bukkit.craftbukkit.util.LongHash
 * 
 * All credits go to CraftBukkit
 */
public class LongHash {
    public static long toLong(int msw, int lsw) {
        return ((long) msw << 32) + lsw - Integer.MIN_VALUE;
    }

    public static int msw(long l) {
        return (int) (l >> 32);
    }

    public static int lsw(long l) {
        return (int) (l & 0xFFFFFFFF) + Integer.MIN_VALUE;
    }
}