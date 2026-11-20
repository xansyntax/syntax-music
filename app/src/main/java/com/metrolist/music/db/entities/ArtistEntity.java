package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.viewmodels.ArtistViewModel;
import java.time.LocalDateTime;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistEntity {
    public final LocalDateTime bookmarkedAt;
    public final String cachedPageJson;
    public final String channelId;
    public final String id;
    public final boolean isLocal;
    public final boolean isPodcastChannel;
    public final LocalDateTime lastUpdateTime;
    public final String name;
    public final String thumbnailUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ArtistEntity(String str, String str2, String str3, String str4, LocalDateTime localDateTime, boolean z, String str5, int i) {
        String str6 = (i & 4) != 0 ? null : str3;
        String str7 = (i & 8) != 0 ? null : str4;
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        localDateTimeNow.getClass();
        this(str, str2, str6, str7, localDateTimeNow, (i & 32) != 0 ? null : localDateTime, (i & 64) == 0, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str5);
    }

    public static ArtistEntity copy$default(ArtistEntity artistEntity, String str, String str2, String str3, LocalDateTime localDateTime, LocalDateTime localDateTime2, boolean z, String str4, int i) {
        String str5 = artistEntity.id;
        if ((i & 2) != 0) {
            str = artistEntity.name;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = artistEntity.thumbnailUrl;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = artistEntity.channelId;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            localDateTime = artistEntity.lastUpdateTime;
        }
        LocalDateTime localDateTime3 = localDateTime;
        LocalDateTime localDateTime4 = (i & 32) != 0 ? artistEntity.bookmarkedAt : localDateTime2;
        boolean z2 = artistEntity.isLocal;
        boolean z3 = (i & 128) != 0 ? artistEntity.isPodcastChannel : z;
        String str9 = (i & 256) != 0 ? artistEntity.cachedPageJson : str4;
        artistEntity.getClass();
        str5.getClass();
        str6.getClass();
        localDateTime3.getClass();
        return new ArtistEntity(str5, str6, str7, str8, localDateTime3, localDateTime4, z2, z3, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistEntity)) {
            return false;
        }
        ArtistEntity artistEntity = (ArtistEntity) obj;
        return Intrinsics.areEqual(this.id, artistEntity.id) && Intrinsics.areEqual(this.name, artistEntity.name) && Intrinsics.areEqual(this.thumbnailUrl, artistEntity.thumbnailUrl) && Intrinsics.areEqual(this.channelId, artistEntity.channelId) && Intrinsics.areEqual(this.lastUpdateTime, artistEntity.lastUpdateTime) && Intrinsics.areEqual(this.bookmarkedAt, artistEntity.bookmarkedAt) && this.isLocal == artistEntity.isLocal && this.isPodcastChannel == artistEntity.isPodcastChannel && Intrinsics.areEqual(this.cachedPageJson, artistEntity.cachedPageJson);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.name);
        String str = this.thumbnailUrl;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelId;
        int iHashCode2 = (this.lastUpdateTime.hashCode() + ((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        LocalDateTime localDateTime = this.bookmarkedAt;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31, this.isLocal, 31), this.isPodcastChannel, 31);
        String str3 = this.cachedPageJson;
        return iM2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isYouTubeArtist() {
        String str = this.id;
        return StringsKt__StringsJVMKt.startsWith(str, "UC", false) || StringsKt__StringsJVMKt.startsWith(str, "FEmusic_library_privately_owned_artist", false);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ArtistEntity(id=", this.id, ", name=", this.name, ", thumbnailUrl=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.thumbnailUrl, ", channelId=", this.channelId, ", lastUpdateTime=");
        sbM.append(this.lastUpdateTime);
        sbM.append(", bookmarkedAt=");
        sbM.append(this.bookmarkedAt);
        sbM.append(", isLocal=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.isLocal, ", isPodcastChannel=", this.isPodcastChannel, ", cachedPageJson=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.cachedPageJson, ")");
    }

    public final ArtistEntity toggleLike() {
        Continuation continuation = null;
        ArtistEntity artistEntityCopy$default = copy$default(this, null, null, null, null, this.bookmarkedAt != null ? null : LocalDateTime.now(), false, null, 479);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new ArtistViewModel.AnonymousClass1(this, continuation, (byte) 4), 3);
        return artistEntityCopy$default;
    }

    public ArtistEntity(String str, String str2, String str3, String str4, LocalDateTime localDateTime, LocalDateTime localDateTime2, boolean z, boolean z2, String str5) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.name = str2;
        this.thumbnailUrl = str3;
        this.channelId = str4;
        this.lastUpdateTime = localDateTime;
        this.bookmarkedAt = localDateTime2;
        this.isLocal = z;
        this.isPodcastChannel = z2;
        this.cachedPageJson = str5;
    }
}
