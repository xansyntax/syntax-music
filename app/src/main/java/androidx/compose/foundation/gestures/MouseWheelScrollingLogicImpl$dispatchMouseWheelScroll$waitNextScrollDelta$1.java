package androidx.compose.foundation.gestures;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1 extends ContinuationImpl {
    public MouseWheelScrollingLogicImpl L$0;
    public Ref$ObjectRef L$1;
    public Ref$LongRef L$2;
    public Ref$ObjectRef L$3;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MouseWheelScrollingLogicImpl.dispatchMouseWheelScroll$waitNextScrollDelta(null, null, null, null, 0L, this);
    }
}
