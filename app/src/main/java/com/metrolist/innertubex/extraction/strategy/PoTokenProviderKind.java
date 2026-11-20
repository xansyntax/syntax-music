package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PoTokenProviderKind {
    public static final /* synthetic */ PoTokenProviderKind[] $VALUES;
    public static final PoTokenProviderKind ANDROID_DROIDGUARD;
    public static final PoTokenProviderKind EXTERNAL;
    public static final PoTokenProviderKind IOS_ATTESTATION;
    public static final PoTokenProviderKind WEBPAGE_ATTESTATION;
    public static final PoTokenProviderKind WEB_BOTGUARD;

    static {
        PoTokenProviderKind poTokenProviderKind = new PoTokenProviderKind("WEB_BOTGUARD", 0);
        WEB_BOTGUARD = poTokenProviderKind;
        PoTokenProviderKind poTokenProviderKind2 = new PoTokenProviderKind("WEBPAGE_ATTESTATION", 1);
        WEBPAGE_ATTESTATION = poTokenProviderKind2;
        PoTokenProviderKind poTokenProviderKind3 = new PoTokenProviderKind("ANDROID_DROIDGUARD", 2);
        ANDROID_DROIDGUARD = poTokenProviderKind3;
        PoTokenProviderKind poTokenProviderKind4 = new PoTokenProviderKind("IOS_ATTESTATION", 3);
        IOS_ATTESTATION = poTokenProviderKind4;
        PoTokenProviderKind poTokenProviderKind5 = new PoTokenProviderKind("EXTERNAL", 4);
        EXTERNAL = poTokenProviderKind5;
        $VALUES = new PoTokenProviderKind[]{poTokenProviderKind, poTokenProviderKind2, poTokenProviderKind3, poTokenProviderKind4, poTokenProviderKind5};
    }

    public static PoTokenProviderKind valueOf(String str) {
        return (PoTokenProviderKind) Enum.valueOf(PoTokenProviderKind.class, str);
    }

    public static PoTokenProviderKind[] values() {
        return (PoTokenProviderKind[]) $VALUES.clone();
    }
}
