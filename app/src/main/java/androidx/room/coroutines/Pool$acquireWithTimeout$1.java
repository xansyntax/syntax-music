package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Pool$acquireWithTimeout$1 extends ContinuationImpl {
    public long J$0;
    public Function0 L$0;
    public Ref$ObjectRef L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Pool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquireWithTimeout$1(Pool pool, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m844acquireWithTimeoutKLykuaI(0L, null, this);
    }
}
