package com.metrolist.music.viewmodels;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackupPreviewInfo {
    public final String accountEmail;
    public final String accountImageUrl;
    public final String accountName;
    public final String cookie;
    public final boolean hasAuthData;

    public BackupPreviewInfo(String str, String str2, String str3, String str4, boolean z) {
        this.hasAuthData = z;
        this.accountName = str;
        this.accountEmail = str2;
        this.accountImageUrl = str3;
        this.cookie = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupPreviewInfo)) {
            return false;
        }
        BackupPreviewInfo backupPreviewInfo = (BackupPreviewInfo) obj;
        return this.hasAuthData == backupPreviewInfo.hasAuthData && Intrinsics.areEqual(this.accountName, backupPreviewInfo.accountName) && Intrinsics.areEqual(this.accountEmail, backupPreviewInfo.accountEmail) && Intrinsics.areEqual(this.accountImageUrl, backupPreviewInfo.accountImageUrl) && Intrinsics.areEqual(this.cookie, backupPreviewInfo.cookie);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.hasAuthData) * 31;
        String str = this.accountName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accountEmail;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accountImageUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cookie;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackupPreviewInfo(hasAuthData=");
        sb.append(this.hasAuthData);
        sb.append(", accountName=");
        sb.append(this.accountName);
        sb.append(", accountEmail=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.accountEmail, ", accountImageUrl=", this.accountImageUrl, ", cookie=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.cookie, ")");
    }

    public /* synthetic */ BackupPreviewInfo() {
        this(null, null, null, null, false);
    }
}
