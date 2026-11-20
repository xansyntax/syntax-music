package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.sabr.SabrBootstrap;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtractedStream {
    public final String audioUrl;
    public final List availableVideoHeights;
    public final Integer bitrate;
    public final String clientName;
    public final String codecs;
    public final Long contentLengthBytes;
    public final Instant expiresAt;
    public final Map headers;
    public final int itag;
    public final Double loudnessDb;
    public ExtractedMediaMetadata mediaMetadata;
    public final String mimeType;
    public Double perceptualLoudnessDb;
    public final PlaybackTrackingData playbackTracking;
    public final String profileId;
    public final long rangeChunkSizeBytes;
    public final boolean requireBoundedRange;
    public final SabrBootstrap sabrBootstrap;
    public final SabrBootstrap sabrVideoBootstrap;
    public final Integer sampleRate;
    public final StreamDiagnostics streamDiagnostics;
    public final boolean useRangeChunks;
    public final Integer videoBitrate;
    public final String videoCodecs;
    public final Long videoContentLengthBytes;
    public final Integer videoHeight;
    public final String videoId;
    public final Integer videoItag;
    public final String videoMimeType;
    public final String videoUrl;
    public final Integer videoWidth;

    public ExtractedStream(String str, String str2, Map map, Double d, Instant instant, Long l, int i, String str3, String str4, Integer num, Integer num2, String str5, String str6, boolean z, long j, boolean z2, PlaybackTrackingData playbackTrackingData, StreamDiagnostics streamDiagnostics, String str7, Integer num3, Integer num4, String str8, String str9, Integer num5, Integer num6, Long l2, SabrBootstrap sabrBootstrap, SabrBootstrap sabrBootstrap2, List list, int i2) {
        boolean z3 = (i2 & 32768) != 0 ? false : z2;
        Integer num7 = (i2 & 524288) != 0 ? null : num3;
        Integer num8 = (i2 & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? null : num4;
        String str10 = (i2 & 2097152) != 0 ? null : str8;
        String str11 = (i2 & 4194304) != 0 ? null : str9;
        Integer num9 = (i2 & 8388608) != 0 ? null : num5;
        Integer num10 = (i2 & 16777216) != 0 ? null : num6;
        Long l3 = (i2 & 33554432) != 0 ? null : l2;
        SabrBootstrap sabrBootstrap3 = (i2 & 67108864) != 0 ? null : sabrBootstrap;
        SabrBootstrap sabrBootstrap4 = (i2 & 134217728) == 0 ? sabrBootstrap2 : null;
        List list2 = (i2 & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? EmptyList.INSTANCE : list;
        str.getClass();
        str2.getClass();
        map.getClass();
        str5.getClass();
        str6.getClass();
        list2.getClass();
        this.videoId = str;
        this.audioUrl = str2;
        this.headers = map;
        this.loudnessDb = d;
        this.expiresAt = instant;
        this.contentLengthBytes = l;
        this.itag = i;
        this.mimeType = str3;
        this.codecs = str4;
        this.bitrate = num;
        this.sampleRate = num2;
        this.clientName = str5;
        this.profileId = str6;
        this.requireBoundedRange = z;
        this.rangeChunkSizeBytes = j;
        this.useRangeChunks = z3;
        this.playbackTracking = playbackTrackingData;
        this.streamDiagnostics = streamDiagnostics;
        this.videoUrl = str7;
        this.videoWidth = num7;
        this.videoHeight = num8;
        this.videoMimeType = str10;
        this.videoCodecs = str11;
        this.videoBitrate = num9;
        this.videoItag = num10;
        this.videoContentLengthBytes = l3;
        this.sabrBootstrap = sabrBootstrap3;
        this.sabrVideoBootstrap = sabrBootstrap4;
        this.availableVideoHeights = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtractedStream)) {
            return false;
        }
        ExtractedStream extractedStream = (ExtractedStream) obj;
        return Intrinsics.areEqual(this.videoId, extractedStream.videoId) && Intrinsics.areEqual(this.audioUrl, extractedStream.audioUrl) && Intrinsics.areEqual(this.headers, extractedStream.headers) && Intrinsics.areEqual(this.loudnessDb, extractedStream.loudnessDb) && Intrinsics.areEqual(this.expiresAt, extractedStream.expiresAt) && Intrinsics.areEqual(this.contentLengthBytes, extractedStream.contentLengthBytes) && this.itag == extractedStream.itag && Intrinsics.areEqual(this.mimeType, extractedStream.mimeType) && Intrinsics.areEqual(this.codecs, extractedStream.codecs) && Intrinsics.areEqual(this.bitrate, extractedStream.bitrate) && Intrinsics.areEqual(this.sampleRate, extractedStream.sampleRate) && Intrinsics.areEqual(this.clientName, extractedStream.clientName) && Intrinsics.areEqual(this.profileId, extractedStream.profileId) && this.requireBoundedRange == extractedStream.requireBoundedRange && this.rangeChunkSizeBytes == extractedStream.rangeChunkSizeBytes && this.useRangeChunks == extractedStream.useRangeChunks && Intrinsics.areEqual(this.playbackTracking, extractedStream.playbackTracking) && this.streamDiagnostics.equals(extractedStream.streamDiagnostics) && Intrinsics.areEqual(this.videoUrl, extractedStream.videoUrl) && Intrinsics.areEqual(this.videoWidth, extractedStream.videoWidth) && Intrinsics.areEqual(this.videoHeight, extractedStream.videoHeight) && Intrinsics.areEqual(this.videoMimeType, extractedStream.videoMimeType) && Intrinsics.areEqual(this.videoCodecs, extractedStream.videoCodecs) && Intrinsics.areEqual(this.videoBitrate, extractedStream.videoBitrate) && Intrinsics.areEqual(this.videoItag, extractedStream.videoItag) && Intrinsics.areEqual(this.videoContentLengthBytes, extractedStream.videoContentLengthBytes) && Intrinsics.areEqual(this.sabrBootstrap, extractedStream.sabrBootstrap) && Intrinsics.areEqual(this.sabrVideoBootstrap, extractedStream.sabrVideoBootstrap) && this.availableVideoHeights.equals(extractedStream.availableVideoHeights);
    }

    public final int hashCode() {
        int iHashCode = (this.headers.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.videoId.hashCode() * 31, 31, this.audioUrl)) * 31;
        Double d = this.loudnessDb;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Instant instant = this.expiresAt;
        int iHashCode3 = (iHashCode2 + (instant == null ? 0 : instant.hashCode())) * 31;
        Long l = this.contentLengthBytes;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.itag, (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31, 31);
        String str = this.mimeType;
        int iHashCode4 = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.codecs;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.bitrate;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sampleRate;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31, 31, this.clientName), 31, this.profileId), this.requireBoundedRange, 31), 31, this.rangeChunkSizeBytes), this.useRangeChunks, 31);
        PlaybackTrackingData playbackTrackingData = this.playbackTracking;
        int iHashCode7 = (this.streamDiagnostics.hashCode() + ((iM2 + (playbackTrackingData == null ? 0 : playbackTrackingData.hashCode())) * 31)) * 31;
        String str3 = this.videoUrl;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.videoWidth;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.videoHeight;
        int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str4 = this.videoMimeType;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.videoCodecs;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num5 = this.videoBitrate;
        int iHashCode13 = (iHashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.videoItag;
        int iHashCode14 = (iHashCode13 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Long l2 = this.videoContentLengthBytes;
        int iHashCode15 = (iHashCode14 + (l2 == null ? 0 : l2.hashCode())) * 31;
        SabrBootstrap sabrBootstrap = this.sabrBootstrap;
        int iHashCode16 = (iHashCode15 + (sabrBootstrap == null ? 0 : sabrBootstrap.hashCode())) * 31;
        SabrBootstrap sabrBootstrap2 = this.sabrVideoBootstrap;
        return this.availableVideoHeights.hashCode() + ((iHashCode16 + (sabrBootstrap2 != null ? sabrBootstrap2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String strPresence = CollectionsKt__IterablesKt.presence(this.videoId);
        String strPresence2 = CollectionsKt__IterablesKt.presence(this.audioUrl);
        int size = this.headers.size();
        boolean z = this.mediaMetadata != null;
        String strPresence3 = CollectionsKt__IterablesKt.presence(this.videoUrl);
        boolean z2 = this.sabrBootstrap != null;
        boolean z3 = this.sabrVideoBootstrap != null;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ExtractedStream(videoId=", strPresence, ", audioUrl=", strPresence2, ", headerCount=");
        sbM.append(size);
        sbM.append(", contentLengthBytes=");
        sbM.append(this.contentLengthBytes);
        sbM.append(", itag=");
        sbM.append(this.itag);
        sbM.append(", mimeType=");
        sbM.append(this.mimeType);
        sbM.append(", clientName=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.clientName, ", profileId=", this.profileId, ", mediaMetadata=");
        sbM.append(z);
        sbM.append(", videoUrl=");
        sbM.append(strPresence3);
        sbM.append(", videoItag=");
        sbM.append(this.videoItag);
        sbM.append(", sabr=");
        sbM.append(z2);
        sbM.append(", sabrVideo=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, z3, ")");
    }
}
