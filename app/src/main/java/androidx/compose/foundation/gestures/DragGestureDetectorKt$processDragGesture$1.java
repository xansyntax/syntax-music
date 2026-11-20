package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Function;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt$processDragGesture$1 extends ContinuationImpl {
    public float F$0;
    public Object L$0;
    public Object L$1;
    public HeadersReader L$10;
    public PointerInputChange L$11;
    public Function L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public Object L$8;
    public Ref$LongRef L$9;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.processDragGesture(null, null, null, null, null, null, null, this);
    }
}
