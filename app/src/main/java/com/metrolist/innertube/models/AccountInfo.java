package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountInfo {
    public final String channelHandle;
    public final String email;
    public final String name;
    public final String thumbnailUrl;

    public AccountInfo(String str, String str2, String str3, String str4) {
        str.getClass();
        this.name = str;
        this.email = str2;
        this.channelHandle = str3;
        this.thumbnailUrl = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        return Intrinsics.areEqual(this.name, accountInfo.name) && Intrinsics.areEqual(this.email, accountInfo.email) && Intrinsics.areEqual(this.channelHandle, accountInfo.channelHandle) && Intrinsics.areEqual(this.thumbnailUrl, accountInfo.thumbnailUrl);
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.email;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelHandle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnailUrl;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("AccountInfo(name=", this.name, ", email=", this.email, ", channelHandle="), this.channelHandle, ", thumbnailUrl=", this.thumbnailUrl, ")");
    }
}
