package com.metrolist.innertubex.models.body;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/FeedbackBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class FeedbackBody {
    public final Context context;
    public final List feedbackTokens;
    public final boolean isFeedbackTokenUnencrypted;
    public final boolean shouldMerge;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 7)), null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/FeedbackBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/FeedbackBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return FeedbackBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FeedbackBody(int i, Context context, List list, boolean z, boolean z2) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(FeedbackBody$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.context = context;
        this.feedbackTokens = list;
        if ((i & 4) == 0) {
            this.isFeedbackTokenUnencrypted = false;
        } else {
            this.isFeedbackTokenUnencrypted = z;
        }
        if ((i & 8) == 0) {
            this.shouldMerge = false;
        } else {
            this.shouldMerge = z2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackBody)) {
            return false;
        }
        FeedbackBody feedbackBody = (FeedbackBody) obj;
        return Intrinsics.areEqual(this.context, feedbackBody.context) && Intrinsics.areEqual(this.feedbackTokens, feedbackBody.feedbackTokens) && this.isFeedbackTokenUnencrypted == feedbackBody.isFeedbackTokenUnencrypted && this.shouldMerge == feedbackBody.shouldMerge;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.shouldMerge) + IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.context.hashCode() * 31, 31, this.feedbackTokens), this.isFeedbackTokenUnencrypted, 31);
    }

    public final String toString() {
        return "FeedbackBody(context=" + this.context + ", feedbackTokens=" + this.feedbackTokens + ", isFeedbackTokenUnencrypted=" + this.isFeedbackTokenUnencrypted + ", shouldMerge=" + this.shouldMerge + ")";
    }

    public FeedbackBody(Context context, List list) {
        list.getClass();
        this.context = context;
        this.feedbackTokens = list;
        this.isFeedbackTokenUnencrypted = false;
        this.shouldMerge = false;
    }
}
