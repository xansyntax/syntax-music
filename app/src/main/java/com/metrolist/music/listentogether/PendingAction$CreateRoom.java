package com.metrolist.music.listentogether;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingAction$CreateRoom extends CharsKt {
    public final String username;

    public PendingAction$CreateRoom(String str) {
        str.getClass();
        this.username = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PendingAction$CreateRoom) && Intrinsics.areEqual(this.username, ((PendingAction$CreateRoom) obj).username);
    }

    public final int hashCode() {
        return this.username.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("CreateRoom(username=", this.username, ")");
    }
}
