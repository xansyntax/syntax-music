package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.Tabs;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse;", "", "Companion", "Contents", "ContinuationContents", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Contents contents;
    public final ContinuationContents continuationContents;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/SearchResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$Contents;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Contents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Tabs tabbedSearchResultsRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$Contents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/SearchResponse$Contents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SearchResponse$Contents$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Contents(int i, Tabs tabs) {
            if (1 == (i & 1)) {
                this.tabbedSearchResultsRenderer = tabs;
            } else {
                EnumsKt.throwMissingFieldException(SearchResponse$Contents$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Contents) && Intrinsics.areEqual(this.tabbedSearchResultsRenderer, ((Contents) obj).tabbedSearchResultsRenderer);
        }

        public final int hashCode() {
            Tabs tabs = this.tabbedSearchResultsRenderer;
            if (tabs == null) {
                return 0;
            }
            return tabs.tabs.hashCode();
        }

        public final String toString() {
            return "Contents(tabbedSearchResultsRenderer=" + this.tabbedSearchResultsRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents;", "", "Companion", "MusicShelfContinuation", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ContinuationContents {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicShelfContinuation musicShelfContinuation;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SearchResponse$ContinuationContents$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicShelfContinuation {
            public static final Lazy[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final List contents;
            public final List continuations;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Content {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/SearchResponse$ContinuationContents$MusicShelfContinuation$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Content(int i, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
                    if (1 == (i & 1)) {
                        this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Content) && Intrinsics.areEqual(this.musicResponsiveListItemRenderer, ((Content) obj).musicResponsiveListItemRenderer);
                }

                public final int hashCode() {
                    return this.musicResponsiveListItemRenderer.hashCode();
                }

                public final String toString() {
                    return "Content(musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ")";
                }
            }

            static {
                BrowseResponse$$ExternalSyntheticLambda0 browseResponse$$ExternalSyntheticLambda0 = new BrowseResponse$$ExternalSyntheticLambda0((byte) 24);
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
                $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, browseResponse$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new BrowseResponse$$ExternalSyntheticLambda0((byte) 25))};
            }

            public /* synthetic */ MusicShelfContinuation(int i, List list, List list2) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(SearchResponse$ContinuationContents$MusicShelfContinuation$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.contents = list;
                this.continuations = list2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicShelfContinuation)) {
                    return false;
                }
                MusicShelfContinuation musicShelfContinuation = (MusicShelfContinuation) obj;
                return Intrinsics.areEqual(this.contents, musicShelfContinuation.contents) && Intrinsics.areEqual(this.continuations, musicShelfContinuation.continuations);
            }

            public final int hashCode() {
                int iHashCode = this.contents.hashCode() * 31;
                List list = this.continuations;
                return iHashCode + (list == null ? 0 : list.hashCode());
            }

            public final String toString() {
                return "MusicShelfContinuation(contents=" + this.contents + ", continuations=" + this.continuations + ")";
            }
        }

        public /* synthetic */ ContinuationContents(int i, MusicShelfContinuation musicShelfContinuation) {
            if (1 == (i & 1)) {
                this.musicShelfContinuation = musicShelfContinuation;
            } else {
                EnumsKt.throwMissingFieldException(SearchResponse$ContinuationContents$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContinuationContents) && Intrinsics.areEqual(this.musicShelfContinuation, ((ContinuationContents) obj).musicShelfContinuation);
        }

        public final int hashCode() {
            return this.musicShelfContinuation.hashCode();
        }

        public final String toString() {
            return "ContinuationContents(musicShelfContinuation=" + this.musicShelfContinuation + ")";
        }
    }

    public /* synthetic */ SearchResponse(int i, Contents contents, ContinuationContents continuationContents) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(SearchResponse$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.contents = contents;
        this.continuationContents = continuationContents;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResponse)) {
            return false;
        }
        SearchResponse searchResponse = (SearchResponse) obj;
        return Intrinsics.areEqual(this.contents, searchResponse.contents) && Intrinsics.areEqual(this.continuationContents, searchResponse.continuationContents);
    }

    public final int hashCode() {
        Contents contents = this.contents;
        int iHashCode = (contents == null ? 0 : contents.hashCode()) * 31;
        ContinuationContents continuationContents = this.continuationContents;
        return iHashCode + (continuationContents != null ? continuationContents.musicShelfContinuation.hashCode() : 0);
    }

    public final String toString() {
        return "SearchResponse(contents=" + this.contents + ", continuationContents=" + this.continuationContents + ")";
    }
}
