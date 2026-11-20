package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PodcastItem extends YTItem {
    public final Artist author;
    public final String channelId;
    public final String episodeCountText;
    public final String id;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final WatchEndpoint playEndpoint;
    public final WatchEndpoint shuffleEndpoint;
    public final String thumbnail;
    public final String title;

    public PodcastItem(String str, String str2, Artist artist, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, String str5, String str6, String str7) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.author = artist;
        this.episodeCountText = str3;
        this.thumbnail = str4;
        this.playEndpoint = watchEndpoint;
        this.shuffleEndpoint = watchEndpoint2;
        this.libraryAddToken = str5;
        this.libraryRemoveToken = str6;
        this.channelId = str7;
    }

    public static PodcastItem copy$default(PodcastItem podcastItem, Artist artist) {
        String str = podcastItem.id;
        String str2 = podcastItem.title;
        String str3 = podcastItem.episodeCountText;
        String str4 = podcastItem.thumbnail;
        WatchEndpoint watchEndpoint = podcastItem.playEndpoint;
        WatchEndpoint watchEndpoint2 = podcastItem.shuffleEndpoint;
        String str5 = podcastItem.libraryAddToken;
        String str6 = podcastItem.libraryRemoveToken;
        String str7 = podcastItem.channelId;
        podcastItem.getClass();
        str.getClass();
        str2.getClass();
        return new PodcastItem(str, str2, artist, str3, str4, watchEndpoint, watchEndpoint2, str5, str6, str7);
    }

    public final PlaylistItem asPlaylistItem() {
        return new PlaylistItem(this.id, this.title, this.author, this.episodeCountText, this.thumbnail, this.playEndpoint, this.shuffleEndpoint, (WatchEndpoint) null, false, (String) null, (String) null, 3072);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PodcastItem)) {
            return false;
        }
        PodcastItem podcastItem = (PodcastItem) obj;
        return Intrinsics.areEqual(this.id, podcastItem.id) && Intrinsics.areEqual(this.title, podcastItem.title) && Intrinsics.areEqual(this.author, podcastItem.author) && Intrinsics.areEqual(this.episodeCountText, podcastItem.episodeCountText) && Intrinsics.areEqual(this.thumbnail, podcastItem.thumbnail) && Intrinsics.areEqual(this.playEndpoint, podcastItem.playEndpoint) && Intrinsics.areEqual(this.shuffleEndpoint, podcastItem.shuffleEndpoint) && Intrinsics.areEqual(this.libraryAddToken, podcastItem.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, podcastItem.libraryRemoveToken) && Intrinsics.areEqual(this.channelId, podcastItem.channelId);
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final boolean getExplicit() {
        return false;
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
        String str = this.episodeCountText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnail;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WatchEndpoint watchEndpoint = this.playEndpoint;
        int iHashCode4 = (iHashCode3 + (watchEndpoint == null ? 0 : watchEndpoint.hashCode())) * 31;
        WatchEndpoint watchEndpoint2 = this.shuffleEndpoint;
        int iHashCode5 = (iHashCode4 + (watchEndpoint2 == null ? 0 : watchEndpoint2.hashCode())) * 31;
        String str3 = this.libraryAddToken;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.libraryRemoveToken;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.channelId;
        return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PodcastItem(id=", this.id, ", title=", this.title, ", author=");
        sbM.append(this.author);
        sbM.append(", episodeCountText=");
        sbM.append(this.episodeCountText);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(", playEndpoint=");
        sbM.append(this.playEndpoint);
        sbM.append(", shuffleEndpoint=");
        sbM.append(this.shuffleEndpoint);
        sbM.append(", libraryAddToken=");
        sbM.append(this.libraryAddToken);
        sbM.append(", libraryRemoveToken=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.libraryRemoveToken, ", channelId=", this.channelId, ")");
    }

    public /* synthetic */ PodcastItem(String str, String str2, Artist artist, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, String str5, String str6, String str7, int i) {
        this(str, str2, artist, str3, str4, watchEndpoint, watchEndpoint2, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7);
    }
}
