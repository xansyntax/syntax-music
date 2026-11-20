package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AuthData {
    public final String authUser;
    public final String cookie;
    public final String dataSyncId;
    public final String visitorData;

    public AuthData(String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        this.cookie = str;
        this.visitorData = str2;
        this.dataSyncId = str3;
        this.authUser = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthData)) {
            return false;
        }
        AuthData authData = (AuthData) obj;
        return Intrinsics.areEqual(this.cookie, authData.cookie) && Intrinsics.areEqual(this.visitorData, authData.visitorData) && this.dataSyncId.equals(authData.dataSyncId) && this.authUser.equals(authData.authUser);
    }

    public final int hashCode() {
        return this.authUser.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.cookie.hashCode() * 31, 31, this.visitorData), 31, this.dataSyncId);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("AuthData(cookie=", this.cookie, ", visitorData=", this.visitorData, ", dataSyncId="), this.dataSyncId, ", authUser=", this.authUser, ")");
    }
}
