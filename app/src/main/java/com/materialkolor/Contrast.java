package com.materialkolor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Contrast {
    public static final /* synthetic */ Contrast[] $VALUES = {new Contrast("Default", 0), new Contrast("Medium", 1), new Contrast("High", 2), new Contrast("Reduced", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    Contrast EF5;

    public static Contrast valueOf(String str) {
        return (Contrast) Enum.valueOf(Contrast.class, str);
    }

    public static Contrast[] values() {
        return (Contrast[]) $VALUES.clone();
    }
}
