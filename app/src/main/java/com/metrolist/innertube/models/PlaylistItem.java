package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistItem extends YTItem {
    public final Artist author;
    public final String authorAvatarUrl;
    public final String description;
    public final String id;
    public final boolean isEditable;
    public final boolean isPodcast;
    public final WatchEndpoint playEndpoint;
    public final WatchEndpoint radioEndpoint;
    public final WatchEndpoint shuffleEndpoint;
    public final String songCountText;
    public final String thumbnail;
    public final String title;

    public PlaylistItem(String str, String str2, Artist artist, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, WatchEndpoint watchEndpoint3, boolean z, boolean z2, String str5, String str6) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.author = artist;
        this.songCountText = str3;
        this.thumbnail = str4;
        this.playEndpoint = watchEndpoint;
        this.shuffleEndpoint = watchEndpoint2;
        this.radioEndpoint = watchEndpoint3;
        this.isEditable = z;
        this.isPodcast = z2;
        this.description = str5;
        this.authorAvatarUrl = str6;
    }

    public static PlaylistItem copy$default(PlaylistItem playlistItem, Artist artist, String str, int i) {
        String str2 = playlistItem.id;
        String str3 = playlistItem.title;
        if ((i & 4) != 0) {
            artist = playlistItem.author;
        }
        Artist artist2 = artist;
        if ((i & 8) != 0) {
            str = playlistItem.songCountText;
        }
        String str4 = playlistItem.thumbnail;
        WatchEndpoint watchEndpoint = playlistItem.playEndpoint;
        WatchEndpoint watchEndpoint2 = playlistItem.shuffleEndpoint;
        WatchEndpoint watchEndpoint3 = playlistItem.radioEndpoint;
        boolean z = playlistItem.isEditable;
        boolean z2 = playlistItem.isPodcast;
        String str5 = playlistItem.description;
        String str6 = playlistItem.authorAvatarUrl;
        playlistItem.getClass();
        str2.getClass();
        str3.getClass();
        return new PlaylistItem(str2, str3, artist2, str, str4, watchEndpoint, watchEndpoint2, watchEndpoint3, z, z2, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistItem)) {
            return false;
        }
        PlaylistItem playlistItem = (PlaylistItem) obj;
        return Intrinsics.areEqual(this.id, playlistItem.id) && Intrinsics.areEqual(this.title, playlistItem.title) && Intrinsics.areEqual(this.author, playlistItem.author) && Intrinsics.areEqual(this.songCountText, playlistItem.songCountText) && Intrinsics.areEqual(this.thumbnail, playlistItem.thumbnail) && Intrinsics.areEqual(this.playEndpoint, playlistItem.playEndpoint) && Intrinsics.areEqual(this.shuffleEndpoint, playlistItem.shuffleEndpoint) && Intrinsics.areEqual(this.radioEndpoint, playlistItem.radioEndpoint) && this.isEditable == playlistItem.isEditable && this.isPodcast == playlistItem.isPodcast && Intrinsics.areEqual(this.description, playlistItem.description) && Intrinsics.areEqual(this.authorAvatarUrl, playlistItem.authorAvatarUrl);
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
        String str = this.songCountText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnail;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WatchEndpoint watchEndpoint = this.playEndpoint;
        int iHashCode4 = (iHashCode3 + (watchEndpoint == null ? 0 : watchEndpoint.hashCode())) * 31;
        WatchEndpoint watchEndpoint2 = this.shuffleEndpoint;
        int iHashCode5 = (iHashCode4 + (watchEndpoint2 == null ? 0 : watchEndpoint2.hashCode())) * 31;
        WatchEndpoint watchEndpoint3 = this.radioEndpoint;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode5 + (watchEndpoint3 == null ? 0 : watchEndpoint3.hashCode())) * 31, this.isEditable, 31), this.isPodcast, 31);
        String str3 = this.description;
        int iHashCode6 = (iM2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.authorAvatarUrl;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaylistItem(id=", this.id, ", title=", this.title, ", author=");
        sbM.append(this.author);
        sbM.append(", songCountText=");
        sbM.append(this.songCountText);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(", playEndpoint=");
        sbM.append(this.playEndpoint);
        sbM.append(", shuffleEndpoint=");
        sbM.append(this.shuffleEndpoint);
        sbM.append(", radioEndpoint=");
        sbM.append(this.radioEndpoint);
        sbM.append(", isEditable=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.isEditable, ", isPodcast=", this.isPodcast, ", description=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.description, ", authorAvatarUrl=", this.authorAvatarUrl, ")");
    }

    public /* synthetic */ PlaylistItem(String str, String str2, Artist artist, String str3, String str4, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, WatchEndpoint watchEndpoint3, boolean z, String str5, String str6, int i) {
        this(str, str2, artist, str3, str4, watchEndpoint, watchEndpoint2, watchEndpoint3, (i & 256) != 0 ? false : z, (i & 512) == 0, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6);
    }
}
