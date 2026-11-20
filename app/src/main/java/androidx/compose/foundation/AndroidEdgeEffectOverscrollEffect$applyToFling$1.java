package androidx.compose.foundation;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect$applyToFling$1 extends ContinuationImpl {
    public long J$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEdgeEffectOverscrollEffect$applyToFling$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m30applyToFlingBMRW4eQ(0L, null, this);
    }
}
