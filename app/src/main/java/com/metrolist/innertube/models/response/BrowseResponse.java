package com.metrolist.innertube.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Button;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicShelfRenderer;
import com.metrolist.innertube.models.ResponseContext;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SectionListRenderer;
import com.metrolist.innertube.models.SubscriptionButton;
import com.metrolist.innertube.models.Tabs;
import com.metrolist.innertube.models.ThumbnailRenderer;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u0002¨\u0006\u000b"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse;", "", "Companion", "Contents", "TwoColumnBrowseResultsRenderer", "SecondaryContents", "ContinuationContents", "ResponseAction", "Header", "Microformat", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class BrowseResponse {
    public final ThumbnailRenderer background;
    public final Contents contents;
    public final ContinuationContents continuationContents;
    public final Header header;
    public final Microformat microformat;
    public final List onResponseReceivedActions;
    public final ResponseContext responseContext;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 0)), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return BrowseResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Contents;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Contents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final SectionListRenderer sectionListRenderer;
        public final Tabs singleColumnBrowseResultsRenderer;
        public final TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Contents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Contents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$Contents$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Contents(int i, Tabs tabs, SectionListRenderer sectionListRenderer, TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(BrowseResponse$Contents$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.singleColumnBrowseResultsRenderer = tabs;
            this.sectionListRenderer = sectionListRenderer;
            this.twoColumnBrowseResultsRenderer = twoColumnBrowseResultsRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Contents)) {
                return false;
            }
            Contents contents = (Contents) obj;
            return Intrinsics.areEqual(this.singleColumnBrowseResultsRenderer, contents.singleColumnBrowseResultsRenderer) && Intrinsics.areEqual(this.sectionListRenderer, contents.sectionListRenderer) && Intrinsics.areEqual(this.twoColumnBrowseResultsRenderer, contents.twoColumnBrowseResultsRenderer);
        }

        public final int hashCode() {
            Tabs tabs = this.singleColumnBrowseResultsRenderer;
            int iHashCode = (tabs == null ? 0 : tabs.tabs.hashCode()) * 31;
            SectionListRenderer sectionListRenderer = this.sectionListRenderer;
            int iHashCode2 = (iHashCode + (sectionListRenderer == null ? 0 : sectionListRenderer.hashCode())) * 31;
            TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer = this.twoColumnBrowseResultsRenderer;
            return iHashCode2 + (twoColumnBrowseResultsRenderer != null ? twoColumnBrowseResultsRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Contents(singleColumnBrowseResultsRenderer=" + this.singleColumnBrowseResultsRenderer + ", sectionListRenderer=" + this.sectionListRenderer + ", twoColumnBrowseResultsRenderer=" + this.twoColumnBrowseResultsRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents;", "", "Companion", "SectionListContinuation", "MusicPlaylistShelfContinuation", "GridContinuation", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ContinuationContents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final GridContinuation gridContinuation;
        public final MusicPlaylistShelfContinuation musicPlaylistShelfContinuation;
        public final MusicShelfRenderer musicShelfContinuation;
        public final SectionListContinuation sectionListContinuation;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$ContinuationContents$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$GridContinuation;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class GridContinuation {
            public static final Lazy[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final List continuations;
            public final List items;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$GridContinuation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$GridContinuation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE;
                }
            }

            static {
                BrowseResponse$$ExternalSyntheticLambda0 browseResponse$$ExternalSyntheticLambda0 = new BrowseResponse$$ExternalSyntheticLambda0((byte) 7);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, browseResponse$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new BrowseResponse$$ExternalSyntheticLambda0((byte) 8))};
            }

            public /* synthetic */ GridContinuation(int i, List list, List list2) {
                if (2 != (i & 2)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$ContinuationContents$GridContinuation$$serializer.INSTANCE.getDescriptor(), i, 2);
                    throw null;
                }
                if ((i & 1) == 0) {
                    this.items = EmptyList.INSTANCE;
                } else {
                    this.items = list;
                }
                this.continuations = list2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GridContinuation)) {
                    return false;
                }
                GridContinuation gridContinuation = (GridContinuation) obj;
                return Intrinsics.areEqual(this.items, gridContinuation.items) && Intrinsics.areEqual(this.continuations, gridContinuation.continuations);
            }

            public final int hashCode() {
                int iHashCode = this.items.hashCode() * 31;
                List list = this.continuations;
                return iHashCode + (list == null ? 0 : list.hashCode());
            }

            public final String toString() {
                return "GridContinuation(items=" + this.items + ", continuations=" + this.continuations + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicPlaylistShelfContinuation {
            public static final Lazy[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final List contents;
            public final List continuations;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE;
                }
            }

            static {
                BrowseResponse$$ExternalSyntheticLambda0 browseResponse$$ExternalSyntheticLambda0 = new BrowseResponse$$ExternalSyntheticLambda0((byte) 9);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, browseResponse$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new BrowseResponse$$ExternalSyntheticLambda0((byte) 10))};
            }

            public /* synthetic */ MusicPlaylistShelfContinuation(int i, List list, List list2) {
                if (2 != (i & 2)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$ContinuationContents$MusicPlaylistShelfContinuation$$serializer.INSTANCE.getDescriptor(), i, 2);
                    throw null;
                }
                if ((i & 1) == 0) {
                    this.contents = EmptyList.INSTANCE;
                } else {
                    this.contents = list;
                }
                this.continuations = list2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicPlaylistShelfContinuation)) {
                    return false;
                }
                MusicPlaylistShelfContinuation musicPlaylistShelfContinuation = (MusicPlaylistShelfContinuation) obj;
                return Intrinsics.areEqual(this.contents, musicPlaylistShelfContinuation.contents) && Intrinsics.areEqual(this.continuations, musicPlaylistShelfContinuation.continuations);
            }

            public final int hashCode() {
                int iHashCode = this.contents.hashCode() * 31;
                List list = this.continuations;
                return iHashCode + (list == null ? 0 : list.hashCode());
            }

            public final String toString() {
                return "MusicPlaylistShelfContinuation(contents=" + this.contents + ", continuations=" + this.continuations + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$SectionListContinuation;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class SectionListContinuation {
            public static final Lazy[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final List contents;
            public final List continuations;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$SectionListContinuation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ContinuationContents$SectionListContinuation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE;
                }
            }

            static {
                BrowseResponse$$ExternalSyntheticLambda0 browseResponse$$ExternalSyntheticLambda0 = new BrowseResponse$$ExternalSyntheticLambda0((byte) 11);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, browseResponse$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new BrowseResponse$$ExternalSyntheticLambda0((byte) 12))};
            }

            public /* synthetic */ SectionListContinuation(int i, List list, List list2) {
                if (2 != (i & 2)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$ContinuationContents$SectionListContinuation$$serializer.INSTANCE.getDescriptor(), i, 2);
                    throw null;
                }
                if ((i & 1) == 0) {
                    this.contents = EmptyList.INSTANCE;
                } else {
                    this.contents = list;
                }
                this.continuations = list2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SectionListContinuation)) {
                    return false;
                }
                SectionListContinuation sectionListContinuation = (SectionListContinuation) obj;
                return Intrinsics.areEqual(this.contents, sectionListContinuation.contents) && Intrinsics.areEqual(this.continuations, sectionListContinuation.continuations);
            }

            public final int hashCode() {
                int iHashCode = this.contents.hashCode() * 31;
                List list = this.continuations;
                return iHashCode + (list == null ? 0 : list.hashCode());
            }

            public final String toString() {
                return "SectionListContinuation(contents=" + this.contents + ", continuations=" + this.continuations + ")";
            }
        }

        public /* synthetic */ ContinuationContents(int i, SectionListContinuation sectionListContinuation, MusicPlaylistShelfContinuation musicPlaylistShelfContinuation, GridContinuation gridContinuation, MusicShelfRenderer musicShelfRenderer) {
            if (15 != (i & 15)) {
                EnumsKt.throwMissingFieldException(BrowseResponse$ContinuationContents$$serializer.INSTANCE.getDescriptor(), i, 15);
                throw null;
            }
            this.sectionListContinuation = sectionListContinuation;
            this.musicPlaylistShelfContinuation = musicPlaylistShelfContinuation;
            this.gridContinuation = gridContinuation;
            this.musicShelfContinuation = musicShelfRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ContinuationContents)) {
                return false;
            }
            ContinuationContents continuationContents = (ContinuationContents) obj;
            return Intrinsics.areEqual(this.sectionListContinuation, continuationContents.sectionListContinuation) && Intrinsics.areEqual(this.musicPlaylistShelfContinuation, continuationContents.musicPlaylistShelfContinuation) && Intrinsics.areEqual(this.gridContinuation, continuationContents.gridContinuation) && Intrinsics.areEqual(this.musicShelfContinuation, continuationContents.musicShelfContinuation);
        }

        public final int hashCode() {
            SectionListContinuation sectionListContinuation = this.sectionListContinuation;
            int iHashCode = (sectionListContinuation == null ? 0 : sectionListContinuation.hashCode()) * 31;
            MusicPlaylistShelfContinuation musicPlaylistShelfContinuation = this.musicPlaylistShelfContinuation;
            int iHashCode2 = (iHashCode + (musicPlaylistShelfContinuation == null ? 0 : musicPlaylistShelfContinuation.hashCode())) * 31;
            GridContinuation gridContinuation = this.gridContinuation;
            int iHashCode3 = (iHashCode2 + (gridContinuation == null ? 0 : gridContinuation.hashCode())) * 31;
            MusicShelfRenderer musicShelfRenderer = this.musicShelfContinuation;
            return iHashCode3 + (musicShelfRenderer != null ? musicShelfRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "ContinuationContents(sectionListContinuation=" + this.sectionListContinuation + ", musicPlaylistShelfContinuation=" + this.musicPlaylistShelfContinuation + ", gridContinuation=" + this.gridContinuation + ", musicShelfContinuation=" + this.musicShelfContinuation + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\u0002¨\u0006\n"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header;", "", "Companion", "MusicImmersiveHeaderRenderer", "MusicVisualHeaderRenderer", "Buttons", "MusicHeaderRenderer", "MusicThumbnail", "MusicThumbnailRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        public final MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        public final MusicHeaderRenderer musicHeaderRenderer;
        public final MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer;
        public final MusicVisualHeaderRenderer musicVisualHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$Buttons;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Buttons {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Menu.MenuRenderer menuRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$Buttons$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$Buttons;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$Buttons$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Buttons(int i, Menu.MenuRenderer menuRenderer) {
                if (1 == (i & 1)) {
                    this.menuRenderer = menuRenderer;
                } else {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$Buttons$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Buttons) && Intrinsics.areEqual(this.menuRenderer, ((Buttons) obj).menuRenderer);
            }

            public final int hashCode() {
                Menu.MenuRenderer menuRenderer = this.menuRenderer;
                if (menuRenderer == null) {
                    return 0;
                }
                return menuRenderer.hashCode();
            }

            public final String toString() {
                return "Buttons(menuRenderer=" + this.menuRenderer + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$Header$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicHeaderRenderer {
            public final List buttons;
            public final Runs secondSubtitle;
            public final Runs straplineTextOne;
            public final MusicThumbnailRenderer straplineThumbnail;
            public final Runs subtitle;
            public final MusicThumbnailRenderer thumbnail;
            public final Runs title;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 13)), null, null, null, null, null, null};

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicHeaderRenderer(int i, List list, Runs runs, MusicThumbnailRenderer musicThumbnailRenderer, Runs runs2, Runs runs3, Runs runs4, MusicThumbnailRenderer musicThumbnailRenderer2) {
                if (127 != (i & 127)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 127);
                    throw null;
                }
                this.buttons = list;
                this.title = runs;
                this.thumbnail = musicThumbnailRenderer;
                this.subtitle = runs2;
                this.secondSubtitle = runs3;
                this.straplineTextOne = runs4;
                this.straplineThumbnail = musicThumbnailRenderer2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicHeaderRenderer)) {
                    return false;
                }
                MusicHeaderRenderer musicHeaderRenderer = (MusicHeaderRenderer) obj;
                return Intrinsics.areEqual(this.buttons, musicHeaderRenderer.buttons) && Intrinsics.areEqual(this.title, musicHeaderRenderer.title) && Intrinsics.areEqual(this.thumbnail, musicHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.subtitle, musicHeaderRenderer.subtitle) && Intrinsics.areEqual(this.secondSubtitle, musicHeaderRenderer.secondSubtitle) && Intrinsics.areEqual(this.straplineTextOne, musicHeaderRenderer.straplineTextOne) && Intrinsics.areEqual(this.straplineThumbnail, musicHeaderRenderer.straplineThumbnail);
            }

            public final int hashCode() {
                List list = this.buttons;
                int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
                Runs runs = this.title;
                int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
                MusicThumbnailRenderer musicThumbnailRenderer = this.thumbnail;
                int iHashCode3 = (iHashCode2 + (musicThumbnailRenderer == null ? 0 : musicThumbnailRenderer.hashCode())) * 31;
                Runs runs2 = this.subtitle;
                int iHashCode4 = (iHashCode3 + (runs2 == null ? 0 : runs2.hashCode())) * 31;
                Runs runs3 = this.secondSubtitle;
                int iHashCode5 = (iHashCode4 + (runs3 == null ? 0 : runs3.hashCode())) * 31;
                Runs runs4 = this.straplineTextOne;
                int iHashCode6 = (iHashCode5 + (runs4 == null ? 0 : runs4.hashCode())) * 31;
                MusicThumbnailRenderer musicThumbnailRenderer2 = this.straplineThumbnail;
                return iHashCode6 + (musicThumbnailRenderer2 != null ? musicThumbnailRenderer2.hashCode() : 0);
            }

            public final String toString() {
                return "MusicHeaderRenderer(buttons=" + this.buttons + ", title=" + this.title + ", thumbnail=" + this.thumbnail + ", subtitle=" + this.subtitle + ", secondSubtitle=" + this.secondSubtitle + ", straplineTextOne=" + this.straplineTextOne + ", straplineThumbnail=" + this.straplineThumbnail + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer;", "", "Companion", "SubscriptionButton2", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicImmersiveHeaderRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Runs description;
            public final Menu menu;
            public final Runs monthlyListenerCount;
            public final Button playButton;
            public final Button startRadioButton;
            public final SubscriptionButton subscriptionButton;
            public final SubscriptionButton2 subscriptionButton2;
            public final ThumbnailRenderer thumbnail;
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2;", "", "Companion", "SubscribeButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class SubscriptionButton2 {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final SubscribeButtonRenderer subscribeButtonRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class SubscribeButtonRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final Runs subscriberCountWithSubscribeText;

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ SubscribeButtonRenderer(int i, Runs runs) {
                        if (1 == (i & 1)) {
                            this.subscriberCountWithSubscribeText = runs;
                        } else {
                            EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                            throw null;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof SubscribeButtonRenderer) && Intrinsics.areEqual(this.subscriberCountWithSubscribeText, ((SubscribeButtonRenderer) obj).subscriberCountWithSubscribeText);
                    }

                    public final int hashCode() {
                        Runs runs = this.subscriberCountWithSubscribeText;
                        if (runs == null) {
                            return 0;
                        }
                        return runs.hashCode();
                    }

                    public final String toString() {
                        return "SubscribeButtonRenderer(subscriberCountWithSubscribeText=" + this.subscriberCountWithSubscribeText + ")";
                    }
                }

                public /* synthetic */ SubscriptionButton2(int i, SubscribeButtonRenderer subscribeButtonRenderer) {
                    if (1 == (i & 1)) {
                        this.subscribeButtonRenderer = subscribeButtonRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof SubscriptionButton2) && Intrinsics.areEqual(this.subscribeButtonRenderer, ((SubscriptionButton2) obj).subscribeButtonRenderer);
                }

                public final int hashCode() {
                    SubscribeButtonRenderer subscribeButtonRenderer = this.subscribeButtonRenderer;
                    if (subscribeButtonRenderer == null) {
                        return 0;
                    }
                    return subscribeButtonRenderer.hashCode();
                }

                public final String toString() {
                    return "SubscriptionButton2(subscribeButtonRenderer=" + this.subscribeButtonRenderer + ")";
                }
            }

            public /* synthetic */ MusicImmersiveHeaderRenderer(int i, Runs runs, Runs runs2, ThumbnailRenderer thumbnailRenderer, Button button, Button button2, SubscriptionButton subscriptionButton, Menu menu, SubscriptionButton2 subscriptionButton2, Runs runs3) {
                if (255 != (i & 255)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 255);
                    throw null;
                }
                this.title = runs;
                this.description = runs2;
                this.thumbnail = thumbnailRenderer;
                this.playButton = button;
                this.startRadioButton = button2;
                this.subscriptionButton = subscriptionButton;
                this.menu = menu;
                this.subscriptionButton2 = subscriptionButton2;
                if ((i & 256) == 0) {
                    this.monthlyListenerCount = null;
                } else {
                    this.monthlyListenerCount = runs3;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicImmersiveHeaderRenderer)) {
                    return false;
                }
                MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer = (MusicImmersiveHeaderRenderer) obj;
                return Intrinsics.areEqual(this.title, musicImmersiveHeaderRenderer.title) && Intrinsics.areEqual(this.description, musicImmersiveHeaderRenderer.description) && Intrinsics.areEqual(this.thumbnail, musicImmersiveHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.playButton, musicImmersiveHeaderRenderer.playButton) && Intrinsics.areEqual(this.startRadioButton, musicImmersiveHeaderRenderer.startRadioButton) && Intrinsics.areEqual(this.subscriptionButton, musicImmersiveHeaderRenderer.subscriptionButton) && Intrinsics.areEqual(this.menu, musicImmersiveHeaderRenderer.menu) && Intrinsics.areEqual(this.subscriptionButton2, musicImmersiveHeaderRenderer.subscriptionButton2) && Intrinsics.areEqual(this.monthlyListenerCount, musicImmersiveHeaderRenderer.monthlyListenerCount);
            }

            public final int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                Runs runs = this.description;
                int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
                ThumbnailRenderer thumbnailRenderer = this.thumbnail;
                int iHashCode3 = (iHashCode2 + (thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode())) * 31;
                Button button = this.playButton;
                int iHashCode4 = (iHashCode3 + (button == null ? 0 : button.buttonRenderer.hashCode())) * 31;
                Button button2 = this.startRadioButton;
                int iHashCode5 = (iHashCode4 + (button2 == null ? 0 : button2.buttonRenderer.hashCode())) * 31;
                SubscriptionButton subscriptionButton = this.subscriptionButton;
                int iHashCode6 = (this.menu.menuRenderer.hashCode() + ((iHashCode5 + (subscriptionButton == null ? 0 : subscriptionButton.subscribeButtonRenderer.hashCode())) * 31)) * 31;
                SubscriptionButton2 subscriptionButton2 = this.subscriptionButton2;
                int iHashCode7 = (iHashCode6 + (subscriptionButton2 == null ? 0 : subscriptionButton2.hashCode())) * 31;
                Runs runs2 = this.monthlyListenerCount;
                return iHashCode7 + (runs2 != null ? runs2.hashCode() : 0);
            }

            public final String toString() {
                return "MusicImmersiveHeaderRenderer(title=" + this.title + ", description=" + this.description + ", thumbnail=" + this.thumbnail + ", playButton=" + this.playButton + ", startRadioButton=" + this.startRadioButton + ", subscriptionButton=" + this.subscriptionButton + ", menu=" + this.menu + ", subscriptionButton2=" + this.subscriptionButton2 + ", monthlyListenerCount=" + this.monthlyListenerCount + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnail;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicThumbnail {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String url;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnail$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnail;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$MusicThumbnail$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicThumbnail(int i, String str) {
                if (1 == (i & 1)) {
                    this.url = str;
                } else {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicThumbnail$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MusicThumbnail) && Intrinsics.areEqual(this.url, ((MusicThumbnail) obj).url);
            }

            public final int hashCode() {
                String str = this.url;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("MusicThumbnail(url=", this.url, ")");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnailRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicThumbnailRenderer {
            public final MusicThumbnailRenderer musicThumbnailRenderer;
            public final List thumbnails;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 14))};

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnailRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicThumbnailRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicThumbnailRenderer(int i, MusicThumbnailRenderer musicThumbnailRenderer, List list) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.musicThumbnailRenderer = musicThumbnailRenderer;
                this.thumbnails = list;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicThumbnailRenderer)) {
                    return false;
                }
                MusicThumbnailRenderer musicThumbnailRenderer = (MusicThumbnailRenderer) obj;
                return Intrinsics.areEqual(this.musicThumbnailRenderer, musicThumbnailRenderer.musicThumbnailRenderer) && Intrinsics.areEqual(this.thumbnails, musicThumbnailRenderer.thumbnails);
            }

            public final int hashCode() {
                int iHashCode = this.musicThumbnailRenderer.hashCode() * 31;
                List list = this.thumbnails;
                return iHashCode + (list == null ? 0 : list.hashCode());
            }

            public final String toString() {
                return "MusicThumbnailRenderer(musicThumbnailRenderer=" + this.musicThumbnailRenderer + ", thumbnails=" + this.thumbnails + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicVisualHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicVisualHeaderRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ThumbnailRenderer foregroundThumbnail;
            public final SubscriptionButton subscriptionButton;
            public final ThumbnailRenderer thumbnail;
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicVisualHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Header$MusicVisualHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicVisualHeaderRenderer(int i, Runs runs, ThumbnailRenderer thumbnailRenderer, ThumbnailRenderer thumbnailRenderer2, SubscriptionButton subscriptionButton) {
                if (15 != (i & 15)) {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
                    throw null;
                }
                this.title = runs;
                this.foregroundThumbnail = thumbnailRenderer;
                this.thumbnail = thumbnailRenderer2;
                this.subscriptionButton = subscriptionButton;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicVisualHeaderRenderer)) {
                    return false;
                }
                MusicVisualHeaderRenderer musicVisualHeaderRenderer = (MusicVisualHeaderRenderer) obj;
                return Intrinsics.areEqual(this.title, musicVisualHeaderRenderer.title) && Intrinsics.areEqual(this.foregroundThumbnail, musicVisualHeaderRenderer.foregroundThumbnail) && Intrinsics.areEqual(this.thumbnail, musicVisualHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.subscriptionButton, musicVisualHeaderRenderer.subscriptionButton);
            }

            public final int hashCode() {
                int iHashCode = (this.foregroundThumbnail.hashCode() + (this.title.hashCode() * 31)) * 31;
                ThumbnailRenderer thumbnailRenderer = this.thumbnail;
                int iHashCode2 = (iHashCode + (thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode())) * 31;
                SubscriptionButton subscriptionButton = this.subscriptionButton;
                return iHashCode2 + (subscriptionButton != null ? subscriptionButton.subscribeButtonRenderer.hashCode() : 0);
            }

            public final String toString() {
                return "MusicVisualHeaderRenderer(title=" + this.title + ", foregroundThumbnail=" + this.foregroundThumbnail + ", thumbnail=" + this.thumbnail + ", subscriptionButton=" + this.subscriptionButton + ")";
            }
        }

        public /* synthetic */ Header(int i, MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer, MusicDetailHeaderRenderer musicDetailHeaderRenderer, MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer, MusicVisualHeaderRenderer musicVisualHeaderRenderer, MusicHeaderRenderer musicHeaderRenderer) {
            if (31 != (i & 31)) {
                EnumsKt.throwMissingFieldException(BrowseResponse$Header$$serializer.INSTANCE.getDescriptor(), i, 31);
                throw null;
            }
            this.musicImmersiveHeaderRenderer = musicImmersiveHeaderRenderer;
            this.musicDetailHeaderRenderer = musicDetailHeaderRenderer;
            this.musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer;
            this.musicVisualHeaderRenderer = musicVisualHeaderRenderer;
            this.musicHeaderRenderer = musicHeaderRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Header)) {
                return false;
            }
            Header header = (Header) obj;
            return Intrinsics.areEqual(this.musicImmersiveHeaderRenderer, header.musicImmersiveHeaderRenderer) && Intrinsics.areEqual(this.musicDetailHeaderRenderer, header.musicDetailHeaderRenderer) && Intrinsics.areEqual(this.musicEditablePlaylistDetailHeaderRenderer, header.musicEditablePlaylistDetailHeaderRenderer) && Intrinsics.areEqual(this.musicVisualHeaderRenderer, header.musicVisualHeaderRenderer) && Intrinsics.areEqual(this.musicHeaderRenderer, header.musicHeaderRenderer);
        }

        public final int hashCode() {
            MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer = this.musicImmersiveHeaderRenderer;
            int iHashCode = (musicImmersiveHeaderRenderer == null ? 0 : musicImmersiveHeaderRenderer.hashCode()) * 31;
            MusicDetailHeaderRenderer musicDetailHeaderRenderer = this.musicDetailHeaderRenderer;
            int iHashCode2 = (iHashCode + (musicDetailHeaderRenderer == null ? 0 : musicDetailHeaderRenderer.hashCode())) * 31;
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer = this.musicEditablePlaylistDetailHeaderRenderer;
            int iHashCode3 = (iHashCode2 + (musicEditablePlaylistDetailHeaderRenderer == null ? 0 : musicEditablePlaylistDetailHeaderRenderer.hashCode())) * 31;
            MusicVisualHeaderRenderer musicVisualHeaderRenderer = this.musicVisualHeaderRenderer;
            int iHashCode4 = (iHashCode3 + (musicVisualHeaderRenderer == null ? 0 : musicVisualHeaderRenderer.hashCode())) * 31;
            MusicHeaderRenderer musicHeaderRenderer = this.musicHeaderRenderer;
            return iHashCode4 + (musicHeaderRenderer != null ? musicHeaderRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Header(musicImmersiveHeaderRenderer=" + this.musicImmersiveHeaderRenderer + ", musicDetailHeaderRenderer=" + this.musicDetailHeaderRenderer + ", musicEditablePlaylistDetailHeaderRenderer=" + this.musicEditablePlaylistDetailHeaderRenderer + ", musicVisualHeaderRenderer=" + this.musicVisualHeaderRenderer + ", musicHeaderRenderer=" + this.musicHeaderRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat;", "", "Companion", "MicroformatDataRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Microformat {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MicroformatDataRenderer microformatDataRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$Microformat$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat$MicroformatDataRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MicroformatDataRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String urlCanonical;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat$MicroformatDataRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$Microformat$MicroformatDataRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$Microformat$MicroformatDataRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MicroformatDataRenderer(int i, String str) {
                if (1 == (i & 1)) {
                    this.urlCanonical = str;
                } else {
                    EnumsKt.throwMissingFieldException(BrowseResponse$Microformat$MicroformatDataRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MicroformatDataRenderer) && Intrinsics.areEqual(this.urlCanonical, ((MicroformatDataRenderer) obj).urlCanonical);
            }

            public final int hashCode() {
                String str = this.urlCanonical;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("MicroformatDataRenderer(urlCanonical=", this.urlCanonical, ")");
            }
        }

        public /* synthetic */ Microformat(int i, MicroformatDataRenderer microformatDataRenderer) {
            if (1 == (i & 1)) {
                this.microformatDataRenderer = microformatDataRenderer;
            } else {
                EnumsKt.throwMissingFieldException(BrowseResponse$Microformat$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Microformat) && Intrinsics.areEqual(this.microformatDataRenderer, ((Microformat) obj).microformatDataRenderer);
        }

        public final int hashCode() {
            MicroformatDataRenderer microformatDataRenderer = this.microformatDataRenderer;
            if (microformatDataRenderer == null) {
                return 0;
            }
            return microformatDataRenderer.hashCode();
        }

        public final String toString() {
            return "Microformat(microformatDataRenderer=" + this.microformatDataRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction;", "", "Companion", "ContinuationItems", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ResponseAction {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ContinuationItems appendContinuationItemsAction;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$ResponseAction$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction$ContinuationItems;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ContinuationItems {
            public final List continuationItems;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 15))};

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction$ContinuationItems$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$ResponseAction$ContinuationItems;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return BrowseResponse$ResponseAction$ContinuationItems$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ContinuationItems(int i, List list) {
                if (1 == (i & 1)) {
                    this.continuationItems = list;
                } else {
                    EnumsKt.throwMissingFieldException(BrowseResponse$ResponseAction$ContinuationItems$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ContinuationItems) && Intrinsics.areEqual(this.continuationItems, ((ContinuationItems) obj).continuationItems);
            }

            public final int hashCode() {
                List list = this.continuationItems;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }

            public final String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("ContinuationItems(continuationItems=", ")", this.continuationItems);
            }
        }

        public /* synthetic */ ResponseAction(int i, ContinuationItems continuationItems) {
            if (1 == (i & 1)) {
                this.appendContinuationItemsAction = continuationItems;
            } else {
                EnumsKt.throwMissingFieldException(BrowseResponse$ResponseAction$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResponseAction) && Intrinsics.areEqual(this.appendContinuationItemsAction, ((ResponseAction) obj).appendContinuationItemsAction);
        }

        public final int hashCode() {
            ContinuationItems continuationItems = this.appendContinuationItemsAction;
            if (continuationItems == null) {
                return 0;
            }
            return continuationItems.hashCode();
        }

        public final String toString() {
            return "ResponseAction(appendContinuationItemsAction=" + this.appendContinuationItemsAction + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$SecondaryContents;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SecondaryContents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final SectionListRenderer sectionListRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$SecondaryContents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$SecondaryContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$SecondaryContents$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SecondaryContents(int i, SectionListRenderer sectionListRenderer) {
            if (1 == (i & 1)) {
                this.sectionListRenderer = sectionListRenderer;
            } else {
                EnumsKt.throwMissingFieldException(BrowseResponse$SecondaryContents$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SecondaryContents) && Intrinsics.areEqual(this.sectionListRenderer, ((SecondaryContents) obj).sectionListRenderer);
        }

        public final int hashCode() {
            SectionListRenderer sectionListRenderer = this.sectionListRenderer;
            if (sectionListRenderer == null) {
                return 0;
            }
            return sectionListRenderer.hashCode();
        }

        public final String toString() {
            return "SecondaryContents(sectionListRenderer=" + this.sectionListRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$TwoColumnBrowseResultsRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TwoColumnBrowseResultsRenderer {
        public final SecondaryContents secondaryContents;
        public final List tabs;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 16)), null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/BrowseResponse$TwoColumnBrowseResultsRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/BrowseResponse$TwoColumnBrowseResultsRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ TwoColumnBrowseResultsRenderer(int i, List list, SecondaryContents secondaryContents) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(BrowseResponse$TwoColumnBrowseResultsRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.tabs = list;
            this.secondaryContents = secondaryContents;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TwoColumnBrowseResultsRenderer)) {
                return false;
            }
            TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer = (TwoColumnBrowseResultsRenderer) obj;
            return Intrinsics.areEqual(this.tabs, twoColumnBrowseResultsRenderer.tabs) && Intrinsics.areEqual(this.secondaryContents, twoColumnBrowseResultsRenderer.secondaryContents);
        }

        public final int hashCode() {
            List list = this.tabs;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            SecondaryContents secondaryContents = this.secondaryContents;
            return iHashCode + (secondaryContents != null ? secondaryContents.hashCode() : 0);
        }

        public final String toString() {
            return "TwoColumnBrowseResultsRenderer(tabs=" + this.tabs + ", secondaryContents=" + this.secondaryContents + ")";
        }
    }

    public /* synthetic */ BrowseResponse(int i, Contents contents, ContinuationContents continuationContents, List list, Header header, Microformat microformat, ResponseContext responseContext, ThumbnailRenderer thumbnailRenderer) {
        if (127 != (i & 127)) {
            EnumsKt.throwMissingFieldException(BrowseResponse$$serializer.INSTANCE.getDescriptor(), i, 127);
            throw null;
        }
        this.contents = contents;
        this.continuationContents = continuationContents;
        this.onResponseReceivedActions = list;
        this.header = header;
        this.microformat = microformat;
        this.responseContext = responseContext;
        this.background = thumbnailRenderer;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowseResponse)) {
            return false;
        }
        BrowseResponse browseResponse = (BrowseResponse) obj;
        return Intrinsics.areEqual(this.contents, browseResponse.contents) && Intrinsics.areEqual(this.continuationContents, browseResponse.continuationContents) && Intrinsics.areEqual(this.onResponseReceivedActions, browseResponse.onResponseReceivedActions) && Intrinsics.areEqual(this.header, browseResponse.header) && Intrinsics.areEqual(this.microformat, browseResponse.microformat) && Intrinsics.areEqual(this.responseContext, browseResponse.responseContext) && Intrinsics.areEqual(this.background, browseResponse.background);
    }

    public final int hashCode() {
        Contents contents = this.contents;
        int iHashCode = (contents == null ? 0 : contents.hashCode()) * 31;
        ContinuationContents continuationContents = this.continuationContents;
        int iHashCode2 = (iHashCode + (continuationContents == null ? 0 : continuationContents.hashCode())) * 31;
        List list = this.onResponseReceivedActions;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Header header = this.header;
        int iHashCode4 = (iHashCode3 + (header == null ? 0 : header.hashCode())) * 31;
        Microformat microformat = this.microformat;
        int iHashCode5 = (this.responseContext.hashCode() + ((iHashCode4 + (microformat == null ? 0 : microformat.hashCode())) * 31)) * 31;
        ThumbnailRenderer thumbnailRenderer = this.background;
        return iHashCode5 + (thumbnailRenderer != null ? thumbnailRenderer.hashCode() : 0);
    }

    public final String toString() {
        return "BrowseResponse(contents=" + this.contents + ", continuationContents=" + this.continuationContents + ", onResponseReceivedActions=" + this.onResponseReceivedActions + ", header=" + this.header + ", microformat=" + this.microformat + ", responseContext=" + this.responseContext + ", background=" + this.background + ")";
    }
}
