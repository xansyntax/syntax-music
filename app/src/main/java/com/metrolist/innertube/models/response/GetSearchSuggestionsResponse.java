package com.metrolist.innertube.models.response;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.SearchSuggestionsSectionRenderer;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class GetSearchSuggestionsResponse {
    public final List contents;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 19))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GetSearchSuggestionsResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final SearchSuggestionsSectionRenderer searchSuggestionsSectionRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetSearchSuggestionsResponse$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GetSearchSuggestionsResponse$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, SearchSuggestionsSectionRenderer searchSuggestionsSectionRenderer) {
            if (1 == (i & 1)) {
                this.searchSuggestionsSectionRenderer = searchSuggestionsSectionRenderer;
            } else {
                EnumsKt.throwMissingFieldException(GetSearchSuggestionsResponse$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.searchSuggestionsSectionRenderer, ((Content) obj).searchSuggestionsSectionRenderer);
        }

        public final int hashCode() {
            return this.searchSuggestionsSectionRenderer.contents.hashCode();
        }

        public final String toString() {
            return "Content(searchSuggestionsSectionRenderer=" + this.searchSuggestionsSectionRenderer + ")";
        }
    }

    public /* synthetic */ GetSearchSuggestionsResponse(int i, List list) {
        if (1 == (i & 1)) {
            this.contents = list;
        } else {
            EnumsKt.throwMissingFieldException(GetSearchSuggestionsResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetSearchSuggestionsResponse) && Intrinsics.areEqual(this.contents, ((GetSearchSuggestionsResponse) obj).contents);
    }

    public final int hashCode() {
        List list = this.contents;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("GetSearchSuggestionsResponse(contents=", ")", this.contents);
    }
}
