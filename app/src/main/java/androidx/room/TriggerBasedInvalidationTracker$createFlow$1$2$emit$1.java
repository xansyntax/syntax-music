package androidx.room;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 extends ContinuationImpl {
    public int[] L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ TriggerBasedInvalidationTracker$createFlow$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(TriggerBasedInvalidationTracker$createFlow$1$2 triggerBasedInvalidationTracker$createFlow$1$2, Continuation continuation) {
        super(continuation);
        this.this$0 = triggerBasedInvalidationTracker$createFlow$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((int[]) null, (Continuation) this);
    }
}
