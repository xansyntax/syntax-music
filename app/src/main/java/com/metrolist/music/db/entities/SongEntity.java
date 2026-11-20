package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.time.LocalDateTime;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongEntity {
    public final String albumId;
    public final String albumName;
    public final LocalDateTime date;
    public final LocalDateTime dateDownload;
    public final LocalDateTime dateModified;
    public final int duration;
    public final boolean explicit;
    public final String id;
    public final LocalDateTime inLibrary;
    public final boolean isCached;
    public final boolean isDownloaded;
    public final boolean isEpisode;
    public final boolean isLocal;
    public final boolean isUploaded;
    public final boolean isVideo;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final boolean liked;
    public final LocalDateTime likedDate;
    public final int lyricsOffset;
    public final Long playbackPosition;
    public final boolean romanizeLyrics;
    public final String thumbnailUrl;
    public final String title;
    public final long totalPlayTime;
    public final String uploadEntityId;
    public final Integer year;

    public /* synthetic */ SongEntity(String str, String str2, int i, String str3, String str4, String str5, boolean z, boolean z2, String str6, String str7, boolean z3, boolean z4, String str8, int i2) {
        this(str, str2, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? false : z, null, null, null, (i2 & 1024) != 0 ? false : z2, null, 0L, null, null, false, (65536 & i2) != 0 ? null : str6, (131072 & i2) != 0 ? null : str7, 0, true, false, false, (4194304 & i2) != 0 ? false : z3, (8388608 & i2) != 0 ? false : z4, null, (i2 & 33554432) != 0 ? null : str8, false);
    }

    public static SongEntity copy$default(SongEntity songEntity, String str, int i, String str2, String str3, String str4, boolean z, LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, String str5, String str6, int i2, boolean z2, boolean z3, boolean z4, String str7, int i3) {
        String str8 = songEntity.id;
        String str9 = (i3 & 2) != 0 ? songEntity.title : str;
        int i4 = (i3 & 4) != 0 ? songEntity.duration : i;
        String str10 = (i3 & 8) != 0 ? songEntity.thumbnailUrl : str2;
        String str11 = (i3 & 16) != 0 ? songEntity.albumId : str3;
        String str12 = (i3 & 32) != 0 ? songEntity.albumName : str4;
        boolean z5 = songEntity.explicit;
        String str13 = str9;
        int i5 = i4;
        String str14 = str10;
        String str15 = str11;
        String str16 = str12;
        Integer num = songEntity.year;
        LocalDateTime localDateTime4 = songEntity.date;
        LocalDateTime localDateTime5 = songEntity.dateModified;
        boolean z6 = (i3 & 1024) != 0 ? songEntity.liked : z;
        LocalDateTime localDateTime6 = (i3 & 2048) != 0 ? songEntity.likedDate : localDateTime;
        long j = songEntity.totalPlayTime;
        LocalDateTime localDateTime7 = (i3 & 8192) != 0 ? songEntity.inLibrary : localDateTime2;
        LocalDateTime localDateTime8 = (i3 & 16384) != 0 ? songEntity.dateDownload : localDateTime3;
        boolean z7 = songEntity.isLocal;
        String str17 = (i3 & 65536) != 0 ? songEntity.libraryAddToken : str5;
        String str18 = (i3 & 131072) != 0 ? songEntity.libraryRemoveToken : str6;
        int i6 = (i3 & 262144) != 0 ? songEntity.lyricsOffset : i2;
        boolean z8 = (i3 & 524288) != 0 ? songEntity.romanizeLyrics : z2;
        boolean z9 = songEntity.isDownloaded;
        boolean z10 = (i3 & 2097152) != 0 ? songEntity.isUploaded : z3;
        boolean z11 = (i3 & 4194304) != 0 ? songEntity.isVideo : z4;
        boolean z12 = (i3 & 8388608) != 0 ? songEntity.isEpisode : true;
        Long l = songEntity.playbackPosition;
        String str19 = (i3 & 33554432) != 0 ? songEntity.uploadEntityId : str7;
        boolean z13 = songEntity.isCached;
        songEntity.getClass();
        str8.getClass();
        str13.getClass();
        return new SongEntity(str8, str13, i5, str14, str15, str16, z5, num, localDateTime4, localDateTime5, z6, localDateTime6, j, localDateTime7, localDateTime8, z7, str17, str18, i6, z8, z9, z10, z11, z12, l, str19, z13);
    }

    public static SongEntity toggleLibrary$default(SongEntity songEntity) {
        LocalDateTime localDateTime = songEntity.inLibrary;
        Continuation continuation = null;
        SongEntity songEntityCopy$default = copy$default(songEntity, null, 0, null, null, null, localDateTime == null ? songEntity.liked : false, localDateTime == null ? songEntity.likedDate : null, localDateTime == null ? LocalDateTime.now() : null, null, null, null, 0, false, false, false, null, 134206463);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new SongEntity$toggleLike$1$1(songEntity, continuation, (byte) 1), 3);
        return songEntityCopy$default;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongEntity)) {
            return false;
        }
        SongEntity songEntity = (SongEntity) obj;
        return Intrinsics.areEqual(this.id, songEntity.id) && Intrinsics.areEqual(this.title, songEntity.title) && this.duration == songEntity.duration && Intrinsics.areEqual(this.thumbnailUrl, songEntity.thumbnailUrl) && Intrinsics.areEqual(this.albumId, songEntity.albumId) && Intrinsics.areEqual(this.albumName, songEntity.albumName) && this.explicit == songEntity.explicit && Intrinsics.areEqual(this.year, songEntity.year) && Intrinsics.areEqual(this.date, songEntity.date) && Intrinsics.areEqual(this.dateModified, songEntity.dateModified) && this.liked == songEntity.liked && Intrinsics.areEqual(this.likedDate, songEntity.likedDate) && this.totalPlayTime == songEntity.totalPlayTime && Intrinsics.areEqual(this.inLibrary, songEntity.inLibrary) && Intrinsics.areEqual(this.dateDownload, songEntity.dateDownload) && this.isLocal == songEntity.isLocal && Intrinsics.areEqual(this.libraryAddToken, songEntity.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, songEntity.libraryRemoveToken) && this.lyricsOffset == songEntity.lyricsOffset && this.romanizeLyrics == songEntity.romanizeLyrics && this.isDownloaded == songEntity.isDownloaded && this.isUploaded == songEntity.isUploaded && this.isVideo == songEntity.isVideo && this.isEpisode == songEntity.isEpisode && Intrinsics.areEqual(this.playbackPosition, songEntity.playbackPosition) && Intrinsics.areEqual(this.uploadEntityId, songEntity.uploadEntityId) && this.isCached == songEntity.isCached;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.duration, Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31);
        String str = this.thumbnailUrl;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.albumId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.albumName;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31, this.explicit, 31);
        Integer num = this.year;
        int iHashCode3 = (iM2 + (num == null ? 0 : num.hashCode())) * 31;
        LocalDateTime localDateTime = this.date;
        int iHashCode4 = (iHashCode3 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31;
        LocalDateTime localDateTime2 = this.dateModified;
        int iM3 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode4 + (localDateTime2 == null ? 0 : localDateTime2.hashCode())) * 31, this.liked, 31);
        LocalDateTime localDateTime3 = this.likedDate;
        int iM4 = IntIntPair$$ExternalSyntheticOutline0.m((iM3 + (localDateTime3 == null ? 0 : localDateTime3.hashCode())) * 31, 31, this.totalPlayTime);
        LocalDateTime localDateTime4 = this.inLibrary;
        int iHashCode5 = (iM4 + (localDateTime4 == null ? 0 : localDateTime4.hashCode())) * 31;
        LocalDateTime localDateTime5 = this.dateDownload;
        int iM5 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode5 + (localDateTime5 == null ? 0 : localDateTime5.hashCode())) * 31, this.isLocal, 31);
        String str4 = this.libraryAddToken;
        int iHashCode6 = (iM5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.libraryRemoveToken;
        int iM6 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.lyricsOffset, (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31, 31), this.romanizeLyrics, 31), this.isDownloaded, 31), this.isUploaded, 31), this.isVideo, 31), this.isEpisode, 31);
        Long l = this.playbackPosition;
        int iHashCode7 = (iM6 + (l == null ? 0 : l.hashCode())) * 31;
        String str6 = this.uploadEntityId;
        return Boolean.hashCode(this.isCached) + ((iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SongEntity(id=", this.id, ", title=", this.title, ", duration=");
        sbM.append(this.duration);
        sbM.append(", thumbnailUrl=");
        sbM.append(this.thumbnailUrl);
        sbM.append(", albumId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.albumId, ", albumName=", this.albumName, ", explicit=");
        sbM.append(this.explicit);
        sbM.append(", year=");
        sbM.append(this.year);
        sbM.append(", date=");
        sbM.append(this.date);
        sbM.append(", dateModified=");
        sbM.append(this.dateModified);
        sbM.append(", liked=");
        sbM.append(this.liked);
        sbM.append(", likedDate=");
        sbM.append(this.likedDate);
        sbM.append(", totalPlayTime=");
        sbM.append(this.totalPlayTime);
        sbM.append(", inLibrary=");
        sbM.append(this.inLibrary);
        sbM.append(", dateDownload=");
        sbM.append(this.dateDownload);
        sbM.append(", isLocal=");
        sbM.append(this.isLocal);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, ", libraryAddToken=", this.libraryAddToken, ", libraryRemoveToken=", this.libraryRemoveToken);
        sbM.append(", lyricsOffset=");
        sbM.append(this.lyricsOffset);
        sbM.append(", romanizeLyrics=");
        sbM.append(this.romanizeLyrics);
        sbM.append(", isDownloaded=");
        sbM.append(this.isDownloaded);
        sbM.append(", isUploaded=");
        sbM.append(this.isUploaded);
        sbM.append(", isVideo=");
        sbM.append(this.isVideo);
        sbM.append(", isEpisode=");
        sbM.append(this.isEpisode);
        sbM.append(", playbackPosition=");
        sbM.append(this.playbackPosition);
        sbM.append(", uploadEntityId=");
        sbM.append(this.uploadEntityId);
        sbM.append(", isCached=");
        sbM.append(this.isCached);
        sbM.append(")");
        return sbM.toString();
    }

    public final SongEntity toggleLike(boolean z) {
        boolean z2 = this.liked;
        boolean z3 = !z2;
        Continuation continuation = null;
        LocalDateTime localDateTimeNow = !z2 ? LocalDateTime.now() : null;
        LocalDateTime localDateTimeNow2 = this.inLibrary;
        if (!z2 && localDateTimeNow2 == null) {
            localDateTimeNow2 = LocalDateTime.now();
        }
        SongEntity songEntityCopy$default = copy$default(this, null, 0, null, null, null, z3, localDateTimeNow, localDateTimeNow2, null, null, null, 0, false, false, false, null, 134206463);
        if (z) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new SongEntity$toggleLike$1$1(this, continuation, (byte) 0), 3);
        }
        return songEntityCopy$default;
    }

    public final SongEntity toggleUploaded() {
        return copy$default(this, null, 0, null, null, null, false, null, null, null, null, null, 0, false, !this.isUploaded, false, null, 132120575);
    }

    public final SongEntity withLibraryMembership(boolean z, LocalDateTime localDateTime) {
        LocalDateTime localDateTime2;
        LocalDateTime localDateTime3;
        localDateTime.getClass();
        if (z) {
            localDateTime2 = this.inLibrary;
            if (localDateTime2 == null) {
                localDateTime3 = localDateTime;
            }
            return copy$default(this, null, 0, null, null, null, false, null, localDateTime3, null, null, null, 0, false, false, false, null, 134209535);
        }
        localDateTime2 = null;
        localDateTime3 = localDateTime2;
        return copy$default(this, null, 0, null, null, null, false, null, localDateTime3, null, null, null, 0, false, false, false, null, 134209535);
    }

    public SongEntity(String str, String str2, int i, String str3, String str4, String str5, boolean z, Integer num, LocalDateTime localDateTime, LocalDateTime localDateTime2, boolean z2, LocalDateTime localDateTime3, long j, LocalDateTime localDateTime4, LocalDateTime localDateTime5, boolean z3, String str6, String str7, int i2, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Long l, String str8, boolean z9) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.duration = i;
        this.thumbnailUrl = str3;
        this.albumId = str4;
        this.albumName = str5;
        this.explicit = z;
        this.year = num;
        this.date = localDateTime;
        this.dateModified = localDateTime2;
        this.liked = z2;
        this.likedDate = localDateTime3;
        this.totalPlayTime = j;
        this.inLibrary = localDateTime4;
        this.dateDownload = localDateTime5;
        this.isLocal = z3;
        this.libraryAddToken = str6;
        this.libraryRemoveToken = str7;
        this.lyricsOffset = i2;
        this.romanizeLyrics = z4;
        this.isDownloaded = z5;
        this.isUploaded = z6;
        this.isVideo = z7;
        this.isEpisode = z8;
        this.playbackPosition = l;
        this.uploadEntityId = str8;
        this.isCached = z9;
    }
}
