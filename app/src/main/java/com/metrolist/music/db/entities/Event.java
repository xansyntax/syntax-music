package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.time.LocalDateTime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Event {
    public final long id;
    public final long playTime;
    public final String songId;
    public final LocalDateTime timestamp;

    public Event(long j, String str, LocalDateTime localDateTime, long j2) {
        str.getClass();
        this.id = j;
        this.songId = str;
        this.timestamp = localDateTime;
        this.playTime = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return this.id == event.id && Intrinsics.areEqual(this.songId, event.songId) && this.timestamp.equals(event.timestamp) && this.playTime == event.playTime;
    }

    public final int hashCode() {
        return Long.hashCode(this.playTime) + ((this.timestamp.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.id) * 31, 31, this.songId)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Event(id=");
        sb.append(this.id);
        sb.append(", songId=");
        sb.append(this.songId);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", playTime=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.playTime, ")");
    }
}
