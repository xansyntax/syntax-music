package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/GetSearchSuggestionsBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class GetSearchSuggestionsBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Context context;
    public final String input;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/GetSearchSuggestionsBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/GetSearchSuggestionsBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GetSearchSuggestionsBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GetSearchSuggestionsBody(int i, Context context, String str) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(GetSearchSuggestionsBody$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.context = context;
        this.input = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSearchSuggestionsBody)) {
            return false;
        }
        GetSearchSuggestionsBody getSearchSuggestionsBody = (GetSearchSuggestionsBody) obj;
        return Intrinsics.areEqual(this.context, getSearchSuggestionsBody.context) && Intrinsics.areEqual(this.input, getSearchSuggestionsBody.input);
    }

    public final int hashCode() {
        return this.input.hashCode() + (this.context.hashCode() * 31);
    }

    public final String toString() {
        return "GetSearchSuggestionsBody(context=" + this.context + ", input=" + this.input + ")";
    }

    public GetSearchSuggestionsBody(Context context, String str) {
        str.getClass();
        this.context = context;
        this.input = str;
    }
}
