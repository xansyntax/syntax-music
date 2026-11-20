package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientSelectionMode {
    public static final /* synthetic */ ClientSelectionMode[] $VALUES;
    public static final ClientSelectionMode API_ONLY;
    public static final ClientSelectionMode AUTOMATIC;
    public static final ClientSelectionMode DISABLED;
    public static final ClientSelectionMode PROBE_ONLY;

    static {
        ClientSelectionMode clientSelectionMode = new ClientSelectionMode("AUTOMATIC", 0);
        AUTOMATIC = clientSelectionMode;
        ClientSelectionMode clientSelectionMode2 = new ClientSelectionMode("MANUAL_ONLY", 1);
        ClientSelectionMode clientSelectionMode3 = new ClientSelectionMode("PROBE_ONLY", 2);
        PROBE_ONLY = clientSelectionMode3;
        ClientSelectionMode clientSelectionMode4 = new ClientSelectionMode("API_ONLY", 3);
        API_ONLY = clientSelectionMode4;
        ClientSelectionMode clientSelectionMode5 = new ClientSelectionMode("DISABLED", 4);
        DISABLED = clientSelectionMode5;
        $VALUES = new ClientSelectionMode[]{clientSelectionMode, clientSelectionMode2, clientSelectionMode3, clientSelectionMode4, clientSelectionMode5};
    }

    public static ClientSelectionMode valueOf(String str) {
        return (ClientSelectionMode) Enum.valueOf(ClientSelectionMode.class, str);
    }

    public static ClientSelectionMode[] values() {
        return (ClientSelectionMode[]) $VALUES.clone();
    }
}
