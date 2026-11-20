package com.metrolist.shazamkit.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J½\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020:HÖ\u0081\u0004J\n\u0010;\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016Ê\u0001\f\b=\u0012\b\b>\u0012\u0004\b\u0003\u0010\u0000¨\u0006<"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionResult;", "", "trackId", "", LinkHeader.Parameters.Title, "artist", "album", "coverArtUrl", "coverArtHqUrl", "genre", "releaseDate", "label", "lyrics", "", "shazamUrl", "appleMusicUrl", "spotifyUrl", "isrc", "youtubeVideoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTrackId", "()Ljava/lang/String;", "getTitle", "getArtist", "getAlbum", "getCoverArtUrl", "getCoverArtHqUrl", "getGenre", "getReleaseDate", "getLabel", "getLyrics", "()Ljava/util/List;", "getShazamUrl", "getAppleMusicUrl", "getSpotifyUrl", "getIsrc", "getYoutubeVideoId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class RecognitionResult {
    public static final int $stable = 8;
    private final String album;
    private final String appleMusicUrl;
    private final String artist;
    private final String coverArtHqUrl;
    private final String coverArtUrl;
    private final String genre;
    private final String isrc;
    private final String label;
    private final List<String> lyrics;
    private final String releaseDate;
    private final String shazamUrl;
    private final String spotifyUrl;
    private final String title;
    private final String trackId;
    private final String youtubeVideoId;

    public /* synthetic */ RecognitionResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, String str11, String str12, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, list, str10, str11, str12, str13, (i & 16384) != 0 ? null : str14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTrackId() {
        return this.trackId;
    }

    public final List<String> component10() {
        return this.lyrics;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getShazamUrl() {
        return this.shazamUrl;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAppleMusicUrl() {
        return this.appleMusicUrl;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSpotifyUrl() {
        return this.spotifyUrl;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getIsrc() {
        return this.isrc;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getYoutubeVideoId() {
        return this.youtubeVideoId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCoverArtUrl() {
        return this.coverArtUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverArtHqUrl() {
        return this.coverArtHqUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGenre() {
        return this.genre;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final RecognitionResult copy(String trackId, String title, String artist, String album, String coverArtUrl, String coverArtHqUrl, String genre, String releaseDate, String label, List<String> lyrics, String shazamUrl, String appleMusicUrl, String spotifyUrl, String isrc, String youtubeVideoId) {
        trackId.getClass();
        title.getClass();
        artist.getClass();
        return new RecognitionResult(trackId, title, artist, album, coverArtUrl, coverArtHqUrl, genre, releaseDate, label, lyrics, shazamUrl, appleMusicUrl, spotifyUrl, isrc, youtubeVideoId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecognitionResult)) {
            return false;
        }
        RecognitionResult recognitionResult = (RecognitionResult) other;
        return Intrinsics.areEqual(this.trackId, recognitionResult.trackId) && Intrinsics.areEqual(this.title, recognitionResult.title) && Intrinsics.areEqual(this.artist, recognitionResult.artist) && Intrinsics.areEqual(this.album, recognitionResult.album) && Intrinsics.areEqual(this.coverArtUrl, recognitionResult.coverArtUrl) && Intrinsics.areEqual(this.coverArtHqUrl, recognitionResult.coverArtHqUrl) && Intrinsics.areEqual(this.genre, recognitionResult.genre) && Intrinsics.areEqual(this.releaseDate, recognitionResult.releaseDate) && Intrinsics.areEqual(this.label, recognitionResult.label) && Intrinsics.areEqual(this.lyrics, recognitionResult.lyrics) && Intrinsics.areEqual(this.shazamUrl, recognitionResult.shazamUrl) && Intrinsics.areEqual(this.appleMusicUrl, recognitionResult.appleMusicUrl) && Intrinsics.areEqual(this.spotifyUrl, recognitionResult.spotifyUrl) && Intrinsics.areEqual(this.isrc, recognitionResult.isrc) && Intrinsics.areEqual(this.youtubeVideoId, recognitionResult.youtubeVideoId);
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getAppleMusicUrl() {
        return this.appleMusicUrl;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getCoverArtHqUrl() {
        return this.coverArtHqUrl;
    }

    public final String getCoverArtUrl() {
        return this.coverArtUrl;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getIsrc() {
        return this.isrc;
    }

    public final String getLabel() {
        return this.label;
    }

    public final List<String> getLyrics() {
        return this.lyrics;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final String getShazamUrl() {
        return this.shazamUrl;
    }

    public final String getSpotifyUrl() {
        return this.spotifyUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getYoutubeVideoId() {
        return this.youtubeVideoId;
    }

    public int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.trackId.hashCode() * 31, 31, this.title), 31, this.artist);
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
        List<String> list = this.lyrics;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.shazamUrl;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.appleMusicUrl;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.spotifyUrl;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.isrc;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.youtubeVideoId;
        return iHashCode11 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        String str = this.trackId;
        String str2 = this.title;
        String str3 = this.artist;
        String str4 = this.album;
        String str5 = this.coverArtUrl;
        String str6 = this.coverArtHqUrl;
        String str7 = this.genre;
        String str8 = this.releaseDate;
        String str9 = this.label;
        List<String> list = this.lyrics;
        String str10 = this.shazamUrl;
        String str11 = this.appleMusicUrl;
        String str12 = this.spotifyUrl;
        String str13 = this.isrc;
        String str14 = this.youtubeVideoId;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RecognitionResult(trackId=", str, ", title=", str2, ", artist=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str3, ", album=", str4, ", coverArtUrl=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str5, ", coverArtHqUrl=", str6, ", genre=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str7, ", releaseDate=", str8, ", label=");
        sbM.append(str9);
        sbM.append(", lyrics=");
        sbM.append(list);
        sbM.append(", shazamUrl=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str10, ", appleMusicUrl=", str11, ", spotifyUrl=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str12, ", isrc=", str13, ", youtubeVideoId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, str14, ")");
    }

    public RecognitionResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<String> list, String str10, String str11, String str12, String str13, String str14) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.trackId = str;
        this.title = str2;
        this.artist = str3;
        this.album = str4;
        this.coverArtUrl = str5;
        this.coverArtHqUrl = str6;
        this.genre = str7;
        this.releaseDate = str8;
        this.label = str9;
        this.lyrics = list;
        this.shazamUrl = str10;
        this.appleMusicUrl = str11;
        this.spotifyUrl = str12;
        this.isrc = str13;
        this.youtubeVideoId = str14;
    }
}
