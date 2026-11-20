package com.metrolist.music.discord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum PresenceStatus {
    Online("online"),
    Idle("idle"),
    Dnd("dnd"),
    /* JADX INFO: Fake field, exist only in values array */
    Invisible("invisible");

    public final String wire;

    PresenceStatus(String str) {
        this.wire = str;
    }
}
