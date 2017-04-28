package com.bergerkiller.reflection.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.ClassTemplate;
import com.bergerkiller.mountiplex.reflection.FieldAccessor;

public class NMSWeightedRandomChoice {
	public static ClassTemplate<?> T = ClassTemplate.createNMS("WeightedRandom.WeightedRandomChoice");
	public static final FieldAccessor<Integer> chance = T.selectField("protected int a");
}
