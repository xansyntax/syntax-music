package com.metrolist.music.db.entities;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayCountEntity {
    public final int count;
    public final int month;
    public final String song;
    public final int year;

    public PlayCountEntity(int i, int i2, int i3, String str) {
        str.getClass();
        this.song = str;
        this.year = i;
        this.month = i2;
        this.count = i3;
    }
}
