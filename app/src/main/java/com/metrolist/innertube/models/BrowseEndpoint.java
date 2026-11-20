package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "BrowseEndpointContextSupportedConfigs", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class BrowseEndpoint extends Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
    public final String browseId;
    public final String params;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs;", "", "Companion", "BrowseEndpointContextMusicConfig", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class BrowseEndpointContextSupportedConfigs {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs$BrowseEndpointContextMusicConfig;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class BrowseEndpointContextMusicConfig {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String pageType;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs$BrowseEndpointContextMusicConfig$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs$BrowseEndpointContextMusicConfig;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "MUSIC_PAGE_TYPE_ALBUM", "Ljava/lang/String;", "MUSIC_PAGE_TYPE_AUDIOBOOK", "MUSIC_PAGE_TYPE_PLAYLIST", "MUSIC_PAGE_TYPE_ARTIST", "MUSIC_PAGE_TYPE_LIBRARY_ARTIST", "MUSIC_PAGE_TYPE_USER_CHANNEL", "MUSIC_PAGE_TYPE_TRACK_LYRICS", "MUSIC_PAGE_TYPE_TRACK_RELATED", "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE", "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseEndpoint$BrowseEndpointContextSupportedConfigs$BrowseEndpointContextMusicConfig$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BrowseEndpointContextMusicConfig(int i, String str) {
                if (1 == (i & 1)) {
                    this.pageType = str;
                } else {
                    EnumsKt.throwMissingFieldException(BrowseEndpoint$BrowseEndpointContextSupportedConfigs$BrowseEndpointContextMusicConfig$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof BrowseEndpointContextMusicConfig) && Intrinsics.areEqual(this.pageType, ((BrowseEndpointContextMusicConfig) obj).pageType);
            }

            public final int hashCode() {
                return this.pageType.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("BrowseEndpointContextMusicConfig(pageType=", this.pageType, ")");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/BrowseEndpoint$BrowseEndpointContextSupportedConfigs;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ BrowseEndpointContextSupportedConfigs(int i, BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig) {
            if (1 == (i & 1)) {
                this.browseEndpointContextMusicConfig = browseEndpointContextMusicConfig;
            } else {
                EnumsKt.throwMissingFieldException(BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BrowseEndpointContextSupportedConfigs) && Intrinsics.areEqual(this.browseEndpointContextMusicConfig, ((BrowseEndpointContextSupportedConfigs) obj).browseEndpointContextMusicConfig);
        }

        public final int hashCode() {
            return this.browseEndpointContextMusicConfig.pageType.hashCode();
        }

        public final String toString() {
            return "BrowseEndpointContextSupportedConfigs(browseEndpointContextMusicConfig=" + this.browseEndpointContextMusicConfig + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/BrowseEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/BrowseEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return BrowseEndpoint$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BrowseEndpoint(int i, String str, String str2, BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(BrowseEndpoint$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.browseId = str;
        if ((i & 2) == 0) {
            this.params = null;
        } else {
            this.params = str2;
        }
        if ((i & 4) == 0) {
            this.browseEndpointContextSupportedConfigs = null;
        } else {
            this.browseEndpointContextSupportedConfigs = browseEndpointContextSupportedConfigs;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowseEndpoint)) {
            return false;
        }
        BrowseEndpoint browseEndpoint = (BrowseEndpoint) obj;
        return Intrinsics.areEqual(this.browseId, browseEndpoint.browseId) && Intrinsics.areEqual(this.params, browseEndpoint.params) && Intrinsics.areEqual(this.browseEndpointContextSupportedConfigs, browseEndpoint.browseEndpointContextSupportedConfigs);
    }

    public final int hashCode() {
        int iHashCode = this.browseId.hashCode() * 31;
        String str = this.params;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs = this.browseEndpointContextSupportedConfigs;
        return iHashCode2 + (browseEndpointContextSupportedConfigs != null ? browseEndpointContextSupportedConfigs.hashCode() : 0);
    }

    public final boolean isArtistEndpoint() {
        BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs = this.browseEndpointContextSupportedConfigs;
        return Intrinsics.areEqual((browseEndpointContextSupportedConfigs == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_ARTIST");
    }

    public final boolean isPodcastEndpoint() {
        BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs = this.browseEndpointContextSupportedConfigs;
        return Intrinsics.areEqual((browseEndpointContextSupportedConfigs == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE");
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("BrowseEndpoint(browseId=", this.browseId, ", params=", this.params, ", browseEndpointContextSupportedConfigs=");
        sbM.append(this.browseEndpointContextSupportedConfigs);
        sbM.append(")");
        return sbM.toString();
    }

    public BrowseEndpoint(String str, String str2) {
        str.getClass();
        this.browseId = str;
        this.params = str2;
        this.browseEndpointContextSupportedConfigs = null;
    }
}
