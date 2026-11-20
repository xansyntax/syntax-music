package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.time.LocalDateTime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecognitionHistory {
    public final String album;
    public final String appleMusicUrl;
    public final String artist;
    public final String coverArtHqUrl;
    public final String coverArtUrl;
    public final String genre;
    public final long id;
    public final String isrc;
    public final String label;
    public final boolean liked;
    public final LocalDateTime recognizedAt;
    public final String releaseDate;
    public final String shazamUrl;
    public final String spotifyUrl;
    public final String title;
    public final String trackId;
    public final String youtubeVideoId;

    public RecognitionHistory(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, LocalDateTime localDateTime, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.id = j;
        this.trackId = str;
        this.title = str2;
        this.artist = str3;
        this.album = str4;
        this.coverArtUrl = str5;
        this.coverArtHqUrl = str6;
        this.genre = str7;
        this.releaseDate = str8;
        this.label = str9;
        this.shazamUrl = str10;
        this.appleMusicUrl = str11;
        this.spotifyUrl = str12;
        this.isrc = str13;
        this.youtubeVideoId = str14;
        this.recognizedAt = localDateTime;
        this.liked = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecognitionHistory)) {
            return false;
        }
        RecognitionHistory recognitionHistory = (RecognitionHistory) obj;
        return this.id == recognitionHistory.id && Intrinsics.areEqual(this.trackId, recognitionHistory.trackId) && Intrinsics.areEqual(this.title, recognitionHistory.title) && Intrinsics.areEqual(this.artist, recognitionHistory.artist) && Intrinsics.areEqual(this.album, recognitionHistory.album) && Intrinsics.areEqual(this.coverArtUrl, recognitionHistory.coverArtUrl) && Intrinsics.areEqual(this.coverArtHqUrl, recognitionHistory.coverArtHqUrl) && Intrinsics.areEqual(this.genre, recognitionHistory.genre) && Intrinsics.areEqual(this.releaseDate, recognitionHistory.releaseDate) && Intrinsics.areEqual(this.label, recognitionHistory.label) && Intrinsics.areEqual(this.shazamUrl, recognitionHistory.shazamUrl) && Intrinsics.areEqual(this.appleMusicUrl, recognitionHistory.appleMusicUrl) && Intrinsics.areEqual(this.spotifyUrl, recognitionHistory.spotifyUrl) && Intrinsics.areEqual(this.isrc, recognitionHistory.isrc) && Intrinsics.areEqual(this.youtubeVideoId, recognitionHistory.youtubeVideoId) && Intrinsics.areEqual(this.recognizedAt, recognitionHistory.recognizedAt) && this.liked == recognitionHistory.liked;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.id) * 31, 31, this.trackId), 31, this.title), 31, this.artist);
        String str = this.album;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.coverArtUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverArtHqUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.genre;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.releaseDate;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.label;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.shazamUrl;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.appleMusicUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.spotifyUrl;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.isrc;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.youtubeVideoId;
        return Boolean.hashCode(this.liked) + ((this.recognizedAt.hashCode() + ((iHashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RecognitionHistory(id=");
        sb.append(this.id);
        sb.append(", trackId=");
        sb.append(this.trackId);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", title=", this.title, ", artist=", this.artist);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", album=", this.album, ", coverArtUrl=", this.coverArtUrl);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", coverArtHqUrl=", this.coverArtHqUrl, ", genre=", this.genre);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", releaseDate=", this.releaseDate, ", label=", this.label);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", shazamUrl=", this.shazamUrl, ", appleMusicUrl=", this.appleMusicUrl);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", spotifyUrl=", this.spotifyUrl, ", isrc=", this.isrc);
        sb.append(", youtubeVideoId=");
        sb.append(this.youtubeVideoId);
        sb.append(", recognizedAt=");
        sb.append(this.recognizedAt);
        sb.append(", liked=");
        sb.append(this.liked);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ RecognitionHistory(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, LocalDateTime localDateTime) {
        this(0L, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, localDateTime, false);
    }
}
