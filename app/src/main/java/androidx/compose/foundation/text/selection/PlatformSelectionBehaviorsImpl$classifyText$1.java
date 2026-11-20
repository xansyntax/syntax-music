package androidx.compose.foundation.text.selection;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl$classifyText$1 extends ContinuationImpl {
    public long J$0;
    public Object L$0;
    public Object L$1;
    public MutexImpl L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSelectionBehaviorsImpl$classifyText$1(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m227classifyTextM8tDOmk(null, 0L, null, this);
    }
}
