package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtractedMediaMetadata {
    public final String author;
    public final String channelId;
    public final Long durationSeconds;
    public final boolean isLive;
    public final String musicVideoType;
    public final List thumbnails;
    public final String title;
    public final String viewCount;

    public ExtractedMediaMetadata(String str, String str2, String str3, Long l, String str4, String str5, List list, boolean z) {
        this.title = str;
        this.author = str2;
        this.channelId = str3;
        this.durationSeconds = l;
        this.musicVideoType = str4;
        this.viewCount = str5;
        this.thumbnails = list;
        this.isLive = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtractedMediaMetadata)) {
            return false;
        }
        ExtractedMediaMetadata extractedMediaMetadata = (ExtractedMediaMetadata) obj;
        return Intrinsics.areEqual(this.title, extractedMediaMetadata.title) && Intrinsics.areEqual(this.author, extractedMediaMetadata.author) && Intrinsics.areEqual(this.channelId, extractedMediaMetadata.channelId) && Intrinsics.areEqual(this.durationSeconds, extractedMediaMetadata.durationSeconds) && Intrinsics.areEqual(this.musicVideoType, extractedMediaMetadata.musicVideoType) && Intrinsics.areEqual(this.viewCount, extractedMediaMetadata.viewCount) && this.thumbnails.equals(extractedMediaMetadata.thumbnails) && this.isLive == extractedMediaMetadata.isLive;
    }

    public final int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.author;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.durationSeconds;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.musicVideoType;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.viewCount;
        return Boolean.hashCode(this.isLive) + Fragment$5$$ExternalSyntheticOutline0.m((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31, 31, this.thumbnails);
    }

    public final String toString() {
        String strPresence = CollectionsKt__IterablesKt.presence(this.title);
        String strPresence2 = CollectionsKt__IterablesKt.presence(this.author);
        String strPresence3 = CollectionsKt__IterablesKt.presence(this.channelId);
        String strPresence4 = CollectionsKt__IterablesKt.presence(this.viewCount);
        int size = this.thumbnails.size();
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ExtractedMediaMetadata(title=", strPresence, ", author=", strPresence2, ", channelId=");
        sbM.append(strPresence3);
        sbM.append(", durationSeconds=");
        sbM.append(this.durationSeconds);
        sbM.append(", musicVideoType=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.musicVideoType, ", viewCount=", strPresence4, ", thumbnailCount=");
        sbM.append(size);
        sbM.append(", isLive=");
        sbM.append(this.isLive);
        sbM.append(")");
        return sbM.toString();
    }
}
