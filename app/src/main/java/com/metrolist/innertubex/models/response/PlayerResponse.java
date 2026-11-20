package com.metrolist.innertubex.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Thumbnails;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\u0002¨\u0006\t"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse;", "", "Companion", "PlayabilityStatus", "StreamingData", "PlayerConfig", "VideoDetails", "PlaybackTracking", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final PlayabilityStatus playabilityStatus;
    public final PlaybackTracking playbackTracking;
    public final PlayerConfig playerConfig;
    public final StreamingData streamingData;
    public final VideoDetails videoDetails;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayabilityStatus;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlayabilityStatus {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String reason;
        public final String status;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayabilityStatus$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayabilityStatus;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlayabilityStatus$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PlayabilityStatus(int i, String str, String str2) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(PlayerResponse$PlayabilityStatus$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.status = str;
            if ((i & 2) == 0) {
                this.reason = null;
            } else {
                this.reason = str2;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlayabilityStatus)) {
                return false;
            }
            PlayabilityStatus playabilityStatus = (PlayabilityStatus) obj;
            return Intrinsics.areEqual(this.status, playabilityStatus.status) && Intrinsics.areEqual(this.reason, playabilityStatus.reason);
        }

        public final int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            String str = this.reason;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("PlayabilityStatus(status=", this.status, ", reason=", this.reason, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking;", "", "Companion", "VideostatsUrl", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlaybackTracking {
        public final VideostatsUrl atrUrl;
        public final Integer videostatsDefaultFlushIntervalSeconds;
        public final VideostatsUrl videostatsPlaybackUrl;
        public final List videostatsScheduledFlushWalltimeSeconds;
        public final VideostatsUrl videostatsWatchtimeUrl;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1(10)), null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlaybackTracking$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking$VideostatsUrl;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class VideostatsUrl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String baseUrl;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking$VideostatsUrl$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlaybackTracking$VideostatsUrl;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ VideostatsUrl(int i, String str) {
                if (1 == (i & 1)) {
                    this.baseUrl = str;
                } else {
                    EnumsKt.throwMissingFieldException(PlayerResponse$PlaybackTracking$VideostatsUrl$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof VideostatsUrl) && Intrinsics.areEqual(this.baseUrl, ((VideostatsUrl) obj).baseUrl);
            }

            public final int hashCode() {
                return this.baseUrl.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("VideostatsUrl(baseUrl=", this.baseUrl, ")");
            }
        }

        public /* synthetic */ PlaybackTracking(int i, VideostatsUrl videostatsUrl, VideostatsUrl videostatsUrl2, VideostatsUrl videostatsUrl3, List list, Integer num) {
            if ((i & 1) == 0) {
                this.videostatsPlaybackUrl = null;
            } else {
                this.videostatsPlaybackUrl = videostatsUrl;
            }
            if ((i & 2) == 0) {
                this.videostatsWatchtimeUrl = null;
            } else {
                this.videostatsWatchtimeUrl = videostatsUrl2;
            }
            if ((i & 4) == 0) {
                this.atrUrl = null;
            } else {
                this.atrUrl = videostatsUrl3;
            }
            if ((i & 8) == 0) {
                this.videostatsScheduledFlushWalltimeSeconds = null;
            } else {
                this.videostatsScheduledFlushWalltimeSeconds = list;
            }
            if ((i & 16) == 0) {
                this.videostatsDefaultFlushIntervalSeconds = null;
            } else {
                this.videostatsDefaultFlushIntervalSeconds = num;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackTracking)) {
                return false;
            }
            PlaybackTracking playbackTracking = (PlaybackTracking) obj;
            return Intrinsics.areEqual(this.videostatsPlaybackUrl, playbackTracking.videostatsPlaybackUrl) && Intrinsics.areEqual(this.videostatsWatchtimeUrl, playbackTracking.videostatsWatchtimeUrl) && Intrinsics.areEqual(this.atrUrl, playbackTracking.atrUrl) && Intrinsics.areEqual(this.videostatsScheduledFlushWalltimeSeconds, playbackTracking.videostatsScheduledFlushWalltimeSeconds) && Intrinsics.areEqual(this.videostatsDefaultFlushIntervalSeconds, playbackTracking.videostatsDefaultFlushIntervalSeconds);
        }

        public final int hashCode() {
            VideostatsUrl videostatsUrl = this.videostatsPlaybackUrl;
            int iHashCode = (videostatsUrl == null ? 0 : videostatsUrl.baseUrl.hashCode()) * 31;
            VideostatsUrl videostatsUrl2 = this.videostatsWatchtimeUrl;
            int iHashCode2 = (iHashCode + (videostatsUrl2 == null ? 0 : videostatsUrl2.baseUrl.hashCode())) * 31;
            VideostatsUrl videostatsUrl3 = this.atrUrl;
            int iHashCode3 = (iHashCode2 + (videostatsUrl3 == null ? 0 : videostatsUrl3.baseUrl.hashCode())) * 31;
            List list = this.videostatsScheduledFlushWalltimeSeconds;
            int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            Integer num = this.videostatsDefaultFlushIntervalSeconds;
            return iHashCode4 + (num != null ? num.hashCode() : 0);
        }

        public final String toString() {
            return "PlaybackTracking(videostatsPlaybackUrl=" + this.videostatsPlaybackUrl + ", videostatsWatchtimeUrl=" + this.videostatsWatchtimeUrl + ", atrUrl=" + this.atrUrl + ", videostatsScheduledFlushWalltimeSeconds=" + this.videostatsScheduledFlushWalltimeSeconds + ", videostatsDefaultFlushIntervalSeconds=" + this.videostatsDefaultFlushIntervalSeconds + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig;", "", "Companion", "AudioConfig", "MediaCommonConfig", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlayerConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final AudioConfig audioConfig;
        public final MediaCommonConfig mediaCommonConfig;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$AudioConfig;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class AudioConfig {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Double loudnessDb;
            public final Double perceptualLoudnessDb;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$AudioConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$AudioConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return PlayerResponse$PlayerConfig$AudioConfig$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ AudioConfig(int i, Double d, Double d2) {
                if ((i & 1) == 0) {
                    this.loudnessDb = null;
                } else {
                    this.loudnessDb = d;
                }
                if ((i & 2) == 0) {
                    this.perceptualLoudnessDb = null;
                } else {
                    this.perceptualLoudnessDb = d2;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AudioConfig)) {
                    return false;
                }
                AudioConfig audioConfig = (AudioConfig) obj;
                return Intrinsics.areEqual(this.loudnessDb, audioConfig.loudnessDb) && Intrinsics.areEqual(this.perceptualLoudnessDb, audioConfig.perceptualLoudnessDb);
            }

            public final int hashCode() {
                Double d = this.loudnessDb;
                int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
                Double d2 = this.perceptualLoudnessDb;
                return iHashCode + (d2 != null ? d2.hashCode() : 0);
            }

            public final String toString() {
                return "AudioConfig(loudnessDb=" + this.loudnessDb + ", perceptualLoudnessDb=" + this.perceptualLoudnessDb + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlayerConfig$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig;", "", "Companion", "MediaUstreamerRequestConfig", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MediaCommonConfig {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final MediaUstreamerRequestConfig mediaUstreamerRequestConfig;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return PlayerResponse$PlayerConfig$MediaCommonConfig$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class MediaUstreamerRequestConfig {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final String videoPlaybackUstreamerConfig;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return PlayerResponse$PlayerConfig$MediaCommonConfig$MediaUstreamerRequestConfig$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ MediaUstreamerRequestConfig(int i, String str) {
                    if ((i & 1) == 0) {
                        this.videoPlaybackUstreamerConfig = null;
                    } else {
                        this.videoPlaybackUstreamerConfig = str;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof MediaUstreamerRequestConfig) && Intrinsics.areEqual(this.videoPlaybackUstreamerConfig, ((MediaUstreamerRequestConfig) obj).videoPlaybackUstreamerConfig);
                }

                public final int hashCode() {
                    String str = this.videoPlaybackUstreamerConfig;
                    if (str == null) {
                        return 0;
                    }
                    return str.hashCode();
                }

                public final String toString() {
                    return IntIntPair$$ExternalSyntheticOutline0.m("MediaUstreamerRequestConfig(videoPlaybackUstreamerConfig=", this.videoPlaybackUstreamerConfig, ")");
                }
            }

            public /* synthetic */ MediaCommonConfig(int i, MediaUstreamerRequestConfig mediaUstreamerRequestConfig) {
                if ((i & 1) == 0) {
                    this.mediaUstreamerRequestConfig = null;
                } else {
                    this.mediaUstreamerRequestConfig = mediaUstreamerRequestConfig;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MediaCommonConfig) && Intrinsics.areEqual(this.mediaUstreamerRequestConfig, ((MediaCommonConfig) obj).mediaUstreamerRequestConfig);
            }

            public final int hashCode() {
                MediaUstreamerRequestConfig mediaUstreamerRequestConfig = this.mediaUstreamerRequestConfig;
                if (mediaUstreamerRequestConfig == null) {
                    return 0;
                }
                return mediaUstreamerRequestConfig.hashCode();
            }

            public final String toString() {
                return "MediaCommonConfig(mediaUstreamerRequestConfig=" + this.mediaUstreamerRequestConfig + ")";
            }
        }

        public /* synthetic */ PlayerConfig(int i, MediaCommonConfig mediaCommonConfig, AudioConfig audioConfig) {
            if ((i & 1) == 0) {
                this.mediaCommonConfig = null;
            } else {
                this.mediaCommonConfig = mediaCommonConfig;
            }
            if ((i & 2) == 0) {
                this.audioConfig = null;
            } else {
                this.audioConfig = audioConfig;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlayerConfig) && Intrinsics.areEqual(this.mediaCommonConfig, ((PlayerConfig) obj).mediaCommonConfig);
        }

        public final int hashCode() {
            MediaCommonConfig mediaCommonConfig = this.mediaCommonConfig;
            if (mediaCommonConfig == null) {
                return 0;
            }
            return mediaCommonConfig.hashCode();
        }

        public final String toString() {
            return "PlayerConfig(mediaCommonConfig=" + this.mediaCommonConfig + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$VideoDetails;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class VideoDetails {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String author;
        public final String channelId;
        public final Boolean isLiveContent;
        public final String lengthSeconds;
        public final String musicVideoType;
        public final Thumbnails thumbnail;
        public final String title;
        public final String videoId;
        public final String viewCount;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$VideoDetails$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$VideoDetails;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$VideoDetails$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ VideoDetails(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Thumbnails thumbnails, Boolean bool) {
            this.videoId = (i & 1) == 0 ? "" : str;
            if ((i & 2) == 0) {
                this.title = null;
            } else {
                this.title = str2;
            }
            if ((i & 4) == 0) {
                this.author = null;
            } else {
                this.author = str3;
            }
            if ((i & 8) == 0) {
                this.channelId = null;
            } else {
                this.channelId = str4;
            }
            if ((i & 16) == 0) {
                this.lengthSeconds = null;
            } else {
                this.lengthSeconds = str5;
            }
            if ((i & 32) == 0) {
                this.musicVideoType = null;
            } else {
                this.musicVideoType = str6;
            }
            if ((i & 64) == 0) {
                this.viewCount = null;
            } else {
                this.viewCount = str7;
            }
            if ((i & 128) == 0) {
                this.thumbnail = null;
            } else {
                this.thumbnail = thumbnails;
            }
            if ((i & 256) == 0) {
                this.isLiveContent = null;
            } else {
                this.isLiveContent = bool;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VideoDetails)) {
                return false;
            }
            VideoDetails videoDetails = (VideoDetails) obj;
            return Intrinsics.areEqual(this.videoId, videoDetails.videoId) && Intrinsics.areEqual(this.title, videoDetails.title) && Intrinsics.areEqual(this.author, videoDetails.author) && Intrinsics.areEqual(this.channelId, videoDetails.channelId) && Intrinsics.areEqual(this.lengthSeconds, videoDetails.lengthSeconds) && Intrinsics.areEqual(this.musicVideoType, videoDetails.musicVideoType) && Intrinsics.areEqual(this.viewCount, videoDetails.viewCount) && Intrinsics.areEqual(this.thumbnail, videoDetails.thumbnail) && Intrinsics.areEqual(this.isLiveContent, videoDetails.isLiveContent);
        }

        public final int hashCode() {
            int iHashCode = this.videoId.hashCode() * 31;
            String str = this.title;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.author;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.channelId;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.lengthSeconds;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.musicVideoType;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.viewCount;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Thumbnails thumbnails = this.thumbnail;
            int iHashCode8 = (iHashCode7 + (thumbnails == null ? 0 : thumbnails.thumbnails.hashCode())) * 31;
            Boolean bool = this.isLiveContent;
            return iHashCode8 + (bool != null ? bool.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("VideoDetails(videoId=", this.videoId, ", title=", this.title, ", author=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.author, ", channelId=", this.channelId, ", lengthSeconds=");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.lengthSeconds, ", musicVideoType=", this.musicVideoType, ", viewCount=");
            sbM.append(this.viewCount);
            sbM.append(", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", isLiveContent=");
            sbM.append(this.isLiveContent);
            sbM.append(")");
            return sbM.toString();
        }
    }

    public /* synthetic */ PlayerResponse(int i, PlayabilityStatus playabilityStatus, StreamingData streamingData, VideoDetails videoDetails, PlaybackTracking playbackTracking, PlayerConfig playerConfig) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(PlayerResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.playabilityStatus = playabilityStatus;
        if ((i & 2) == 0) {
            this.streamingData = null;
        } else {
            this.streamingData = streamingData;
        }
        if ((i & 4) == 0) {
            this.videoDetails = null;
        } else {
            this.videoDetails = videoDetails;
        }
        if ((i & 8) == 0) {
            this.playbackTracking = null;
        } else {
            this.playbackTracking = playbackTracking;
        }
        if ((i & 16) == 0) {
            this.playerConfig = null;
        } else {
            this.playerConfig = playerConfig;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponse)) {
            return false;
        }
        PlayerResponse playerResponse = (PlayerResponse) obj;
        return Intrinsics.areEqual(this.playabilityStatus, playerResponse.playabilityStatus) && Intrinsics.areEqual(this.streamingData, playerResponse.streamingData) && Intrinsics.areEqual(this.videoDetails, playerResponse.videoDetails) && Intrinsics.areEqual(this.playbackTracking, playerResponse.playbackTracking) && Intrinsics.areEqual(this.playerConfig, playerResponse.playerConfig);
    }

    public final int hashCode() {
        int iHashCode = this.playabilityStatus.hashCode() * 31;
        StreamingData streamingData = this.streamingData;
        int iHashCode2 = (iHashCode + (streamingData == null ? 0 : streamingData.hashCode())) * 31;
        VideoDetails videoDetails = this.videoDetails;
        int iHashCode3 = (iHashCode2 + (videoDetails == null ? 0 : videoDetails.hashCode())) * 31;
        PlaybackTracking playbackTracking = this.playbackTracking;
        int iHashCode4 = (iHashCode3 + (playbackTracking == null ? 0 : playbackTracking.hashCode())) * 31;
        PlayerConfig playerConfig = this.playerConfig;
        return iHashCode4 + (playerConfig != null ? playerConfig.hashCode() : 0);
    }

    public final String toString() {
        return "PlayerResponse(playabilityStatus=" + this.playabilityStatus + ", streamingData=" + this.streamingData + ", videoDetails=" + this.videoDetails + ", playbackTracking=" + this.playbackTracking + ", playerConfig=" + this.playerConfig + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData;", "", "Companion", "Format", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class StreamingData {
        public static final Lazy[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final List adaptiveFormats;
        public final String dashManifestUrl;
        public final Integer expiresInSeconds;
        public final List formats;
        public final String hlsManifestUrl;
        public final String serverAbrStreamingUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$StreamingData$$serializer.INSTANCE;
            }
        }

        static {
            LastFM$$ExternalSyntheticLambda1 lastFM$$ExternalSyntheticLambda1 = new LastFM$$ExternalSyntheticLambda1((byte) 11);
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, lastFM$$ExternalSyntheticLambda1), ResultKt.lazy(lazyThreadSafetyMode, new LastFM$$ExternalSyntheticLambda1((byte) 12)), null, null, null, null};
        }

        public /* synthetic */ StreamingData(int i, List list, List list2, Integer num, String str, String str2, String str3) {
            if ((i & 1) == 0) {
                this.formats = null;
            } else {
                this.formats = list;
            }
            if ((i & 2) == 0) {
                this.adaptiveFormats = EmptyList.INSTANCE;
            } else {
                this.adaptiveFormats = list2;
            }
            if ((i & 4) == 0) {
                this.expiresInSeconds = null;
            } else {
                this.expiresInSeconds = num;
            }
            if ((i & 8) == 0) {
                this.hlsManifestUrl = null;
            } else {
                this.hlsManifestUrl = str;
            }
            if ((i & 16) == 0) {
                this.dashManifestUrl = null;
            } else {
                this.dashManifestUrl = str2;
            }
            if ((i & 32) == 0) {
                this.serverAbrStreamingUrl = null;
            } else {
                this.serverAbrStreamingUrl = str3;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StreamingData)) {
                return false;
            }
            StreamingData streamingData = (StreamingData) obj;
            return Intrinsics.areEqual(this.formats, streamingData.formats) && Intrinsics.areEqual(this.adaptiveFormats, streamingData.adaptiveFormats) && Intrinsics.areEqual(this.expiresInSeconds, streamingData.expiresInSeconds) && Intrinsics.areEqual(this.hlsManifestUrl, streamingData.hlsManifestUrl) && Intrinsics.areEqual(this.dashManifestUrl, streamingData.dashManifestUrl) && Intrinsics.areEqual(this.serverAbrStreamingUrl, streamingData.serverAbrStreamingUrl);
        }

        public final int hashCode() {
            List list = this.formats;
            int iM = Fragment$5$$ExternalSyntheticOutline0.m((list == null ? 0 : list.hashCode()) * 31, 31, this.adaptiveFormats);
            Integer num = this.expiresInSeconds;
            int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.hlsManifestUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.dashManifestUrl;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.serverAbrStreamingUrl;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("StreamingData(formats=");
            sb.append(this.formats);
            sb.append(", adaptiveFormats=");
            sb.append(this.adaptiveFormats);
            sb.append(", expiresInSeconds=");
            sb.append(this.expiresInSeconds);
            sb.append(", hlsManifestUrl=");
            sb.append(this.hlsManifestUrl);
            sb.append(", dashManifestUrl=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.dashManifestUrl, ", serverAbrStreamingUrl=", this.serverAbrStreamingUrl, ")");
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format;", "", "Companion", "AudioTrack", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Format {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String approxDurationMs;
            public final Integer audioChannels;
            public final String audioQuality;
            public final Integer audioSampleRate;
            public final AudioTrack audioTrack;
            public final int bitrate;
            public final String cipher;
            public final Long contentLength;
            public final Integer height;
            public final boolean isDrc;
            public final int itag;
            public final String lastModified;
            public final Double loudnessDb;
            public final String mimeType;
            public final String quality;
            public final String signatureCipher;
            public final String url;
            public final Integer width;
            public final String xtags;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format$AudioTrack;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class AudioTrack {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final Boolean audioIsDefault;
                public final String displayName;
                public final String id;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format$AudioTrack$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format$AudioTrack;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ AudioTrack(int i, String str, String str2, Boolean bool) {
                    if ((i & 1) == 0) {
                        this.id = null;
                    } else {
                        this.id = str;
                    }
                    if ((i & 2) == 0) {
                        this.displayName = null;
                    } else {
                        this.displayName = str2;
                    }
                    if ((i & 4) == 0) {
                        this.audioIsDefault = null;
                    } else {
                        this.audioIsDefault = bool;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof AudioTrack)) {
                        return false;
                    }
                    AudioTrack audioTrack = (AudioTrack) obj;
                    return Intrinsics.areEqual(this.id, audioTrack.id) && Intrinsics.areEqual(this.displayName, audioTrack.displayName) && Intrinsics.areEqual(this.audioIsDefault, audioTrack.audioIsDefault);
                }

                public final int hashCode() {
                    String str = this.id;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.displayName;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    Boolean bool = this.audioIsDefault;
                    return iHashCode2 + (bool != null ? bool.hashCode() : 0);
                }

                public final String toString() {
                    StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AudioTrack(id=", this.id, ", displayName=", this.displayName, ", audioIsDefault=");
                    sbM.append(this.audioIsDefault);
                    sbM.append(")");
                    return sbM.toString();
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/response/PlayerResponse$StreamingData$Format;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return PlayerResponse$StreamingData$Format$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Format(int i, int i2, String str, String str2, int i3, Integer num, Integer num2, Long l, String str3, String str4, String str5, Integer num3, Integer num4, Double d, String str6, String str7, AudioTrack audioTrack, boolean z, String str8, String str9) {
                this.itag = (i & 1) == 0 ? -1 : i2;
                if ((i & 2) == 0) {
                    this.url = null;
                } else {
                    this.url = str;
                }
                if ((i & 4) == 0) {
                    this.mimeType = "";
                } else {
                    this.mimeType = str2;
                }
                if ((i & 8) == 0) {
                    this.bitrate = 0;
                } else {
                    this.bitrate = i3;
                }
                if ((i & 16) == 0) {
                    this.width = null;
                } else {
                    this.width = num;
                }
                if ((i & 32) == 0) {
                    this.height = null;
                } else {
                    this.height = num2;
                }
                if ((i & 64) == 0) {
                    this.contentLength = null;
                } else {
                    this.contentLength = l;
                }
                if ((i & 128) == 0) {
                    this.quality = null;
                } else {
                    this.quality = str3;
                }
                if ((i & 256) == 0) {
                    this.audioQuality = null;
                } else {
                    this.audioQuality = str4;
                }
                if ((i & 512) == 0) {
                    this.approxDurationMs = null;
                } else {
                    this.approxDurationMs = str5;
                }
                if ((i & 1024) == 0) {
                    this.audioSampleRate = null;
                } else {
                    this.audioSampleRate = num3;
                }
                if ((i & 2048) == 0) {
                    this.audioChannels = null;
                } else {
                    this.audioChannels = num4;
                }
                if ((i & 4096) == 0) {
                    this.loudnessDb = null;
                } else {
                    this.loudnessDb = d;
                }
                if ((i & 8192) == 0) {
                    this.lastModified = null;
                } else {
                    this.lastModified = str6;
                }
                if ((i & 16384) == 0) {
                    this.xtags = null;
                } else {
                    this.xtags = str7;
                }
                if ((32768 & i) == 0) {
                    this.audioTrack = null;
                } else {
                    this.audioTrack = audioTrack;
                }
                if ((65536 & i) == 0) {
                    this.isDrc = false;
                } else {
                    this.isDrc = z;
                }
                if ((131072 & i) == 0) {
                    this.signatureCipher = null;
                } else {
                    this.signatureCipher = str8;
                }
                if ((i & 262144) == 0) {
                    this.cipher = null;
                } else {
                    this.cipher = str9;
                }
            }

            public static Format copy$default(Format format, String str, int i) {
                int i2 = format.itag;
                String str2 = format.mimeType;
                int i3 = format.bitrate;
                Integer num = format.width;
                Integer num2 = format.height;
                Long l = format.contentLength;
                String str3 = format.quality;
                String str4 = format.audioQuality;
                String str5 = format.approxDurationMs;
                Integer num3 = format.audioSampleRate;
                Integer num4 = format.audioChannels;
                Double d = format.loudnessDb;
                String str6 = format.lastModified;
                String str7 = format.xtags;
                AudioTrack audioTrack = format.audioTrack;
                boolean z = format.isDrc;
                String str8 = null;
                String str9 = (i & 131072) != 0 ? format.signatureCipher : null;
                if ((i & 262144) != 0) {
                    str8 = format.cipher;
                }
                format.getClass();
                str2.getClass();
                return new Format(i2, str, str2, i3, num, num2, l, str3, str4, str5, num3, num4, d, str6, str7, audioTrack, z, str9, str8);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Format)) {
                    return false;
                }
                Format format = (Format) obj;
                return this.itag == format.itag && Intrinsics.areEqual(this.url, format.url) && Intrinsics.areEqual(this.mimeType, format.mimeType) && this.bitrate == format.bitrate && Intrinsics.areEqual(this.width, format.width) && Intrinsics.areEqual(this.height, format.height) && Intrinsics.areEqual(this.contentLength, format.contentLength) && Intrinsics.areEqual(this.quality, format.quality) && Intrinsics.areEqual(this.audioQuality, format.audioQuality) && Intrinsics.areEqual(this.approxDurationMs, format.approxDurationMs) && Intrinsics.areEqual(this.audioSampleRate, format.audioSampleRate) && Intrinsics.areEqual(this.audioChannels, format.audioChannels) && Intrinsics.areEqual(this.loudnessDb, format.loudnessDb) && Intrinsics.areEqual(this.lastModified, format.lastModified) && Intrinsics.areEqual(this.xtags, format.xtags) && Intrinsics.areEqual(this.audioTrack, format.audioTrack) && this.isDrc == format.isDrc && Intrinsics.areEqual(this.signatureCipher, format.signatureCipher) && Intrinsics.areEqual(this.cipher, format.cipher);
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
                int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
                String str2 = this.quality;
                int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.audioQuality;
                int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.approxDurationMs;
                int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Integer num3 = this.audioSampleRate;
                int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
                Integer num4 = this.audioChannels;
                int iHashCode9 = (iHashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
                Double d = this.loudnessDb;
                int iHashCode10 = (iHashCode9 + (d == null ? 0 : d.hashCode())) * 31;
                String str5 = this.lastModified;
                int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.xtags;
                int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
                AudioTrack audioTrack = this.audioTrack;
                int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode12 + (audioTrack == null ? 0 : audioTrack.hashCode())) * 31, this.isDrc, 31);
                String str7 = this.signatureCipher;
                int iHashCode13 = (iM2 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.cipher;
                return iHashCode13 + (str8 != null ? str8.hashCode() : 0);
            }

            public final boolean isAudio() {
                return this.width == null;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Format(itag=");
                sb.append(this.itag);
                sb.append(", url=");
                sb.append(this.url);
                sb.append(", mimeType=");
                sb.append(this.mimeType);
                sb.append(", bitrate=");
                sb.append(this.bitrate);
                sb.append(", width=");
                sb.append(this.width);
                sb.append(", height=");
                sb.append(this.height);
                sb.append(", contentLength=");
                sb.append(this.contentLength);
                sb.append(", quality=");
                sb.append(this.quality);
                sb.append(", audioQuality=");
                IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.audioQuality, ", approxDurationMs=", this.approxDurationMs, ", audioSampleRate=");
                sb.append(this.audioSampleRate);
                sb.append(", audioChannels=");
                sb.append(this.audioChannels);
                sb.append(", loudnessDb=");
                sb.append(this.loudnessDb);
                sb.append(", lastModified=");
                sb.append(this.lastModified);
                sb.append(", xtags=");
                sb.append(this.xtags);
                sb.append(", audioTrack=");
                sb.append(this.audioTrack);
                sb.append(", isDrc=");
                sb.append(this.isDrc);
                sb.append(", signatureCipher=");
                sb.append(this.signatureCipher);
                sb.append(", cipher=");
                return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.cipher, ")");
            }

            public Format(int i, String str, String str2, int i2, Integer num, Integer num2, Long l, String str3, String str4, String str5, Integer num3, Integer num4, Double d, String str6, String str7, AudioTrack audioTrack, boolean z, String str8, String str9) {
                this.itag = i;
                this.url = str;
                this.mimeType = str2;
                this.bitrate = i2;
                this.width = num;
                this.height = num2;
                this.contentLength = l;
                this.quality = str3;
                this.audioQuality = str4;
                this.approxDurationMs = str5;
                this.audioSampleRate = num3;
                this.audioChannels = num4;
                this.loudnessDb = d;
                this.lastModified = str6;
                this.xtags = str7;
                this.audioTrack = audioTrack;
                this.isDrc = z;
                this.signatureCipher = str8;
                this.cipher = str9;
            }
        }
    }
}
