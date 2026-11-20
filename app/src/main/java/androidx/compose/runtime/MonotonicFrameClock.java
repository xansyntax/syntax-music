package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MonotonicFrameClock extends CoroutineContext.Element {
    @Override // kotlin.coroutines.CoroutineContext.Element
    default CoroutineContext.Key getKey() {
        return NeverEqualPolicy.$$INSTANCE;
    }

    Object withFrameNanos(Function1 function1, Continuation continuation);
}
