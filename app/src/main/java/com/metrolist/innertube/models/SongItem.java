package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongItem extends YTItem {
    public final Album album;
    public final List artists;
    public final String chartChange;
    public final Integer chartPosition;
    public final Integer duration;
    public final WatchEndpoint endpoint;
    public final boolean explicit;
    public final String historyRemoveToken;
    public final String id;
    public final boolean isEpisode;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final String musicVideoType;
    public final String setVideoId;
    public final String thumbnail;
    public final String title;
    public final String uploadEntityId;

    public /* synthetic */ SongItem(String str, String str2, List list, Album album, Integer num, String str3, Integer num2, String str4, String str5, boolean z, WatchEndpoint watchEndpoint, String str6, String str7, String str8, String str9, boolean z2, String str10, int i) {
        this(str, str2, list, (i & 8) != 0 ? null : album, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : str4, str5, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? null : watchEndpoint, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9, (32768 & i) != 0 ? false : z2, (i & 65536) != 0 ? null : str10);
    }

    public static SongItem copy$default(SongItem songItem, List list, Integer num, String str, int i) {
        String str2 = songItem.id;
        String str3 = songItem.title;
        List list2 = (i & 4) != 0 ? songItem.artists : list;
        Album album = songItem.album;
        Integer num2 = (i & 16) != 0 ? songItem.duration : num;
        String str4 = songItem.musicVideoType;
        List list3 = list2;
        Integer num3 = num2;
        Integer num4 = songItem.chartPosition;
        String str5 = songItem.chartChange;
        String str6 = (i & 256) != 0 ? songItem.thumbnail : str;
        boolean z = songItem.explicit;
        WatchEndpoint watchEndpoint = songItem.endpoint;
        String str7 = songItem.setVideoId;
        String str8 = songItem.libraryAddToken;
        String str9 = songItem.libraryRemoveToken;
        String str10 = songItem.historyRemoveToken;
        String str11 = str6;
        boolean z2 = songItem.isEpisode;
        String str12 = songItem.uploadEntityId;
        songItem.getClass();
        str2.getClass();
        str3.getClass();
        list3.getClass();
        str11.getClass();
        return new SongItem(str2, str3, list3, album, num3, str4, num4, str5, str11, z, watchEndpoint, str7, str8, str9, str10, z2, str12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongItem)) {
            return false;
        }
        SongItem songItem = (SongItem) obj;
        return Intrinsics.areEqual(this.id, songItem.id) && Intrinsics.areEqual(this.title, songItem.title) && Intrinsics.areEqual(this.artists, songItem.artists) && Intrinsics.areEqual(this.album, songItem.album) && Intrinsics.areEqual(this.duration, songItem.duration) && Intrinsics.areEqual(this.musicVideoType, songItem.musicVideoType) && Intrinsics.areEqual(this.chartPosition, songItem.chartPosition) && Intrinsics.areEqual(this.chartChange, songItem.chartChange) && Intrinsics.areEqual(this.thumbnail, songItem.thumbnail) && this.explicit == songItem.explicit && Intrinsics.areEqual(this.endpoint, songItem.endpoint) && Intrinsics.areEqual(this.setVideoId, songItem.setVideoId) && Intrinsics.areEqual(this.libraryAddToken, songItem.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, songItem.libraryRemoveToken) && Intrinsics.areEqual(this.historyRemoveToken, songItem.historyRemoveToken) && this.isEpisode == songItem.isEpisode && Intrinsics.areEqual(this.uploadEntityId, songItem.uploadEntityId);
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
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.artists);
        Album album = this.album;
        int iHashCode = (iM + (album == null ? 0 : album.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.musicVideoType;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.chartPosition;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.chartChange;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.thumbnail), this.explicit, 31);
        WatchEndpoint watchEndpoint = this.endpoint;
        int iHashCode5 = (iM2 + (watchEndpoint == null ? 0 : watchEndpoint.hashCode())) * 31;
        String str3 = this.setVideoId;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.libraryAddToken;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.libraryRemoveToken;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.historyRemoveToken;
        int iM3 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31, this.isEpisode, 31);
        String str7 = this.uploadEntityId;
        return iM3 + (str7 != null ? str7.hashCode() : 0);
    }

    public final boolean isVideoSong() {
        String str = this.musicVideoType;
        return (str == null || Intrinsics.areEqual(str, "MUSIC_VIDEO_TYPE_ATV")) ? false : true;
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SongItem(id=", this.id, ", title=", this.title, ", artists=");
        sbM.append(this.artists);
        sbM.append(", album=");
        sbM.append(this.album);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", musicVideoType=");
        sbM.append(this.musicVideoType);
        sbM.append(", chartPosition=");
        sbM.append(this.chartPosition);
        sbM.append(", chartChange=");
        sbM.append(this.chartChange);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(", explicit=");
        sbM.append(this.explicit);
        sbM.append(", endpoint=");
        sbM.append(this.endpoint);
        sbM.append(", setVideoId=");
        sbM.append(this.setVideoId);
        sbM.append(", libraryAddToken=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.libraryAddToken, ", libraryRemoveToken=", this.libraryRemoveToken, ", historyRemoveToken=");
        sbM.append(this.historyRemoveToken);
        sbM.append(", isEpisode=");
        sbM.append(this.isEpisode);
        sbM.append(", uploadEntityId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.uploadEntityId, ")");
    }

    public SongItem(String str, String str2, List list, Album album, Integer num, String str3, Integer num2, String str4, String str5, boolean z, WatchEndpoint watchEndpoint, String str6, String str7, String str8, String str9, boolean z2, String str10) {
        str.getClass();
        str2.getClass();
        str5.getClass();
        this.id = str;
        this.title = str2;
        this.artists = list;
        this.album = album;
        this.duration = num;
        this.musicVideoType = str3;
        this.chartPosition = num2;
        this.chartChange = str4;
        this.thumbnail = str5;
        this.explicit = z;
        this.endpoint = watchEndpoint;
        this.setVideoId = str6;
        this.libraryAddToken = str7;
        this.libraryRemoveToken = str8;
        this.historyRemoveToken = str9;
        this.isEpisode = z2;
        this.uploadEntityId = str10;
    }
}
