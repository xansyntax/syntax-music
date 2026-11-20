package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/SearchEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchEndpoint extends Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String params;
    public final String query;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SearchEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SearchEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchEndpoint$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SearchEndpoint(int i, String str, String str2) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(SearchEndpoint$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.params = str;
        this.query = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchEndpoint)) {
            return false;
        }
        SearchEndpoint searchEndpoint = (SearchEndpoint) obj;
        return Intrinsics.areEqual(this.params, searchEndpoint.params) && Intrinsics.areEqual(this.query, searchEndpoint.query);
    }

    public final int hashCode() {
        String str = this.params;
        return this.query.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("SearchEndpoint(params=", this.params, ", query=", this.query, ")");
    }
}
