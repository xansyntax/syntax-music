package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EpisodeItem extends YTItem {
    public final Artist author;
    public final Integer duration;
    public final WatchEndpoint endpoint;
    public final boolean explicit;
    public final String id;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final Album podcast;
    public final String publishDateText;
    public final String thumbnail;
    public final String title;

    public EpisodeItem(String str, String str2, Artist artist, Album album, Integer num, String str3, String str4, boolean z, WatchEndpoint watchEndpoint, String str5, String str6) {
        str.getClass();
        str2.getClass();
        str4.getClass();
        this.id = str;
        this.title = str2;
        this.author = artist;
        this.podcast = album;
        this.duration = num;
        this.publishDateText = str3;
        this.thumbnail = str4;
        this.explicit = z;
        this.endpoint = watchEndpoint;
        this.libraryAddToken = str5;
        this.libraryRemoveToken = str6;
    }

    public static EpisodeItem copy$default(EpisodeItem episodeItem, Artist artist) {
        String str = episodeItem.id;
        String str2 = episodeItem.title;
        Album album = episodeItem.podcast;
        Integer num = episodeItem.duration;
        String str3 = episodeItem.publishDateText;
        String str4 = episodeItem.thumbnail;
        boolean z = episodeItem.explicit;
        WatchEndpoint watchEndpoint = episodeItem.endpoint;
        String str5 = episodeItem.libraryAddToken;
        String str6 = episodeItem.libraryRemoveToken;
        episodeItem.getClass();
        episodeItem.getClass();
        episodeItem.getClass();
        str.getClass();
        str2.getClass();
        str4.getClass();
        return new EpisodeItem(str, str2, artist, album, num, str3, str4, z, watchEndpoint, str5, str6);
    }

    public final SongItem asSongItem() {
        return new SongItem(this.id, this.title, CollectionsKt__IterablesKt.listOfNotNull(this.author), this.podcast, this.duration, null, null, null, this.thumbnail, this.explicit, this.endpoint, null, this.libraryAddToken, this.libraryRemoveToken, null, true, null, 84192);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EpisodeItem)) {
            return false;
        }
        EpisodeItem episodeItem = (EpisodeItem) obj;
        return Intrinsics.areEqual(this.id, episodeItem.id) && Intrinsics.areEqual(this.title, episodeItem.title) && Intrinsics.areEqual(this.author, episodeItem.author) && Intrinsics.areEqual(this.podcast, episodeItem.podcast) && Intrinsics.areEqual(this.duration, episodeItem.duration) && Intrinsics.areEqual(this.publishDateText, episodeItem.publishDateText) && Intrinsics.areEqual(this.thumbnail, episodeItem.thumbnail) && this.explicit == episodeItem.explicit && Intrinsics.areEqual(this.endpoint, episodeItem.endpoint) && Intrinsics.areEqual(this.libraryAddToken, episodeItem.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, episodeItem.libraryRemoveToken);
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final boolean getExplicit() {
        return this.explicit;
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
        Artist artist = this.author;
        int iHashCode = (iM + (artist == null ? 0 : artist.hashCode())) * 31;
        Album album = this.podcast;
        int iHashCode2 = (iHashCode + (album == null ? 0 : album.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.publishDateText;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31, 31, this.thumbnail), this.explicit, 31);
        WatchEndpoint watchEndpoint = this.endpoint;
        int iHashCode4 = (iM2 + (watchEndpoint == null ? 0 : watchEndpoint.hashCode())) * 31;
        String str2 = this.libraryAddToken;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.libraryRemoveToken;
        return (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 961;
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("EpisodeItem(id=", this.id, ", title=", this.title, ", author=");
        sbM.append(this.author);
        sbM.append(", podcast=");
        sbM.append(this.podcast);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", publishDateText=");
        sbM.append(this.publishDateText);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(", explicit=");
        sbM.append(this.explicit);
        sbM.append(", endpoint=");
        sbM.append(this.endpoint);
        sbM.append(", libraryAddToken=");
        sbM.append(this.libraryAddToken);
        sbM.append(", libraryRemoveToken=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.libraryRemoveToken, ", markAsPlayedToken=null, markAsUnplayedToken=null)");
    }

    public /* synthetic */ EpisodeItem(String str, String str2, Artist artist, Album album, Integer num, String str3, String str4, boolean z, WatchEndpoint watchEndpoint, String str5, String str6, int i) {
        this(str, str2, artist, (i & 8) != 0 ? null : album, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str3, str4, (i & 128) != 0 ? false : z, watchEndpoint, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6);
    }
}
