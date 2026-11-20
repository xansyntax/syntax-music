package com.metrolist.music.playback.alarm;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicAlarmEntry {
    public final boolean enabled;
    public final int hour;
    public final String id;
    public final int minute;
    public final long nextTriggerAt;
    public final String playlistId;
    public final boolean randomSong;

    public MusicAlarmEntry(String str, boolean z, int i, int i2, String str2, boolean z2, long j) {
        this.id = str;
        this.enabled = z;
        this.hour = i;
        this.minute = i2;
        this.playlistId = str2;
        this.randomSong = z2;
        this.nextTriggerAt = j;
    }

    public static MusicAlarmEntry copy$default(MusicAlarmEntry musicAlarmEntry, boolean z, int i, int i2, String str, boolean z2, long j, int i3) {
        boolean z3 = z;
        String str2 = musicAlarmEntry.id;
        if ((i3 & 2) != 0) {
            z3 = musicAlarmEntry.enabled;
        }
        if ((i3 & 4) != 0) {
            i = musicAlarmEntry.hour;
        }
        if ((i3 & 8) != 0) {
            i2 = musicAlarmEntry.minute;
        }
        if ((i3 & 16) != 0) {
            str = musicAlarmEntry.playlistId;
        }
        if ((i3 & 32) != 0) {
            z2 = musicAlarmEntry.randomSong;
        }
        if ((i3 & 64) != 0) {
            j = musicAlarmEntry.nextTriggerAt;
        }
        long j2 = j;
        str.getClass();
        boolean z4 = z2;
        String str3 = str;
        int i4 = i2;
        return new MusicAlarmEntry(str2, z3, i, i4, str3, z4, j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicAlarmEntry)) {
            return false;
        }
        MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj;
        return this.id.equals(musicAlarmEntry.id) && this.enabled == musicAlarmEntry.enabled && this.hour == musicAlarmEntry.hour && this.minute == musicAlarmEntry.minute && this.playlistId.equals(musicAlarmEntry.playlistId) && this.randomSong == musicAlarmEntry.randomSong && this.nextTriggerAt == musicAlarmEntry.nextTriggerAt;
    }

    public final int hashCode() {
        return Long.hashCode(this.nextTriggerAt) + IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.minute, IntIntPair$$ExternalSyntheticOutline0.m(this.hour, IntIntPair$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, this.enabled, 31), 31), 31), 31, this.playlistId), this.randomSong, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MusicAlarmEntry(id=");
        sb.append(this.id);
        sb.append(", enabled=");
        sb.append(this.enabled);
        sb.append(", hour=");
        sb.append(this.hour);
        sb.append(", minute=");
        sb.append(this.minute);
        sb.append(", playlistId=");
        sb.append(this.playlistId);
        sb.append(", randomSong=");
        sb.append(this.randomSong);
        sb.append(", nextTriggerAt=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.nextTriggerAt, ")");
    }
}
