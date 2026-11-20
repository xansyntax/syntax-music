package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.time.LocalDateTime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PodcastEntity {
    public final String author;
    public final LocalDateTime bookmarkedAt;
    public final String channelId;
    public final String id;
    public final LocalDateTime lastUpdateTime;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final String thumbnailUrl;
    public final String title;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PodcastEntity(String str, String str2, String str3, String str4, String str5, LocalDateTime localDateTime, int i) {
        String str6 = (i & 16) != 0 ? null : str5;
        LocalDateTime localDateTime2 = (i & 32) != 0 ? null : localDateTime;
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        localDateTimeNow.getClass();
        this(str, str2, str3, str4, str6, localDateTime2, localDateTimeNow, null, null);
    }

    public static PodcastEntity copy$default(PodcastEntity podcastEntity, String str, String str2, String str3, String str4, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i) {
        String str5 = podcastEntity.id;
        if ((i & 2) != 0) {
            str = podcastEntity.title;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = podcastEntity.author;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = podcastEntity.thumbnailUrl;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = podcastEntity.channelId;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            localDateTime = podcastEntity.bookmarkedAt;
        }
        LocalDateTime localDateTime3 = localDateTime;
        LocalDateTime localDateTime4 = (i & 64) != 0 ? podcastEntity.lastUpdateTime : localDateTime2;
        String str10 = podcastEntity.libraryAddToken;
        String str11 = podcastEntity.libraryRemoveToken;
        podcastEntity.getClass();
        str5.getClass();
        str6.getClass();
        localDateTime4.getClass();
        return new PodcastEntity(str5, str6, str7, str8, str9, localDateTime3, localDateTime4, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PodcastEntity)) {
            return false;
        }
        PodcastEntity podcastEntity = (PodcastEntity) obj;
        return Intrinsics.areEqual(this.id, podcastEntity.id) && Intrinsics.areEqual(this.title, podcastEntity.title) && Intrinsics.areEqual(this.author, podcastEntity.author) && Intrinsics.areEqual(this.thumbnailUrl, podcastEntity.thumbnailUrl) && Intrinsics.areEqual(this.channelId, podcastEntity.channelId) && Intrinsics.areEqual(this.bookmarkedAt, podcastEntity.bookmarkedAt) && Intrinsics.areEqual(this.lastUpdateTime, podcastEntity.lastUpdateTime) && Intrinsics.areEqual(this.libraryAddToken, podcastEntity.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, podcastEntity.libraryRemoveToken);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title);
        String str = this.author;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnailUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        LocalDateTime localDateTime = this.bookmarkedAt;
        int iHashCode4 = (this.lastUpdateTime.hashCode() + ((iHashCode3 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31)) * 31;
        String str4 = this.libraryAddToken;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.libraryRemoveToken;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PodcastEntity(id=", this.id, ", title=", this.title, ", author=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.author, ", thumbnailUrl=", this.thumbnailUrl, ", channelId=");
        sbM.append(this.channelId);
        sbM.append(", bookmarkedAt=");
        sbM.append(this.bookmarkedAt);
        sbM.append(", lastUpdateTime=");
        sbM.append(this.lastUpdateTime);
        sbM.append(", libraryAddToken=");
        sbM.append(this.libraryAddToken);
        sbM.append(", libraryRemoveToken=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.libraryRemoveToken, ")");
    }

    public final PodcastEntity toggleBookmark() {
        LocalDateTime localDateTimeNow = this.bookmarkedAt != null ? null : LocalDateTime.now();
        LocalDateTime localDateTimeNow2 = LocalDateTime.now();
        localDateTimeNow2.getClass();
        return copy$default(this, null, null, null, null, localDateTimeNow, localDateTimeNow2, 415);
    }

    public PodcastEntity(String str, String str2, String str3, String str4, String str5, LocalDateTime localDateTime, LocalDateTime localDateTime2, String str6, String str7) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.author = str3;
        this.thumbnailUrl = str4;
        this.channelId = str5;
        this.bookmarkedAt = localDateTime;
        this.lastUpdateTime = localDateTime2;
        this.libraryAddToken = str6;
        this.libraryRemoveToken = str7;
    }
}
