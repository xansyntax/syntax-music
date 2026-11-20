package com.metrolist.innertube.models.response;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistPanelRenderer;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse;", "", "Companion", "Contents", "ContinuationContents", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class NextResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Contents contents;
    public final ContinuationContents continuationContents;
    public final NavigationEndpoint currentVideoEndpoint;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return NextResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents;", "", "Companion", "SingleColumnMusicWatchNextResultsRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Contents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer;
        public final YouTubeDataPage$Contents$TwoColumnWatchNextResults twoColumnWatchNextResults;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse$Contents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return NextResponse$Contents$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer;", "", "Companion", "TabbedRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class SingleColumnMusicWatchNextResultsRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final TabbedRenderer tabbedRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer;", "", "Companion", "WatchNextTabbedResultsRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class TabbedRenderer {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$WatchNextTabbedResultsRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class WatchNextTabbedResultsRenderer {
                    public final List tabs;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 23))};

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$WatchNextTabbedResultsRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$WatchNextTabbedResultsRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$WatchNextTabbedResultsRenderer$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ WatchNextTabbedResultsRenderer(int i, List list) {
                        if (1 == (i & 1)) {
                            this.tabs = list;
                        } else {
                            EnumsKt.throwMissingFieldException(NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$WatchNextTabbedResultsRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                            throw null;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof WatchNextTabbedResultsRenderer) && Intrinsics.areEqual(this.tabs, ((WatchNextTabbedResultsRenderer) obj).tabs);
                    }

                    public final int hashCode() {
                        return this.tabs.hashCode();
                    }

                    public final String toString() {
                        return Fragment$5$$ExternalSyntheticOutline0.m("WatchNextTabbedResultsRenderer(tabs=", ")", this.tabs);
                    }
                }

                public /* synthetic */ TabbedRenderer(int i, WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer) {
                    if (1 == (i & 1)) {
                        this.watchNextTabbedResultsRenderer = watchNextTabbedResultsRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$TabbedRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof TabbedRenderer) && Intrinsics.areEqual(this.watchNextTabbedResultsRenderer, ((TabbedRenderer) obj).watchNextTabbedResultsRenderer);
                }

                public final int hashCode() {
                    WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer = this.watchNextTabbedResultsRenderer;
                    if (watchNextTabbedResultsRenderer == null) {
                        return 0;
                    }
                    return watchNextTabbedResultsRenderer.tabs.hashCode();
                }

                public final String toString() {
                    return "TabbedRenderer(watchNextTabbedResultsRenderer=" + this.watchNextTabbedResultsRenderer + ")";
                }
            }

            public /* synthetic */ SingleColumnMusicWatchNextResultsRenderer(int i, TabbedRenderer tabbedRenderer) {
                if (1 == (i & 1)) {
                    this.tabbedRenderer = tabbedRenderer;
                } else {
                    EnumsKt.throwMissingFieldException(NextResponse$Contents$SingleColumnMusicWatchNextResultsRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SingleColumnMusicWatchNextResultsRenderer) && Intrinsics.areEqual(this.tabbedRenderer, ((SingleColumnMusicWatchNextResultsRenderer) obj).tabbedRenderer);
            }

            public final int hashCode() {
                TabbedRenderer tabbedRenderer = this.tabbedRenderer;
                if (tabbedRenderer == null) {
                    return 0;
                }
                return tabbedRenderer.hashCode();
            }

            public final String toString() {
                return "SingleColumnMusicWatchNextResultsRenderer(tabbedRenderer=" + this.tabbedRenderer + ")";
            }
        }

        public /* synthetic */ Contents(int i, SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer, YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(NextResponse$Contents$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.singleColumnMusicWatchNextResultsRenderer = singleColumnMusicWatchNextResultsRenderer;
            this.twoColumnWatchNextResults = youTubeDataPage$Contents$TwoColumnWatchNextResults;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Contents)) {
                return false;
            }
            Contents contents = (Contents) obj;
            return Intrinsics.areEqual(this.singleColumnMusicWatchNextResultsRenderer, contents.singleColumnMusicWatchNextResultsRenderer) && Intrinsics.areEqual(this.twoColumnWatchNextResults, contents.twoColumnWatchNextResults);
        }

        public final int hashCode() {
            SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer = this.singleColumnMusicWatchNextResultsRenderer;
            int iHashCode = (singleColumnMusicWatchNextResultsRenderer == null ? 0 : singleColumnMusicWatchNextResultsRenderer.hashCode()) * 31;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults = this.twoColumnWatchNextResults;
            return iHashCode + (youTubeDataPage$Contents$TwoColumnWatchNextResults != null ? youTubeDataPage$Contents$TwoColumnWatchNextResults.hashCode() : 0);
        }

        public final String toString() {
            return "Contents(singleColumnMusicWatchNextResultsRenderer=" + this.singleColumnMusicWatchNextResultsRenderer + ", twoColumnWatchNextResults=" + this.twoColumnWatchNextResults + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$ContinuationContents;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ContinuationContents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final PlaylistPanelRenderer playlistPanelContinuation;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/NextResponse$ContinuationContents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/NextResponse$ContinuationContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return NextResponse$ContinuationContents$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ContinuationContents(int i, PlaylistPanelRenderer playlistPanelRenderer) {
            if (1 == (i & 1)) {
                this.playlistPanelContinuation = playlistPanelRenderer;
            } else {
                EnumsKt.throwMissingFieldException(NextResponse$ContinuationContents$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContinuationContents) && Intrinsics.areEqual(this.playlistPanelContinuation, ((ContinuationContents) obj).playlistPanelContinuation);
        }

        public final int hashCode() {
            return this.playlistPanelContinuation.hashCode();
        }

        public final String toString() {
            return "ContinuationContents(playlistPanelContinuation=" + this.playlistPanelContinuation + ")";
        }
    }

    public /* synthetic */ NextResponse(int i, Contents contents, ContinuationContents continuationContents, NavigationEndpoint navigationEndpoint) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(NextResponse$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.contents = contents;
        this.continuationContents = continuationContents;
        this.currentVideoEndpoint = navigationEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextResponse)) {
            return false;
        }
        NextResponse nextResponse = (NextResponse) obj;
        return Intrinsics.areEqual(this.contents, nextResponse.contents) && Intrinsics.areEqual(this.continuationContents, nextResponse.continuationContents) && Intrinsics.areEqual(this.currentVideoEndpoint, nextResponse.currentVideoEndpoint);
    }

    public final int hashCode() {
        int iHashCode = this.contents.hashCode() * 31;
        ContinuationContents continuationContents = this.continuationContents;
        int iHashCode2 = (iHashCode + (continuationContents == null ? 0 : continuationContents.playlistPanelContinuation.hashCode())) * 31;
        NavigationEndpoint navigationEndpoint = this.currentVideoEndpoint;
        return iHashCode2 + (navigationEndpoint != null ? navigationEndpoint.hashCode() : 0);
    }

    public final String toString() {
        return "NextResponse(contents=" + this.contents + ", continuationContents=" + this.continuationContents + ", currentVideoEndpoint=" + this.currentVideoEndpoint + ")";
    }
}
