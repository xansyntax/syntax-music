package com.metrolist.innertubex.models.body;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/BrowseBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class BrowseBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String browseId;
    public final Context context;
    public final String continuation;
    public final String params;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/BrowseBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/BrowseBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return BrowseBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BrowseBody(int i, Context context, String str, String str2, String str3) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(BrowseBody$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.context = context;
        if ((i & 2) == 0) {
            this.browseId = null;
        } else {
            this.browseId = str;
        }
        if ((i & 4) == 0) {
            this.params = null;
        } else {
            this.params = str2;
        }
        if ((i & 8) == 0) {
            this.continuation = null;
        } else {
            this.continuation = str3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowseBody)) {
            return false;
        }
        BrowseBody browseBody = (BrowseBody) obj;
        return Intrinsics.areEqual(this.context, browseBody.context) && Intrinsics.areEqual(this.browseId, browseBody.browseId) && Intrinsics.areEqual(this.params, browseBody.params) && Intrinsics.areEqual(this.continuation, browseBody.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.context.hashCode() * 31;
        String str = this.browseId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.params;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.continuation;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BrowseBody(context=");
        sb.append(this.context);
        sb.append(", browseId=");
        sb.append(this.browseId);
        sb.append(", params=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.params, ", continuation=", this.continuation, ")");
    }

    public BrowseBody(Context context, String str, String str2, String str3) {
        this.context = context;
        this.browseId = str;
        this.params = str2;
        this.continuation = str3;
    }
}
