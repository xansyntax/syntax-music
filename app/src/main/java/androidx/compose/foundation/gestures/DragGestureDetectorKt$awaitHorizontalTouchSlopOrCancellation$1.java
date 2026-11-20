package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 extends ContinuationImpl {
    public float F$0;
    public Function2 L$0;
    public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$1;
    public Ref$LongRef L$2;
    public HeadersReader L$3;
    public PointerInputChange L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.m86awaitHorizontalTouchSlopOrCancellationjO51t88(null, 0L, null, this);
    }
}
