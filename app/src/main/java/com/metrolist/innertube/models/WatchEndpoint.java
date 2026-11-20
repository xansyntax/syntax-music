package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "WatchEndpointMusicSupportedConfigs", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class WatchEndpoint extends Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Integer index;
    public final String params;
    public final String playlistId;
    public final String playlistSetVideoId;
    public final String videoId;
    public final WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/WatchEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return WatchEndpoint$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs;", "", "Companion", "WatchEndpointMusicConfig", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class WatchEndpointMusicSupportedConfigs {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final WatchEndpointMusicConfig watchEndpointMusicConfig;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs$WatchEndpointMusicConfig;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class WatchEndpointMusicConfig {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String musicVideoType;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs$WatchEndpointMusicConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/WatchEndpoint$WatchEndpointMusicSupportedConfigs$WatchEndpointMusicConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "MUSIC_VIDEO_TYPE_OMV", "Ljava/lang/String;", "MUSIC_VIDEO_TYPE_UGC", "MUSIC_VIDEO_TYPE_ATV", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return WatchEndpoint$WatchEndpointMusicSupportedConfigs$WatchEndpointMusicConfig$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ WatchEndpointMusicConfig(int i, String str) {
                if (1 == (i & 1)) {
                    this.musicVideoType = str;
                } else {
                    EnumsKt.throwMissingFieldException(WatchEndpoint$WatchEndpointMusicSupportedConfigs$WatchEndpointMusicConfig$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WatchEndpointMusicConfig) && Intrinsics.areEqual(this.musicVideoType, ((WatchEndpointMusicConfig) obj).musicVideoType);
            }

            public final int hashCode() {
                return this.musicVideoType.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("WatchEndpointMusicConfig(musicVideoType=", this.musicVideoType, ")");
            }
        }

        public /* synthetic */ WatchEndpointMusicSupportedConfigs(int i, WatchEndpointMusicConfig watchEndpointMusicConfig) {
            if (1 == (i & 1)) {
                this.watchEndpointMusicConfig = watchEndpointMusicConfig;
            } else {
                EnumsKt.throwMissingFieldException(WatchEndpoint$WatchEndpointMusicSupportedConfigs$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WatchEndpointMusicSupportedConfigs) && Intrinsics.areEqual(this.watchEndpointMusicConfig, ((WatchEndpointMusicSupportedConfigs) obj).watchEndpointMusicConfig);
        }

        public final int hashCode() {
            return this.watchEndpointMusicConfig.musicVideoType.hashCode();
        }

        public final String toString() {
            return "WatchEndpointMusicSupportedConfigs(watchEndpointMusicConfig=" + this.watchEndpointMusicConfig + ")";
        }
    }

    public /* synthetic */ WatchEndpoint(int i, String str, String str2, String str3, String str4, Integer num, WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs) {
        if ((i & 1) == 0) {
            this.videoId = null;
        } else {
            this.videoId = str;
        }
        if ((i & 2) == 0) {
            this.playlistId = null;
        } else {
            this.playlistId = str2;
        }
        if ((i & 4) == 0) {
            this.playlistSetVideoId = null;
        } else {
            this.playlistSetVideoId = str3;
        }
        if ((i & 8) == 0) {
            this.params = null;
        } else {
            this.params = str4;
        }
        if ((i & 16) == 0) {
            this.index = null;
        } else {
            this.index = num;
        }
        if ((i & 32) == 0) {
            this.watchEndpointMusicSupportedConfigs = null;
        } else {
            this.watchEndpointMusicSupportedConfigs = watchEndpointMusicSupportedConfigs;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchEndpoint)) {
            return false;
        }
        WatchEndpoint watchEndpoint = (WatchEndpoint) obj;
        return Intrinsics.areEqual(this.videoId, watchEndpoint.videoId) && Intrinsics.areEqual(this.playlistId, watchEndpoint.playlistId) && Intrinsics.areEqual(this.playlistSetVideoId, watchEndpoint.playlistSetVideoId) && Intrinsics.areEqual(this.params, watchEndpoint.params) && Intrinsics.areEqual(this.index, watchEndpoint.index) && Intrinsics.areEqual(this.watchEndpointMusicSupportedConfigs, watchEndpoint.watchEndpointMusicSupportedConfigs);
    }

    public final int hashCode() {
        String str = this.videoId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.playlistId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playlistSetVideoId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.params;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.index;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs = this.watchEndpointMusicSupportedConfigs;
        return iHashCode5 + (watchEndpointMusicSupportedConfigs != null ? watchEndpointMusicSupportedConfigs.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("WatchEndpoint(videoId=", this.videoId, ", playlistId=", this.playlistId, ", playlistSetVideoId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.playlistSetVideoId, ", params=", this.params, ", index=");
        sbM.append(this.index);
        sbM.append(", watchEndpointMusicSupportedConfigs=");
        sbM.append(this.watchEndpointMusicSupportedConfigs);
        sbM.append(")");
        return sbM.toString();
    }

    public WatchEndpoint(int i, String str, String str2, String str3) {
        str = (i & 1) != 0 ? null : str;
        str2 = (i & 2) != 0 ? null : str2;
        str3 = (i & 8) != 0 ? null : str3;
        this.videoId = str;
        this.playlistId = str2;
        this.playlistSetVideoId = null;
        this.params = str3;
        this.index = null;
        this.watchEndpointMusicSupportedConfigs = null;
    }
}
