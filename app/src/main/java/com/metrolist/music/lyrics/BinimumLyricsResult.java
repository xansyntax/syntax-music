package com.metrolist.music.lyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/BinimumLyricsResult;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class BinimumLyricsResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String album_name;
    public final String artist_name;
    public final Integer duration;
    public final String id;
    public final String isrc;
    public final String lyricsUrl;
    public final String timing_type;
    public final String track_name;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/BinimumLyricsResult$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/BinimumLyricsResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return BinimumLyricsResult$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BinimumLyricsResult(int i, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        if ((i & 2) == 0) {
            this.track_name = null;
        } else {
            this.track_name = str2;
        }
        if ((i & 4) == 0) {
            this.artist_name = null;
        } else {
            this.artist_name = str3;
        }
        if ((i & 8) == 0) {
            this.album_name = null;
        } else {
            this.album_name = str4;
        }
        if ((i & 16) == 0) {
            this.duration = null;
        } else {
            this.duration = num;
        }
        if ((i & 32) == 0) {
            this.isrc = null;
        } else {
            this.isrc = str5;
        }
        if ((i & 64) == 0) {
            this.timing_type = null;
        } else {
            this.timing_type = str6;
        }
        if ((i & 128) == 0) {
            this.lyricsUrl = null;
        } else {
            this.lyricsUrl = str7;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinimumLyricsResult)) {
            return false;
        }
        BinimumLyricsResult binimumLyricsResult = (BinimumLyricsResult) obj;
        return Intrinsics.areEqual(this.id, binimumLyricsResult.id) && Intrinsics.areEqual(this.track_name, binimumLyricsResult.track_name) && Intrinsics.areEqual(this.artist_name, binimumLyricsResult.artist_name) && Intrinsics.areEqual(this.album_name, binimumLyricsResult.album_name) && Intrinsics.areEqual(this.duration, binimumLyricsResult.duration) && Intrinsics.areEqual(this.isrc, binimumLyricsResult.isrc) && Intrinsics.areEqual(this.timing_type, binimumLyricsResult.timing_type) && Intrinsics.areEqual(this.lyricsUrl, binimumLyricsResult.lyricsUrl);
    }

    public final int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.track_name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.artist_name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.album_name;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.isrc;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.timing_type;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.lyricsUrl;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("BinimumLyricsResult(id=", this.id, ", track_name=", this.track_name, ", artist_name=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.artist_name, ", album_name=", this.album_name, ", duration=");
        sbM.append(this.duration);
        sbM.append(", isrc=");
        sbM.append(this.isrc);
        sbM.append(", timing_type=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.timing_type, ", lyricsUrl=", this.lyricsUrl, ")");
    }
}
