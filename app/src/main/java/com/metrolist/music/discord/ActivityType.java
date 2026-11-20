package com.metrolist.music.discord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum ActivityType {
    Playing(0),
    Streaming(1),
    Listening(2),
    Watching(3),
    Custom(4),
    Competing(5);

    public final byte code;

    /* JADX WARN: Multi-variable type inference failed */
    ActivityType(int i) {
        this.code = i;
    }
}
