package com.metrolist.innertube.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"com/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format", "", "Companion", "AudioTrack", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerResponse$StreamingData$Format {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String approxDurationMs;
    public final Integer audioChannels;
    public final String audioQuality;
    public final Integer audioSampleRate;
    public final AudioTrack audioTrack;
    public final Integer averageBitrate;
    public final int bitrate;
    public final String cipher;
    public final Long contentLength;
    public final Integer fps;
    public final Integer height;
    public final int itag;
    public final Long lastModified;
    public final Double loudnessDb;
    public final String mimeType;
    public final String quality;
    public final String qualityLabel;
    public final String signatureCipher;
    public final String url;
    public final Integer width;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format$AudioTrack;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AudioTrack {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String displayName;
        public final String id;
        public final Boolean isAutoDubbed;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format$AudioTrack$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format$AudioTrack;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AudioTrack(int i, String str, String str2, Boolean bool) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.displayName = str;
            this.id = str2;
            this.isAutoDubbed = bool;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioTrack)) {
                return false;
            }
            AudioTrack audioTrack = (AudioTrack) obj;
            return Intrinsics.areEqual(this.displayName, audioTrack.displayName) && Intrinsics.areEqual(this.id, audioTrack.id) && Intrinsics.areEqual(this.isAutoDubbed, audioTrack.isAutoDubbed);
        }

        public final int hashCode() {
            String str = this.displayName;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.id;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.isAutoDubbed;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AudioTrack(displayName=", this.displayName, ", id=", this.id, ", isAutoDubbed=");
            sbM.append(this.isAutoDubbed);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$StreamingData$Format;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerResponse$StreamingData$Format$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerResponse$StreamingData$Format(int i, int i2, String str, String str2, int i3, Integer num, Integer num2, Long l, String str3, Integer num3, String str4, Integer num4, String str5, String str6, Integer num5, Integer num6, Double d, Long l2, String str7, String str8, AudioTrack audioTrack) {
        if (1048575 != (i & 1048575)) {
            EnumsKt.throwMissingFieldException(PlayerResponse$StreamingData$Format$$serializer.INSTANCE.getDescriptor(), i, 1048575);
            throw null;
        }
        this.itag = i2;
        this.url = str;
        this.mimeType = str2;
        this.bitrate = i3;
        this.width = num;
        this.height = num2;
        this.contentLength = l;
        this.quality = str3;
        this.fps = num3;
        this.qualityLabel = str4;
        this.averageBitrate = num4;
        this.audioQuality = str5;
        this.approxDurationMs = str6;
        this.audioSampleRate = num5;
        this.audioChannels = num6;
        this.loudnessDb = d;
        this.lastModified = l2;
        this.signatureCipher = str7;
        this.cipher = str8;
        this.audioTrack = audioTrack;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponse$StreamingData$Format)) {
            return false;
        }
        PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = (PlayerResponse$StreamingData$Format) obj;
        return this.itag == playerResponse$StreamingData$Format.itag && Intrinsics.areEqual(this.url, playerResponse$StreamingData$Format.url) && Intrinsics.areEqual(this.mimeType, playerResponse$StreamingData$Format.mimeType) && this.bitrate == playerResponse$StreamingData$Format.bitrate && Intrinsics.areEqual(this.width, playerResponse$StreamingData$Format.width) && Intrinsics.areEqual(this.height, playerResponse$StreamingData$Format.height) && Intrinsics.areEqual(this.contentLength, playerResponse$StreamingData$Format.contentLength) && Intrinsics.areEqual(this.quality, playerResponse$StreamingData$Format.quality) && Intrinsics.areEqual(this.fps, playerResponse$StreamingData$Format.fps) && Intrinsics.areEqual(this.qualityLabel, playerResponse$StreamingData$Format.qualityLabel) && Intrinsics.areEqual(this.averageBitrate, playerResponse$StreamingData$Format.averageBitrate) && Intrinsics.areEqual(this.audioQuality, playerResponse$StreamingData$Format.audioQuality) && Intrinsics.areEqual(this.approxDurationMs, playerResponse$StreamingData$Format.approxDurationMs) && Intrinsics.areEqual(this.audioSampleRate, playerResponse$StreamingData$Format.audioSampleRate) && Intrinsics.areEqual(this.audioChannels, playerResponse$StreamingData$Format.audioChannels) && Intrinsics.areEqual(this.loudnessDb, playerResponse$StreamingData$Format.loudnessDb) && Intrinsics.areEqual(this.lastModified, playerResponse$StreamingData$Format.lastModified) && Intrinsics.areEqual(this.signatureCipher, playerResponse$StreamingData$Format.signatureCipher) && Intrinsics.areEqual(this.cipher, playerResponse$StreamingData$Format.cipher) && Intrinsics.areEqual(this.audioTrack, playerResponse$StreamingData$Format.audioTrack);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.itag) * 31;
        String str = this.url;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.bitrate, Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.mimeType), 31);
        Integer num = this.width;
        int iHashCode2 = (iM + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.contentLength;
        int iM2 = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode3 + (l == null ? 0 : l.hashCode())) * 31, 31, this.quality);
        Integer num3 = this.fps;
        int iHashCode4 = (iM2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.qualityLabel;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num4 = this.averageBitrate;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str3 = this.audioQuality;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.approxDurationMs;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num5 = this.audioSampleRate;
        int iHashCode9 = (iHashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.audioChannels;
        int iHashCode10 = (iHashCode9 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Double d = this.loudnessDb;
        int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
        Long l2 = this.lastModified;
        int iHashCode12 = (iHashCode11 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str5 = this.signatureCipher;
        int iHashCode13 = (iHashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cipher;
        int iHashCode14 = (iHashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        AudioTrack audioTrack = this.audioTrack;
        return iHashCode14 + (audioTrack != null ? audioTrack.hashCode() : 0);
    }

    public final String toString() {
        return "Format(itag=" + this.itag + ", url=" + this.url + ", mimeType=" + this.mimeType + ", bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", contentLength=" + this.contentLength + ", quality=" + this.quality + ", fps=" + this.fps + ", qualityLabel=" + this.qualityLabel + ", averageBitrate=" + this.averageBitrate + ", audioQuality=" + this.audioQuality + ", approxDurationMs=" + this.approxDurationMs + ", audioSampleRate=" + this.audioSampleRate + ", audioChannels=" + this.audioChannels + ", loudnessDb=" + this.loudnessDb + ", lastModified=" + this.lastModified + ", signatureCipher=" + this.signatureCipher + ", cipher=" + this.cipher + ", audioTrack=" + this.audioTrack + ")";
    }

    public PlayerResponse$StreamingData$Format(int i, String str, String str2, int i2, Long l, Integer num, String str3, Integer num2, Double d) {
        this.itag = i;
        this.url = str;
        this.mimeType = str2;
        this.bitrate = i2;
        this.width = null;
        this.height = null;
        this.contentLength = l;
        this.quality = "";
        this.fps = null;
        this.qualityLabel = null;
        this.averageBitrate = num;
        this.audioQuality = null;
        this.approxDurationMs = str3;
        this.audioSampleRate = num2;
        this.audioChannels = null;
        this.loudnessDb = d;
        this.lastModified = null;
        this.signatureCipher = null;
        this.cipher = null;
        this.audioTrack = null;
    }
}
