package com.google.common.collect;

import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Multimaps$TransformedEntriesListMultimap$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Multimaps$TransformedEntriesListMultimap f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Multimaps$TransformedEntriesListMultimap$$ExternalSyntheticLambda0(Multimaps$TransformedEntriesListMultimap multimaps$TransformedEntriesListMultimap, Object obj) {
        this.f$0 = multimaps$TransformedEntriesListMultimap;
        this.f$1 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((Format$$ExternalSyntheticLambda1) this.f$0.transformer.f$0).apply(obj);
    }
}
