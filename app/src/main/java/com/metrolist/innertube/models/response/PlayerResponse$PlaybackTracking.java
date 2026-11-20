package com.metrolist.innertube.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"com/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking", "", "Companion", "VideostatsPlaybackUrl", "VideostatsWatchtimeUrl", "AtrUrl", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerResponse$PlaybackTracking {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final AtrUrl atrUrl;
    public final VideostatsPlaybackUrl videostatsPlaybackUrl;
    public final VideostatsWatchtimeUrl videostatsWatchtimeUrl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$AtrUrl;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AtrUrl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String baseUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$AtrUrl$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$AtrUrl;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AtrUrl(int i, String str) {
            if (1 == (i & 1)) {
                this.baseUrl = str;
            } else {
                EnumsKt.throwMissingFieldException(PlayerResponse$PlaybackTracking$AtrUrl$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AtrUrl) && Intrinsics.areEqual(this.baseUrl, ((AtrUrl) obj).baseUrl);
        }

        public final int hashCode() {
            String str = this.baseUrl;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("AtrUrl(baseUrl=", this.baseUrl, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlayerResponse$PlaybackTracking$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerResponse$PlaybackTracking(int i, VideostatsPlaybackUrl videostatsPlaybackUrl, VideostatsWatchtimeUrl videostatsWatchtimeUrl, AtrUrl atrUrl) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(PlayerResponse$PlaybackTracking$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
        this.atrUrl = atrUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponse$PlaybackTracking)) {
            return false;
        }
        PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking = (PlayerResponse$PlaybackTracking) obj;
        return Intrinsics.areEqual(this.videostatsPlaybackUrl, playerResponse$PlaybackTracking.videostatsPlaybackUrl) && Intrinsics.areEqual(this.videostatsWatchtimeUrl, playerResponse$PlaybackTracking.videostatsWatchtimeUrl) && Intrinsics.areEqual(this.atrUrl, playerResponse$PlaybackTracking.atrUrl);
    }

    public final int hashCode() {
        VideostatsPlaybackUrl videostatsPlaybackUrl = this.videostatsPlaybackUrl;
        int iHashCode = (videostatsPlaybackUrl == null ? 0 : videostatsPlaybackUrl.hashCode()) * 31;
        VideostatsWatchtimeUrl videostatsWatchtimeUrl = this.videostatsWatchtimeUrl;
        int iHashCode2 = (iHashCode + (videostatsWatchtimeUrl == null ? 0 : videostatsWatchtimeUrl.hashCode())) * 31;
        AtrUrl atrUrl = this.atrUrl;
        return iHashCode2 + (atrUrl != null ? atrUrl.hashCode() : 0);
    }

    public final String toString() {
        return "PlaybackTracking(videostatsPlaybackUrl=" + this.videostatsPlaybackUrl + ", videostatsWatchtimeUrl=" + this.videostatsWatchtimeUrl + ", atrUrl=" + this.atrUrl + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class VideostatsPlaybackUrl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String baseUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ VideostatsPlaybackUrl(int i, String str) {
            if (1 == (i & 1)) {
                this.baseUrl = str;
            } else {
                EnumsKt.throwMissingFieldException(PlayerResponse$PlaybackTracking$VideostatsPlaybackUrl$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VideostatsPlaybackUrl) && Intrinsics.areEqual(this.baseUrl, ((VideostatsPlaybackUrl) obj).baseUrl);
        }

        public final int hashCode() {
            String str = this.baseUrl;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("VideostatsPlaybackUrl(baseUrl=", this.baseUrl, ")");
        }

        public VideostatsPlaybackUrl(String str) {
            this.baseUrl = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class VideostatsWatchtimeUrl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String baseUrl;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ VideostatsWatchtimeUrl(int i, String str) {
            if (1 == (i & 1)) {
                this.baseUrl = str;
            } else {
                EnumsKt.throwMissingFieldException(PlayerResponse$PlaybackTracking$VideostatsWatchtimeUrl$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VideostatsWatchtimeUrl) && Intrinsics.areEqual(this.baseUrl, ((VideostatsWatchtimeUrl) obj).baseUrl);
        }

        public final int hashCode() {
            String str = this.baseUrl;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("VideostatsWatchtimeUrl(baseUrl=", this.baseUrl, ")");
        }

        public VideostatsWatchtimeUrl(String str) {
            this.baseUrl = str;
        }
    }

    public PlayerResponse$PlaybackTracking(VideostatsPlaybackUrl videostatsPlaybackUrl, VideostatsWatchtimeUrl videostatsWatchtimeUrl) {
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
        this.atrUrl = null;
    }
}
