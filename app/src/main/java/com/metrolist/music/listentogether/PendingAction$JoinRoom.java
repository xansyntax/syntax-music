package com.metrolist.music.listentogether;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingAction$JoinRoom extends CharsKt {
    public final String roomCode;
    public final String username;

    public PendingAction$JoinRoom(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.roomCode = str;
        this.username = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingAction$JoinRoom)) {
            return false;
        }
        PendingAction$JoinRoom pendingAction$JoinRoom = (PendingAction$JoinRoom) obj;
        return Intrinsics.areEqual(this.roomCode, pendingAction$JoinRoom.roomCode) && Intrinsics.areEqual(this.username, pendingAction$JoinRoom.username);
    }

    public final int hashCode() {
        return this.username.hashCode() + (this.roomCode.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("JoinRoom(roomCode=", this.roomCode, ", username=", this.username, ")");
    }
}
