package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.utils.SyncUtils;
import java.time.LocalDateTime;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistEntity {
    public final LocalDateTime bookmarkedAt;
    public final String browseId;
    public final LocalDateTime createdAt;
    public final String id;
    public final boolean isAutoSync;
    public final boolean isEditable;
    public final boolean isLocal;
    public final LocalDateTime lastUpdateTime;
    public final String name;
    public final String playEndpointParams;
    public final String radioEndpointParams;
    public final Integer remoteSongCount;
    public final String shuffleEndpointParams;
    public final String thumbnailUrl;

    public PlaylistEntity(String str, String str2, String str3, LocalDateTime localDateTime, boolean z, LocalDateTime localDateTime2, Integer num, String str4, String str5, String str6, String str7, int i) {
        this((i & 1) != 0 ? CollectionsKt__IterablesKt.generateLocalId("LP") : str, str2, (i & 4) != 0 ? null : str3, LocalDateTime.now(), (i & 16) != 0 ? LocalDateTime.now() : localDateTime, (i & 32) != 0 ? true : z, (i & 64) != 0 ? null : localDateTime2, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, false, false);
    }

    public static PlaylistEntity copy$default(PlaylistEntity playlistEntity, String str, String str2, LocalDateTime localDateTime, boolean z, LocalDateTime localDateTime2, Integer num, String str3, String str4, String str5, String str6, boolean z2, int i) {
        String str7 = playlistEntity.id;
        String str8 = (i & 2) != 0 ? playlistEntity.name : str;
        String str9 = (i & 4) != 0 ? playlistEntity.browseId : str2;
        LocalDateTime localDateTime3 = playlistEntity.createdAt;
        LocalDateTime localDateTime4 = (i & 16) != 0 ? playlistEntity.lastUpdateTime : localDateTime;
        boolean z3 = (i & 32) != 0 ? playlistEntity.isEditable : z;
        LocalDateTime localDateTime5 = (i & 64) != 0 ? playlistEntity.bookmarkedAt : localDateTime2;
        Integer num2 = (i & 128) != 0 ? playlistEntity.remoteSongCount : num;
        String str10 = (i & 256) != 0 ? playlistEntity.playEndpointParams : str3;
        String str11 = (i & 512) != 0 ? playlistEntity.thumbnailUrl : str4;
        String str12 = (i & 1024) != 0 ? playlistEntity.shuffleEndpointParams : str5;
        String str13 = (i & 2048) != 0 ? playlistEntity.radioEndpointParams : str6;
        boolean z4 = playlistEntity.isLocal;
        boolean z5 = (i & 8192) != 0 ? playlistEntity.isAutoSync : z2;
        playlistEntity.getClass();
        str7.getClass();
        str8.getClass();
        return new PlaylistEntity(str7, str8, str9, localDateTime3, localDateTime4, z3, localDateTime5, num2, str10, str11, str12, str13, z4, z5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistEntity)) {
            return false;
        }
        PlaylistEntity playlistEntity = (PlaylistEntity) obj;
        return Intrinsics.areEqual(this.id, playlistEntity.id) && Intrinsics.areEqual(this.name, playlistEntity.name) && Intrinsics.areEqual(this.browseId, playlistEntity.browseId) && Intrinsics.areEqual(this.createdAt, playlistEntity.createdAt) && Intrinsics.areEqual(this.lastUpdateTime, playlistEntity.lastUpdateTime) && this.isEditable == playlistEntity.isEditable && Intrinsics.areEqual(this.bookmarkedAt, playlistEntity.bookmarkedAt) && Intrinsics.areEqual(this.remoteSongCount, playlistEntity.remoteSongCount) && Intrinsics.areEqual(this.playEndpointParams, playlistEntity.playEndpointParams) && Intrinsics.areEqual(this.thumbnailUrl, playlistEntity.thumbnailUrl) && Intrinsics.areEqual(this.shuffleEndpointParams, playlistEntity.shuffleEndpointParams) && Intrinsics.areEqual(this.radioEndpointParams, playlistEntity.radioEndpointParams) && this.isLocal == playlistEntity.isLocal && this.isAutoSync == playlistEntity.isAutoSync;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.name);
        String str = this.browseId;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        LocalDateTime localDateTime = this.createdAt;
        int iHashCode2 = (iHashCode + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31;
        LocalDateTime localDateTime2 = this.lastUpdateTime;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (localDateTime2 == null ? 0 : localDateTime2.hashCode())) * 31, this.isEditable, 31);
        LocalDateTime localDateTime3 = this.bookmarkedAt;
        int iHashCode3 = (iM2 + (localDateTime3 == null ? 0 : localDateTime3.hashCode())) * 31;
        Integer num = this.remoteSongCount;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.playEndpointParams;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnailUrl;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shuffleEndpointParams;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.radioEndpointParams;
        return Boolean.hashCode(this.isAutoSync) + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31, this.isLocal, 31);
    }

    public final PlaylistEntity localToggleLike() {
        return copy$default(this, null, null, null, false, this.bookmarkedAt != null ? null : LocalDateTime.now(), null, null, null, null, null, false, 16319);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaylistEntity(id=", this.id, ", name=", this.name, ", browseId=");
        sbM.append(this.browseId);
        sbM.append(", createdAt=");
        sbM.append(this.createdAt);
        sbM.append(", lastUpdateTime=");
        sbM.append(this.lastUpdateTime);
        sbM.append(", isEditable=");
        sbM.append(this.isEditable);
        sbM.append(", bookmarkedAt=");
        sbM.append(this.bookmarkedAt);
        sbM.append(", remoteSongCount=");
        sbM.append(this.remoteSongCount);
        sbM.append(", playEndpointParams=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.playEndpointParams, ", thumbnailUrl=", this.thumbnailUrl, ", shuffleEndpointParams=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.shuffleEndpointParams, ", radioEndpointParams=", this.radioEndpointParams, ", isLocal=");
        sbM.append(this.isLocal);
        sbM.append(", isAutoSync=");
        sbM.append(this.isAutoSync);
        sbM.append(")");
        return sbM.toString();
    }

    public final PlaylistEntity toggleLike() {
        PlaylistEntity playlistEntityLocalToggleLike = localToggleLike();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 22), 3);
        return playlistEntityLocalToggleLike;
    }

    public PlaylistEntity(String str, String str2, String str3, LocalDateTime localDateTime, LocalDateTime localDateTime2, boolean z, LocalDateTime localDateTime3, Integer num, String str4, String str5, String str6, String str7, boolean z2, boolean z3) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.name = str2;
        this.browseId = str3;
        this.createdAt = localDateTime;
        this.lastUpdateTime = localDateTime2;
        this.isEditable = z;
        this.bookmarkedAt = localDateTime3;
        this.remoteSongCount = num;
        this.playEndpointParams = str4;
        this.thumbnailUrl = str5;
        this.shuffleEndpointParams = str6;
        this.radioEndpointParams = str7;
        this.isLocal = z2;
        this.isAutoSync = z3;
    }
}
