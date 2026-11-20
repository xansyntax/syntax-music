package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PoTokenRequirement {
    public static final /* synthetic */ PoTokenRequirement[] $VALUES;
    public static final PoTokenRequirement NONE;
    public static final PoTokenRequirement OPTIONAL;
    public static final PoTokenRequirement REQUIRED;

    static {
        PoTokenRequirement poTokenRequirement = new PoTokenRequirement("NONE", 0);
        NONE = poTokenRequirement;
        PoTokenRequirement poTokenRequirement2 = new PoTokenRequirement("OPTIONAL", 1);
        OPTIONAL = poTokenRequirement2;
        PoTokenRequirement poTokenRequirement3 = new PoTokenRequirement("REQUIRED", 2);
        REQUIRED = poTokenRequirement3;
        $VALUES = new PoTokenRequirement[]{poTokenRequirement, poTokenRequirement2, poTokenRequirement3};
    }

    public static PoTokenRequirement valueOf(String str) {
        return (PoTokenRequirement) Enum.valueOf(PoTokenRequirement.class, str);
    }

    public static PoTokenRequirement[] values() {
        return (PoTokenRequirement[]) $VALUES.clone();
    }
}
