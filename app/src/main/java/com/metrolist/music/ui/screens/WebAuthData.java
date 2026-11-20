package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WebAuthData {
    public final String authUser;
    public final String dataSyncId;
    public final String visitorData;

    public WebAuthData(String str, String str2, String str3) {
        this.visitorData = str;
        this.dataSyncId = str2;
        this.authUser = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebAuthData)) {
            return false;
        }
        WebAuthData webAuthData = (WebAuthData) obj;
        return Intrinsics.areEqual(this.visitorData, webAuthData.visitorData) && Intrinsics.areEqual(this.dataSyncId, webAuthData.dataSyncId) && this.authUser.equals(webAuthData.authUser);
    }

    public final int hashCode() {
        String str = this.visitorData;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.dataSyncId;
        return this.authUser.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("WebAuthData(visitorData=", this.visitorData, ", dataSyncId=", this.dataSyncId, ", authUser="), this.authUser, ")");
    }
}
