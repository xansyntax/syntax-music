package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeAccount {
    public final String byline;
    public final String channelHandle;
    public final String dataSyncId;
    public final boolean isSelected;
    public final String name;
    public final String pageId;
    public final String signinUrl;
    public final String thumbnailUrl;

    public YouTubeAccount(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        this.name = str;
        this.byline = str2;
        this.channelHandle = str3;
        this.thumbnailUrl = str4;
        this.isSelected = z;
        this.signinUrl = str5;
        this.pageId = str6;
        this.dataSyncId = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YouTubeAccount)) {
            return false;
        }
        YouTubeAccount youTubeAccount = (YouTubeAccount) obj;
        return this.name.equals(youTubeAccount.name) && Intrinsics.areEqual(this.byline, youTubeAccount.byline) && Intrinsics.areEqual(this.channelHandle, youTubeAccount.channelHandle) && Intrinsics.areEqual(this.thumbnailUrl, youTubeAccount.thumbnailUrl) && this.isSelected == youTubeAccount.isSelected && Intrinsics.areEqual(this.signinUrl, youTubeAccount.signinUrl) && Intrinsics.areEqual(this.pageId, youTubeAccount.pageId) && Intrinsics.areEqual(this.dataSyncId, youTubeAccount.dataSyncId);
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.byline;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelHandle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnailUrl;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31, this.isSelected, 31);
        String str4 = this.signinUrl;
        int iHashCode4 = (iM + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pageId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.dataSyncId;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("YouTubeAccount(name=", this.name, ", byline=", this.byline, ", channelHandle=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.channelHandle, ", thumbnailUrl=", this.thumbnailUrl, ", isSelected=");
        sbM.append(this.isSelected);
        sbM.append(", signinUrl=");
        sbM.append(this.signinUrl);
        sbM.append(", pageId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.pageId, ", dataSyncId=", this.dataSyncId, ")");
    }
}
