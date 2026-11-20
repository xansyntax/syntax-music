package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistItem extends YTItem {
    public final String channelId;
    public final String id;
    public final boolean isProfile;
    public final WatchEndpoint playEndpoint;
    public final WatchEndpoint radioEndpoint;
    public final WatchEndpoint shuffleEndpoint;
    public final String thumbnail;
    public final String title;

    public ArtistItem(String str, String str2, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, WatchEndpoint watchEndpoint3, boolean z) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.thumbnail = str3;
        this.channelId = str4;
        this.playEndpoint = watchEndpoint;
        this.shuffleEndpoint = watchEndpoint2;
        this.radioEndpoint = watchEndpoint3;
        this.isProfile = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistItem)) {
            return false;
        }
        ArtistItem artistItem = (ArtistItem) obj;
        return Intrinsics.areEqual(this.id, artistItem.id) && Intrinsics.areEqual(this.title, artistItem.title) && Intrinsics.areEqual(this.thumbnail, artistItem.thumbnail) && Intrinsics.areEqual(this.channelId, artistItem.channelId) && Intrinsics.areEqual(this.playEndpoint, artistItem.playEndpoint) && Intrinsics.areEqual(this.shuffleEndpoint, artistItem.shuffleEndpoint) && Intrinsics.areEqual(this.radioEndpoint, artistItem.radioEndpoint) && this.isProfile == artistItem.isProfile;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getId() {
        return this.id;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getTitle() {
        return this.title;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title);
        String str = this.thumbnail;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        WatchEndpoint watchEndpoint = this.playEndpoint;
        int iHashCode3 = (iHashCode2 + (watchEndpoint == null ? 0 : watchEndpoint.hashCode())) * 31;
        WatchEndpoint watchEndpoint2 = this.shuffleEndpoint;
        int iHashCode4 = (iHashCode3 + (watchEndpoint2 == null ? 0 : watchEndpoint2.hashCode())) * 31;
        WatchEndpoint watchEndpoint3 = this.radioEndpoint;
        return Boolean.hashCode(this.isProfile) + ((iHashCode4 + (watchEndpoint3 != null ? watchEndpoint3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ArtistItem(id=", this.id, ", title=", this.title, ", thumbnail=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.thumbnail, ", channelId=", this.channelId, ", playEndpoint=");
        sbM.append(this.playEndpoint);
        sbM.append(", shuffleEndpoint=");
        sbM.append(this.shuffleEndpoint);
        sbM.append(", radioEndpoint=");
        sbM.append(this.radioEndpoint);
        sbM.append(", isProfile=");
        sbM.append(this.isProfile);
        sbM.append(")");
        return sbM.toString();
    }

    public /* synthetic */ ArtistItem(String str, String str2, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, WatchEndpoint watchEndpoint3, int i) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : watchEndpoint, watchEndpoint2, watchEndpoint3, (i & 128) == 0);
    }
}
