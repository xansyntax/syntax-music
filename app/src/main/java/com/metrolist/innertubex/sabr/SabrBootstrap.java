package com.metrolist.innertubex.sabr;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.Arrays;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SabrBootstrap {
    public final SabrFormatId audioFormat;
    public final String audioTrackId;
    public final int clientName;
    public final String clientVersion;
    public final Long contentLengthBytes;
    public final SabrFormatId discardVideoFormat;
    public final int discardVideoHeight;
    public final long durationMs;
    public final boolean isDrc;
    public final String mimeType;
    public final byte[] poToken;
    public final String requestOrigin;
    public final String requestUserAgent;
    public final Integer selectedVideoBitrate;
    public final Long selectedVideoContentLengthBytes;
    public final SabrFormatId selectedVideoFormat;
    public final Integer selectedVideoHeight;
    public final String selectedVideoMimeType;
    public final Integer selectedVideoWidth;
    public final String serverAbrStreamingUrl;
    public final String videoId;
    public final byte[] videoPlaybackUstreamerConfig;

    public SabrBootstrap(String str, String str2, byte[] bArr, int i, String str3, SabrFormatId sabrFormatId, SabrFormatId sabrFormatId2, int i2, SabrFormatId sabrFormatId3, Integer num, Integer num2, Long l, String str4, Integer num3, long j, Long l2, String str5, String str6, boolean z, byte[] bArr2, String str7, String str8) {
        str5.getClass();
        this.videoId = str;
        this.serverAbrStreamingUrl = str2;
        this.videoPlaybackUstreamerConfig = bArr;
        this.clientName = i;
        this.clientVersion = str3;
        this.audioFormat = sabrFormatId;
        this.discardVideoFormat = sabrFormatId2;
        this.discardVideoHeight = i2;
        this.selectedVideoFormat = sabrFormatId3;
        this.selectedVideoWidth = num;
        this.selectedVideoHeight = num2;
        this.selectedVideoContentLengthBytes = l;
        this.selectedVideoMimeType = str4;
        this.selectedVideoBitrate = num3;
        this.durationMs = j;
        this.contentLengthBytes = l2;
        this.mimeType = str5;
        this.audioTrackId = str6;
        this.isDrc = z;
        this.poToken = bArr2;
        this.requestUserAgent = str7;
        this.requestOrigin = str8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SabrBootstrap)) {
            return false;
        }
        SabrBootstrap sabrBootstrap = (SabrBootstrap) obj;
        if (!this.videoId.equals(sabrBootstrap.videoId) || !this.serverAbrStreamingUrl.equals(sabrBootstrap.serverAbrStreamingUrl) || !Arrays.equals(this.videoPlaybackUstreamerConfig, sabrBootstrap.videoPlaybackUstreamerConfig) || this.clientName != sabrBootstrap.clientName || !this.clientVersion.equals(sabrBootstrap.clientVersion) || !this.audioFormat.equals(sabrBootstrap.audioFormat) || !this.discardVideoFormat.equals(sabrBootstrap.discardVideoFormat) || this.discardVideoHeight != sabrBootstrap.discardVideoHeight || !Intrinsics.areEqual(this.selectedVideoFormat, sabrBootstrap.selectedVideoFormat) || !Intrinsics.areEqual(this.selectedVideoWidth, sabrBootstrap.selectedVideoWidth) || !Intrinsics.areEqual(this.selectedVideoHeight, sabrBootstrap.selectedVideoHeight) || !Intrinsics.areEqual(this.selectedVideoContentLengthBytes, sabrBootstrap.selectedVideoContentLengthBytes) || !Intrinsics.areEqual(this.selectedVideoMimeType, sabrBootstrap.selectedVideoMimeType) || !Intrinsics.areEqual(this.selectedVideoBitrate, sabrBootstrap.selectedVideoBitrate) || this.durationMs != sabrBootstrap.durationMs || !Intrinsics.areEqual(this.contentLengthBytes, sabrBootstrap.contentLengthBytes) || !Intrinsics.areEqual(this.mimeType, sabrBootstrap.mimeType) || !Intrinsics.areEqual(this.audioTrackId, sabrBootstrap.audioTrackId) || this.isDrc != sabrBootstrap.isDrc || !Intrinsics.areEqual(this.requestUserAgent, sabrBootstrap.requestUserAgent) || !Intrinsics.areEqual(this.requestOrigin, sabrBootstrap.requestOrigin)) {
            return false;
        }
        byte[] bArr = sabrBootstrap.poToken;
        byte[] bArr2 = this.poToken;
        if (bArr2 == null) {
            return bArr == null;
        }
        return bArr != null && Arrays.equals(bArr2, bArr);
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(Arrays.hashCode(this.videoPlaybackUstreamerConfig));
        Integer numValueOf2 = Integer.valueOf(this.clientName);
        Integer numValueOf3 = Integer.valueOf(this.discardVideoHeight);
        Long lValueOf = Long.valueOf(this.durationMs);
        Boolean boolValueOf = Boolean.valueOf(this.isDrc);
        byte[] bArr = this.poToken;
        return CollectionsKt__IterablesKt.listOf(this.serverAbrStreamingUrl, numValueOf, numValueOf2, this.clientVersion, this.audioFormat, this.discardVideoFormat, numValueOf3, this.selectedVideoFormat, this.selectedVideoWidth, this.selectedVideoHeight, this.selectedVideoContentLengthBytes, this.selectedVideoMimeType, this.selectedVideoBitrate, lValueOf, this.contentLengthBytes, this.mimeType, this.audioTrackId, boolValueOf, bArr != null ? Integer.valueOf(Arrays.hashCode(bArr)) : null, this.requestUserAgent, this.requestOrigin).hashCode();
    }

    public final String toString() {
        String string = Arrays.toString(this.videoPlaybackUstreamerConfig);
        String string2 = Arrays.toString(this.poToken);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SabrBootstrap(videoId=", this.videoId, ", serverAbrStreamingUrl=", this.serverAbrStreamingUrl, ", videoPlaybackUstreamerConfig=");
        sbM.append(string);
        sbM.append(", clientName=");
        sbM.append(this.clientName);
        sbM.append(", clientVersion=");
        sbM.append(this.clientVersion);
        sbM.append(", audioFormat=");
        sbM.append(this.audioFormat);
        sbM.append(", discardVideoFormat=");
        sbM.append(this.discardVideoFormat);
        sbM.append(", discardVideoHeight=");
        sbM.append(this.discardVideoHeight);
        sbM.append(", selectedVideoFormat=");
        sbM.append(this.selectedVideoFormat);
        sbM.append(", selectedVideoWidth=");
        sbM.append(this.selectedVideoWidth);
        sbM.append(", selectedVideoHeight=");
        sbM.append(this.selectedVideoHeight);
        sbM.append(", selectedVideoContentLengthBytes=");
        sbM.append(this.selectedVideoContentLengthBytes);
        sbM.append(", selectedVideoMimeType=");
        sbM.append(this.selectedVideoMimeType);
        sbM.append(", selectedVideoBitrate=");
        sbM.append(this.selectedVideoBitrate);
        sbM.append(", durationMs=");
        sbM.append(this.durationMs);
        sbM.append(", contentLengthBytes=");
        sbM.append(this.contentLengthBytes);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, ", mimeType=", this.mimeType, ", audioTrackId=", this.audioTrackId);
        sbM.append(", isDrc=");
        sbM.append(this.isDrc);
        sbM.append(", poToken=");
        sbM.append(string2);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, ", requestUserAgent=", this.requestUserAgent, ", requestOrigin=", this.requestOrigin);
        sbM.append(")");
        return sbM.toString();
    }
}
