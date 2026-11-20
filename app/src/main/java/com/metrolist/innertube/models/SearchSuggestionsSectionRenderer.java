package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchSuggestionsSectionRenderer {
    public final List contents;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(24))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchSuggestionsSectionRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content;", "", "Companion", "SearchSuggestionRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        public final SearchSuggestionRenderer searchSuggestionRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SearchSuggestionsSectionRenderer$Content$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class SearchSuggestionRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final NavigationEndpoint navigationEndpoint;
            public final Runs suggestion;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ SearchSuggestionRenderer(int i, Runs runs, NavigationEndpoint navigationEndpoint) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(SearchSuggestionsSectionRenderer$Content$SearchSuggestionRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.suggestion = runs;
                this.navigationEndpoint = navigationEndpoint;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SearchSuggestionRenderer)) {
                    return false;
                }
                SearchSuggestionRenderer searchSuggestionRenderer = (SearchSuggestionRenderer) obj;
                return Intrinsics.areEqual(this.suggestion, searchSuggestionRenderer.suggestion) && Intrinsics.areEqual(this.navigationEndpoint, searchSuggestionRenderer.navigationEndpoint);
            }

            public final int hashCode() {
                return this.navigationEndpoint.hashCode() + (this.suggestion.hashCode() * 31);
            }

            public final String toString() {
                return "SearchSuggestionRenderer(suggestion=" + this.suggestion + ", navigationEndpoint=" + this.navigationEndpoint + ")";
            }
        }

        public /* synthetic */ Content(int i, SearchSuggestionRenderer searchSuggestionRenderer, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(SearchSuggestionsSectionRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.searchSuggestionRenderer = searchSuggestionRenderer;
            this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.searchSuggestionRenderer, content.searchSuggestionRenderer) && Intrinsics.areEqual(this.musicResponsiveListItemRenderer, content.musicResponsiveListItemRenderer);
        }

        public final int hashCode() {
            SearchSuggestionRenderer searchSuggestionRenderer = this.searchSuggestionRenderer;
            int iHashCode = (searchSuggestionRenderer == null ? 0 : searchSuggestionRenderer.hashCode()) * 31;
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = this.musicResponsiveListItemRenderer;
            return iHashCode + (musicResponsiveListItemRenderer != null ? musicResponsiveListItemRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Content(searchSuggestionRenderer=" + this.searchSuggestionRenderer + ", musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ")";
        }
    }

    public /* synthetic */ SearchSuggestionsSectionRenderer(int i, List list) {
        if (1 == (i & 1)) {
            this.contents = list;
        } else {
            EnumsKt.throwMissingFieldException(SearchSuggestionsSectionRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchSuggestionsSectionRenderer) && Intrinsics.areEqual(this.contents, ((SearchSuggestionsSectionRenderer) obj).contents);
    }

    public final int hashCode() {
        return this.contents.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("SearchSuggestionsSectionRenderer(contents=", ")", this.contents);
    }
}
