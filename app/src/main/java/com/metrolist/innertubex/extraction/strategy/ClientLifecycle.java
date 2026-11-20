package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientLifecycle {
    public static final /* synthetic */ ClientLifecycle[] $VALUES;
    public static final ClientLifecycle BROKEN;
    public static final ClientLifecycle DEPRECATED;
    public static final ClientLifecycle EXPERIMENTAL;
    public static final ClientLifecycle STABLE;
    public static final ClientLifecycle UNRELEASED;

    static {
        ClientLifecycle clientLifecycle = new ClientLifecycle("STABLE", 0);
        STABLE = clientLifecycle;
        ClientLifecycle clientLifecycle2 = new ClientLifecycle("CANARY", 1);
        ClientLifecycle clientLifecycle3 = new ClientLifecycle("EXPERIMENTAL", 2);
        EXPERIMENTAL = clientLifecycle3;
        ClientLifecycle clientLifecycle4 = new ClientLifecycle("UNRELEASED", 3);
        UNRELEASED = clientLifecycle4;
        ClientLifecycle clientLifecycle5 = new ClientLifecycle("DEPRECATED", 4);
        DEPRECATED = clientLifecycle5;
        ClientLifecycle clientLifecycle6 = new ClientLifecycle("BROKEN", 5);
        BROKEN = clientLifecycle6;
        $VALUES = new ClientLifecycle[]{clientLifecycle, clientLifecycle2, clientLifecycle3, clientLifecycle4, clientLifecycle5, clientLifecycle6};
    }

    public static ClientLifecycle valueOf(String str) {
        return (ClientLifecycle) Enum.valueOf(ClientLifecycle.class, str);
    }

    public static ClientLifecycle[] values() {
        return (ClientLifecycle[]) $VALUES.clone();
    }
}
