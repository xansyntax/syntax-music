package com.metrolist.innertubex;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeLogLevel {
    public static final /* synthetic */ InnerTubeLogLevel[] $VALUES;
    public static final InnerTubeLogLevel DEBUG;
    public static final InnerTubeLogLevel INFO;
    public static final InnerTubeLogLevel WARN;

    static {
        InnerTubeLogLevel innerTubeLogLevel = new InnerTubeLogLevel("DEBUG", 0);
        DEBUG = innerTubeLogLevel;
        InnerTubeLogLevel innerTubeLogLevel2 = new InnerTubeLogLevel("INFO", 1);
        INFO = innerTubeLogLevel2;
        InnerTubeLogLevel innerTubeLogLevel3 = new InnerTubeLogLevel("WARN", 2);
        WARN = innerTubeLogLevel3;
        $VALUES = new InnerTubeLogLevel[]{innerTubeLogLevel, innerTubeLogLevel2, innerTubeLogLevel3, new InnerTubeLogLevel("ERROR", 3)};
    }

    public static InnerTubeLogLevel valueOf(String str) {
        return (InnerTubeLogLevel) Enum.valueOf(InnerTubeLogLevel.class, str);
    }

    public static InnerTubeLogLevel[] values() {
        return (InnerTubeLogLevel[]) $VALUES.clone();
    }
}
