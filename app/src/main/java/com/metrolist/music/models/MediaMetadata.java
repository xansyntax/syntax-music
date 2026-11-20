package com.metrolist.music.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.db.entities.SongEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadata implements Serializable {
    public final Album album;
    public final List artists;
    public final int duration;
    public final boolean explicit;
    public final String id;
    public final boolean isEpisode;
    public final String libraryAddToken;
    public final String libraryRemoveToken;
    public final String musicVideoType;
    public final String setVideoId;
    public final String suggestedBy;
    public final String thumbnailUrl;
    public final String title;
    public final String uploadEntityId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Album implements Serializable {
        public final String id;
        public final String title;

        public Album(String str, String str2) {
            str.getClass();
            str2.getClass();
            this.id = str;
            this.title = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Album)) {
                return false;
            }
            Album album = (Album) obj;
            return Intrinsics.areEqual(this.id, album.id) && Intrinsics.areEqual(this.title, album.title);
        }

        public final int hashCode() {
            return this.title.hashCode() + (this.id.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Album(id=", this.id, ", title=", this.title, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Artist implements Serializable {
        public final String id;
        public final String name;

        public Artist(String str, String str2) {
            str2.getClass();
            this.id = str;
            this.name = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Artist)) {
                return false;
            }
            Artist artist = (Artist) obj;
            return Intrinsics.areEqual(this.id, artist.id) && Intrinsics.areEqual(this.name, artist.name);
        }

        public final int hashCode() {
            String str = this.id;
            return this.name.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Artist(id=", this.id, ", name=", this.name, ")");
        }
    }

    public /* synthetic */ MediaMetadata(String str, String str2, List list, int i, String str3, Album album, String str4, String str5, boolean z, String str6, String str7, String str8, boolean z2, String str9, int i2) {
        this(str, str2, list, i, str3, (i2 & 32) != 0 ? null : album, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? false : z, (i2 & 4096) != 0 ? null : str6, (i2 & 8192) != 0 ? null : str7, (i2 & 16384) != 0 ? null : str8, (32768 & i2) != 0 ? false : z2, (i2 & 65536) != 0 ? null : str9);
    }

    public static MediaMetadata copy$default(MediaMetadata mediaMetadata, ArrayList arrayList, int i, String str, int i2) {
        String str2 = mediaMetadata.id;
        String str3 = mediaMetadata.title;
        List list = (i2 & 4) != 0 ? mediaMetadata.artists : arrayList;
        int i3 = (i2 & 8) != 0 ? mediaMetadata.duration : i;
        String str4 = mediaMetadata.thumbnailUrl;
        List list2 = list;
        int i4 = i3;
        Album album = mediaMetadata.album;
        String str5 = mediaMetadata.setVideoId;
        String str6 = mediaMetadata.musicVideoType;
        boolean z = mediaMetadata.explicit;
        mediaMetadata.getClass();
        mediaMetadata.getClass();
        mediaMetadata.getClass();
        String str7 = mediaMetadata.libraryAddToken;
        String str8 = mediaMetadata.libraryRemoveToken;
        String str9 = (i2 & 16384) != 0 ? mediaMetadata.suggestedBy : str;
        boolean z2 = mediaMetadata.isEpisode;
        String str10 = mediaMetadata.uploadEntityId;
        mediaMetadata.getClass();
        str2.getClass();
        str3.getClass();
        list2.getClass();
        return new MediaMetadata(str2, str3, list2, i4, str4, album, str5, str6, z, str7, str8, str9, z2, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return Intrinsics.areEqual(this.id, mediaMetadata.id) && Intrinsics.areEqual(this.title, mediaMetadata.title) && Intrinsics.areEqual(this.artists, mediaMetadata.artists) && this.duration == mediaMetadata.duration && Intrinsics.areEqual(this.thumbnailUrl, mediaMetadata.thumbnailUrl) && Intrinsics.areEqual(this.album, mediaMetadata.album) && Intrinsics.areEqual(this.setVideoId, mediaMetadata.setVideoId) && Intrinsics.areEqual(this.musicVideoType, mediaMetadata.musicVideoType) && this.explicit == mediaMetadata.explicit && Intrinsics.areEqual(this.libraryAddToken, mediaMetadata.libraryAddToken) && Intrinsics.areEqual(this.libraryRemoveToken, mediaMetadata.libraryRemoveToken) && Intrinsics.areEqual(this.suggestedBy, mediaMetadata.suggestedBy) && this.isEpisode == mediaMetadata.isEpisode && Intrinsics.areEqual(this.uploadEntityId, mediaMetadata.uploadEntityId);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.duration, Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.artists), 31);
        String str = this.thumbnailUrl;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        Album album = this.album;
        int iHashCode2 = (iHashCode + (album == null ? 0 : album.hashCode())) * 31;
        String str2 = this.setVideoId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.musicVideoType;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31, this.explicit, 31), false, 29791);
        String str4 = this.libraryAddToken;
        int iHashCode4 = (iM2 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.libraryRemoveToken;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.suggestedBy;
        int iM3 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31, this.isEpisode, 31);
        String str7 = this.uploadEntityId;
        return iM3 + (str7 != null ? str7.hashCode() : 0);
    }

    public final boolean isVideoSong() {
        String str = this.musicVideoType;
        return (str == null || Intrinsics.areEqual(str, "MUSIC_VIDEO_TYPE_ATV")) ? false : true;
    }

    public final SongEntity toSongEntity() {
        Album album = this.album;
        return new SongEntity(this.id, this.title, this.duration, this.thumbnailUrl, album != null ? album.id : null, album != null ? album.title : null, this.explicit, false, this.libraryAddToken, this.libraryRemoveToken, isVideoSong(), this.isEpisode, this.uploadEntityId, 87872384);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("MediaMetadata(id=", this.id, ", title=", this.title, ", artists=");
        sbM.append(this.artists);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", thumbnailUrl=");
        sbM.append(this.thumbnailUrl);
        sbM.append(", album=");
        sbM.append(this.album);
        sbM.append(", setVideoId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.setVideoId, ", musicVideoType=", this.musicVideoType, ", explicit=");
        sbM.append(this.explicit);
        sbM.append(", liked=false, likedDate=null, inLibrary=null, libraryAddToken=");
        sbM.append(this.libraryAddToken);
        sbM.append(", libraryRemoveToken=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.libraryRemoveToken, ", suggestedBy=", this.suggestedBy, ", isEpisode=");
        sbM.append(this.isEpisode);
        sbM.append(", uploadEntityId=");
        sbM.append(this.uploadEntityId);
        sbM.append(")");
        return sbM.toString();
    }

    public MediaMetadata(String str, String str2, List list, int i, String str3, Album album, String str4, String str5, boolean z, String str6, String str7, String str8, boolean z2, String str9) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.artists = list;
        this.duration = i;
        this.thumbnailUrl = str3;
        this.album = album;
        this.setVideoId = str4;
        this.musicVideoType = str5;
        this.explicit = z;
        this.libraryAddToken = str6;
        this.libraryRemoveToken = str7;
        this.suggestedBy = str8;
        this.isEpisode = z2;
        this.uploadEntityId = str9;
    }
}
