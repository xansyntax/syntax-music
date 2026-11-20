package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaInfo {
    public final String author;
    public final String authorId;
    public final String authorThumbnail;
    public final String description;
    public final Integer dislike;
    public final Integer like;
    public final String subscribers;
    public final String title;
    public final String uploadDate;
    public final String videoId;
    public final Integer viewCount;

    public MediaInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3) {
        str.getClass();
        this.videoId = str;
        this.title = str2;
        this.author = str3;
        this.authorId = str4;
        this.authorThumbnail = str5;
        this.description = str6;
        this.uploadDate = str7;
        this.subscribers = str8;
        this.viewCount = num;
        this.like = num2;
        this.dislike = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        return Intrinsics.areEqual(this.videoId, mediaInfo.videoId) && Intrinsics.areEqual(this.title, mediaInfo.title) && Intrinsics.areEqual(this.author, mediaInfo.author) && Intrinsics.areEqual(this.authorId, mediaInfo.authorId) && Intrinsics.areEqual(this.authorThumbnail, mediaInfo.authorThumbnail) && Intrinsics.areEqual(this.description, mediaInfo.description) && Intrinsics.areEqual(this.uploadDate, mediaInfo.uploadDate) && Intrinsics.areEqual(this.subscribers, mediaInfo.subscribers) && Intrinsics.areEqual(this.viewCount, mediaInfo.viewCount) && Intrinsics.areEqual(this.like, mediaInfo.like) && Intrinsics.areEqual(this.dislike, mediaInfo.dislike);
    }

    public final int hashCode() {
        int iHashCode = this.videoId.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.author;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.authorId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.authorThumbnail;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.uploadDate;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.subscribers;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.viewCount;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.like;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.dislike;
        return iHashCode10 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("MediaInfo(videoId=", this.videoId, ", title=", this.title, ", author=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.author, ", authorId=", this.authorId, ", authorThumbnail=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.authorThumbnail, ", description=", this.description, ", uploadDate=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.uploadDate, ", subscribers=", this.subscribers, ", viewCount=");
        sbM.append(this.viewCount);
        sbM.append(", like=");
        sbM.append(this.like);
        sbM.append(", dislike=");
        sbM.append(this.dislike);
        sbM.append(")");
        return sbM.toString();
    }
}
