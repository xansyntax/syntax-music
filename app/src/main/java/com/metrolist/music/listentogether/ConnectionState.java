package com.metrolist.music.listentogether;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionState {
    public static final /* synthetic */ ConnectionState[] $VALUES;
    public static final ConnectionState CONNECTED;
    public static final ConnectionState CONNECTING;
    public static final ConnectionState DISCONNECTED;
    public static final ConnectionState ERROR;
    public static final ConnectionState RECONNECTING;

    static {
        ConnectionState connectionState = new ConnectionState("DISCONNECTED", 0);
        DISCONNECTED = connectionState;
        ConnectionState connectionState2 = new ConnectionState("CONNECTING", 1);
        CONNECTING = connectionState2;
        ConnectionState connectionState3 = new ConnectionState("CONNECTED", 2);
        CONNECTED = connectionState3;
        ConnectionState connectionState4 = new ConnectionState("RECONNECTING", 3);
        RECONNECTING = connectionState4;
        ConnectionState connectionState5 = new ConnectionState("ERROR", 4);
        ERROR = connectionState5;
        $VALUES = new ConnectionState[]{connectionState, connectionState2, connectionState3, connectionState4, connectionState5};
    }

    public static ConnectionState valueOf(String str) {
        return (ConnectionState) Enum.valueOf(ConnectionState.class, str);
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }
}
