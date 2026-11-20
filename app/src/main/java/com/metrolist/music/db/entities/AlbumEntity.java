package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.utils.SyncUtils;
import java.time.LocalDateTime;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumEntity {
    public final LocalDateTime bookmarkedAt;
    public final int duration;
    public final boolean explicit;
    public final String id;
    public final LocalDateTime inLibrary;
    public final boolean isLocal;
    public final boolean isUploaded;
    public final LocalDateTime lastUpdateTime;
    public final LocalDateTime likedDate;
    public final String playlistId;
    public final int songCount;
    public final Integer themeColor;
    public final String thumbnailUrl;
    public final String title;
    public final Integer year;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AlbumEntity(String str, String str2, String str3, Integer num, String str4, int i, int i2, boolean z, int i3) {
        String str5 = (i3 & 2) != 0 ? null : str2;
        Integer num2 = (i3 & 8) != 0 ? null : num;
        boolean z2 = (i3 & 256) != 0 ? false : z;
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        localDateTimeNow.getClass();
        this(str, str5, str3, num2, str4, null, i, i2, z2, localDateTimeNow, null, null, null, false, false);
    }

    public static AlbumEntity copy$default(AlbumEntity albumEntity, String str, String str2, String str3, Integer num, String str4, int i, int i2, boolean z, LocalDateTime localDateTime, boolean z2, int i3) {
        String str5 = (i3 & 1) != 0 ? albumEntity.id : str;
        String str6 = (i3 & 2) != 0 ? albumEntity.playlistId : str2;
        String str7 = (i3 & 4) != 0 ? albumEntity.title : str3;
        Integer num2 = (i3 & 8) != 0 ? albumEntity.year : num;
        String str8 = (i3 & 16) != 0 ? albumEntity.thumbnailUrl : str4;
        Integer num3 = albumEntity.themeColor;
        int i4 = (i3 & 64) != 0 ? albumEntity.songCount : i;
        int i5 = (i3 & 128) != 0 ? albumEntity.duration : i2;
        boolean z3 = (i3 & 256) != 0 ? albumEntity.explicit : z;
        LocalDateTime localDateTime2 = albumEntity.lastUpdateTime;
        LocalDateTime localDateTime3 = (i3 & 1024) != 0 ? albumEntity.bookmarkedAt : localDateTime;
        LocalDateTime localDateTime4 = albumEntity.likedDate;
        LocalDateTime localDateTime5 = albumEntity.inLibrary;
        boolean z4 = albumEntity.isLocal;
        boolean z5 = (i3 & 16384) != 0 ? albumEntity.isUploaded : z2;
        albumEntity.getClass();
        str5.getClass();
        str7.getClass();
        localDateTime2.getClass();
        return new AlbumEntity(str5, str6, str7, num2, str8, num3, i4, i5, z3, localDateTime2, localDateTime3, localDateTime4, localDateTime5, z4, z5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumEntity)) {
            return false;
        }
        AlbumEntity albumEntity = (AlbumEntity) obj;
        return Intrinsics.areEqual(this.id, albumEntity.id) && Intrinsics.areEqual(this.playlistId, albumEntity.playlistId) && Intrinsics.areEqual(this.title, albumEntity.title) && Intrinsics.areEqual(this.year, albumEntity.year) && Intrinsics.areEqual(this.thumbnailUrl, albumEntity.thumbnailUrl) && Intrinsics.areEqual(this.themeColor, albumEntity.themeColor) && this.songCount == albumEntity.songCount && this.duration == albumEntity.duration && this.explicit == albumEntity.explicit && Intrinsics.areEqual(this.lastUpdateTime, albumEntity.lastUpdateTime) && Intrinsics.areEqual(this.bookmarkedAt, albumEntity.bookmarkedAt) && Intrinsics.areEqual(this.likedDate, albumEntity.likedDate) && Intrinsics.areEqual(this.inLibrary, albumEntity.inLibrary) && this.isLocal == albumEntity.isLocal && this.isUploaded == albumEntity.isUploaded;
    }

    public final int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.playlistId;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.title);
        Integer num = this.year;
        int iHashCode2 = (iM + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.thumbnailUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.themeColor;
        int iHashCode4 = (this.lastUpdateTime.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.duration, IntIntPair$$ExternalSyntheticOutline0.m(this.songCount, (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31, 31), 31), this.explicit, 31)) * 31;
        LocalDateTime localDateTime = this.bookmarkedAt;
        int iHashCode5 = (iHashCode4 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31;
        LocalDateTime localDateTime2 = this.likedDate;
        int iHashCode6 = (iHashCode5 + (localDateTime2 == null ? 0 : localDateTime2.hashCode())) * 31;
        LocalDateTime localDateTime3 = this.inLibrary;
        return Boolean.hashCode(this.isUploaded) + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode6 + (localDateTime3 != null ? localDateTime3.hashCode() : 0)) * 31, this.isLocal, 31);
    }

    public final AlbumEntity localToggleLike() {
        return copy$default(this, null, null, null, null, null, 0, 0, false, this.bookmarkedAt != null ? null : LocalDateTime.now(), false, 31743);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AlbumEntity(id=", this.id, ", playlistId=", this.playlistId, ", title=");
        sbM.append(this.title);
        sbM.append(", year=");
        sbM.append(this.year);
        sbM.append(", thumbnailUrl=");
        sbM.append(this.thumbnailUrl);
        sbM.append(", themeColor=");
        sbM.append(this.themeColor);
        sbM.append(", songCount=");
        sbM.append(this.songCount);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", explicit=");
        sbM.append(this.explicit);
        sbM.append(", lastUpdateTime=");
        sbM.append(this.lastUpdateTime);
        sbM.append(", bookmarkedAt=");
        sbM.append(this.bookmarkedAt);
        sbM.append(", likedDate=");
        sbM.append(this.likedDate);
        sbM.append(", inLibrary=");
        sbM.append(this.inLibrary);
        sbM.append(", isLocal=");
        sbM.append(this.isLocal);
        sbM.append(", isUploaded=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.isUploaded, ")");
    }

    public final AlbumEntity toggleLike() {
        AlbumEntity albumEntityLocalToggleLike = localToggleLike();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 21), 3);
        return albumEntityLocalToggleLike;
    }

    public final AlbumEntity toggleUploaded() {
        return copy$default(this, null, null, null, null, null, 0, 0, false, null, !this.isUploaded, 16383);
    }

    public AlbumEntity(String str, String str2, String str3, Integer num, String str4, Integer num2, int i, int i2, boolean z, LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, LocalDateTime localDateTime4, boolean z2, boolean z3) {
        str.getClass();
        str3.getClass();
        this.id = str;
        this.playlistId = str2;
        this.title = str3;
        this.year = num;
        this.thumbnailUrl = str4;
        this.themeColor = num2;
        this.songCount = i;
        this.duration = i2;
        this.explicit = z;
        this.lastUpdateTime = localDateTime;
        this.bookmarkedAt = localDateTime2;
        this.likedDate = localDateTime3;
        this.inLibrary = localDateTime4;
        this.isLocal = z2;
        this.isUploaded = z3;
    }
}
