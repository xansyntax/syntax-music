package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CapabilitySupport {
    public static final /* synthetic */ CapabilitySupport[] $VALUES;
    public static final CapabilitySupport LIMITED;
    public static final CapabilitySupport SUPPORTED;
    public static final CapabilitySupport UNKNOWN;
    public static final CapabilitySupport UNSUPPORTED;

    static {
        CapabilitySupport capabilitySupport = new CapabilitySupport("SUPPORTED", 0);
        SUPPORTED = capabilitySupport;
        CapabilitySupport capabilitySupport2 = new CapabilitySupport("LIMITED", 1);
        LIMITED = capabilitySupport2;
        CapabilitySupport capabilitySupport3 = new CapabilitySupport("UNKNOWN", 2);
        UNKNOWN = capabilitySupport3;
        CapabilitySupport capabilitySupport4 = new CapabilitySupport("UNSUPPORTED", 3);
        UNSUPPORTED = capabilitySupport4;
        $VALUES = new CapabilitySupport[]{capabilitySupport, capabilitySupport2, capabilitySupport3, capabilitySupport4};
    }

    public static CapabilitySupport valueOf(String str) {
        return (CapabilitySupport) Enum.valueOf(CapabilitySupport.class, str);
    }

    public static CapabilitySupport[] values() {
        return (CapabilitySupport[]) $VALUES.clone();
    }
}
