package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FormatEntity {
    public final int bitrate;
    public final String codecs;
    public final long contentLength;
    public final String id;
    public final int itag;
    public final Double loudnessDb;
    public final String mimeType;
    public final Double perceptualLoudnessDb;
    public final String playbackUrl;
    public final Integer sampleRate;

    public FormatEntity(String str, int i, String str2, String str3, int i2, Integer num, long j, Double d, Double d2, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.id = str;
        this.itag = i;
        this.mimeType = str2;
        this.codecs = str3;
        this.bitrate = i2;
        this.sampleRate = num;
        this.contentLength = j;
        this.loudnessDb = d;
        this.perceptualLoudnessDb = d2;
        this.playbackUrl = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatEntity)) {
            return false;
        }
        FormatEntity formatEntity = (FormatEntity) obj;
        return Intrinsics.areEqual(this.id, formatEntity.id) && this.itag == formatEntity.itag && Intrinsics.areEqual(this.mimeType, formatEntity.mimeType) && Intrinsics.areEqual(this.codecs, formatEntity.codecs) && this.bitrate == formatEntity.bitrate && Intrinsics.areEqual(this.sampleRate, formatEntity.sampleRate) && this.contentLength == formatEntity.contentLength && Intrinsics.areEqual(this.loudnessDb, formatEntity.loudnessDb) && Intrinsics.areEqual(this.perceptualLoudnessDb, formatEntity.perceptualLoudnessDb) && Intrinsics.areEqual(this.playbackUrl, formatEntity.playbackUrl);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.bitrate, Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.itag, this.id.hashCode() * 31, 31), 31, this.mimeType), 31, this.codecs), 31);
        Integer num = this.sampleRate;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iM + (num == null ? 0 : num.hashCode())) * 31, 31, this.contentLength);
        Double d = this.loudnessDb;
        int iHashCode = (iM2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.perceptualLoudnessDb;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str = this.playbackUrl;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FormatEntity(id=");
        sb.append(this.id);
        sb.append(", itag=");
        sb.append(this.itag);
        sb.append(", mimeType=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.mimeType, ", codecs=", this.codecs, ", bitrate=");
        sb.append(this.bitrate);
        sb.append(", sampleRate=");
        sb.append(this.sampleRate);
        sb.append(", contentLength=");
        sb.append(this.contentLength);
        sb.append(", loudnessDb=");
        sb.append(this.loudnessDb);
        sb.append(", perceptualLoudnessDb=");
        sb.append(this.perceptualLoudnessDb);
        sb.append(", playbackUrl=");
        sb.append(this.playbackUrl);
        sb.append(")");
        return sb.toString();
    }
}
